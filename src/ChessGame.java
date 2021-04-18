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

    GameBoard gameBoard;

    public void settings(){
        // Set the size of the Processing window
        size(1024, 1024);

        gameBoard = new GameBoard(this);
    }

    public void draw(){
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
