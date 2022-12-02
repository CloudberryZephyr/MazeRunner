import java.util.Scanner;

public class Empty extends Cell{
    private Player p1;
    public Empty(Player player){
        this.p1 = player;
    }


    public void safePlace(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("this is a safe place, an empty room, that will not harm you");

    }

    @Override
    public String toString() {
        if (known) {
            return " ";
        } else {
            return "*";
        }
    }
}
