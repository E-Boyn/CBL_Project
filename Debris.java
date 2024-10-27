import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Represents debris created when environment card is slain/destroyed.
 * Each debris smaller fragment of original card.
 * Debris located near location of original card.
 */
public class Debris {
    Card originalCard = new Card();
    
    Dimension debreeSize = new Dimension();
    List<Card> debris = new ArrayList<>();
    int numOfobjects;
    Random rand = new Random();
    Debree debree;

    /** Constructs Debris object that generates multiple Debree pieces 
     * around a specified environment card. 
     * Amount of debris pieces generated is randomized between 1 and 3.
     * 
     * @param originalCard Original environment card the debris is created from
     */
    public Debris(EnvironmentCard originalCard) {

        this.originalCard = originalCard;

        numOfobjects = rand.nextInt(3) + 1;
        for (int i = 0; i < numOfobjects; i++) {
            debree = new Debree(originalCard); 
            debree.setVisible(true);
            debris.add(debree);
        }
    }

}