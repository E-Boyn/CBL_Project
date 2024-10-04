import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

public class Card extends JFrame {
    Card(){

        this.setUndecorated(true);
        this.addFocusListener(new CustomFocusListener());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
        this.setSize(400, 300);
        
    }
}
