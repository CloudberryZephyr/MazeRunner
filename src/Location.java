import java.util.ArrayList;

/**
 * @author Clara Shoemaker
 * @version 1.2
 */
public class Location {
    private int x;
    private int y;

    /**
     * A constructor method that takes two int values for a given location
     * within the limits of the Board class's board array
     *
     * @param x int value for the column of the location
     * @param y int value for the row of the location
     */
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Copy constructor for Location class
     * @param loc Location object to be copied
     */
    public Location(Location loc){
        x = loc.x;
        y = loc.y;

    }

    /**
     * a combined setter for the x and y data members
     * @param x int value for the column of the location
     * @param y int value fot the row of the location
     */
    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * a getter for the x data member
     * @return int value for variable x
     */
    public int getX(){
        return x;
    }

    /**
     * a getter for the y data member
     * @return int value for variable y
     */
    public int getY(){
        return y;
    }

    @Override
    public boolean equals(Object other){
        if (other == this) {
            return true;
        }
        if (!(other instanceof Location)) {
            return false;
        }
        Location loc = (Location)other;
        if(loc.x==this.x && loc.y==this.y) {
            return true;
        }
        return false;
    }

    public boolean testForMonsters(ArrayList<Monster> monsters){
        for (Monster m : monsters) {
            if (m.getLocation().equals(this)){
                return true;
            }
        }
        return false;
    }

}