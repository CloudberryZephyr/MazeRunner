import java.util.Locale;
import java.util.Scanner;
import java.util.Timer;

public class Exit extends Cell{
    private Player p1;
    Scanner scan = new Scanner(System.in);




    public Exit(Player player){
        this.p1 = player;

    }


    public boolean endGameTest(){
        System.out.println("You found the exit Tunnel");
        if (p1.hasKey()) {
            System.out.println("Press T to exit through the tunnel");
            String pc = scan.next().toLowerCase(Locale.ROOT);
            if (pc.equals("t")) {
                System.out.println("Good Game, Maze Runner");
                System.out.println("your total time was: " + Stopwatch.getElapsedTimeSecs());
            }
            return true;
        } else {
            System.out.println("You don't have the key yet.  Please return with the key.");
        }
        return false;
    }

    @Override
    public String toString(){
        return "@";
    }
}
