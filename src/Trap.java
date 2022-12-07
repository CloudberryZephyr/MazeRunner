

public abstract class Trap extends Cell{
    //private String

    private Player p1;
    protected String damageType;
    protected int damageAmt;

    public Trap(Player player,String damageType, int damageAmt){
        this.p1 = player;
        this.damageType = damageType;
        this.damageAmt = damageAmt;
    }

    public abstract int takeDamage();
    public abstract int getDamageAmt();
    public abstract String getDamageType();
    public abstract String toString();

}




