public class Shield extends Item{
    private String name;
    private int incomingDamage;


    public Shield(Player player, int blockAmt, int incomingDamage){
        super(player, blockAmt, incomingDamage);
        this.name = "Shield";
        this.blockAmt = 15;
        this.incomingDamage = incomingDamage;
    }



    public String getName() {
        return name;
    }








}
