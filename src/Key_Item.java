public class Key_Item extends Item{
    public Key_Item(Player player, int blockAmt, int incomingDamage) {
        super(player, blockAmt, incomingDamage);

    }

    @Override
    public String getName() {
        return "Key";
    }
}
