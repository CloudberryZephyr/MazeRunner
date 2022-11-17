public class BoardTester {
    public static void main(String[] args) {
        Board board = new Board(1, new Player());
        board.printBoard(new Location(0,0));
        System.out.println();
        board.printBoard(new Location(1,1));
        System.out.println();
        board.printBoard(new Location(2,2));
        System.out.println();
        board.printBoard(new Location(4,3));
    }
}
