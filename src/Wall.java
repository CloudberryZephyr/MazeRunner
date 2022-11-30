public class Wall extends Cell{

    @Override
    public String toString(){
        if(known){
            return "W";
        } else {
            return "*";
        }
    }
}
