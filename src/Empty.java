import java.util.Scanner;

public class Empty extends Cell{
    private Player p1;
    /**
     * Author: Max
     */

    /**
     * Empty provides a safe place for the player to go without worrying about traps
     * @param player
     */
    public Empty(Player player){
        this.p1 = player;
    }


    @Override
    public String toString() {
        return ".";
    }
}
