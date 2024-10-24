import java.awt.*;
import java.util.Random;
import javax.swing.*;

// DOES NOT WORK
// TODO but then if don't wanna do then don't do lol im sorry
public class Debris extends Card {
    
    public Debris(Point origin, Dimension originalSize) {
        super();
        this.setAlwaysOnTop(true);  // Ensure debris is on top -- to make sure it runs damn
        this.heightPercentage = 0.1; 
        this.widthHeightRatio = 1.0;
        
        // Generate random size for debris (smaller than original card)
        Random rand = new Random();
        int debrisWidth = rand.nextInt(originalSize.width / 2) + 10;
        int debrisHeight = rand.nextInt(originalSize.height / 2) + 10;
        
        // Set random position near the original card (within a small range)
        int xOffset = rand.nextInt(originalSize.width) - originalSize.width / 2;
        int yOffset = rand.nextInt(originalSize.height) - originalSize.height / 2;
        Point debrisPosition = new Point(origin.x + xOffset, origin.y + yOffset);
        
        this.setSize(debrisWidth, debrisHeight);
        this.setLocation(debrisPosition.x, debrisPosition.y);
    }
}
