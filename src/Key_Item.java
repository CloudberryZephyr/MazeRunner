public class Key_Item extends Item{
    //allows key item to be added to bag, the Key class has all the Key Room I-O
    public Key_Item(Player player, int blockAmt, int incomingDamage) {
        super(player, blockAmt, incomingDamage);
    }

    @Override
    public String getName() {
        return "Key";
    }
}
