import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    private Stack<Cell> playerPath;
    static Scanner scan = new Scanner(System.in);
    private static Board BL1;
    private static Player p1 = new Player(5);
    private static Player p2 = new Player(15);
    private static Player p3 = new Player(20);


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
    // 1) board view gives error if it tries to go outside the arrayList index
    // 2) printBoard is returning memory addresses.
    // 3) there may be no exit cell.
    // 4) first itteration of loop returns "invalid input"







    /**
     * prompts for username, determines game level, and creates new board and player
     */
    public static void gameStart() {
        System.out.println("Please enter username:");
        String userName = scan.nextLine();



        System.out.println("\nChoose your difficulty, integer: from 1-3");
        boolean levelI = false;

        while (!levelI) {
            String level = scan.next();

            if (level.equals("1")) {
                BL1 = new Board(1, p1, 5);
                levelI = true;
            } else if (level.equals("2")) {
                BL1 = new Board(2, p2, 15);
                levelI = true;
            } else if (level.equals("3")) { //FIXME wierd error at level = 3 could be >= problem
                BL1 = new Board(3, p3, 20);
                levelI = true;
            } else {
                levelI = false;
                System.out.println("Input invalid, please enter an integer 1-3");
            }
        }
    }


    /**
     * this is the player movement and game loop method. this allows the player to move
     * until they have found the key and have entered the exit cell. Includes all in-game player I\O.
     */

    public static void gameLoop() {
        int size = BL1.getBOARD_SIZE();
        System.out.println(">>");

        while ((!p1.hasKey()) && (p1.getLocation().getX() != size - 1) && (p1.getLocation().getY() != size - 1)) {
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

                } else {
                    System.out.println("Input invalid\nPlease re-inter movement input: W, A, S, D. \n" +
                            "Press: I, to view backpack inventory \n" + "Press: R, to print rules and instructions");
                    moveI = false;
                }
            }
        }
    }
}


