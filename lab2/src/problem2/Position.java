package problem2;

public class Position {

    int row;
    int col;

    public Position(int r, int c) {
        row = r;
        col = c;
    }

    public static Position fromChess(String s) {

        int col = s.charAt(0) - 'a';
        int row = 8 - (s.charAt(1) - '0');

        return new Position(row, col);
    }
}