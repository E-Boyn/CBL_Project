import java.awt.*;  
import javax.swing.JFrame;
import javax.swing.*;

/**
 * main
 */
public class main{
public static void main(String[] args) {
    //for now just testing how stiff works, nothing important here
    Card card = new Card();
    
    card.setSize(800, 800);
    
    card.setImage("images\\tree2.png");
    card.setVisible(true);;
    //Card card2 = new Card();
    //Card card3 = new Card();
    //card.getContentPane().setBackground(Color.black);
   // card3.getContentPane().setBackground(Color.red);
    //card3.setSize(1000, 200);
}
}