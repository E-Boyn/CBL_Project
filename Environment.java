import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Environment {

    List<Card> environmentCards = new ArrayList<>();
    Player playerCard;
    Dagger daggerCard;
    Enemy enemyCard;
    Treasure treasureCard;

    int numOfobjects;
    int screenWidth;
    int screenHeight;
    boolean enemyFlag = true;
    boolean treasureFlag = false;

    private int randomNumber(int num) {
        return (int) ((Math.random() * (num - 1)) + 1);
    }


    Environment (int round) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.screenWidth = screenSize.width;
        this.screenHeight = screenSize.height;
        
        if (round == 0) {
            numOfobjects = 4;
            spawnDaggerPlayer();
            spawnCards();
            enemyCard = new Enemy();
            positionCards();
        } else if (round == 1) {
            numOfobjects = 6;
            spawnCards();
            enemyCard = new Enemy();
            positionCards();
        } else {
            numOfobjects = randomNumber(20);
            spawnCards();
            treasureCard = new Treasure();
            enemyFlag = false;
            treasureFlag = true;
            positionCards();
        } 
    }
    

    private void spawnDaggerPlayer() {
        playerCard = new Player();
        playerCard.popCard();
        daggerCard = new Dagger();
        daggerCard.popCard();
    }
    

    private void spawnCards() {
        int numOfTree = randomNumber(numOfobjects);
        numOfobjects = numOfobjects - numOfTree;

        int numOfHouse = randomNumber(numOfobjects);
        numOfobjects = numOfobjects - numOfHouse;

        int numOfCave = randomNumber(numOfobjects);

        for (int i = 0; i < numOfTree; i++) {
            environmentCards.add(new Tree());
        }
        for (int i = 0; i < numOfHouse; i++) {
            environmentCards.add(new House());
        }
        for (int i = 0; i < numOfCave; i++) {
            environmentCards.add(new Cave());
        }

    }


    void positionCards() {
        Random rand = new Random();
        List<Rectangle> environmentBounds = new ArrayList<>();
        int safeZoneHeightOffset = 150;  // Place cards ABOVE Player/Dagger
    
        // Generate environment cards' positions first, but not display them yet
        for (Card environmentCard : environmentCards) {
            // Use randomPosition() to get random coordinates
            Point randomPos = environmentCard.randomPosition(
                screenWidth - environmentCard.getWidth(),
                screenHeight - safeZoneHeightOffset - environmentCard.getHeight()
            );
    
            // Track bounds of each environment card for later use
            environmentBounds.add(new Rectangle(randomPos.x, randomPos.y,
                environmentCard.getWidth(), environmentCard.getHeight()));
            
            // Temporarily store position but don't make the environment card visible yet
            environmentCard.setLocation(randomPos.x, randomPos.y);
        }
    
        // Pick random environment card to hide the enemy card inside
        // Using its top-left point to generate enemy so it can be covered
        if (enemyFlag) {
            Rectangle chosenEnv = environmentBounds.get(rand.nextInt(environmentBounds.size()));
    
            // Place enemy card at the top-left corner of the chosen environment card
            Point enemyPos = getTopLeftPointInside(chosenEnv);
            enemyCard.setLocation(enemyPos.x, enemyPos.y);
            enemyCard.setVisible(true);  // Display the enemy card, but it will be covered later
        }
    
        // Make environment cards visible (they will cover enemy card)
        for (Card environmentCard : environmentCards) {
            environmentCard.setVisible(true);  // Now show the environment cards to cover the enemy
        }
    
        // Use later ---- Handle treasure similarly
        if (treasureFlag) {
            Rectangle chosenEnv = environmentBounds.get(rand.nextInt(environmentBounds.size()));
            Point treasurePos = getTopLeftPointInside(chosenEnv);
            treasureCard.setLocation(treasurePos.x, treasurePos.y);
            treasureCard.setVisible(true);  // Make treasure visible but behind environment
        }
    }
    

    // Helper method to get the top-left point of a given rectangle (environment card bounds)
    private Point getTopLeftPointInside(Rectangle rect) {
        return new Point(rect.x, rect.y);
    }

    
}
