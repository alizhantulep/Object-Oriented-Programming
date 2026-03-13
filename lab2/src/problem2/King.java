package problem2;

public class King extends Piece {
    public King(Position p, boolean isWhite) {
        super(p, isWhite);
    }

    public boolean isLegalMove(Position to, Piece[][] board) {
        int rowDiff = Math.abs(to.row - pos.row);
        int colDiff = Math.abs(to.col - pos.col);

        if (rowDiff <= 1 && colDiff <= 1) {
            return board[to.row][to.col] == null || board[to.row][to.col].isWhite != this.isWhite;
        }

        if (rowDiff == 0 && colDiff == 2) {
            if (to.col == 6) {
                return board[pos.row][5] == null && board[pos.row][6] == null && board[pos.row][7] instanceof Rook;
            } else if (to.col == 2) { 
                return board[pos.row][1] == null && board[pos.row][2] == null && board[pos.row][3] == null && board[pos.row][0] instanceof Rook;
            }
        }

        return false;
    }

    public char getSymbol() {
        return isWhite ? '\u2654' : '\u265A';
    }
}