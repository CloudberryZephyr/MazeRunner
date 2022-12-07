

public abstract class Trap extends Cell{
    //private String

    private Player p1;
    protected String damageType;
    protected int damageAmt;

    public Trap(Player player,String damageType, int damage){
        this.p1 = player;
        this.damageType = damageType;
        this.damageAmt = damage;
    }


    public abstract String toString();

}




