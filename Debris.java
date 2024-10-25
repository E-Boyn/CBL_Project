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
    
    Dimension debreeSize = new Dimension();

    List<Card> debris = new ArrayList<>();
    int numOfobjects;
     Random rand = new Random();
Debree debree;

    public Debris(EnvironmentCard originalCard) {
        // super();
        // this.setAlwaysOnTop(true);  // Ensure debris is on top -- to make sure it runs damn
        
        // this.heightPercentage = 0.1; 
        // this.widthHeightRatio = 1.0;

        
        originalCard = originalCard;

       numOfobjects = rand.nextInt(3)+1;
       for ( int i = 0; i < numOfobjects; i++) {
                debree = new Debree(originalCard); 
                
                debree.setVisible(true);
                debris.add(debree);
       }
    }


        // Set random position near the original card (within a small range)
  

    //     // Generate random size for debris (smaller than original card)
    // private void setSize(Card card){
    //     debreeSize.height = rand.nextInt(originalSize.height / 2) + 100;
    //     debreeSize.width = (int) (debreeSize.height * card.widthHeightRatio);

    //     card.setSize(debreeSize);
    // }


// private void setImage(Card card) {
//     // Load original image
//     String imagePath = getRandomImageFromPaths(card);

//     ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagePath));
//     Image image = imageIcon.getImage();
    
//     // Calculate height based on screen size and percentage
//     debreeSize.height = rand.nextInt(originalSize.height / 2) + 100;
//     debreeSize.width = (int) (debreeSize.height * card.widthHeightRatio);

    
//     // Resize image to fit card
//     Image scaledImage = image.getScaledInstance( debreeSize.width, debreeSize.height, Image.SCALE_SMOOTH);
//     ImageIcon scaledIcon = new ImageIcon(scaledImage);

//     // Set scaled image in JLabel
//     JLabel diplayImage = new JLabel(scaledIcon);
//     card.add(diplayImage);

//     card.setSize(debreeSize);
//     card.pack(); // Adjust frame to fit image
// }
}