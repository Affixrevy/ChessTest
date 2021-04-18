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

        validMoves.add(board[currentFile][currentRank + 1]);
        if (!moved)
            validMoves.add(board[currentFile][currentRank + 2]);

        return validMoves;
    }

    @Override
    boolean isValidMove(int rank, int file) {
        System.out.println("checking...");
        return this.getValidMoves().contains(ChessGame.gameBoard.getBoard()[rank][file]);
    }

    @Override
    boolean movePiece(int rank, int file) {

        if (this.isValidMove(rank, file)){
            try {
                System.out.println("move!");
                ChessGame.gameBoard.changeBoard(currentRank, currentFile, rank, file);
                this.currentRank = rank;
                moved = true;
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
