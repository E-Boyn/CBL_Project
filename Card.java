import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

//TODO Make this class abstract
public class Card extends JFrame implements FocusListener, MouseMotionListener{
    @Override
    public void focusGained(FocusEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void focusLost(FocusEvent e) {
        // TODO Auto-generated method stub
    }
//---------------------
    @Override
    public void mouseDragged(MouseEvent e) {
        mousePositionOnScreen = new Point(e.getX() , e.getY());
        this.setLocation(mousePositionOnScreen);
    }

    @Override
    public void mouseMoved(MouseEvent e) {}

//===================================================================
    Point mousePositionOnScreen; //position of Mouse while it's being dragged (pressed + moved)
    JLabel diplayImage;
    ImageIcon image;
    Dimension size = new Dimension();
    String imagePath = "";
    boolean visible = true;
//==================================================================


    public Card(){
        this.setUndecorated(true);
        this.addFocusListener(this);
        this.addMouseMotionListener(this);

        this.setSize(400, 300); //TODO Delete this, override it in each subclass - use % of the screen resolution
        this.setVisible(visible); // TODO overrid in each enemy card?
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
    public void setVisible(boolean b){
        visible = b;
    }

    public void SetImage(String path) {
        image = new ImageIcon(path);
        diplayImage = new JLabel(image);
        this.add(diplayImage);
    }
}
