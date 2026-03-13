package problem2;

public class Pawn extends Piece {
    public Pawn(Position p, boolean isWhite) {
        super(p, isWhite);
    }

    public boolean isLegalMove(Position to, Piece[][] board) {
        int dir = isWhite ? -1 : 1;
        int startRow = isWhite ? 6 : 1;

        if (to.col == pos.col && board[to.row][to.col] == null) {
            if (to.row - pos.row == dir) return true;
            return pos.row == startRow && to.row - pos.row == 2 * dir && board[pos.row + dir][pos.col] == null;
        }

        if (Math.abs(to.col - pos.col) == 1 && to.row - pos.row == dir) {
            return board[to.row][to.col] != null && board[to.row][to.col].isWhite != this.isWhite;
        }

        return false;
    }

    public char getSymbol() {
        return isWhite ? '\u2659' : '\u265F';
    }
}