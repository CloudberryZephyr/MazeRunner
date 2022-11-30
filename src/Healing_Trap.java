public class Healing_Trap extends Trap{
    private Player p1;

    public Healing_Trap(Player player){
        this.p1 = player;
    }



    public void refillHealth(int rateOfHealing){
        // want to change this so that the player is healed at an amount per second.
        // And movement is blocked while healing is taking place.
        System.out.println("Congratulation you found a healing room, this room will refill your health to full");
        int fillAmt = p1.getMaxHealth() -  p1.getHealth();
        p1.gainHealth(fillAmt);
    }

}
