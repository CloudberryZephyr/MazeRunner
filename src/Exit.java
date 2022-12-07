import java.util.Locale;
import java.util.Scanner;

public class Exit extends Cell{
    private Player p1;
    private boolean hasKey;
    Scanner scan = new Scanner(System.in);




    public Exit(Player player){
        this.p1 = player;
        this.hasKey = p1.hasKey();

    }


    public boolean endGameTest(){
        System.out.println("You found the exit Tunnel");
        //useItem
        System.out.println("Press T to exit through the tunnel");
        String pc = scan.next().toLowerCase(Locale.ROOT);
        if(pc.equals("t")){
            System.out.println("Good Game, Maze Runner");
            System.out.println("your total time was: ");
        }
        return hasKey;
    }

    @Override
    public String toString(){
        return "@";
    }
}
