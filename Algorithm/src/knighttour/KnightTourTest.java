package knighttour;

public class KnightTourTest {
    public static void main(String[] args) {
        int x = 8, y = 8;
        KnightTour kt = new KnightTour(x, y);
        int row = 0, col = 0;
        int[][] chessBoard = new int[x][y];
        System.out.println("start");
        long start = System.currentTimeMillis();
        kt.knightTour(chessBoard, row, col, 1);
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(chessBoard[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
