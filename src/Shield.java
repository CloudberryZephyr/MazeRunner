public class Shield extends Item{
    private String name;
    private int incomingDamage;


    public Shield(Player player, int blockAmt, int incomingDamage){
        super(player, blockAmt, incomingDamage);
        this.name = "Shield";
        this.blockAmt = 5;
        this.incomingDamage = incomingDamage;
        loseHealthAfterBlock();
    }

    public int takeDamage() {
        String type = "f";

        p1.loseHealth(incomingDamage,type);
        return p1.getFallHealth();
    }

    public void loseHealthAfterBlock(){
        playerDamage = incomingDamage - blockAmt;
        p1.loseHealth(playerDamage,"f");
    }



    public String getName() {
        return name;
    }








}
