import java.util.Locale;
import java.util.Scanner;

public class Pit_Trap extends Trap{
    Scanner scan = new Scanner(System.in);
    private Player p1;
    protected Item shield;

    /**
     * Author: Max
     */

    /**
     * creates a pit trap cell that does fall damage to player.
     * @param player
     * @param damageType fall damage
     * @param damageAmt
     */
    public Pit_Trap(Player player,String damageType, int damageAmt){
        super(player,damageType,damageAmt);
        this.p1 = player;
        this.damageType = "F";
        this.damageAmt = 5;
    }

    /**
     * informs player that they have found the key and asks them how they would like to retrieve it.
     */

    public void IO() {
        System.out.println("you have entered a Pit trap room, would you like to use an item? Y/N");
        String YN = scan.nextLine().toLowerCase(Locale.ROOT);
        if (YN.equals("y")) {
            System.out.println("What item would you like to use?");
            System.out.println("inventory: shield");
            String itemCH = scan.nextLine();
            String choice = itemCH.toLowerCase();

            if (p1.getBackPack().contains(itemCH)) {
                if (choice.equals("shield")) {
                    shield = new Shield(p1, 5, 10);
                }
                System.out.println("Current fall health: " + p1.getFallHealth() + "/20" +
                        "\nCurrent kinetic health: " + p1.getKineticHealth() + "/15" +
                        "\nCurrent general health: " + p1.getGeneralHealth() + "/15");
            }
        } else if (YN.equals("n")) {
            System.out.println("you should have used your shield");
            takeDamage();
            System.out.println("Current fall health: " + p1.getFallHealth() + "/20" +
                    "\nCurrent kinetic health: " + p1.getKineticHealth() + "/15" +
                    "\nCurrent general health: " + p1.getGeneralHealth() + "/15");
        } else {
            takeDamage();
            System.out.println("Current fall health: " + p1.getFallHealth() + "/20" +
                    "\nCurrent kinetic health: " + p1.getKineticHealth() + "/15" +
                    "\nCurrent general health: " + p1.getGeneralHealth() + "/15");
        }
    }


    /**
     * inflicts fall damage on the player
     * @return current fallDamage health
     */

    public int takeDamage() {
        String type = "k";
        p1.loseHealth(10,type);
        return p1.getFallHealth();
    }



    /**
     * @return trap symbol to board
     */
    @Override
    public String toString() {
        return "P";
    }
}
