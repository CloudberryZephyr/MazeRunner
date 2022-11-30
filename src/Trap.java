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
        traps.add(new Key(true, p1));

        //traps.add(new Healing_Trap(p1));


    }

    public Cell randTrap(){

        //for(int i =0; i < )
        int randNum = rand.nextInt(traps.size()); /* additional int must be changed with the number of known traps that
                                                        must be inserted.  Such as (Key), (Entrance) */
        return traps.get(randNum);
    }
}




