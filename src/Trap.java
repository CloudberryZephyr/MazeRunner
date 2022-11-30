import java.util.ArrayList;
import java.util.Random;


public class Trap extends Cell{
    Random rand = new Random();
    private Player p1;


    ArrayList<String> items;
    ArrayList<Cell> traps;

    public Trap(){
        //this.p1 = player;
    }

    public void loadTrapsL1(){
        traps.add(new Key(p1));
        //traps.add();

    }

    public Cell randTrap(){
        int randNum = rand.nextInt(traps.size()) +1; /* additional int must be changed with the number of known traps that
                                                        must be inserted.  Such as (Key), (Entrance) */
        return traps.get(randNum);
    }
}




