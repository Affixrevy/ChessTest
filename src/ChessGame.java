//Import Processing Dependencies
import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

import java.awt.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * This Class is the Main Runner for an OOP based Processing chess game
 *
 * @author  Arthur Gao
 * @version 1.0
 * @since   1.0
 */
public class ChessGame extends PApplet {

    public static GameBoard gameBoard;

    private boolean boardDrawn = false;

    public void settings(){
        // Set the size of the Processing window
        size(1024, 1024);

        gameBoard = new GameBoard(this);
    }

    public void draw(){
        if (!boardDrawn){
            gameBoard.drawBoard();
            boardDrawn = !boardDrawn;
        }
    }

    public void mousePressed(){
        int rank = Math.floorDiv(mouseY, Math.floorDiv(height, 8));
        int file = Math.floorDiv(mouseX, Math.floorDiv(width, 8));

        if (gameBoard.getBoard()[rank][file].isOccupied()){
            ArrayList<ChessSquare> possibleMoves = gameBoard.getBoard()[rank][file].getOccupier().getValidMoves();

//            for(ChessSquare m: possibleMoves) {
//                System.out.print("f: " + m.getFile() + " r: " + m.getRank());
//                if (m.getOccupier() != null) {
//                    System.out.print(" is a: " + m.getOccupier().name);
//                }
//                System.out.println();
//            }
        }

        gameBoard.drawBoard();
    }

    //Start Processing window up
    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "ChessGame" };
        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }
    }
}
