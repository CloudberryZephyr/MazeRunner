import java.util.Random;

/**
 * @author Clara Shoemaker
 * @version 1.2
 */
public class Monster {
    private int health;
    protected Location location;
    private Random rand;

    protected Board level;

    /**
     * Constructor method that creates a monster object in a location corresponding to given x and y values
     * @param x int value for the monster's starting column
     * @param y int value for the monster's starting row
     */
    public Monster(int x, int y, Board level) {
        health = 10;   // initializing monster's health to 10, we'll see if this is practical
        location = new Location(x, y);
        rand = new Random();
        this.level = level;
    }

    /**
     * This method controls the simple movement pattern in the board of the monster
     */
    public void move() {
         int direction = rand.nextInt(4);
         if (direction == 0){
             location.setLocation(location.getX(), location.getY()-1);
         } else if (direction == 1){
             location.setLocation(location.getX(), location.getY()+1);
         } else if (direction == 2){
             location.setLocation(location.getX()-1, location.getY());
         } else if (direction == 3){
             location.setLocation(location.getX()+1, location.getY());
         }
    }
}
