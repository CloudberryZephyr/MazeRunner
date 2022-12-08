public class Shield extends Item{
    private String name;
    private int incomingDamage;

    /**
     * Author: Max
     */

    /**
     * creates new shield item that can be added to the backpack
     * @param player
     * @param blockAmt amount the shield will block
     * @param incomingDamage amount of damage incoming
     */
    public Shield(Player player, int blockAmt, int incomingDamage){
        super(player, blockAmt, incomingDamage);
        this.name = "Shield";
        this.blockAmt = blockAmt;
        this.incomingDamage = incomingDamage;
        loseHealthAfterBlock();
    }


//    public void loseHealthAfterBlock(){
//        playerDamage = incomingDamage - blockAmt;
//        p1.loseHealth(playerDamage,"f");
//    }


    /**
     * @return name of item in the backpack
     */
    public String getName() {
        return name;
    }








}
