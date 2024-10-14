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
        mousePositionOnScreen = new Point(e.getX() , e.getY());
        this.setLocation(mousePositionOnScreen);
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
    protected StringBuilder imagePaths;
//=============================================================================
   public Card(){
        this.setUndecorated(true);
        this.addFocusListener(this);
        this.addMouseMotionListener(this);

    }


    protected void setImage(String imagePath, double widthRatio, double heightRatio) {
        image = new ImageIcon(getClass().getResource(imagePath));
        diplayImage = new JLabel(image);
        this.add(diplayImage);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width; 
        int screenHeight = screenSize.height; 

        int cardWidth = (int) (screenWidth * widthRatio);
        int cardHeight = (int) (screenHeight * heightRatio);

        this.setSize(cardWidth, cardHeight);
        this.pack(); //resize frame to fit image

    }

    protected void popCard()

}
