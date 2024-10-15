import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


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

    Point mousePositionOnScreen;

    //============================ Start of Card generation ============================

    protected String[] imagePaths; // String array template for random image generation
    
    protected int screenWidth;
    protected int screenHeight;


    /**
     * Constructor initializes the card.
     * 
     * - Retrieves user's screen size.
     * - Makes the card frame undecorated (no title bar).
     * - Adds focus and mouse motion listeners to track user interactions with the card.
     */

    public Card() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.screenWidth = screenSize.width;
        this.screenHeight = screenSize.height;

        this.setUndecorated(true);

        this.addFocusListener(this);
        this.addMouseMotionListener(this);
    }


    /**
     * Sets fixed image for the card and scales it according to
     * screen height percentage and width/height ratio.
     * 
     * @param imagePath Images' file paths.
     * @param heightPercentage Screen height percentage a card card will occupy.
     * @param widthHeightRatio Card ratio of width to height
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


    /**
     * Randomly selects and sets an image from the image paths array.
     * Method for subclasses with randomized image generation (Tree, House, Cave).
     * 
     * @param widthRatio Card dimension's width/height ratio.
     * @param heightRatio Height percentage relative to screen size.
     * @throws IllegalStateException When imagePaths array not initialized in subclass.
     */

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


    /** From Card.java in nenvironment-generation branch
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
     * Manage locations of environment cards and hides enemy and treasure cards amidst them.
     * 
     * @param environmentCards List of environment cards to be placed on the screen.
     * @param enemyCard Enemy card to be hidden amidst the environment cards.
     * @param treasureCard Treasure card to be hidden amidst the environment cards.
     * @param screenWidth Screen width to calc card position.
     * @param screenHeight Screen height to calc card position.
     */    
    public static void positionCards(List<Card> environmentCards, Card enemyCard, 
        Card treasureCard, int screenWidth, int screenHeight) {
        
        Random rand = new Random();
        List<Rectangle> environmentBounds = new ArrayList<>();
        int safeZoneHeightOffset = 150;  // Place cards ABOVE Player/Dagger

        // Place environment cards randomly
        for (Card environmentCard : environmentCards) {
            // Use randomPosition() to get random coordinates
            Point randomPos = environmentCard.randomPosition(
                screenWidth - environmentCard.getWidth(), 
                screenHeight - safeZoneHeightOffset - environmentCard.getHeight()
                );

            // Set the card's location and track its bounds -- to later hide emeny & treasure cards
            environmentCard.setLocation(randomPos.x, randomPos.y);
            environmentBounds.add(new Rectangle(randomPos.x, randomPos.y, 
                environmentCard.getWidth(), environmentCard.getHeight()));
            environmentCard.setVisible(true);
        }

        // Hide enemy and treasure cards behind or between environment cards
        placeCardBehindEnvironment(rand, enemyCard, environmentBounds);
        enemyCard.setVisible(true);
        placeCardBehindEnvironment(rand, treasureCard, environmentBounds);
        treasureCard.setVisible(true);
    }

    // Helper method to place a card behind environment cards
    private static void placeCardBehindEnvironment(Random rand, Card card, 
        List<Rectangle> environmentBounds) {

        Rectangle chosenEnv = environmentBounds.get(rand.nextInt(environmentBounds.size()));
        int x = chosenEnv.x + rand.nextInt(Math.max(1, chosenEnv.width - card.getWidth()));
        int y = chosenEnv.y + rand.nextInt(Math.max(1, chosenEnv.height - card.getHeight()));
        card.setLocation(x, y);
    }


    /**
     * Displays the card. 
     * To be overridden by subclasses to handle specifics of card displaying in the game.
     */

    protected void popCard(){

    }

}
