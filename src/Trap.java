import java.util.ArrayList;



public class Trap extends Cell{

    private Player p1;


    ArrayList<String> items;
    public Trap(){
        //this.p1 = player;
    }
    ArrayList<Cell> traps;


    /**
     * Method hard codes traps into level 1
     * Hard Coded so that we can have exact control over how many traps
     * are in the maze and the difficulty.
     */

    public void loadTrapsL1(){
        traps.add(new Key(true, p1));
        traps.add(new Wall());
        traps.add(new Empty(p1));
        traps.add(new BackPack_Refil());
        //traps.add(new Healing_Trap(p1));

    }
    /**
     * Method hard codes traps into level 2
     * Provides the same utility as the method above but for level 2.
     */

    public void loadTrapsL2(){
        traps.add(new Key(true, p1));
        traps.add(new Wall());
        traps.add(new Empty(p1));

        //traps.add(new Healing_Trap(p1));

    }


    //public abstract toString();
}




