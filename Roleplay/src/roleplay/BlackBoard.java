package roleplay;

// A+ Computer Science  -  www.apluscompsci.com

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

//Name - Tim Barber
//Date - 8/30/2018
//Class - APCS
//Lab  - 


public class BlackBoard {

    public void paint(Canvas canvas) {
        //draw(canvas);
    }

    public void smileyFace(Canvas canvas) {
        GraphicsContext graphics = canvas.getGraphicsContext2D();
        graphics.setStroke(Color.BLUE);
        graphics.strokeText("REEEEEEEEEEEE", 35, 35);

        graphics.setFill(Color.YELLOW);
        graphics.fillRect(210, 100, 400, 400);


        //add more code here


    }
}