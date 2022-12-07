public class Shield extends Item{
    private String name;


    public Shield(Player player, int blockAmt, int incomingDamage){
        super(player, blockAmt, incomingDamage);
        this.name = "Shield";
    }


    public String getName() {
        return name;
    }








}
