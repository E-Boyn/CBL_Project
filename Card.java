import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

//TODO Make this class abstract
public class Card extends JFrame implements FocusListener, MouseMotionListener{

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = (int)(e.getXOnScreen() - mousePosition.getX());
        int y = (int)(e.getYOnScreen() - mousePosition.getY());

        mousePositionOnScreen = new Point(x , y);
        this.setLocation(mousePositionOnScreen);
    }
    
    public void mousePressed(MouseEvent e){
        mousePositionOnScreen = new Point(e.getX() , e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseMoved'");
    }

    @Override
    public void focusGained(FocusEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'focusGained'");
    }

    @Override
    public void focusLost(FocusEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'focusLost'");
    }
//=============================================================================
    JLabel diplayImage;
    ImageIcon image;

//-------------------------------
double screenPersantage;
int w;
//-------------------------------

    Dimension size;
    String imagePath = "";
    Point mousePositionOnScreen;
    Point mousePosition;
    protected StringBuilder imagePaths;
//=============================================================================
   public Card(){
        this.setUndecorated(true);
        this.addFocusListener(this);
        this.addMouseMotionListener(this);

    }

    protected void popCard(){
        this.setSize(size.width,size.height); //TODO DElEte this, overrite it in each subclass - use % of the screen resolution
        this.setVisible(true); // TODO overite in each enemy card?
    }

    protected void setImage(String path){
        image = new ImageIcon(getClass().getResource(path));
        diplayImage = new JLabel(image);
        this.add(diplayImage);
    }

}
