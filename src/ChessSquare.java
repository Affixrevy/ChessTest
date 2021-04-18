
public class ChessSquare {
    private final int rank;
    private final int file;

    private ChessPiece occupier;

    public ChessSquare(int rank, int file, ChessPiece occupier) {
        this.rank = rank;
        this.file = file;
        this.occupier = occupier;
    }

    public ChessSquare(int rank, int file) {
        this.rank = rank;
        this.file = file;
    }

    public int getRank() {
        return rank;
    }

    public int getFile() {
        return file;
    }

    public ChessPiece getOccupier() {
        return occupier;
    }

    public void setOccupier(ChessPiece occupier) {
        this.occupier = occupier;
    }

    public boolean isOccupied() {
        return this.occupier != null;
    }
}
