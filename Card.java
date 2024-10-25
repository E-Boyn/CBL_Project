import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Card extends JFrame implements MouseMotionListener, MouseListener {
    @Override
    public void mouseDragged(MouseEvent e) {
        int x = (int) (e.getXOnScreen() - mousePosition.getX());
        int y = (int) (e.getYOnScreen() - mousePosition.getY());
       
        this.setLocation(x, y);
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        mousePosition.x = e.getX();
        mousePosition.y = e.getY();
    }
    
    protected String[] imagePaths; // String array template for random image generation
    protected int screenWidth;
    protected int screenHeight;
    protected double heightPercentage; // Screen height percentage a card will occupy.
    protected double widthHeightRatio; // Card ratio of width to height
    protected double widthRatio;
    protected double heightRatio;

    private Point mousePosition = new Point();

    protected boolean isActivated;
    public boolean isDagger = false;
    JLabel diplayImage;

    ImageIcon image;

    protected Color color = new Color(23, 244, 106);

    Dimension size;
    int xM;
    int yM;


    /**
     * Constructor initializes the card.
     * 
     * - Retrieves user's screen size.
     * - Makes the card frame undecorated (no title bar).
     * - Adds focus and mouse motion listeners to track user interactions with the card.
     */

    public Card() {
        setType(Type.UTILITY);
        setAlwaysOnTop( true );


        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.screenWidth = screenSize.width;
        this.screenHeight = screenSize.height;

        setBorder();

        setUndecorated(true);
        addMouseListener(this);
        addMouseMotionListener(this);
    }


    protected void setBorder() {
        this.getRootPane().setBorder(BorderFactory.createDashedBorder(color, 2, 5, 1, false));
    }


    public void slay() {}


    /**
     * Sets fixed image for the card and scales it according to
     * screen height percentage and width/height ratio.
     * 
     * @param imagePath Images' file paths.
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


    /**
     * Randomly selects and sets an image from the image paths array.
     * Method for subclasses with randomized image generation (Tree, House, Cave).
     * 
     * @throws IllegalStateException When imagePaths array not initialized in subclass.
     */

    protected void setRandomImage() {
        if (imagePaths == null || imagePaths.length == 0) {
            throw new IllegalStateException("Image paths not initialized in subclass.");
        } // Ensure the array is filled
        String randomImagePath = getRandomImageFromPaths(); // Randomly select an image path
        setImage(randomImagePath); // Use setImage to display image
    }

    // Helper method to randomly select an image from the imagePaths array
    private String getRandomImageFromPaths() {
        Random random = new Random();
        int randomIndex = random.nextInt(imagePaths.length);
        return imagePaths[randomIndex];
    }


    /** From Card.java in environment-generation branch
     * Generates random position on the screen within the given maximum
     * width (maxX) and height (maxY) values.
     * 
     * @param maxX Max X-coordinate (horizontal) for the card.
     * @param maxY Max Y-coordinate (vertical) for the card.
     * @return A Point object containing random x and y coordinates.
     */
    public Point randomPosition(int maxX, int maxY) {
        int x = (int) (Math.random() * maxX);
        int y = (int) (Math.random() * maxY);
        return new Point(x, y);
    }


    /**
     * Displays the card. 
     * To be overridden by subclasses to handle specifics of card displaying in the game.
     */
    protected void popCard(){
    }


    // =================== Not used methods ===================
    
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
