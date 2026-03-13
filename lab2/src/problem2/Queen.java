package problem2;

public class Queen extends Piece {
    public Queen(Position p, boolean isWhite) {
        super(p, isWhite);
    }

    public boolean isLegalMove(Position to, Piece[][] board) {
        if (pos.row == to.row && pos.col == to.col) return false;

        int rowDiff = Math.abs(to.row - pos.row);
        int colDiff = Math.abs(to.col - pos.col);

        boolean movesLikeRook = (pos.row == to.row || pos.col == to.col);
        boolean movesLikeBishop = (rowDiff == colDiff);

        if (!movesLikeRook && !movesLikeBishop) return false;

        int rowStep = Integer.compare(to.row, pos.row);
        int colStep = Integer.compare(to.col, pos.col);

        int r = pos.row + rowStep;
        int c = pos.col + colStep;

        while (r != to.row || c != to.col) {
            if (board[r][c] != null) return false;
            r += rowStep;
            c += colStep;
        }

        return board[to.row][to.col] == null || board[to.row][to.col].isWhite != this.isWhite;
    }
    public char getSymbol() {
        return isWhite ? '\u2655' : '\u265B';
    }
}