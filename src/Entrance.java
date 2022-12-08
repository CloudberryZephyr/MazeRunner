public class Entrance extends Cell {
    private Player p1;
    /**
     * Author: Max
     */

    /**
     * creates the entrance cell and loads player into it.
     * the entrance cell is only displayed if the user moves back to its location.
     * @param player
     */

    public Entrance(Player player) {
        this.p1 = player;
    }

    @Override
    public String toString(){
        return "#";
    }


}
