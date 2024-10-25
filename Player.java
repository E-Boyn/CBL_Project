import java.awt.Color;
import javax.swing.JFrame;

/** Represents Player card in the game.
 * Player card displayed at the bottom-left corner of the screen.
 */
public class Player extends CardWithFocusListener {

    /** Constructs Player card with specific dimensions & an image.
     */
    public Player() {
        super();
        heightPercentage = 0.1111;
        widthHeightRatio = 1.0;
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        color = new Color(78, 36, 247);
        setBorder();
        setImage("/images/player.png");
    }

    // Displays card on screen
    @Override
    protected void popCard() {
        int taskbarHeightOffset = 50;  // Set higher to not be covered by taskbar

        // Set card location to the bottom-left corner but higher than taskbar
        int x = 0;  // Bottom-left means x = 0
        int y = screenHeight - this.getHeight() - taskbarHeightOffset;

        this.setLocation(x, y);
        this.setVisible(true);
    }
}
