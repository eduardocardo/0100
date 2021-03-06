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
    
    
    //array que almacena el numero de bolas
    private BouncingBall[] balls;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        

        
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
        
        for(int i =0;i < numberBalls;i++)
        {
            Color color = new Color((rnd.nextInt(256)),(rnd.nextInt(256)),(rnd.nextInt(256)));
            int xPos = rnd.nextInt(75);
            int yPos = rnd.nextInt(75);
            //se crea una bola con diametro aleatorio comprendido entre 5 y 30
            int diametro = rnd.nextInt(26) + 5; 
            balls[i] = new BouncingBall(xPos, yPos, diametro, 
                       color, ground, myCanvas);
            balls[i].draw();
            
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
            for(int i = 0; i < numberBalls; i++)
            {
                if(balls[i].getXPosition() >= 550) {
                    finished = true;
                }
            }
        }

    }
}
