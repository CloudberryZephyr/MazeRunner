public class Healing_Trap extends Cell{
    private Player p1;

    /**
     * Author: Max
     */

    /**
     * offers a room where players health will be refilled
     * @param player
     */
    public Healing_Trap(Player player){
        this.p1 = player;
    }

    /**
     * finds correct health type and refills it to the MaxHealth defined in the player class
     */
    public void refillHealth(){
        // want to change this so that the player is healed at an amount per second.
        // And movement is blocked while healing is taking place.
        System.out.println("Congratulation you found a healing room, this room will refill your health to full");
        p1.setFallHealth(20);
        p1.setGeneralHealth(15);
        p1.setKineticHealth(15);
        System.out.println("Current fall health: " + p1.getFallHealth() + "/20" +
                "\nCurrent kinetic health: " + p1.getKineticHealth() + "/15"+
                "\nCurrent general health: " + p1.getGeneralHealth() + "/15");

    }

    /**
     * @return trap symbol to board
     */
    @Override
    public String toString(){
       return "+";
    }

}
