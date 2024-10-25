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

       this.originalCard = originalCard;

       numOfobjects = rand.nextInt(3)+1;
       for ( int i = 0; i < numOfobjects; i++) {
                debree = new Debree(originalCard); 
                
                debree.setVisible(true);
                debris.add(debree);
       }
    }

}