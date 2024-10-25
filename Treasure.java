import java.awt.Color;

/** Represents Treasure card in the game found in the final round.
 * Game ends when the treasure is focused.
 */
public class Treasure extends CardWithFocusListener {

    /** Constructs Treasure card with specific dimensions, color, and image.
     */
    public Treasure() {
        super();

        
        color = new Color(255, 238, 0);
        setBorder();
        heightPercentage = 0.2222;
        widthHeightRatio = 1.25;

        setImage("/images/treasure.png");
    }

    // Displays card on screen
    @Override
    protected void popCard() {
        this.setVisible(true);
    }
}
