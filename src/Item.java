import java.util.Locale;
import java.util.Scanner;

public class Item {
    protected Player p1;
    private int maxHealth;
    protected int blockAmt;
    protected int incomingDamage;
    protected int playerDamage;
    protected Item shield;
    Scanner scan = new Scanner(System.in);


    public Item (Player player,int blockAmt, int incomingDamage){
        this.p1 = player;
        this.blockAmt = blockAmt;
        maxHealth = p1.getMaxHealth();
        this.incomingDamage = incomingDamage;
    }

    public String getName(){
        return "Item";
    }


    public void loseHealthAfterBlock(){
        playerDamage = incomingDamage - blockAmt;
        p1.loseHealth(playerDamage,"f");
    }

    public int getCurHealth(){
        return p1.getHealth();
    }
    public int getMaxHealth(){
        return maxHealth;
    }
}
