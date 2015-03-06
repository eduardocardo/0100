import java.awt.Color;
import java.util.Random;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    //array que almacena los colores de las bolas
    private Color[] colores;
    //array que almacena los diametros de las bolas
    private int[] diametro;
    //array que almacena el numero de bolas
    private BouncingBall[] balls;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        colores =  new Color[4];
        colores[0] = Color.BLUE;
        colores[1] = Color.RED;
        colores[2] = Color.GREEN;
        colores[3] = Color.BLACK;

        diametro = new int[3];
        diametro[0] = 15;
        diametro[1] = 20;
        diametro[2] = 25;

        balls = null;

    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numberBalls)
    {
        balls = new BouncingBall[numberBalls];
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        Random rnd = new Random();
        int xPos = 50;
        int yPos = 50;
        for(int i =0;i < numberBalls;i++)
        {

            balls[i] = new BouncingBall(xPos, yPos, diametro[rnd.nextInt(diametro.length)], 
                       colores[rnd.nextInt(colores.length)], ground, myCanvas);
            balls[i].draw();
            xPos = xPos + 10;
            yPos = yPos + 10;
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);      // small delay
            for(int i = 0; i < numberBalls; i++)
            {
                balls[i].move();
            }
            // stop once ball has travelled a certain distance on x axis
            if(balls[rnd.nextInt(numberBalls)].getXPosition() >= 550) {
                finished = true;
            }
        }

    }
}
