import java.util.ArrayList;
import java.util.Random;

/**
 * @author Clara Shoemaker
 * @version 1.5
 */
public class Board {
    // data members
    private Cell[][] cells;
    private Cell[][] boardView;
    private int difficulty;
    private final int BOARD_SIZE;
    private Player player;

    private Random rand;

    /**
     * Constructor class - initializes all data members, constructs the board of play according to a given difficulty
     *
     * @param difficulty an int value that determines the density of traps, number of monsters, etc.
     * @param player Player object corresponding to the current player character in Main class
     */
    public Board(int difficulty, Player player, int boardSize) {
        this.difficulty = difficulty;
        this.player = player;
        //BOARD_SIZE = difficulty + 9;  Possible changes to board size depending on game difficulty
        BOARD_SIZE = boardSize;
        rand = new Random();

        cells = new Cell[BOARD_SIZE][BOARD_SIZE];
        boardView = new Cell[5][5];
        // TODO: random generation of traps in the map

        // currently initializes the base board in a default setting - no traps
        int keyRow = rand.nextInt(1, BOARD_SIZE);
        int keyCol = rand.nextInt(1, BOARD_SIZE);
        for (int i = 0; i<BOARD_SIZE; i++){
            for (int j = 0; j<BOARD_SIZE; j++) {
                if (i==0 && j==0){
                    cells[i][j] = new Entrance(player);
                } else if (i == BOARD_SIZE-1 && j == BOARD_SIZE-1){
                    cells[i][j] = new Exit(player);
                } else if (i==keyRow && j == keyCol){
                    cells[i][j] = new Key(player.hasKey(), player);
                } else {
                        cells[i][j] = new Empty(player);
                }
            }
        }

        // initializes board view array assuming the player starts at 0, 0
        for (int i=0; i<5; i++){
            for (int j=0; j<5; j++) {
                boardView[i][j] = cells[i][j];
            }
        }
    }

    /**
     * prints the boardView array in a visual console format
     */
    public void printBoard(Location location) {
        //STUB
        int playerRow = location.getY();//player.getLocation().getX();
        int playerCol = location.getX();//player.getLocation().getY();
        if (playerRow >= 2) {
            if ( (playerCol >= 2) && (BOARD_SIZE - playerCol >= 2)) { // non-edge board view
                for (int i = -2; i<3; i++) {
                    for (int j = -2; j<3; j++) {
                        boardView[i + 2][j+2] = cells[playerRow+i][playerCol+j];
                    }
                }
            }
            if ( (playerCol == 1) || (BOARD_SIZE - playerCol == 1)) {  // player position is 1 from the upper or lower edge
                for (int i = -1; i<4; i++) {
                    for (int j = -1; j<4; j++) {
                        boardView[i + 1][j+1] = cells[playerRow+i][playerCol+j];
                    }
                }
            }
            if ((playerCol == 0) || (BOARD_SIZE - playerCol == 0)) {  // player is positioned on the upper or lower edge
                for (int i = 0; i<5; i++) {
                    for (int j = 0; j<5; j++) {
                        boardView[i][j] = cells[playerRow+i][playerCol+j];
                    }
                }
            }
        } else if (playerRow == 1) {  // Player's x is within 1 cell of the edge of the bounds
            if ( (playerCol >= 2) && (BOARD_SIZE - playerCol >= 2)) { // non-edge board view
                for (int i = -1; i<4; i++) {
                    for (int j = -2; j<3; j++) {
                        boardView[i + 1][j+2] = cells[playerRow+i][playerCol+j];
                    }
                }
            }
            if ( (playerCol == 1) || (BOARD_SIZE - playerCol == 1)) {  // player position is 1 from the upper or lower edge
                for (int i = -1; i<4; i++) {
                    for (int j = -1; j<4; j++) {
                        boardView[i + 1][j+1] = cells[playerRow+i][playerCol+j];
                    }
                }
            }
            if ((playerCol == 0) || (BOARD_SIZE - playerCol == 0)) {  // player is positioned on the upper or lower edge
                for (int i = 0; i<5; i++) {
                    for (int j = 0; j<5; j++) {
                        boardView[i][j] = cells[playerRow+i][playerCol+j];
                    }
                }
            }
        } else if (playerRow == 0) {  // player's x is on the edge of the bounds
            if ( (playerCol >= 2) && (BOARD_SIZE - playerCol >= 2)) { // non-edge board view
                for (int i = 0; i<5; i++) {
                    for (int j = -2; j<3; j++) {
                        boardView[i][j+2] = cells[playerRow+i][playerCol+j];
                    }
                }
            }
            if ( (playerCol == 1) || (BOARD_SIZE - playerCol == 1)) {  // player position is 1 from the upper or lower edge
                for (int i = 0; i<5; i++) {
                    for (int j = -1; j<4; j++) {
                        boardView[i][j+1] = cells[playerRow+i][playerCol+j];
                    }
                }
            }
            if ((playerCol == 0) || (BOARD_SIZE - playerCol == 0)) {  // player is positioned on the upper or lower edge
                for (int i = 0; i<5; i++) {
                    for (int j = 0; j<5; j++) {
                        boardView[i][j] = cells[playerRow+i][playerCol+j];
                    }
                }
            }
        }

        // Print out board
        for(int i = 0; i< boardView.length; i++) {
            for (int j = 0; j< boardView.length; j++) {
                if(boardView[i][j] == cells[playerRow][playerCol]){
                    System.out.print(" U ");
                } else {
                    System.out.print(boardView[i][j].toString() + " ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Returns the cell object at a given location in the cells array
     * @param x row value for desired location
     * @param y column value for desired location
     * @return Cell object at desired location in cells array
     */
    public Cell getCellAt(int x, int y) {
        return cells[x][y];
    }

    /**
     * adds traps to cell array to create randomized board
     * @param difficulty int value of level difficulty
     */
    public void randomizeTraps(int difficulty) {
        ArrayList<Cell> traps = new ArrayList<>();

        if(difficulty==1){
            traps.add(new Key(true, player));
            traps.add(new Wall());
            traps.add(new Empty(player));
            traps.add(new BackPack_Refil());
            //traps.add(new Healing_Trap(p1));
        } else if (difficulty==2) {
            traps.add(new Key(true, player));
            traps.add(new Wall());
            traps.add(new Empty(player));

            //traps.add(new Healing_Trap(p1));
        }
    }

    public int getBOARD_SIZE(){return BOARD_SIZE;}
}
