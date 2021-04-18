import processing.core.*;

import java.util.ArrayList;

/**
 * This abstract class provides the interface and a basic initializer for a chess piece
 */
public abstract class ChessPiece {

    final PApplet sketch;
    final String name;

    int currentFile;
    int currentRank;

    int player;

    boolean alive;

    public ChessPiece(PApplet sketch, String name, int file, int rank, int player) {
        this.sketch = sketch;
        this.name = name;

        this.currentFile = file;
        this.currentRank = rank;

        this.player = player;
        this.alive = true;
    }

    void capture() {
        this.alive = !this.alive;
    }

    abstract ArrayList<ChessSquare> getValidMoves() throws UnsupportedOperationException;
    abstract boolean isValidMove(int file, int rank) throws UnsupportedOperationException;
    abstract boolean movePiece(int file, int rank) throws UnsupportedOperationException;


}
