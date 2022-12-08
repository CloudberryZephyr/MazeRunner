import java.util.Locale;
import java.util.Scanner;

public class Pit_Trap extends Trap{
    Scanner scan = new Scanner(System.in);
    private Player p1;
    protected Item shield;


    public Pit_Trap(Player player,String damageType, int damageAmt){
        super(player,damageType,damageAmt);
        this.p1 = player;
        this.damageType = "F";
        this.damageAmt = damageAmt;
    }

    public void IO(){
        System.out.println("you have entered a trap room, would you like ot use an item?");
        String YN = scan.nextLine().toLowerCase(Locale.ROOT);
        if(YN.equals("y")) {
            System.out.println("What item would you like to use?");
            String itemCH = scan.nextLine();
            //Item it = new Item(p1,0,0);
            String choice = itemCH.toLowerCase();

            if (p1.getBackPack().contains(itemCH)) {
                if (choice.equals("shield")) {
                    shield = new Shield(p1, 2, damageAmt);
                }
                //p1.getBackPack().remove(itemCH);

                //it.getItem(p1,15,takeDamage(),itemCH);
                System.out.println("Current health: " + p1.getHealth() + "/" + p1.getMaxHealth());

            }
        }
        else if(YN.equals("n")) {
                System.out.println("you should have used your shield");
                takeDamage();
                System.out.println("Current health: " + p1.getHealth() + "/" + p1.getMaxHealth());
        } else{
            takeDamage();
            System.out.println("Current health: " + p1.getHealth() + "/" + p1.getMaxHealth());

        }
    }



    public int takeDamage() {
        String type = "K";
        p1.loseHealth(10,type);
        return p1.getFallHealth();
    }


    @Override
    public int getDamageAmt() {
        return damageAmt;
    }

    @Override
    public String getDamageType() {
        return damageType;
    }

    @Override
    public String toString() {
        return "P";
    }
}
