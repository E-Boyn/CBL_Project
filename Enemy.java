import java.awt.Color;
import java.awt.event.*;

/** Represents Enemy card in game which player must slay with Dagger card.
 * Displayed but hidden behind environment cards.
 */
public class Enemy extends CardWithFocusListener {

    /** Constructs Enemy card with specific dimension, color, and image.
     */
    public Enemy() {
        super();

        this.getContentPane().setBackground(Color.BLACK);
        color = new Color(255, 0, 0);
        setBorder();
        heightPercentage = 0.2222;
        widthHeightRatio = 1.25;

        setImage("/images/enemyRED.png");
    }

    // Comment
    @Override
    public void mouseDragged(MouseEvent e) {
    }
    
    // Comment
    @Override
    public void mousePressed(MouseEvent e) {
    }

    // Comment
    @Override
    protected void popCard() {
        this.setVisible(true);
    }
    
}