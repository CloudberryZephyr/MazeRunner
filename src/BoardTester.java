public class BoardTester {
    public static void main(String[] args) {
        Board board = new Board(1, new Player(), new Location(2,0));
        board.printBoard();
    }
}
