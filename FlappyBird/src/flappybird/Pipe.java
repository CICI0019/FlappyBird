/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybird;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author clara
 */
public class Pipe {
    BufferedImage pipes;
    int x;
    int y;
    int width;
    int height;
    int distance;
    int gap;
    Random ran = new Random();//random display the pipe
    public Pipe(int i){//the pipe
        try {
            pipes = ImageIO.read(this.getClass().getResource("pipefour.png"));
        } catch (IOException ex) {
            Logger.getLogger(Pipe.class.getName()).log(Level.SEVERE, null, ex);
        }
        width = pipes.getWidth()*2;
        height = pipes.getHeight()*3;
        distance = 340;
        
       x = 450 + distance * (i - 1);
       y = -ran.nextInt(height + 200- 650);//between 0 - whatever interger.
    }
    public void moveme(){
        x--;
        if(x <= -width){
            x = 450 + distance ;
            y = -ran.nextInt(height + 200 - 650 +1);
        }
    }
}
