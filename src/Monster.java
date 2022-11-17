/**
 * @author Clara Shoemaker
 * @version 1.0
 */
public class Monster {
    private int health;
    private Location location;

    /**
     * Constructor method that creates a monster object in a location corresponding to given x and y values
     * @param x int value for the monster's starting column
     * @param y int value for the monster's starting row
     */
    public Monster(int x, int y) {
        health = 10;   // initializing monster's health to 10, we'll see if this is practical
        location = new Location(x, y);
    }

    /**
     * This method controls the simple movement pattern in the board of the monster
     * TODO: determine the basic pattern of movement for a monster
     */
    public void move() {
        //STUB
    }
}
