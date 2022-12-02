/**
 * @author Clara Shoemaker
 * @version 1.1
 */
public class SmartMonster extends Monster{
    private Player player;

    /**
     * Constructor method for the smart monster, functionally the same as for its parent class
     * @param x int value for the smartMonster's starting column
     * @param y int value for the smartMonster's starting row
     */
    public SmartMonster(int x, int y, Board level, Player player){
        super(x,y,level);
        this.player = player;
    }

    /**
     * This method is a basic AI process that controls the smartMonster's tracking behavior and movement
     */
    @Override
    public void move(){
        if (level.getCellAt(location.getX(), location.getY()).isKnown()){
            int placeInPlayerPath=0;
            for(Location loc : player.getPath()) {
                if(location.equals(loc)) {
                    placeInPlayerPath = player.getPath().indexOf(loc);
                }
            }
            location = player.getPath().get(placeInPlayerPath+1);
        } else {
            move();
        }
    }
}
