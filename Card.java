import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

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

    Point mousePositionOnScreen;

    protected String[] imagePaths;
    
    protected int screenWidth;
    protected int screenHeight;

    public Card(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.screenWidth = screenSize.width;
        this.screenHeight = screenSize.height;

        this.setUndecorated(true);

        this.addFocusListener(this);
        this.addMouseMotionListener(this);
    }

    /** Method to set fixed image generation: Icon, Dagger, Enemy, and Treasure.
     */

    protected void setImage(String imagePath, double heightPercentage, double widthHeightRatio) {
        image = new ImageIcon(getClass().getResource(imagePath));
        diplayImage = new JLabel(image);
        this.add(diplayImage);

        int cardHeight = (int) (screenHeight * heightPercentage);
        int cardWidth = (int) (cardHeight * widthHeightRatio);

        this.setSize(cardWidth, cardHeight);
        this.pack(); //resize frame to fit image
    }

    /** Method to set a random image genberation: Tree, House, Cave from the imagePaths array.
     *  */
    protected void setRandomImage(double widthRatio, double heightRatio) {
        if (imagePaths == null || imagePaths.length == 0) {
            throw new IllegalStateException("Image paths not initialized in subclass.");
        } // Ensure the array is filled
        String randomImagePath = getRandomImageFromPaths(); // Randomly select an image path
        setImage(randomImagePath, widthRatio, heightRatio); // Use setImage to display image
    }

    // Helper method to randomly select an image from the imagePaths array
    private String getRandomImageFromPaths() {
        Random random = new Random();
        int randomIndex = random.nextInt(imagePaths.length);
        return imagePaths[randomIndex];
    }

    protected void popCard(){

    }

}
