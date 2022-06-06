/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author clara
 */

public class BPanel extends JPanel {
    //control the game
     BufferedImage bg;
     BufferedImage pg;
     BufferedImage go;
     Floor floor;//declare 
     Pipe pip1;
     Pipe pip2;
     Pipe pip3;
     Pipe pip4;
     Pipe pip5;
     Pipe pip6;
     Bird b;
     boolean isStart =false;
     boolean isOver = false;
     int score = 0;
    
    public BPanel(){
       //background
 try {
             bg = ImageIO.read(this.getClass().getResource("Background.png"));
         } catch (IOException ex) {
             Logger.getLogger(BPanel.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             pg = ImageIO.read(this.getClass().getResource("PlayScreen.png"));
         } catch (IOException ex) {
             Logger.getLogger(BPanel.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             go = ImageIO.read(this.getClass().getResource("gameover.png"));
         } catch (IOException ex) {
             Logger.getLogger(BPanel.class.getName()).log(Level.SEVERE, null, ex);
         }
 
        floor = new Floor();
        pip1 = new Pipe(1);
        pip2 = new Pipe(2);
        pip3 = new Pipe(3);
        pip4 = new Pipe(4);
        pip5 = new Pipe(5);
        b = new Bird();
        
        MouseAdapter adapter = new MouseAdapter(){
        public void mouseClicked(MouseEvent e){
            super.mouseClicked(e);
            if(isStart == false){
                 isStart = true;  
                 start();
            }else if(isOver){
                isStart = false;
                isOver = false;
                floor = new Floor();
                pip1 = new Pipe(1);
                pip2 = new Pipe(2);
                pip3 = new Pipe(3);
                pip4 = new Pipe(4);
                pip5 = new Pipe(5);
                b = new Bird();
                score = 0;
                repaint();
            }
            else{
                 
                 b.moveUp();
                 
            }
            
           }    
        };
        this.addMouseListener(adapter);
                           
       
    }
    public void start(){
      //start the game
      myThread mt = new myThread();
      Thread t = new Thread(mt);
      t.start();//time and different part
    }
    public void paint(Graphics g){
       super.paint(g);
       //draw the picture
       g.drawImage(bg,0,0, null);
       
       g.drawImage(pip1.pipes,pip1.x,pip1.y, pip1.width,pip1.height,null);
       g.drawImage(pip2.pipes,pip2.x,pip2.y, pip2.width,pip2.height,null);
       g.drawImage(pip3.pipes,pip3.x,pip3.y, pip3.width,pip3.height,null);
       g.drawImage(pip4.pipes,pip4.x,pip4.y, pip4.width,pip4.height,null);
       g.drawImage(pip5.pipes,pip5.x,pip5.y, pip5.width,pip5.height,null);
       g.drawImage(floor.go, floor.x,floor.y , null);
       g.drawImage(b.bird, b.x, b.y,b.width,b.height, null);
       if(isStart == false){
           g.drawImage(pg, 0, 0, null);
       }
       if(isOver){
          g.drawImage(go, 0, 0, null);  
       }
       Font f = new Font("Psychedelic",Font.BOLD,30);
       g.setFont(f);
       g.setColor(Color.white);
       g.drawString("Score: " + score, 400, 30);//to draw 
       
    }
    class myThread implements Runnable{
      //to start the game
        @Override
        public void run() {
             while(true){
            floor.moveme();
            pip1.moveme();
            pip2.moveme();
            pip3.moveme();
            pip4.moveme();
            pip5.moveme();
            b.fly();
            b.moveme();
            boolean b1 = b.Hit();
            boolean b2 = b.Hit(pip1);
            boolean b3 = b.Hit(pip2);
            boolean b4 = b.Hit(pip3);
            boolean b5 = b.Hit(pip4);
            boolean b6 = b.Hit(pip5);
            
            
            if(b1){
                isOver = true;
               break;//stop everything
            }
            if(b.x == pip1.x + pip1.width || b.x == pip2.x + pip2.width || b.x == pip3.x + pip3.width ){
                score++;
            }
            try {
                Thread.sleep(15);//speed for floor to move.
                repaint();
            } catch (InterruptedException ex) {
                Logger.getLogger(BPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }     

        }
        
    }
   

}
