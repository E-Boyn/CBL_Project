import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

//TODO Make this class abstract
public class Card extends JFrame implements FocusListener, MouseMotionListener, MouseListener{

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = (int)(e.getXOnScreen() - mousePosition.getX());
        int y = (int)(e.getYOnScreen() - mousePosition.getY());
       
        this.setLocation(x,y);
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        mousePosition.x = e.getX();
        mousePosition.y = e.getY();
    }

    @Override
    public void focusGained(FocusEvent e) {
        // TODO Auto-generated method stub
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
    Point mousePosition = new Point(0 , 0);
    protected StringBuilder imagePaths;
//=============================================================================
   public Card(){
        this.setUndecorated(true);
        this.addFocusListener(this);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
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




//Not used methods
//========================================================================================================
    @Override
    public void focusLost(FocusEvent e) {
        // TODO Auto-generated method stub
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }
}
