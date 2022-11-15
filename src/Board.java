import java.util.ArrayList;

/**
 * @author Clara Shoemaker
 * @version 1.2
 */
public class Board {
    // data members
    private Cell[][] cells;
    private Cell[][] boardView;
    private ArrayList<Monster> monsters;
    private int difficulty;
    private final int BOARD_SIZE;
    private Player player;


    /**
     * Constructor class - initializes all data members, constructs the board of play according to a given difficulty
     *
     * @param difficulty an int value that determines the density of traps, number of monsters, etc.
     * @param player Player object corresponding to the current player character in Main class
     */
    public Board(int difficulty, Player player, Location location) {
        this.difficulty = difficulty;
        this.player = player;
        //BOARD_SIZE = difficulty + 9;  Possible changes to board size depending on game difficulty
        BOARD_SIZE = 10;

        cells = new Cell[BOARD_SIZE][BOARD_SIZE];
        boardView = new Cell[5][5];
        // TODO: random generation of traps in the map
        // currently initializes entire board to be empty
        for (int i = 0; i<BOARD_SIZE; i++){
            for (int j = 0; j<BOARD_SIZE; j++) {
                cells[i][j] = new Empty();
            }
        }

        // initializes board view array
        int playerX = location.getX();//player.getLocation().getX();
        int playerY = location.getY();//player.getLocation().getY();
        if (playerX >= 2) {
            if ( (playerY >= 2) && (BOARD_SIZE - playerY >= 2)) { // non-edge board view
                for (int i = -2; i<3; i++) {
                    for (int j = -2; j<3; j++) {
                        boardView[i + 2][j+2] = cells[playerX+i][playerY+j];
                    }
                }
            }
            if ( (playerY == 1) || (BOARD_SIZE - playerY == 1)) {  // player position is 1 from the upper or lower edge
                for (int i = -1; i<4; i++) {
                    for (int j = -1; j<4; j++) {
                        boardView[i + 1][j+1] = cells[playerX+i][playerY+j];
                    }
                }
            }
            if ((playerY == 0) || (BOARD_SIZE - playerY == 0)) {  // player is positioned on the upper or lower edge
                for (int i = 0; i<5; i++) {
                    for (int j = 0; j<5; j++) {
                        boardView[i][j] = cells[playerX+i][playerY+j];
                    }
                }
            }
        } else if (playerX == 1) {  // Player's x is within 1 cell of the edge of the bounds
            if ( (playerY >= 2) && (BOARD_SIZE - playerY >= 2)) { // non-edge board view
                for (int i = -1; i<4; i++) {
                    for (int j = -2; j<3; j++) {
                        boardView[i + 1][j+2] = cells[playerX+i][playerY+j];
                    }
                }
            }
            if ( (playerY == 1) || (BOARD_SIZE - playerY == 1)) {  // player position is 1 from the upper or lower edge
                for (int i = -1; i<4; i++) {
                    for (int j = -1; j<4; j++) {
                        boardView[i + 1][j+1] = cells[playerX+i][playerY+j];
                    }
                }
            }
            if ((playerY == 0) || (BOARD_SIZE - playerY == 0)) {  // player is positioned on the upper or lower edge
                for (int i = 0; i<5; i++) {
                    for (int j = 0; j<5; j++) {
                        boardView[i][j] = cells[playerX+i][playerY+j];
                    }
                }
            }
        } else if (playerX == 0) {  // player's x is on the edge of the bounds
            if ( (playerY >= 2) && (BOARD_SIZE - playerY >= 2)) { // non-edge board view
                for (int i = 0; i<5; i++) {
                    for (int j = -2; j<3; j++) {
                        boardView[i][j+2] = cells[playerX+i][playerY+j];
                    }
                }
            }
            if ( (playerY == 1) || (BOARD_SIZE - playerY == 1)) {  // player position is 1 from the upper or lower edge
                for (int i = 0; i<5; i++) {
                    for (int j = -1; j<4; j++) {
                        boardView[i][j+1] = cells[playerX+i][playerY+j];
                    }
                }
            }
            if ((playerY == 0) || (BOARD_SIZE - playerY == 0)) {  // player is positioned on the upper or lower edge
                for (int i = 0; i<5; i++) {
                    for (int j = 0; j<5; j++) {
                        boardView[i][j] = cells[playerX+i][playerY+j];
                    }
                }
            }
        }
    }

    /**
     * prints the boardView array in a visual console format
     */
    public void printBoard() {
        //STUB
        for(int i = 0; i< boardView.length; i++) {
            for (int j = 0; j< boardView.length; j++) {
                System.out.print(boardView[i][j].toString());
            }
            System.out.println();
        }
    }
}
