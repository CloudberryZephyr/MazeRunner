import java.util.Locale;
import java.util.Scanner;

public abstract class Item {
    private Player p1;
    private int maxHealth;
    protected int blockAmt;
    protected int incomingDamage;
    protected int playerDamage;
    Scanner scan = new Scanner(System.in);


    public Item (Player player,int blockAmt, int incomingDamage){
        this.p1 = player;
        this.blockAmt = blockAmt;
        maxHealth = p1.getMaxHealth();
        this.incomingDamage = incomingDamage;
    }

    public abstract String getName();

    public void loseHealthAfterBlock(){
        playerDamage = incomingDamage - blockAmt;
        p1.loseHealth(playerDamage,"fallDamage");
    }

    public void useItem(){
        System.out.println("would you like to use an item?");
        String itemYN = scan.nextLine().toLowerCase(Locale.ROOT);
        if(itemYN.equals("y")){
            System.out.println("which item would you like to use?");
            System.out.println(p1.getBackPack());
            int itemCH = scan.nextInt();

        }
    }
    public int getCurHealth(){
        return p1.getHealth();
    }
    public int getMaxHealth(){
        return maxHealth;
    }

}
