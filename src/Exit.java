public class Exit extends Cell{
    private Player p1;
    private boolean hasKey;
    private boolean hasfound;


    public Exit(Player player){
        this.p1 = player;
        this.hasKey = p1.hasKey();

    }


    public boolean endGameTest(){
        return hasKey;
    }

    @Override
    public String toString(){
        return "@";
    }
}
