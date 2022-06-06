/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybird;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


/**
 *
 * @author clara
 */
public class Bird {
    BufferedImage bird;
    int x;
    int y;
    int width;
    int height;
    List<BufferedImage> list;
    double sp= 10;//speed
    double t = 0.2;//timer
    double s = 0;//space
    double g = 5;//gravity
    public Bird(){
        try {
            bird = ImageIO.read(this.getClass().getResource("Pose 1.png"));
        } catch (IOException ex) {
            Logger.getLogger(Bird.class.getName()).log(Level.SEVERE, null, ex);
        }
        width = bird.getWidth()*2;
        height = bird.getHeight()*2;
        x = 100;
        y = 300;
        list = new ArrayList<BufferedImage>();
        try {
            list.add(ImageIO.read(this.getClass().getResource("Pose 1.png")));
        } catch (IOException ex) {
            Logger.getLogger(Bird.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            list.add(ImageIO.read(this.getClass().getResource("Pose 1.png")));
        } catch (IOException ex) {
            Logger.getLogger(Bird.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
            list.add(ImageIO.read(this.getClass().getResource("Pose 1.png")));
        } catch (IOException ex) {
            Logger.getLogger(Bird.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            list.add(ImageIO.read(this.getClass().getResource("Pose 1.png")));
        } catch (IOException ex) {
            Logger.getLogger(Bird.class.getName()).log(Level.SEVERE, null, ex);
        }
       try {
            list.add(ImageIO.read(this.getClass().getResource("Pose 2.png")));
        } catch (IOException ex) {
            Logger.getLogger(Bird.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            list.add(ImageIO.read(this.getClass().getResource("Pose 2.png")));
        } catch (IOException ex) {
            Logger.getLogger(Bird.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            list.add(ImageIO.read(this.getClass().getResource("Pose 2.png")));
        } catch (IOException ex) {
            Logger.getLogger(Bird.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            list.add(ImageIO.read(this.getClass().getResource("Pose 2.png")));
        } catch (IOException ex) {
            Logger.getLogger(Bird.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            list.add(ImageIO.read(this.getClass().getResource("Pose 3.png")));
        } catch (IOException ex) {
            Logger.getLogger(Bird.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            list.add(ImageIO.read(this.getClass().getResource("Pose 3.png")));
        } catch (IOException ex) {
            Logger.getLogger(Bird.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            list.add(ImageIO.read(this.getClass().getResource("Pose 3.png")));
        } catch (IOException ex) {
            Logger.getLogger(Bird.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            list.add(ImageIO.read(this.getClass().getResource("Pose 3.png")));
        } catch (IOException ex) {
            Logger.getLogger(Bird.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            list.add(ImageIO.read(this.getClass().getResource("Pose 2.png")));
        } catch (IOException ex) {
            Logger.getLogger(Bird.class.getName()).log(Level.SEVERE, null, ex);
        }

    
       }
    int index = 0;
    public void fly(){
        if(index >= 13){
            index = 0;
        }
        bird = list.get(index);
        index++;
    }
    public void moveme(){
        s = sp * t;//the space
        y = y - (int)s;
        double sp2 = sp - g * t;
        sp = sp2;
    }
    public void moveUp(){
        sp = 30;
    }
    public boolean Hit(){
        //for top and bottom
                return y <= 0 || y >= 650 - 150 - height;
    }
    public boolean Hit(Pipe pip){
        if(x >= pip.x - width && x <= pip.x + pip.width){
            if(y > pip.height / 2 + pip.y - pip.gap / 2 && y < pip.height / 2 + pip.y + pip.gap / 2 - height){
                return false;
            }
            return true;
        }
        return false;
    }
    
}
     
             
 

