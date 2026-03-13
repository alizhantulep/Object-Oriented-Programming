package problem2;

public abstract class Piece {

    Position pos;
    boolean isWhite; 

    public Piece(Position p, boolean isWhite) {
        this.pos = p;
        this.isWhite = isWhite;
    }

    public abstract boolean isLegalMove(Position to, Piece[][] board);


    public abstract char getSymbol();
}