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

    private int fallHealth;

    private int kineticHealth;

    private int generalHealth;

    private Location location;

    private final int BOARD_SIZE;

    private LinkedList<Location> path;

    private boolean isAlive = true;



    /**
     * player constructor method
     * TODO: determine what to give the player initially
     */
    public Player(int boardSize){
        backPack = new HashSet<>();
        fallHealth = 20;
        kineticHealth = 15;
        generalHealth = 15;
        health = fallHealth + kineticHealth + generalHealth; // set initial health to 50, we'll see if this is practical or not
        maxHealth = health;

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
        if (direction == 'a' && location.getY()>0) {
            location.setLocation(location.getX(), location.getY()-1);
        }
        if (direction == 'd' && location.getY()<BOARD_SIZE-1) {
            location.setLocation(location.getX(), location.getY()+1);
        }
        if (direction == 'w' && location.getX()>0) {
            location.setLocation(location.getX()-1, location.getY());
        }
        if (direction == 's' && location.getX()<BOARD_SIZE-1) {
            location.setLocation(location.getX()+1, location.getY());
        }

        // adds the new location to a player path for use by SmartMonsters
        path.add(new Location(location));
    }

    /**
     * Method for losing a given amount of health
     * @param amt int amount of health to lose
     */
    public void loseHealth(int amt, String type){ // this is getting very complicated and may be better to do one damage type
        if(type.equals("K")){
            if(kineticHealth > amt) {
                kineticHealth = kineticHealth - amt;
            } else if(kineticHealth < amt) {
                    System.out.println("you died");
            }
        }

        if(type.equals("f")){
            if(fallHealth > amt) {
                fallHealth = fallHealth - amt;
            } else if(fallHealth > 0 && fallHealth < amt){
                int minus = fallHealth-amt;
                if(minus < kineticHealth) {
                    kineticHealth = kineticHealth - minus;
                } else {
                    System.out.println("You Died, your kinetic health ran out.");
                    isAlive = false;
                }
            } else if(fallHealth == 0 && kineticHealth > amt){
                kineticHealth = kineticHealth - amt;
            } else if(fallHealth ==0 && kineticHealth < amt){
                System.out.println("You died, your fall health and or kinetic health have ran out");
                isAlive = false;
            }
        }

        if(type.equals("g")){
            if(generalHealth > amt) {
                generalHealth = generalHealth - amt;
            }
            if(generalHealth < amt){
                System.out.println("You Died, your life force threw in the towel");
                isAlive = false;
            }
        }

        health = fallHealth + kineticHealth + generalHealth;

    }

    /**
     * Method for gaining a given amount of health
     * @param amt int amount of health to gain
     */
    public void gainHealth(int amt){
        health += amt;
    }

    /**
     * method for determining if the player has picked up the key in the past
     * @return boolean value - true if the key has been picked up, false if it has not
     */
    public boolean hasKey(){
        return backPack.contains("Key");
    }

    /**
     * fills backpack according to difficulty level
     */
    public void fillBackpack(){
        //TODO finish this method
        backPack.add("Nuke");
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

    /**
     * Adds a String representing an Item to the backpack hashset
     * @param thing String value to be added to backpack
     */
    public void addToBackpack(String thing){
        backPack.add(thing);
    }







    /* GETTERS AND SETTERS */

    /**
     * getter for fallHeath data member
     * @return int value of fallHealth
     */
    public int getFallHealth() {
        return fallHealth;
    }

    /**
     * setter for fallHealth data member
     * @param fallHealth desired int value of fallHealth
     */
    public void setFallHealth(int fallHealth) {
        this.fallHealth = fallHealth;
    }

    /**
     * getter for kineticHealth data member
     * @return int value of kineticHealth
     */
    public int getKineticHealth() {
        return kineticHealth;
    }

    /**
     * setter for kineticHealth data member
     * @param kineticHealth desired int value for kineticHealth
     */
    public void setKineticHealth(int kineticHealth) {
        this.kineticHealth = kineticHealth;
    }

    /**
     * getter for generalHealth data member
     * @return int value of generalHealth
     */
    public int getGeneralHealth() {
        return generalHealth;
    }

    /**
     * setter for generalHealth data member
     * @param generalHealth desired int value for generalHealth
     */
    public void setGeneralHealth(int generalHealth) {
        this.generalHealth = generalHealth;
    }

    /**
     * getter for isAlive data member
     * @return boolean value of isAlive
     */
    public boolean getIsAlive() {
        return isAlive;
    }

    /**
     * setter for isAlive data member
     * @param v desired boolean value for isAlive
     */
    public void setIsAlive(boolean v) {
        isAlive = v;
    }

    /**
     * getter for int data member health
     * @return int value of health variable
     */
    public int getHealth() {
        return health;
    }

    /**
     * getter for maxHealth data member
     * @return int value of maxHealth
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * getter method for the player's current location
     * @return Location object for the player - NOTE: this is the same object, not a copy
     */
    public Location getLocation() {
        return location;
    }

    /**
     * setter for location data member
     * @param loc desired Location object corresponding to the player's desired location in the board
     */
    public void setLocation(Location loc){
        location = loc;
    }

    /**
     * getter for backpack ArrayList
     * @return object reference for ArrayList object backpack
     */
    public Set<String> getBackPack() {
        return backPack;
    }

    /**
     * getter for path data member
     * @return LinkedList of all past locations travelled by the player, in order.
     */
    public LinkedList<Location> getPath() {
        return path;
    }

    /**
     * setter for LinkedList<Location></Location> data member path
     * @param path desired LinkedList<Location></Location> object to be referenced by path data member
     */
    public void setPath(LinkedList<Location> path) {
        this.path = path;
    }
}
