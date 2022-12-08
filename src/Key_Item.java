public class Key_Item extends Item{
    //allows key item to be added to bag, the Key class has all the Key Room I-O
    /**
     * Author: Max
     */

    /**
     * allows player to add key to backpack.
     * @param player
     * @param blockAmt if the item negates specific damage type the amount will be given here
     * @param incomingDamage amount of damage coming from trap.
     */
    public Key_Item(Player player, int blockAmt, int incomingDamage) {
        super(player, blockAmt, incomingDamage);
    }

    /**
     * @return trap symbol to board
     */
    @Override
    public String getName() {
        return "Key";
    }
}
