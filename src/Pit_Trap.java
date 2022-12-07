import java.util.Locale;
import java.util.Scanner;

public class Pit_Trap extends Trap{
    Scanner scan = new Scanner(System.in);
    private Player p1;


    public Pit_Trap(Player player,String damageType, int damageAmt){
        super(player,damageType,damageAmt);
        this.p1 = player;
        this.damageType = "F";
        this.damageAmt = 5;
    }

    public void IO(){
        System.out.println("you have entered a trap room, would you like ot use an item?");
        String YN = scan.nextLine().toLowerCase(Locale.ROOT);
        if(YN.equals("y")){
            System.out.println("What item would you like to use?");
            String ItemCH = scan.nextLine();
            Item it = new Item(p1,0,0);

            it.getItem(p1,15,takeDamage(),ItemCH);

        }
    }



    public int takeDamage() {
        String type = "f";
        int val = p1.getFallHealth() - 5;
        p1.setFallHealth(p1.getFallHealth() - 5);
        return val;
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
