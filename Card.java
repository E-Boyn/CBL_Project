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

    /** Method to set image generation.
     * Subclasses with fixed generation: Player, Dagger, Enemy, Treasure.
     */

    protected void setImage(String imagePath, double heightPercentage, double widthHeightRatio) {
        // Load original image
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagePath));
        Image image = imageIcon.getImage();
        
        // Calculate height based on screen size and percentage
        int cardHeight = (int) (screenHeight * heightPercentage);
        int cardWidth = (int) (cardHeight * widthHeightRatio);

        // Resize image to fit card
        Image scaledImage = image.getScaledInstance(cardWidth, cardHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Set scaled image in JLabel
        JLabel diplayImage = new JLabel(scaledIcon);
        this.add(diplayImage);

        this.setSize(cardWidth, cardHeight);
        this.pack(); // Adjust frame to fit image
    }

    /** Method to set a random image geneeration making use of setImage().
     * Subclasses with random generations: Tree, House, Cave.
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
