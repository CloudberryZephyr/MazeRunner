import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    Scanner user = new Scanner(System.in);
    private int L1BoardSize = 10;
    private int L2BoardSize = 15;
    private int L3BoardSize = 20;

    Player p1 = new Player(L1BoardSize);
    Player p2 = new Player(L2BoardSize);
    Player p3 = new Player(L3BoardSize);

    private Stack<Cell> playerPath;

    public void gameLoop(){
        int level =0;


        System.out.println("Welcome to the Maze Runner game please, select the difficulty 1-3 that you would like to play with");
        level = user.nextInt();
        createGame(level);

        if(level == 0 || level > 3){ // if Integer input is invalid this tries again
            System.out.println("input invalid, please enter a number 1-3");
            level= user.nextInt();
            createGame(level);
        } else{ // if input is in the form of a String this corrects it
            level = stringToInt(user.nextLine());
            createGame(level);
        }

    }
    public void PlayerMove(){}


    /**
     * Error handling, if user inters a string instead on Int value
     * @param userInput
     * @return user input changed to int value
     */



    public int stringToInt(String userInput){
        int choice = 0; // cur only handles 1-3
        String caps = userInput.toUpperCase(Locale.ROOT);

        if(caps.equals("ONE")){
            choice = 1;
        }
        if(caps.equals("TWO")){
            choice = 2;
        }
        if(caps.equals("THREE")){
            choice = 3;
        }
        if(choice == 0){
            System.out.println("You have entered incorrect input, please retry");
            stringToInt(user.nextLine());
        }
        return choice;
    }

    public void createGame(int level){
        if(user.nextInt()==1 ) {
            level = user.nextInt();
            Board b1 = new Board(level, p1, L1BoardSize);
        }
        if(user.nextInt()==2) {
            level = user.nextInt();
            Board b2 = new Board(level, p2, L2BoardSize);
        }
        if(user.nextInt()==3){
            level = user.nextInt();
            Board b1 = new Board(level, p3, L3BoardSize);
        }


    }

}


