public abstract class Item {
    private Player p1;
    private int maxHealth;
    protected int blockAmt;
    protected int incomingDamage;
    protected int playerDamage;


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

    public int getCurHealth(){
        return p1.getHealth();
    }
    public int getMaxHealth(){
        return maxHealth;
    }

}
