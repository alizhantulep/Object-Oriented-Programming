package problem2;

import java.util.Scanner;

public class Board {

    Piece[][] board = new Piece[8][8];
    boolean whiteTurn = true;
    Position enPassantTarget = null;

    public Board() {
        setup();
    }

    private void setup() {
        board[7][0] = new Rook(new Position(7,0), true);
        board[7][1] = new Knight(new Position(7,1), true);
        board[7][2] = new Bishop(new Position(7,2), true);
        board[7][3] = new Queen(new Position(7,3), true);
        board[7][4] = new King(new Position(7,4), true);
        board[7][5] = new Bishop(new Position(7,5), true);
        board[7][6] = new Knight(new Position(7,6), true);
        board[7][7] = new Rook(new Position(7,7), true);

        for (int i = 0; i < 8; i++) board[6][i] = new Pawn(new Position(6,i), true);

        board[0][0] = new Rook(new Position(0,0), false);
        board[0][1] = new Knight(new Position(0,1), false);
        board[0][2] = new Bishop(new Position(0,2), false);
        board[0][3] = new Queen(new Position(0,3), false);
        board[0][4] = new King(new Position(0,4), false);
        board[0][5] = new Bishop(new Position(0,5), false);
        board[0][6] = new Knight(new Position(0,6), false);
        board[0][7] = new Rook(new Position(0,7), false);

        for (int i = 0; i < 8; i++) board[1][i] = new Pawn(new Position(1,i), false);
    }

    public void draw() {
        System.out.println("   a b c d e f g h");
        System.out.println(" ┌─────────────────┐");
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + "| ");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(((i + j) % 2 != 0 ? "- " : ". "));
                } else {
                    System.out.print(board[i][j].getSymbol() + " ");
                }
            }
            System.out.println("| " + (8 - i));
        }
        System.out.println(" └─────────────────┘");
        System.out.println("   a b c d e f g h");
    }

    public Position findKing(boolean white) {
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                if (board[i][j] instanceof King && board[i][j].isWhite == white)
                    return new Position(i,j);
        return null;
    }

    public boolean isCheck(boolean white) {
        Position king = findKing(white);
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                Piece p = board[i][j];
                if (p != null && p.isWhite != white && p.isLegalMove(king, board)) return true;
            }
        return false;
    }

    public boolean canEscapeCheck(Position from, Position to, boolean white) {
        Piece p = board[from.row][from.col];
        Piece target = board[to.row][to.col];
        Position oldPos = p.pos;

        board[to.row][to.col] = p;
        board[from.row][from.col] = null;
        p.pos = to;

        boolean safe = !isCheck(white);

        p.pos = oldPos;
        board[from.row][from.col] = p;
        board[to.row][to.col] = target;

        return safe;
    }

    public boolean isCheckMate(boolean white) {
        if (!isCheck(white)) return false;
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                Piece p = board[i][j];
                if (p != null && p.isWhite == white)
                    for (int r = 0; r < 8; r++)
                        for (int c = 0; c < 8; c++) {
                            Position to = new Position(r, c);
                            if ((p.isLegalMove(to, board) || isEnPassantLegal(p, to)) && canEscapeCheck(new Position(i, j), to, white))
                                return false;
                        }
            }
        return true;
    }

    private boolean isEnPassantLegal(Piece p, Position to) {
        if (!(p instanceof Pawn) || enPassantTarget == null) return false;
        int dir = p.isWhite ? -1 : 1;
        return to.row == enPassantTarget.row && to.col == enPassantTarget.col &&
               Math.abs(to.col - p.pos.col) == 1 && to.row - p.pos.row == dir;
    }

    public void move(Position from, Position to) {
        Piece p = board[from.row][from.col];
        
        if (p == null || p.isWhite != whiteTurn) { System.out.println("Invalid turn"); return; }
        
        if (!p.isLegalMove(to, board) && !isEnPassantLegal(p, to)) { System.out.println("Illegal move"); return; }

        if (!canEscapeCheck(from, to, whiteTurn)) { System.out.println("King in check!"); return; }

        if (p instanceof Pawn && enPassantTarget != null && to.row == enPassantTarget.row && to.col == enPassantTarget.col) {
            board[p.isWhite ? to.row + 1 : to.row - 1][to.col] = null;
        }

        if (p instanceof King && Math.abs(to.col - from.col) == 2) {
            int rookCol = (to.col == 6) ? 7 : 0;
            int nextRookCol = (to.col == 6) ? 5 : 3;
            Piece rook = board[from.row][rookCol];
            board[from.row][nextRookCol] = rook;
            board[from.row][rookCol] = null;
            if (rook != null) rook.pos = new Position(from.row, nextRookCol);
        }

        board[to.row][to.col] = p;
        board[from.row][from.col] = null;
        p.pos = to;

        if (p instanceof Pawn && (to.row == 0 || to.row == 7)) board[to.row][to.col] = new Queen(to, p.isWhite);

        enPassantTarget = (p instanceof Pawn && Math.abs(to.row - from.row) == 2) ? 
                          new Position((from.row + to.row) / 2, from.col) : null;

        whiteTurn = !whiteTurn;

        if (isCheck(whiteTurn)) {
            if (isCheckMate(whiteTurn)) {
                draw();
                System.out.println("CHECKMATE!");
                System.exit(0);
            } else System.out.println("CHECK!");
        }
    }

    public void play() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            draw();
            System.out.println((whiteTurn ? "White" : "Black") + " move :");
            System.out.println("For example: a2 a4");
            try {
                move(Position.fromChess(sc.next()), Position.fromChess(sc.next()));
            } catch (Exception e) {
                System.out.println("Error input.");
                sc.nextLine();
            }
        }
    }
}