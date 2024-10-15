import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.*;

public class main {
    /**
     * Manage locations of environment cards and hides enemy and treasure cards amidst them.
     * 
     * @param environmentCards List of environment cards to be placed on the screen.
     * @param enemyCard Enemy card to be hidden amidst the environment cards.
     * @param treasureCard Treasure card to be hidden amidst the environment cards.
     * @param screenWidth Screen width to calc card position.
     * @param screenHeight Screen height to calc card position.
     */    
    public static void positionCards(List<Card> environmentCards, Card enemyCard, 
        Card treasureCard, int screenWidth, int screenHeight) {
        
        Random rand = new Random();
        List<Rectangle> environmentBounds = new ArrayList<>();
        int safeZoneHeightOffset = 150;  // Place cards ABOVE Player/Dagger

        // Place environment cards randomly
        for (Card environmentCard : environmentCards) {
            // Use randomPosition() to get random coordinates
            Point randomPos = environmentCard.randomPosition(
                screenWidth - environmentCard.getWidth(), 
                screenHeight - safeZoneHeightOffset - environmentCard.getHeight()
                );

            // Set the card's location and track its bounds -- to later hide emeny & treasure cards
            environmentCard.setLocation(randomPos.x, randomPos.y);
            environmentBounds.add(new Rectangle(randomPos.x, randomPos.y, 
                environmentCard.getWidth(), environmentCard.getHeight()));
            environmentCard.setVisible(true);
        }

        // Hide enemy and treasure cards behind or between environment cards 
        // TODO !!!!!!! make it so that it's JUST behind. Not between. Between unguaranteed hiding
        placeCardBehindEnvironment(rand, enemyCard, environmentBounds);
        enemyCard.setVisible(true);
        placeCardBehindEnvironment(rand, treasureCard, environmentBounds);
        treasureCard.setVisible(true);
    }

    // Helper method to place a card behind environment cards
    private static void placeCardBehindEnvironment(Random rand, Card card, 
        List<Rectangle> environmentBounds) {

        Rectangle chosenEnv = environmentBounds.get(rand.nextInt(environmentBounds.size()));
        int x = chosenEnv.x + rand.nextInt(Math.max(1, chosenEnv.width - card.getWidth()));
        int y = chosenEnv.y + rand.nextInt(Math.max(1, chosenEnv.height - card.getHeight()));
        card.setLocation(x, y);
    }
    public static void main(String[] args) {

        Tree tree = new Tree();
        tree.setVisible(true);

        House house = new House();
        house.setVisible(true);
        
        Card card=new Card();
        card.setSize(100,200);
        card.setVisible(true);
        /*
            //Display player & dagger at fixed positions
            Player playerCard = new Player();
            playerCard.popCard();
            Dagger daggerCard = new Dagger();
            daggerCard.popCard();

            Tree treeCard = new Tree();
            House houseCard = new House();
            Cave caveCard = new Cave();
            Enemy enemyCard = new Enemy();
            Treasure treasureCard = new Treasure();

            List<Card> environmentCards = new ArrayList<>();
            environmentCards.add(treeCard);
            environmentCards.add(houseCard);
            environmentCards.add(caveCard);

            positionCards(environmentCards, enemyCard, treasureCard, 
                treeCard.screenWidth, treeCard.screenHeight);
 */
    }
}
