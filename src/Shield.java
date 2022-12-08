public class Shield extends Item{
    private String name;
    private int incomingDamage;


    public Shield(Player player, int blockAmt, int incomingDamage){
        super(player, blockAmt, incomingDamage);
        this.name = "Shield";
        this.blockAmt = blockAmt;
        this.incomingDamage = incomingDamage;
        loseHealthAfterBlock();
    }


    public void loseHealthAfterBlock(){
        playerDamage = incomingDamage - blockAmt;
        p1.loseHealth(playerDamage,"f");
    }



    public String getName() {
        return name;
    }








}
