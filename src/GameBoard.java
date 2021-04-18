//Import Processing Dependencies
import processing.core.*;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is the game board in a chess game
 *
 * @author Arthur Gao
 * @version 1.0
 * @since   1.0
 */
public class GameBoard{

    private final PApplet sketch;

    // Set Rank and File key value pairs
    private final Map<Integer, Character> FILE = new HashMap<Integer, Character>();
    private final Map<Integer, Integer> RANK = new HashMap<Integer, Integer>();

    // Set color constants
    private final int DARK_COLOR;
    private final int LIGHT_COLOR;

    // Game board
    private ChessSquare[][] board = new ChessSquare[8][8];

    /**
     * Sets up the GUI environment for the Processing program
     */
    public GameBoard(PApplet sketch){
        this.sketch = sketch;

        // Generate the HashMaps that convert grid to Chess Rank and File notation
        generateFile();
        generateRank();

        DARK_COLOR = sketch.color(184,139,74);
        LIGHT_COLOR = sketch.color(227,193,111);
        generateBoard();
    }

    public ChessSquare[][] getBoard(){
        return board;
    }

    public void changeBoard(int origin_rank, int origin_file, int destination_rank, int destination_file) throws Exception {
        if (board[destination_rank][destination_file].isOccupied()){
            throw new Exception("You Fucked Up!");
        }

        board[destination_rank][destination_file].setOccupier(board[origin_rank][origin_file].getOccupier());
        board[origin_rank][origin_file].setOccupier(null);

    }

    /**
     * Calculate the positions for board squares.
     *
     * <p>
     * Iterate over positions for board squares and then call {@link #drawBoardRect(int, int)} to draw the rectangle.
     * Add ChessSquare at defined position
     * </p>
     */
    public void drawBoard(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++){
                drawBoardRect(i, j);

            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                drawBoardPieces(i, j);
            }
        }

    }

    private void generateBoard(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new ChessSquare(i, j);
            }
        }

        board[0][0].setOccupier(new Pawn(sketch, "Pawn", 0, 0, 0));
    }

    private void drawBoardPieces(int currentFile, int currentRank){
        ChessSquare currentSquare = board[currentRank][currentFile];
        if (!currentSquare.isOccupied()){
            return;
        }
        // Set square width and height constants
        final int xSize = sketch.width/8;
        final int ySize = sketch.height/8;
        final int diameter = xSize/2;

        if (currentSquare.getOccupier().player == 0){
            sketch.fill(0);
        } else {
            sketch.fill(255);
        }

        sketch.ellipse(currentFile * xSize + (float)(xSize/2),
                       currentRank * ySize + (float)(ySize/2),
                          diameter,
                          diameter);
    }

    /**
     * Draw square of a chess board and label them.
     *
     * <p>Draw square of chess board based on position provided by currentFile and currentRank. Uses {@link #DARK_COLOR}
     * to determine fill color of dark squares and {@link #LIGHT_COLOR} to determine fill color of light squares. Then
     * uses {@link #FILE} to determine chess representation of file drawn and {@link #RANK} to determine chess
     * representation of rank drawn and labels square using chess rank and file notation.</p>
     *
     * @param currentFile   current file of square being drawn
     * @param currentRank   current rank of square being drawn
     */
    private void drawBoardRect(int currentFile, int currentRank){
        // Set stroke weight to 0 so there is no border around squares
        sketch.strokeWeight(0);

        // Set square width and height constants
        final int xSize = sketch.width/8;
        final int ySize = sketch.height/8;

        // Set fill color to correct values for current square
        if (currentRank % 2 == 0){
            if (currentFile % 2 == 0){
                sketch.fill(LIGHT_COLOR);
            } else {
                sketch.fill(DARK_COLOR);
            }
        } else {
            if (currentFile % 2 == 0){
                sketch.fill(DARK_COLOR);
            } else {
                sketch.fill(LIGHT_COLOR);
            }
        }

        // Draw rectangle/square at calculated position
        sketch.rect(currentFile * xSize, currentRank * ySize, xSize, ySize);

        // Determine text location and height based on screen size
        int textHeight = sketch.height/64;
        float textLocationX = (float)(xSize/20);
        float textLocationY = (float)1.2 * textHeight;

        // Draw chess text representation of current square
        sketch.textSize(textHeight);
        sketch.fill(255);
        sketch.textAlign(sketch.LEFT);
        sketch.text(FILE.get(currentFile) + "" + RANK.get(currentRank),
                currentFile * xSize + textLocationX,
                currentRank * ySize + textLocationY);

        // Draw computer rank and file numbers
        sketch.fill(200, 0, 0);
        sketch.textAlign(sketch.RIGHT);
        sketch.text("F:" + currentFile + " R:" + currentRank,
                currentFile * xSize + xSize - textLocationX,
                currentRank * ySize + ySize - (float)0.5 * textLocationY);

    }


    /**
     * Generates a map that maps the integer value of horizontal locations on the grid to their Chess File character representation
     *
     * <p>This method directly modifies File, and therefore should only be called once</p>
     */
    private void generateFile(){
        char[] rankNames = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

        for (int i = 0; i < 8; i++) {
            FILE.put(i, rankNames[i]);
        }
    }

    /**
     * Generates a map that maps the integer value of vertical locations on the grid to their Chess rank integer representation
     *
     * <p>This method directly modifies File, and therefore should only be called once</p>
     */
    private void generateRank(){
        for (int i = 0; i < 8; i++) {
            RANK.put(i, 8 - i);
        }
    }
}
