import java.util.Locale;
import java.util.Scanner;
import java.util.Timer;

public class Exit extends Cell{
    private Player p1;
    Scanner scan = new Scanner(System.in);
    /**
     * Author: Max
     */

    /**
     * creates Exit cell that the player must locate within the maze.
     * the exit cell is located at the farthest point from the entrance.
     * @param player
     */

    public Exit(Player player){
        this.p1 = player;

    }

    /**
     * tests weather the player can exit the maze and gives instructions to player if they have not met the win
     * conditions.
     * @return return dictates if the game loop in main should be ended
     */
    public boolean endGameTest(){
        System.out.println("You found the exit tunnel gate");
        if (p1.hasKey()) {
            System.out.println("Press K: to use your key to exit through the tunnel");
            String pc = scan.next().toLowerCase(Locale.ROOT);
            if (pc.equals("k")) {
                System.out.println("Good Game, Maze Runner");
                System.out.println("your total time was: " + Stopwatch.getElapsedTimeSecs() + " seconds"); // minutes
                return true;
            } else {
                System.out.println("The game will continue");
            }
        } else if(!p1.hasKey()){
            System.out.println("You don't have the key yet.  Please return with the key.");
        } else{
            System.out.println("The game will continue");
        }

        return false;
    }

    @Override
    public String toString(){
        return "@";
    }
}
