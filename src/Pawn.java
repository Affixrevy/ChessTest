import processing.core.PApplet;

import java.util.ArrayList;

public class Pawn extends ChessPiece {
    private boolean moved = false;

    public Pawn(PApplet sketch, String name, int file, int rank, int player) {
        super(sketch, name, file, rank, player);
    }

    @Override
    ArrayList<ChessSquare> getValidMoves() {
        ArrayList<ChessSquare> validMoves = new ArrayList<>();

        ChessSquare[][] board = ChessGame.gameBoard.getBoard();

        validMoves.add(board[currentFile + 1][currentRank]);
        validMoves.add(board[currentFile + 2][currentRank]);

        return validMoves;
    }

    @Override
    boolean isValidMove(int file, int rank) {
        return false;
    }

    @Override
    boolean movePiece(int file, int rank) {
        return false;
    }
}
