import java.util.ArrayList;

/**
 * @author Clara Shoemaker
 * @version 1.1
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
    public Board(int difficulty, Player player) {
        this.difficulty = difficulty;
        this.player = player;
        //BOARD_SIZE = difficulty + 9;  Possible changes to board size depending on game difficulty
        BOARD_SIZE = 10;

        cells = new Cell[BOARD_SIZE][BOARD_SIZE];
        // TODO: random generation of traps in the map
        // currently initializes entire board to be empty
        for (int i = 0; i<BOARD_SIZE; i++){
            for (int j = 0; j<BOARD_SIZE; j++) {
                cells[i][j] = new Empty();
            }
        }

        // initializes board view array
        int playerX = player.getLocation().getX();
        int playerY = player.getLocation().getY();
        if (playerX >= 2) {
            if ( (BOARD_SIZE - playerY >= 2) && (playerY >= 2) ) { // non-edge board view
                boardView[0][0] = cells[playerX-2][playerY-2];
                boardView[0][1] = cells[playerX-2][playerY-1];
                boardView[0][2] = cells[playerX-2][playerY];
                boardView[0][3] = cells[playerX-2][playerY+1];
                boardView[0][4] = cells[playerX-2][playerY+2];
                boardView[1][0] = cells[playerX-1][playerY-2];
                boardView[1][1] = cells[playerX-1][playerY-1];
                boardView[1][2] = cells[playerX-1][playerY];
                boardView[1][3] = cells[playerX-1][playerY+1];
                boardView[1][4] = cells[playerX-1][playerY+2];
                boardView[2][0] = cells[playerX][playerY-2];
                boardView[2][1] = cells[playerX][playerY-1];
                boardView[2][2] = cells[playerX][playerY];
                boardView[2][3] = cells[playerX][playerY+1];
                boardView[2][4] = cells[playerX][playerY+2];
                boardView[3][0] = cells[playerX+1][playerY-2];
                boardView[3][1] = cells[playerX+1][playerY-1];
                boardView[3][2] = cells[playerX+1][playerY];
                boardView[3][3] = cells[playerX+1][playerY+1];
                boardView[3][4] = cells[playerX+1][playerY+2];
                boardView[4][0] = cells[playerX+2][playerY-2];
                boardView[4][1] = cells[playerX+2][playerY-1];
                boardView[4][2] = cells[playerX+2][playerY];
                boardView[4][3] = cells[playerX+2][playerY+1];
                boardView[4][4] = cells[playerX+2][playerY+2];
            }
            if ( (playerY == 1) || (BOARD_SIZE - playerY == 1)) {  // player position is 1 from the upper or lower edge
                boardView[0][0] = cells[playerX-2][playerY-1];
                boardView[0][1] = cells[playerX-2][playerY];
                boardView[0][2] = cells[playerX-2][playerY+1];
                boardView[0][3] = cells[playerX-2][playerY+2];
                boardView[0][4] = cells[playerX-2][playerY+3];
                boardView[1][0] = cells[playerX-1][playerY-1];
                boardView[1][1] = cells[playerX-1][playerY];
                boardView[1][2] = cells[playerX-1][playerY+1];
                boardView[1][3] = cells[playerX-1][playerY+2];
                boardView[1][4] = cells[playerX-1][playerY+3];
                boardView[2][0] = cells[playerX][playerY-1];
                boardView[2][1] = cells[playerX][playerY];
                boardView[2][2] = cells[playerX][playerY+1];
                boardView[2][3] = cells[playerX][playerY+2];
                boardView[2][4] = cells[playerX][playerY+3];
                boardView[3][0] = cells[playerX+1][playerY-1];
                boardView[3][1] = cells[playerX+1][playerY];
                boardView[3][2] = cells[playerX+1][playerY+1];
                boardView[3][3] = cells[playerX+1][playerY+2];
                boardView[3][4] = cells[playerX+1][playerY+2];
                boardView[4][0] = cells[playerX+2][playerY-1];
                boardView[4][1] = cells[playerX+2][playerY];
                boardView[4][2] = cells[playerX+2][playerY+1];
                boardView[4][3] = cells[playerX+2][playerY+2];
                boardView[4][4] = cells[playerX+2][playerY+3];
            }
            if ((playerY == 0) || (BOARD_SIZE - playerY == 0)) {  // player is positioned on the upper or lower edge
                boardView[0][0] = cells[playerX-2][playerY];
                boardView[0][1] = cells[playerX-2][playerY+1];
                boardView[0][2] = cells[playerX-2][playerY+2];
                boardView[0][3] = cells[playerX-2][playerY+3];
                boardView[0][4] = cells[playerX-2][playerY+4];
                boardView[1][0] = cells[playerX-1][playerY];
                boardView[1][1] = cells[playerX-1][playerY+1];
                boardView[1][2] = cells[playerX-1][playerY+2];
                boardView[1][3] = cells[playerX-1][playerY+3];
                boardView[1][4] = cells[playerX-1][playerY+4];
                boardView[2][0] = cells[playerX][playerY];
                boardView[2][1] = cells[playerX][playerY+1];
                boardView[2][2] = cells[playerX][playerY+2];
                boardView[2][3] = cells[playerX][playerY+3];
                boardView[2][4] = cells[playerX][playerY+4];
                boardView[3][0] = cells[playerX+1][playerY];
                boardView[3][1] = cells[playerX+1][playerY+1];
                boardView[3][2] = cells[playerX+1][playerY+2];
                boardView[3][3] = cells[playerX+1][playerY+3];
                boardView[3][4] = cells[playerX+1][playerY+4];
                boardView[4][0] = cells[playerX+2][playerY];
                boardView[4][1] = cells[playerX+2][playerY+1];
                boardView[4][2] = cells[playerX+2][playerY+2];
                boardView[4][3] = cells[playerX+2][playerY+3];
                boardView[4][4] = cells[playerX+2][playerY+4];
            }
        }


    }

    /**
     * prints the boardView array in a visual console format
     */
    public void printBoard() {
        //STUB
    }
}
