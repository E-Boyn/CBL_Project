import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/** Represents a card in the game. 
 * The card can be displayed as a JFrame & can be dragged.
 */
public class Card extends JFrame implements MouseMotionListener, MouseListener {
    
    // Moves card according to user's mouse drag
    @Override
    public void mouseDragged(MouseEvent e) {
        
        setCursor(new Cursor(Cursor.MOVE_CURSOR));
        int x = (int) (e.getXOnScreen() - mousePosition.getX());
        int y = (int) (e.getYOnScreen() - mousePosition.getY());
       
        this.setLocation(x, y);
    }
    
    // Stores position where mouse is pressed for drag calculations
    @Override
    public void mousePressed(MouseEvent e) {
        
        mousePosition.x = e.getX();
        mousePosition.y = e.getY();
    }
    
    protected String[] imagePaths;
    protected int screenWidth;
    protected int screenHeight;
    protected double heightPercentage;
    protected double widthHeightRatio;
    protected double widthRatio;
    protected double heightRatio;

    private Point mousePosition = new Point();

    protected boolean isActivated;
    public boolean isDagger = false;
    JLabel diplayImage;
    public boolean isDebree = false;
    ImageIcon image;

    protected Color color = new Color(23, 244, 106);

    Dimension size;
    int xM;
    int yM;


    /** Constructs & initialize card object appearance.
     * Retrieves screen size, set card to be undecorated, add mouse listener for interactions.
     */

    public Card() {
        setType(Type.UTILITY);
        setAlwaysOnTop(true);


        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.screenWidth = screenSize.width;
        this.screenHeight = screenSize.height;

        setBorder();

        setUndecorated(true);
        addMouseListener(this);
        addMouseMotionListener(this);
    }


    protected void setBorder() {
        this.getRootPane().setBorder(BorderFactory.createLineBorder(color, 2,  true));
    }


    public void slay() {}


    /** Set image in card by loading & resizing.
     * Based on specified height percentage & width-to-height ratio.
     * 
     * @param imagePath Path to image to be displayed on card
     */
    protected void setImage(String imagePath) {
        // Load original image
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagePath));
        Image image = imageIcon.getImage();
        
        // Calculate height based on screen size and percentage
        
        int cardHeight = (int) (this.screenHeight * this.heightPercentage);
        int cardWidth = (int) (cardHeight * this.widthHeightRatio);

        // Resize image to fit card
        Image scaledImage = image.getScaledInstance(cardWidth, cardHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Set scaled image in JLabel
        JLabel diplayImage = new JLabel(scaledIcon);
        this.add(diplayImage);

        this.setSize(cardWidth, cardHeight);
        this.pack(); // Adjust frame to fit image
    }


    /** Randomly select image from imagePaths array to set card's image.
     * Throws exception if no image paths are provided.
     */

    protected void setRandomImage() {
        if (imagePaths == null || imagePaths.length == 0) {
            throw new IllegalStateException("Image paths not initialized in subclass.");
        }
        String randomImagePath = getRandomImageFromPaths(); // Randomly select an image path
        setImage(randomImagePath); // Use setImage to display image
    }


    // Helper method to randomly select image from the imagePaths array
    private String getRandomImageFromPaths() {
        Random random = new Random();
        int randomIndex = random.nextInt(imagePaths.length);
        return imagePaths[randomIndex];
    }


    /** Generates random position within specified boundaries.
     * Functions for card appearance positions.
     * 
     * @param maxX Max x coordinate
     * @param maxY Max Y coordinate
     * @return Point object representing random position
     */
    public Point randomPosition(int maxX, int maxY) {
        int x = (int) (Math.random() * maxX);
        int y = (int) (Math.random() * maxY);
        return new Point(x, y);
    }


    /** Displays card on screen
     * Subclases can override this to specify how card appear in game.
     */
    protected void popCard(){
    }

//===== Used for mouse cursor ====

    @Override
    public void mouseReleased(MouseEvent e) {
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
    // ===== Unused methods required for interface =====
    
    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {     
    }


}