public class TestBoard {
    public static void main(String[] args) {
        Board t1 = new Board(new int[][] {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}
        });

        t1.checkBoard(1);
        t1.checkBoard(2);
        t1.checkBoard(3);
        t1.checkBoard(4);
        System.out.println(t1.isWinning());
        // t1.checkBoard(5);
        // System.out.println(t1.isWinning());

        t1.checkBoard(7);
        t1.checkBoard(13);
        t1.checkBoard(19);
        System.out.println(t1.isWinning());
        t1.checkBoard(25);
        System.out.println(t1.isWinning());
    }
}