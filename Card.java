import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

//TODO Make this class abstract
public class Card extends JFrame {
    JLabel diplayImage;
    ImageIcon image;
    Dimension size = new Dimension();
    String imagePath = "";

    Card(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setUndecorated(true);
        this.addFocusListener(new CustomFocusListener());

        this.setVisible(true); // TODO overite in each enemy card?
        this.setSize(400, 300); //TODO DElEte this, overrite it in each subclass - use % of the screen resolution
        
        image = new ImageIcon(getClass().getResource("images\\house1.png"));
        diplayImage = new JLabel(image);
        this.add(diplayImage);
    }
}
