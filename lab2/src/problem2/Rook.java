package problem2;

public class Rook extends Piece {
    public Rook(Position p, boolean isWhite) {
        super(p, isWhite);
    }

    public boolean isLegalMove(Position to, Piece[][] board) {
        if (pos.row != to.row && pos.col != to.col) return false;
        if (pos.row == to.row && pos.col == to.col) return false;

        if (pos.row == to.row) {
            int step = (to.col > pos.col) ? 1 : -1;
            for (int c = pos.col + step; c != to.col; c += step) {
                if (board[pos.row][c] != null) return false;
            }
        } else {
            int step = (to.row > pos.row) ? 1 : -1;
            for (int r = pos.row + step; r != to.row; r += step) {
                if (board[r][pos.col] != null) return false;
            }
        }

        return board[to.row][to.col] == null || board[to.row][to.col].isWhite != isWhite;
    }

    public char getSymbol() {
        return isWhite ? '\u2656' : '\u265C';
    }
}