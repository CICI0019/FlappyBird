/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybird;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author clara
 */
public class Floor {
    int x = 0;
    int y;
    //the length for the ground to move;
    BufferedImage go;
    int width;
    int height;
    public Floor(){
        try {
            go = ImageIO.read(this.getClass().getResource("Floor1.png"));
        } catch (IOException ex) {
            Logger.getLogger(Floor.class.getName()).log(Level.SEVERE, null, ex);
        }
        width = go.getWidth();
        height = go.getHeight();
        y = 676 - height;
        
    }
    
    public void moveme(){
        if(x <= width-980){
            x = 0;
        }
        x--;
    }
}
