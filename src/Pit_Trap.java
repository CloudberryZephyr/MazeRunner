public class Pit_Trap extends Trap{

    public Pit_Trap(Player player,String damageType, int damageAmt){
        super(player,damageType,damageAmt);
        this.damageType = "F";
        this.damageAmt = damageAmt;
    }

    @Override
    public int takeDamage() {
        String type = getDamageType();

        return 0;
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
