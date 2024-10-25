import java.awt.Color;
import java.awt.event.*;

/** Represents Dagger card in game.
 * Dagger functionality:
 *      - "Slay" enemies
 *      - Slay environments to debris
 *      - End game when used towards player card
 */
public class Dagger extends CardWithFocusListener {
    
    /** Constructs Dagger card with specific dimensions, color, and image.
     */    
    public Dagger() {
        super();
        isDagger = true;
        heightPercentage = 0.22;
        widthHeightRatio = 0.6;
        
        color = new Color(78, 36, 247);
        setBorder();
        setImage("/images/dagger.png");
    }

    // Notify listeners that dagger gained focs to triggers functionalities/actions
    @Override
    public void focusGained(FocusEvent e) {
        isActivated = true;
        notifyIsActiveListeners();
    }

    // Displays Dagger on screen
    @Override
    protected void popCard() {
        int taskbarHeightOffset = 50;  // Set higher to not be covered by taskbar

        // Locates it to the bottom-center but above taskbar
        int x = (screenWidth - this.getWidth()) / 2;  // Center horizontally
        int y = screenHeight - this.getHeight() - taskbarHeightOffset;

        this.setLocation(x, y);
        this.setVisible(true); 
    }

}