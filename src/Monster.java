import java.util.Random;

/**
 * @author Clara Shoemaker
 * @version 1.2
 */
public class Monster {
    protected Location location;
    private Random rand;

    /**
     * Constructor method that creates a monster object in a location corresponding to given x and y values
     * @param x int value for the monster's starting column
     * @param y int value for the monster's starting row
     */
    public Monster(int x, int y) {
        location = new Location(x, y);
        rand = new Random();
    }

    /**
     * This method controls the simple movement pattern in the board of the monster
     */
    public void move(int boardSize) {
         int direction = rand.nextInt(4);
         if (direction == 0 && location.getY()>0){
             location.setLocation(location.getX(), location.getY()-1);
         } else if (direction == 1 && location.getY()<boardSize){
             location.setLocation(location.getX(), location.getY()+1);
         } else if (direction == 2 && location.getX()>0){
             location.setLocation(location.getX()-1, location.getY());
         } else if (direction == 3 && location.getX()<boardSize){
             location.setLocation(location.getX()+1, location.getY());
         }
    }

    /**
     * getter for monster's Location
     * @return Location object tracking monster's position in the board
     */
    public Location getLocation(){
        return location;
    }
}
