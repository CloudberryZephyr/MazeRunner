import java.util.Locale;
import java.util.Scanner;

public class Item {
    protected Player p1;
    private int maxHealth;
    protected int blockAmt;
    protected int incomingDamage;
    protected int playerDamage;


    /**
     * Author: Max
     */

    /**
     * does much the same as cell, all items in backpack inherit from this class.
     * @param player
     * @param blockAmt damage that item may block if the damage type can be affected by the item
     * @param incomingDamage damage that trap will deal
     */
    public Item (Player player,int blockAmt, int incomingDamage){
        this.p1 = player;
        this.blockAmt = blockAmt;
        maxHealth = p1.getMaxHealth();
        this.incomingDamage = incomingDamage;
    }

    public String getName(){
        return "Item";
    }

    /**
     * returns the fall damage that is inflicted on player if the player uses an item taht has an effect on
     * fall damage
     */
    public void loseHealthAfterBlock(){
        playerDamage = incomingDamage - blockAmt;
        p1.loseHealth(playerDamage,"f");
    }
}
