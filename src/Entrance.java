public class Entrance extends Cell {
    private Player p1;

    public Entrance(Player player) {
        this.p1 = player;
    }

    /**
     * shows the player what is in their bag
     */
    public void PrintBackpack(){
        System.out.println("These are the items in your backpack");
        System.out.println(p1.getBackPack());
        System.out.println("These can be used on any trap or monsters but keep in mind that you can only use them once.\n" +
                "There are rooms that refill your bag but those are a rare find");
    }

    /**
     * Entrance message for Level 1
     */
    public void PrintMessageL1() {
        System.out.println("you have entered the maze and are at location 0,0\n" +
                "you have the option to move anywhere within the maze unless you encounter a wall.\n" +
                "If you find a wall you must reroute.\n \n" +
                "To move press: W, S, A, D. To access these rules again press: R. To see items in your \n" +
                "backpack inventory press: I. \n");
                System.out.println("These are the items in your backpack");
        System.out.println(p1.getBackPack());
        System.out.println("These can be used on any trap or monsters but keep in mind that you can only use them once.\n" +
                "There are rooms that refill your bag but those are a rare find");

        System.out.println("Your objective is to stay alive and find a key, then exit the maze, if you do not have \n " +
                "the key upon reaching the exit you will not be able to exit the maze\n" +
                "Good Luck Maze Runner, and by the way, lookout for the roaming monster\n\n");

    }

    /**
     * Entrance Message for level 2
     */
    public void PrintMessageL2(){ // decide how many monsters
        System.out.println("These are the items in your backpack for level 2");
        System.out.println(p1.getBackPack());
        System.out.println("These can be used on any trap or monsters but keep in mind that you can only use them once.\n" +
                "There are rooms that refill your bag but those are a rare find");

        System.out.println("You have entered the second level of the maze, here you will find all the same rules\n" +
                "apply. However, the critters have gotten a little meaner, and there be more traps...\n"+
                "Good Luck Maze Runner");
    }

    @Override
    public String toString(){
        return "#";
    }


}
