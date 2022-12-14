import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    private Stack<Cell> playerPath;
    private static String userName = "";
    static Scanner scan = new Scanner(System.in);
    private static Board BL1;
    private static int difficulty;
    private static Player p1;
    protected static boolean exit = true;

    /**
     * Author: Max
     */

    /**
     * gives player an outline of the game and how to interact with the game.
     * also starts and stops a game timer which is displayed if the game is won.
     * and creates game and game loop.
     * @param args
     */

    public static void main(String[] args) {
        System.out.println("Hello, you have entered the maze and are at location 0,0.\n" +
                "you have the option to move anywhere within the maze unless you encounter a wall.\n" +
                "If you find a wall you must reroute. A blank space in maze shows the current monster cell\n \n" +

                "To move press: W, S, A, D."+
                "Press: R to access the game rules.\n" +
                "Press: I to view items in your backpack inventory. \n"+
                "Press: e to save game and exit \n" +
                "Press: l to view a legend of icons found on the game board\n");

        System.out.println("Your objective is to stay alive and find a key, then exit the maze, if you do not have \n " +
                "the key upon reaching the exit you will not be able to exit the maze\n" +
                "Good Luck Maze Runner, and by the way, lookout for the roaming monster\n\n");
        gameStart();
        Stopwatch.start();

        gameLoop();
        Stopwatch.stop();
    }

    /**
     * prompts for username, determines game level, and creates new board and player
     */
    public static void gameStart() {
        boolean goodInput = false;
        while (!goodInput) {
            System.out.println("Load last save? y/n ");
            String loadSave = scan.nextLine();
            if (loadSave.toLowerCase().equals("n")) {
                goodInput = true;
                System.out.println("Please enter username:");
                userName = scan.nextLine();


                System.out.println("\nChoose your difficulty, integer: from 1-3");
                boolean levelI = false;

                while (!levelI) {
                    String level = scan.next();

                    if (level.equals("1")) {
                        difficulty = Integer.parseInt(level);
                        p1 = new Player(5);
                        BL1 = new Board(difficulty, p1, 5);
                        levelI = true;
                    } else if (level.equals("2")) {
                        difficulty = Integer.parseInt(level);
                        p1 = new Player(15);
                        BL1 = new Board(difficulty, p1, 15);
                        levelI = true;
                    } else if (level.equals("3")) {
                        difficulty = Integer.parseInt(level);
                        p1 = new Player(20);
                        BL1 = new Board(difficulty, p1, 20);
                        levelI = true;
                    } else {
                        levelI = false;
                        System.out.println("Input invalid, please enter an integer 1-3");
                    }
                }
            } else if (loadSave.toLowerCase().equals("y")) {
                loadSave();
                goodInput = true;
            } else {
                System.out.println("+---ERROR---+");
            }
        }
    }



    /**
     * this is the player movement and game loop method. this allows the player to move
     * until they have found the key and have entered the exit cell. Includes all in-game player I\O.
     */
    public static void gameLoop() {

        int size = BL1.getBOARD_SIZE();
        boolean gameEnd = false;

        while (!gameEnd) {
            boolean moveI = false;
            while (!moveI) {
                System.out.print(">>");
                String moveChoice = scan.nextLine().toLowerCase();


                if (moveChoice.equals("w")) {
                    moveIfNoWall(moveChoice);
                    moveI = true;

                } else if (moveChoice.equals("s")) {
                    moveIfNoWall(moveChoice);
                    moveI = true;

                } else if (moveChoice.equals("a")) {
                    moveIfNoWall(moveChoice);
                    moveI = true;

                } else if (moveChoice.equals("d")) {
                    moveIfNoWall(moveChoice);
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
                else if (moveChoice.equals("l")) {
                    System.out.println("#: Entrance \nX: Wall. \nP: Pit Trap. \nK: Key room. \n@:Exit \n+: Healing Room. .: Empty Room" +
                            "\n"
                    );
                }
                else if (moveChoice.equals("e")) {
                    System.out.println("exiting...");
                    saveAndExit();
                    return;
                } else {
                    System.out.println("Input invalid\nPlease re-inter movement input: W, A, S, D. \n" +
                            "Press: I, to view backpack inventory. \n" + "Press: R, to print rules and instructions."
                            +"\nPress L, to view a legend of room types." + "\nPress: E to save and exit.");
                    moveI = false;
                }

                // move the monsters
                for (Monster m : BL1.getMonsters()) {
                    if (m instanceof SmartMonster) {
                        ((SmartMonster) m).move(BL1.getBOARD_SIZE());
                    } else {
                        m.move(BL1.getBOARD_SIZE());
                    }
                }

                // if the player is at the exit, and the endGameTest returns true, win the game
                if (BL1.getCellAt(p1.getLocation().getX(), p1.getLocation().getY()) instanceof Exit) {
                    if(((Exit) BL1.getCellAt(p1.getLocation().getX(), p1.getLocation().getY())).endGameTest()){
                        gameEnd = true;
                    }
                }

                // if the player is dead, lose the game
                if(!p1.getIsAlive() && p1.getDeathByHealth()){
                    gameEnd = true;
                    System.out.println("you found the monster, or did it find you??");
                    System.out.println("ether way, you died");
                } else if(!p1.getIsAlive()){
                    gameEnd = true;
                }
            }
        }
    }

    /**
     * lets player interact with the cell at the given coordinates
     * @param x int value for column of desired cell
     * @param y int value for row of desired cell
     */
    public static void curCell(int x, int y){
        Cell cur = BL1.getCellAt(x,y);
        if(cur instanceof Key){
            ((Key) cur).interAction();
        } else if( cur instanceof Pit_Trap){
            ((Pit_Trap) cur).IO();
        } else if(cur instanceof Healing_Trap) {
            ((Healing_Trap) cur).refillHealth();
        }
    }

    /**
     * saves all necessary information of current game to a txt file
     */
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
            saveWriter.println(p1.getFallHealth());
            saveWriter.println((p1.getGeneralHealth()));
            saveWriter.println(p1.getKineticHealth());
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
                    saveWriter.println("Smart " + ((SmartMonster) m).location.getX() + " " + ((SmartMonster) m).location.getY());
                } else {
                    saveWriter.println("Dumb " + m.location.getX() + " " + m.location.getY());
                }
            }
            saveWriter.close();

        } catch (Exception e) {
            System.out.println("+---ERROR---+");
        }


    }

    /**
     * reads information from a txt file and converts it into game data
     */
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
            p1.setFallHealth(saveSc.nextInt());
            p1.setGeneralHealth(saveSc.nextInt());
            p1.setKineticHealth(saveSc.nextInt());
            int maxHealth = saveSc.nextInt();
            p1.loseHealth(maxHealth-health, " ");
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
                    monsters.add(new SmartMonster(saveSc.nextInt(), saveSc.nextInt(), p1));
                } else if (type.equals("Dumb")){
                    monsters.add(new Monster(saveSc.nextInt(), saveSc.nextInt()));
                }
            }

            saveSc.close();

        } catch (Exception e) {
            System.out.println("+---ERROR---+");
        }
    }

    /**
     * Changes the player's location in a desired location if the cell they wish to occupy is not an instance of the Wall class
     * @param direction String representing WASD direction the player wishes to move
     */
    public static void moveIfNoWall(String direction){
        if (direction.equals("w")) {
            p1.move('w');
            if (BL1.getCellAt(p1.getLocation().getX(), p1.getLocation().getY()) instanceof Wall) {
                p1.move('s');
                System.out.println("you hit a wall");
            }
            BL1.printBoard(p1);

        } else if (direction.equals("s")) {
            p1.move('s');
            if (BL1.getCellAt(p1.getLocation().getX(), p1.getLocation().getY()) instanceof Wall) {
                p1.move('w');
                System.out.println("you hit a wall");

            }
            BL1.printBoard(p1);

        } else if (direction.equals("a")) {
            p1.move('a');
            if (BL1.getCellAt(p1.getLocation().getX(), p1.getLocation().getY()) instanceof Wall) {
                p1.move('d');
                System.out.println("you hit a wall");

            }
            BL1.printBoard(p1);

        } else if (direction.equals("d")) {
            p1.move('d');
            if (BL1.getCellAt(p1.getLocation().getX(), p1.getLocation().getY()) instanceof Wall) {
                p1.move('a');
                System.out.println("you hit a wall");

            }
            BL1.printBoard(p1);
        }
        curCell(p1.getLocation().getX(),p1.getLocation().getY());
    }
}


