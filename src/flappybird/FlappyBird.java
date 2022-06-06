/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybird;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author Clara Llamozas
 */
public class FlappyBird extends JFrame{
                        //inherits from another class
    /**
     * @param args the command line arguments
     */
    
    public int width = 952;
    public int height = 650;
    public FlappyBird(){
       
        setSize(width,height); //design the frame
        setLocationRelativeTo(null);//center
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//to close the frame
        //setResizable(false);
        setTitle("HeTi计划");//title of the game= FalppyBird
        try {
            setIconImage(ImageIO.read(this.getClass().getResource("Title.png")));
        } catch (IOException ex) {
            Logger.getLogger(FlappyBird.class.getName()).log(Level.SEVERE, null, ex);
        }//Logo for the game;
        BPanel panel = new BPanel();//to display panel in the frame
        add(panel);
        setVisible(true);//to show the frame   
        //panel.start();
    }
    public static void main(String[] args) {
      new FlappyBird();
      
    }
    
}
