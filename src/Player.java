import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author Clara Shoemaker
 * @version 1.2
 */
public class Player {
    private Set<String> backPack;
    private int health;
    private int maxHealth;
    private Location location;
    private final int BOARD_SIZE;
    private LinkedList<Location> path;


    /**
     * player constructor method
     * TODO: determine what to give the player initially
     */
    public Player(int boardSize){
        backPack = new HashSet<>();
        health = 50; // set initial health to 50, we'll see if this is practical or not
        maxHealth = 50;
        location = new Location(0, 0); // starts the player in the top left corner by default
        this.BOARD_SIZE = boardSize;
        path = new LinkedList<>();

    }

    /**
     * moves the Player by changing its location
     * @param direction string representation of the four movement options: up, down, left, and right
     */
    public void move(char direction){
        // changes the player's location according to the given direction
        if (direction == 'w' && location.getY()>0) {
            System.out.println("You found a wall, rerouting is needed");
            location.setLocation(location.getX(), location.getY()-1);
        }
        if (direction == 's' && location.getY()<BOARD_SIZE) {
            location.setLocation(location.getX(), location.getY()+1);
        }
        if (direction == 'a' && location.getX()>0) {
            location.setLocation(location.getX()-1, location.getY());
        }
        if (direction == 'd' && location.getX()<BOARD_SIZE) {
            location.setLocation(location.getX()+1, location.getY());
        }

        // adds the new location to a player path for use by SmartMonsters
        path.add(new Location(location));
    }

    /**
     * Method for losing a given amount of health
     * @param amt int amount of health to lose
     */
    public void loseHealth(int amt){
        health -= amt;
    }

    /**
     * Method for gaining a given amount of health
     * @param amt int amount of health to gain
     */
    public void gainHealth(int amt){
        health += amt;
    }

    /**
     * getter for int data member health
     * @return int value of health variable
     */
    public int getHealth(){
        return health;
    }

    /**
     * getter for maxHealth data member
     * @return int value of maxHealth
     */
    public int getMaxHealth(){
        return maxHealth;
    }

    /**
     * method for determining if the player has picked up the key in the past
     * @return boolean value - true if the key has been picked up, false if it has not
     */
    public boolean hasKey(){
        return backPack.contains("key");
    }

    /**
     * getter method for the player's current location
     * @return Location object for the player - NOTE: this is the same object, not a copy
     */
    public Location getLocation(){
        return location;
    }

    /**
     * fills backpack according to difficulty level
     */
    public void fillBackpack(){
        //TODO finish this method
    }

    /**
     * getter for backpack ArrayList
     * @return object reference for ArrayList object backpack
     */
    public Set<String> getBackPack(){
        return backPack;
    }

    /**
     * getter for path data member
     * @return LinkedList of all past locations travelled by the player, in order.
     */
    public LinkedList<Location> getPath(){
        return path;
    }

    /**
     * determines whether the path ArrayList contains a location identical to a given Location object
     * @param loc Location object whose data members are equal to the desired object in path ArrayList
     * @return whether an identical Location object has been found in path
     */
    public boolean doesPathContain(Location loc) {
        for (Location place : path){
            if (place.equals(loc)){
                return true;
            }
        }
        return false;
    }
}
