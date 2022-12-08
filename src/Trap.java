

public abstract class Trap extends Cell{
    //private String

    private Player p1;
    protected String damageType;
    protected int damageAmt;
    /**
     * Author: Max
     */

    /**
     *  parent cell for all cells that acts on the player
     * @param player
     * @param damageType type of damage trap will inflict
     * @param damageAmt amount of damage trap will inflict (can be 0)
     */

    public Trap(Player player,String damageType, int damageAmt){
        this.p1 = player;
        this.damageType = damageType;
        this.damageAmt = damageAmt;
    }

    /**
     * takes health from player
     * @return amount of damage inflicted
     */

    public abstract int takeDamage();

    /**
     * @return trap symbol to board
     */
    public abstract String toString();

}




