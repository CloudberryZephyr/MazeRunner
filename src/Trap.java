import java.util.ArrayList;




public class Trap extends Cell{
    ArrayList<String> items;
    ArrayList<Cell> traps;

    public Trap(){}

    public void loadTrapsL1(){
        traps.add(Empty);
        traps.add(Key);

    }

    public int randTrap(){

        return 1;
    }
}
