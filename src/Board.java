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
    private ArrayList<Cell> traps;
    private ArrayList<Monster> monsters;


    /**
     * Constructor class - initializes all data members, constructs the board of play according to a given difficulty
     *
     * @param difficulty an int value that determines the density of traps, number of monsters, etc.
     * @param player Player object corresponding to the current player character in Main class
     */
    public Board(int difficulty, Player player, int boardSize) {
        this.difficulty = difficulty;
        this.player = player;
        BOARD_SIZE = boardSize;
        rand = new Random();
        monsters = new ArrayList<>();
        for (int i = 0; i<difficulty; i++){
            monsters.add(new Monster(boardSize-1, boardSize-1, 10));
            monsters.add(new SmartMonster(boardSize-1, boardSize-1, 10, player));
        }

        cells = new Cell[BOARD_SIZE][BOARD_SIZE];
        boardView = new Cell[5][5];

        // currently initializes the base board in a default setting - no traps
        int keyRow = rand.nextInt(1, BOARD_SIZE);
        int keyCol = rand.nextInt(1, BOARD_SIZE);
        initializeTraps(difficulty);
        Cell previous = new Empty(player);
        for (int i = 0; i<BOARD_SIZE; i++){
            for (int j = 0; j<BOARD_SIZE; j++) {
                if (i==0 && j==0){
                    cells[i][j] = new Entrance(player);
                } else if (i == BOARD_SIZE-1 && j == BOARD_SIZE-1){
                    cells[i][j] = new Exit(player);
                } else if (i==keyRow && j == keyCol) {
                    cells[i][j] = new Key(player.hasKey(), player);
                 }else if(previous instanceof Wall){
                    cells[i][j] = new Empty(player);
                } else {
                    cells[i][j] = traps.get(rand.nextInt(0,traps.size()));
                }
                previous = cells[i][j];
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
    public void printBoard(Player player) {
        int playerX = player.getLocation().getX();
        int playerY = player.getLocation().getY();

        for (int i = 0; i< BOARD_SIZE; i++) {
            System.out.print("--");
        }
        System.out.println();
        for (int i = 0; i<BOARD_SIZE; i++){
            for (int j = 0; j<BOARD_SIZE; j++){
                Location thisLoc = new Location(i,j);
                if(j==0){
                    System.out.print("|");
                }
                if ( (i<playerX-2) || (j < playerY-2) || (i>playerX+2) || (j>playerY+2)) {
                    System.out.print("  ");
                } else if (i == playerX && j == playerY) {
                    System.out.print("U ");
                    if (thisLoc.testForMonsters(monsters)){
                        player.isAlive = false;
                    }
                } else if (thisLoc.testForMonsters(monsters)){
                    System.out.print("  ");
                } else if (player.doesPathContain(new Location(i,j))) {
                    System.out.print(cells[i][j].toString() + " ");
                } else {
                    System.out.print("* ");
                }
                if (j==BOARD_SIZE-1){
                    System.out.print("|");
                }
            }
            System.out.println();
        }
        for (int i = 0; i< BOARD_SIZE; i++) {
            System.out.print("--");
        }
        System.out.println();
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
    public void initializeTraps(int difficulty) {
        traps = new ArrayList<>();

        if(difficulty==3){
            traps.add(new Wall()); // don't change this wall location -> max
            traps.add(new Empty(player));
            traps.add(new BackPack_Refil());
            traps.add(new Pit_Trap(player,"f",5));
            traps.add(new Healing_Trap(player));
        } else if (difficulty==2) {
            traps.add(new Wall());
            traps.add(new Empty(player));
            traps.add(new Healing_Trap(player));
        } else if (difficulty==1){
            //traps.add(new Wall());
            traps.add(new Empty(player));


        }
    }

    public int getBOARD_SIZE(){return BOARD_SIZE;}

    public ArrayList<Monster> getMonsters(){
        return monsters;
    }

    public void setCellAt(int x, int y, Cell cell){
        cells[x][y] = cell;
    }

}
