package problem2;

public class Knight extends Piece {
    public Knight(Position p, boolean isWhite) {
        super(p, isWhite);
    }

    public boolean isLegalMove(Position to, Piece[][] board) {
        int rowDiff = Math.abs(to.row - pos.row);
        int colDiff = Math.abs(to.col - pos.col);

        if (!((rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2))) return false;

        return board[to.row][to.col] == null || board[to.row][to.col].isWhite != this.isWhite;
    }

    public char getSymbol() {
        return isWhite ? '\u2658' : '\u265E';
    }
}