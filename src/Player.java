import java.util.ArrayList;

public class Player {
    private ArrayList<String> backPack;
    private int health;
    private Location location;

    /**
     * player constructor method
     * TODO: determine what to give the player initially
     * TODO: determine where to start the player
     * TODO: is there one player throughout the game, or a new player object for each level?
     */
    public Player(){
        backPack = new ArrayList<>();
        health = 50; // set initial health to 50, we'll see if this is practical or not
        location = new Location(0, 0); // starts the player in the top left corner by default
    }

    /**
     * moves the Player by changing its location
     * @param direction string representation of the four movement options: up, down, left, and right
     *                  TODO: what key words are we going to use?
     */
    public void move(String direction){
        if (direction.equals("up") && location.getY()>0) {
            location.setLocation(location.getX(), location.getY()-1);
        }
        if (direction.equals("down") && location.getY()</* some measure for max board y */) {
            location.setLocation(location.getX(), location.getY()+1);
        }
        if (direction.equals("left") && location.getX()>0) {
            location.setLocation(location.getX()-1, location.getY());
        }
        if (direction.equals("right") && location.getX()</* some measure for max board x */) {
            location.setLocation(location.getX()+1, location.getY());
        }
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
     * method for determining if the player has picked up the key in the past
     * @return boolean value - true if the key has been picked up, false if it has not
     */
    private boolean hasKey(){
        return backPack.contains("key");
    }

    /**
     * getter method for the player's current location
     * @return Location object for the player - NOTE: this is the same object, not a copy
     */
    public Location getLocation(){
        return location;
    }
}
