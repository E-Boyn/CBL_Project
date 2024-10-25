import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Represents debris created when environment card is slain/destroyed.
 * Each debries is smaller fragment of original card.
 * Debris located near location of original card.
 */
public class Debris {
    Card originalCard = new Card();

    Dimension originalSize = new Dimension();
    Dimension debreeSize = new Dimension();

    Random rand = new Random();

    List<Card> debris = new ArrayList<>();
    int numOfobjects;

    /** Constructs debris based on origibnal card.
     * 
     * @param card Orginal crad which debris are created from.
     */
    public Debris(Card card) {
        originalSize.width = card.getSize().width;
        originalSize.height = card.getSize().height;
        
        originalCard = card;

        numOfobjects = rand.nextInt(3) + 1;
        for (int i = 0; i < numOfobjects; i++) {
            debris.add(new Card());

            debris.get(i).heightPercentage = 0.1; 
            debris.get(i).widthHeightRatio = 1.0;
                
            debris.get(i).getContentPane().setBackground(Color.BLACK);
            debris.get(i).color = new Color(255, 0, 0);

            setSize(debris.get(i));
            setPosition(debris.get(i));
                
            debris.get(i).setVisible(true);
        }
    }


    // Set random position near the original card
    private void setPosition(Card card) {
        
        int xOffset = rand.nextInt(originalSize.width);
        int yOffset = rand.nextInt(originalSize.height);

        Point debrisPosition = new Point(originalCard.getX() + xOffset, 
            originalCard.getY() + yOffset);
        
        card.setLocation(debrisPosition.x, debrisPosition.y);
    }


    // Generate random size for debris. must be smaller than original card
    private void setSize(Card card) {
        debreeSize.width  = rand.nextInt(originalSize.width / 2) + 1;
        debreeSize.height = rand.nextInt(originalSize.height / 2) + 1;

        card.setSize(debreeSize);
    }
}
