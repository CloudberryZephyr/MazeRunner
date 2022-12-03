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
        Scanner scan = new Scanner(System.in);
        gameStart();
        gameLoop();

    }


    /**
     * determines game level, and creates new board and player
     */
    public static void gameStart() {

        System.out.println("Choose your level");
        int level = scan.nextInt();

        boolean levelI = false;

        while (!levelI) {
            if (level == 1) {
                BL1 = new Board(1, p1, 5);
                levelI = true;
            } else if (level == 2) {
                BL1 = new Board(2, p2, 15);
                levelI = true;
            } else if (level == 3) {
                BL1 = new Board(3, p3, 20);
                levelI = true;
            } else {
                levelI = false;
                System.out.println("Input invalid, please enter an integer 1-3");
            }

            //TODO Need to tell the new player object that they are in cell[0][0] to print start up message. or move start up message

        }
    }


    /**
     * this is the player movement and game loop method. this allows the player to move
     * until they have found the key and have entered the exit cell.
     */

    public static void gameLoop() {
        int size = BL1.getBOARD_SIZE();
        while ((!p1.hasKey()) && (p1.getLocation().getX() != size - 1) && (p1.getLocation().getY() != size - 1)) {

            //System.out.println("Press: W to move forward, S to move back, A to move left, D to move right");

            boolean moveI = false;
            while (!moveI) {
                //TODO need to add the player view into this class, currently, prompts player to move but i have no
                //      idea how or where im moving.
                //TODO also need to work in payer path??

                String moveChoice = scan.nextLine().toLowerCase(Locale.ROOT);

                if (moveChoice.equals("w")) {
                    p1.move('w');
                    moveI = true;

                } else if (moveChoice.equals("s")) {
                    p1.move('s');
                    moveI = true;

                } else if (moveChoice.equals("a")) {
                    p1.move('a');
                    moveI = true;

                } else if (moveChoice.equals("d")) {
                    p1.move('d');
                    moveI = true;

                } else {
                    moveI = false;
                    System.out.println("Input invalid, please re-inter movement input: W, S, D");
                }
            }
        }
    }
}


