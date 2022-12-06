import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    private Stack<Cell> playerPath;
    private static String userName = "";
    static Scanner scan = new Scanner(System.in);
    private static Board BL1;
    private static int difficulty;
    private static Player p1 = new Player(5);



    public static void main(String[] args) {
//        System.out.println("you have entered the maze and are at location 0,0\n" +
//                "you have the option to move anywhere within the maze unless you encounter a wall.\n" +
//                "If you find a wall you must reroute.\n \n" +
//                "To move press: W, S, A, D. To access these rules again press: R. To see items in your \n" +
//                "backpack inventory press: I. \n");
//        System.out.println("These are the items in your backpack");
//        System.out.println(p1.getBackPack());
//        System.out.println("These can be used on any trap or monsters but keep in mind that you can only use them once.\n" +
//                "There are rooms that refill your bag but those are a rare find");
//
//        System.out.println("Your objective is to stay alive and find a key, then exit the maze, if you do not have \n " +
//                "the key upon reaching the exit you will not be able to exit the maze\n" +
//                "Good Luck Maze Runner, and by the way, lookout for the roaming monster\n\n");
        gameStart();
        gameLoop();
    }
    //TODO cur bugs
    // 1) gameLoop ends if player reaches any edge other than the left or top.







    /**
     * prompts for username, determines game level, and creates new board and player
     */
    public static void gameStart() {
        System.out.println("Load last save? y/n ");
        String loadSave = scan.nextLine();
        if (loadSave.equals("n")) {
            System.out.println("Please enter username:");
            userName = scan.nextLine();


            System.out.println("\nChoose your difficulty, integer: from 1-3");
            boolean levelI = false;

            while (!levelI) {
                String level = scan.next();

                if (level.equals("1")) {
                    difficulty = Integer.parseInt(level);
                    BL1 = new Board(difficulty, p1, 5);
                    levelI = true;
                } else if (level.equals("2")) {
                    difficulty = Integer.parseInt(level);
                    BL1 = new Board(difficulty, p1, 15);
                    levelI = true;
                } else if (level.equals("3")) {
                    difficulty = Integer.parseInt(level);
                    BL1 = new Board(difficulty, p1, 20);
                    levelI = true;
                } else {
                    levelI = false;
                    System.out.println("Input invalid, please enter an integer 1-3");
                }
            }
        } else if (loadSave.equals("y")){
            loadSave();
        } else {
            System.out.println("+---ERROR---+");
        }
    }


    /**
     * this is the player movement and game loop method. this allows the player to move
     * until they have found the key and have entered the exit cell. Includes all in-game player I\O.
     */

    public static void gameLoop() {
        int size = BL1.getBOARD_SIZE();
        System.out.println(">>");

        while (!((p1.hasKey()) && ((p1.getLocation().getX() == size - 1) && (p1.getLocation().getY() == size - 1)))) {
            boolean moveI = false;

            while (!moveI) {
                String moveChoice = scan.nextLine().toLowerCase(Locale.ROOT);


                if (moveChoice.equals("w")) {
                    p1.move('w');
                    BL1.printBoard(p1);
                    moveI = true;

                } else if (moveChoice.equals("s")) {
                    p1.move('s');
                    BL1.printBoard(p1);
                    moveI = true;

                } else if (moveChoice.equals("a")) {
                    p1.move('a');
                    BL1.printBoard(p1);
                    moveI = true;

                } else if (moveChoice.equals("d")) {
                    p1.move('d');
                    BL1.printBoard(p1);
                    moveI = true;
                }
                else if (moveChoice.equals("r")) {
                    System.out.println("To move press: W, S, A, D. To access rules and instructions press: R. To see items in your \n"+
                                       "backpack inventory press: I.");
                    System.out.println("Your objective is to stay alive and find a key, use items in your bag to accomplish this, then exit the maze, if you do not have \n " +
                            "the key upon reaching the exit you will not be able to exit the maze\n" +
                            "Good Luck Maze Runner, and lookout for the monster\n\n");
                    moveI = true;
                }
                else if (moveChoice.equals("i")) {// prints backpack for player to see
                    System.out.println("These are the items in your backpack");
                   System.out.println(p1.getBackPack());
                    System.out.println("These can be used on any trap or monsters but keep in mind that you can only use them once.\n");
                }
                else if (moveChoice.equals("")) {

                }
                else if (moveChoice.equals("e")) {// prints backpack for player to see
                    System.out.println("exiting...");
                    saveAndExit();
                    return;
                } else {
                    System.out.println("Input invalid\nPlease re-inter movement input: W, A, S, D. \n" +
                            "Press: I, to view backpack inventory. \n" + "Press: R, to print rules and instructions."
                            +"Press: E to save and exit.");
                    moveI = false;
                }
            }
        }
    }

    public static void saveAndExit(){
        try {
            PrintWriter saveWriter = new PrintWriter("lastSave.txt");
            // write out general information
            saveWriter.println(userName);
            saveWriter.println(BL1.getBOARD_SIZE());
            saveWriter.println(difficulty);
            // write out player information
            saveWriter.println(p1.getBackPack().size());
            for (String item : p1.getBackPack()) {
                saveWriter.println(item);
            }
            saveWriter.println(p1.getHealth());
            saveWriter.println(p1.getMaxHealth());
            saveWriter.println(p1.getLocation().getX() + " " + p1.getLocation().getY());
            saveWriter.println(p1.getPath().size());
            for (Location loc : p1.getPath()) {
                saveWriter.println(loc.getX() + " " + loc.getY());
            }
            // write out board information
            for (int i = 0; i < BL1.getBOARD_SIZE(); i++){
                for ( int j = 0; j < BL1.getBOARD_SIZE(); j++){
                    saveWriter.println(BL1.getCellAt(i,j).toString());
                }
            }
            // write out monster information
            for (Monster m : BL1.getMonsters()) {
                if (m instanceof SmartMonster){
                    saveWriter.println("Smart " + ((SmartMonster) m).location.getX() + " " + ((SmartMonster) m).location.getY() + " " + ((SmartMonster) m).getHealth());
                } else {
                    saveWriter.println("Dumb " + m.location.getX() + " " + m.location.getY() + " " + m.getHealth());
                }
            }
            saveWriter.close();

        } catch (Exception e) {
            System.out.println("+---ERROR---+");
        }


    }

    public static void loadSave(){
        try {
            File lastSave = new File("lastSave.txt");
            Scanner saveSc = new Scanner(lastSave);
            // read general information
            userName = saveSc.nextLine();
            int boardSize = saveSc.nextInt();
            difficulty = saveSc.nextInt();
            // read player information and create player
            p1 = new Player(boardSize);
            Set<String> backpack = new HashSet<>();
            int backpackSize = saveSc.nextInt();
            while (p1.getBackPack().size()<backpackSize) {
                p1.addToBackpack(saveSc.next());
            }
            int health = saveSc.nextInt();
            int maxHealth = saveSc.nextInt();
            p1.loseHealth(maxHealth-health);
            p1.setLocation(new Location(saveSc.nextInt(), saveSc.nextInt()));
            int counter = 0;
            int locNum = saveSc.nextInt();
            while (counter < locNum) {
                p1.getPath().add(new Location(saveSc.nextInt(), saveSc.nextInt()));
                counter++;
            }
            // write out board information
            BL1 = new Board(difficulty, p1, boardSize);
            for (int i = 0; i < BL1.getBOARD_SIZE(); i++){
                for ( int j = 0; j < BL1.getBOARD_SIZE(); j++){
                    String temp = saveSc.next();
                    if (temp.equals(".")) {
                        BL1.setCellAt(i, j, new Empty(p1));
                    } else if (temp.equals("#")) {
                        BL1.setCellAt(i, j, new Entrance(p1));
                    } else if (temp.equals("@")) {
                        BL1.setCellAt(i, j, new Exit(p1));
                    } else if (temp.equals("+")) {
                        BL1.setCellAt(i, j, new Healing_Trap(p1));
                    } else if (temp.equals("k")) {
                        BL1.setCellAt(i, j, new Key(p1.hasKey(), p1));
                    } else if (temp.equals("W")) {
                        BL1.setCellAt(i, j, new Wall());
                    }
                }
            }
            // write out monster information
            ArrayList<Monster> monsters = BL1.getMonsters();
            while (saveSc.hasNext()) {
                String type = saveSc.next();
                if (type.equals("Smart")) {
                    monsters.add(new SmartMonster(saveSc.nextInt(), saveSc.nextInt(), saveSc.nextInt(), p1));
                } else if (type.equals("Dumb")){
                    monsters.add(new Monster(saveSc.nextInt(), saveSc.nextInt(), saveSc.nextInt()));
                }
            }

            saveSc.close();

        } catch (Exception e) {
            System.out.println("+---ERROR---+");
        }


    }
}


