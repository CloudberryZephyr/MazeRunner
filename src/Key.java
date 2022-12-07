import javax.security.auth.callback.ConfirmationCallback;
import java.util.Locale;
import java.util.Scanner;

public class Key extends Cell{
    private Player player;
    private boolean keyFound;
//    private int playerCurX = player.getLocation().getX();
//    private int playerCurY = player.getLocation().getY();


    public Key(boolean found, Player p1){
        this.player = p1;
        this.keyFound = found;
    }

    public void interAction(){
        Scanner scan = new Scanner(System.in);
        System.out.println("You have entered the key room, there is a golden key hanging from a string from the ceiling");
        System.out.println("Press 'C' to cut the string \n Press 'P' to pull the string down \n press 'I' to ignore an obvios trap");

        char pick =  scan.next().toUpperCase().charAt(0);

        if(pick == 'C'){
            System.out.println("Good choice you found the key, please proceed to the nearest exit");


            player.getBackPack().add("Key");
        } else if(pick == 'P'){
            System.out.println("Why would you pull it??? You just pulled the roof down on your head");
            player.loseHealth(5,"k");

        }else if (pick == 'I'){
            System.out.println("Was that the right choice? you'll find out later...");
        }
    }

    @Override
    public String toString() {
        return "k";
    }

}
