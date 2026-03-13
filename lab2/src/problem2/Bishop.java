package problem2;

public class Bishop extends Piece {
    public Bishop(Position p, boolean isWhite) {
        super(p, isWhite);
    }

    @Override
    public boolean isLegalMove(Position to, Piece[][] board) {
        if (Math.abs(to.row - pos.row) != Math.abs(to.col - pos.col)) return false;
        if (pos.row == to.row && pos.col == to.col) return false;

        int rowStep = (to.row > pos.row) ? 1 : -1;
        int colStep = (to.col > pos.col) ? 1 : -1;

        int r = pos.row + rowStep;
        int c = pos.col + colStep;

        while (r != to.row) {
            if (board[r][c] != null) return false;
            r += rowStep;
            c += colStep;
        }

        return board[to.row][to.col] == null || board[to.row][to.col].isWhite != isWhite;
    }

    public char getSymbol() {
        return isWhite ? '\u2657' : '\u265D';
    }
}