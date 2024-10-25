import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.awt.event.FocusEvent;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.Timer;

public class Environment implements FocusChangedListener, SlayListener {

    @Override
    public void somethingGotFocused(Card card) {
        System.out.println("CARD ADDED");
        daggerdPrepearedFlag = true;
        history.add(card);  // Track focus history
    }
    
    @Override
    public void daggerGotFocused(Card card) {
        if(daggerdPrepearedFlag){
            System.out.println("Dagger focused");
            int lastFocusedIndex = history.size() - 1;
            history.get(lastFocusedIndex).slay(); 
        }
        daggerdPrepearedFlag = false;
        // if (!history.isEmpty()) {
        //     // Get last focused card from history
        //     Card lastFocusedCard = history.get(history.size() - 1);

        //     // Only slay if the last focused card was the enemy
        //     if (lastFocusedCard instanceof Enemy && !enemySlain) {
        //         lastFocusedCard.slay();  // Slay the enemy

        //         // Call enemySlain to progress to the next round
        //         
        //     } else {
        //         System.out.println("Environment focused, not slaying it.");
        //     }
        // }
    }

    @Override
    public void environmentClosed(Card card) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'environmentClosed'");
    }

    @Override
    public void environmentSlain(Card card) {
        // TODO Auto-generated method stub
        System.out.println("Environment card focused. No destruction.");
        throw new UnsupportedOperationException("Unimplemented method 'environmentSlain'");
    }

    @Override
    public void enemySlain(Card card) {
        System.out.println("Enemy slain! Progressing to next round...");
        enemySlain = true;  // Mark enemy as slain
        progressToNextRound();  // Move to the next round after enemy is slain
    }

    @Override
    public void treasureFound(Card card) {
        if (!gameOver) {
            // TODO Make the Message show. It does not show rn idk why
            System.out.println("Treasure found! You win the game!");
             Timer timer = new Timer(1000, event -> {

            treasureCard.setDefaultCloseOperation(treasureCard.EXIT_ON_CLOSE);
            treasureCard.dispatchEvent(new WindowEvent(treasureCard, WindowEvent.WINDOW_CLOSING));

            }
            );
        
        timer.start();
            gameOver = true;
        }
    }

    @Override
    public void playerSlain(Card card) {
        // Implement any logic for player slaying if needed
    }


    // =============================================================================================


    private int currentRound = 0;  // Track the current round
    
    // Store environment cards across rounds
    public List<EnvironmentCard> environmentCards = new ArrayList<>();
    
    List<Card> history = new ArrayList<>();  // Track focus history
    Player playerCard;
    Dagger daggerCard;
    Enemy enemyCard;  // Only one enemy per round in the first 2 rounds
    Treasure treasureCard;  // Treasure in the final round

    int numOfobjects;
    int screenWidth;
    int screenHeight;

    //Control flags
    boolean enemySpawned = false;
    boolean treasureSpawned = false; 
    boolean enemySlain = false;  // If the enemy is slain in the current round
    boolean gameOver = false;  // Ensure game over happens only once
    boolean daggerdPrepearedFlag = false;
    // Constructor starts with round 0
    Environment(int round) {
        playerCard = new Player();
        daggerCard = new Dagger();
        playerCard.addIsActiveListener(this);
        
        this.currentRound = round;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.screenWidth = screenSize.width;
        this.screenHeight = screenSize.height;

        // Spawn player and dagger only once at the start of the game (first round)
        spawnDaggerPlayer();

        // Start the game with the current round
        startGame();
    }


    // Start the game and progress through rounds
    public void startGame() {
        enemySlain = false;  // Reset enemy slain flag for each round
        history.clear();  // Clear the history to avoid carrying over data between rounds
        if (currentRound == 0) {
            setupRound(4);  // Round 1: 4 environment cards and 1 enemy
        } else if (currentRound == 1) {
            setupRound(6);  // Round 2: 6 new environment cards and 1 enemy
        } else if (currentRound == 2) {
            setupTreasureRound();  // Round 3: Final treasure hunt round (NO enemy)
        }
    }


    // Setup rounds where an enemy is hidden (for round 1 and round 2)
    private void setupRound(int numOfEnvCards) {
        if (!enemySpawned) {
            // Only add new environment cards (keep the existing ones)
            numOfobjects = numOfEnvCards;
            spawnNewEnvironmentCards();  // Add new environment cards to existing ones

            // Spawn a new enemy
            enemyCard = new Enemy();
            enemyCard.addSlayListener(this);

            // Add listeners to environment and enemy cards
            for (EnvironmentCard environmentCard : environmentCards) {
                environmentCard.addIsActiveListener(this);  // Listener for interaction
            }

            // Add enemy and dagger listeners
            enemyCard.addIsActiveListener(this);
            daggerCard.addIsActiveListener(this);  // Ensure dagger card listens for focus

            positionCards();  // Position cards on screen

            // Set the flag to true to avoid spawning more than 1 enemy in this round
            enemySpawned = true;
        }
    }


    // Setup the final treasure round (NO enemy, just treasure)
    private void setupTreasureRound() {
        if (!treasureSpawned) {
            // Generate 10–20 new environment cards in the final round
            numOfobjects = randomNumber(10, 20);  
            
            // Add new environment cards to existing ones
            spawnNewEnvironmentCards();

            // Spawn treasure (No enemy in this round)
            treasureCard = new Treasure();

            // Add listeners for environment and treasure
            for (EnvironmentCard environmentCard : environmentCards) {
                environmentCard.addIsActiveListener(this);  // Listener for interaction
            }

            // Add treasure listener
            treasureCard.addIsActiveListener(this);

            positionCards();  // Position the treasure behind environment cards

            // Set the flag to true to avoid spawning more than 1 treasure
            treasureSpawned = true;
        }
    }


    // Method to spawn player and dagger cards (called only once at the start)
    private void spawnDaggerPlayer() {
        playerCard.popCard();
        daggerCard.popCard();
    }


    // Spawn new environment cards without clearing the previous ones
    private void spawnNewEnvironmentCards() {
        int numOfTree = randomNumber(numOfobjects);
        numOfobjects -= numOfTree;

        int numOfHouse = randomNumber(numOfobjects);
        numOfobjects -= numOfHouse;

        int numOfCave = numOfobjects;

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


    // After the enemy is slain, go to the next round
    public void progressToNextRound() {

        //TODO THERE IS NO ENEMY TO SLAY IN THE FINAL ROUND WHY IS THIS HERE
        if (currentRound == 2) {
            if (!gameOver) {  // Ensure game over logic is not triggered multiple times
                System.out.println("Game Over: You found the treasure!");  // End the game
                gameOver = true;  // Set the game over flag
            }
            return;
        } 
        currentRound++;  // Move to the next round
        enemySpawned = false;  // Reset the flag for the new round's enemy
        treasureSpawned = false;  // Reset the flag for the treasure round
        startGame();  // Start the next round
    }

    
    // Helper method to position cards (enemy, treasure, environment)
    void positionCards() {
        int taskbarheight = Toolkit.getDefaultToolkit().getScreenSize().height 
                                - GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
        Random rand = new Random();
        List<Rectangle> environmentBounds = new ArrayList<>();
        int safeZoneHeightOffset = daggerCard.getHeight() + taskbarheight;  // Place cards ABOVE Player/Dagger

        // Generate the environment cards' positions
        for (Card environmentCard : environmentCards) {
            Point randomPos = environmentCard.randomPosition(screenWidth 
                - environmentCard.getWidth(), screenHeight 
                - safeZoneHeightOffset - environmentCard.getHeight());

            // Track the bounds of each environment card
            environmentBounds.add(new Rectangle(randomPos.x, randomPos.y,
                    environmentCard.getWidth(), environmentCard.getHeight()));
            environmentCard.setLocation(randomPos.x, randomPos.y);
        }

        // Enemy card (if exist) generated in the top-left corner of a random environment card
        // Only position the enemy in rounds 1 and 
        if (currentRound < 2 && enemyCard != null && !enemyCard.isVisible()) {
            Rectangle chosenEnv = environmentBounds.get(rand.nextInt(environmentBounds.size()));
            Point enemyPos = getTopLeftPointInside(chosenEnv);
            enemyCard.setLocation(enemyPos.x, enemyPos.y);
            enemyCard.setVisible(true);  // Display the enemy card, but it will be covered later
        }

        // Treasure card (if exist) generated in the top-left corner of a random environment card
        // Only position the treasure in the final round
        if (treasureCard != null && !treasureCard.isVisible()) { 
            Rectangle chosenEnv = environmentBounds.get(rand.nextInt(environmentBounds.size()));
            Point treasurePos = getTopLeftPointInside(chosenEnv);
            treasureCard.setLocation(treasurePos.x, treasurePos.y);
            treasureCard.setVisible(true);  // Make treasure visible but behind environment
        }

        // Make the environment cards visible (they will cover enemy and treasure cards)
        for (Card environmentCard : environmentCards) {
            environmentCard.setVisible(true);
        }
    }


    // Helper method to get the top-left point of a given rectangle (environment card bounds)
    private Point getTopLeftPointInside(Rectangle rect) {
        return new Point(rect.x, rect.y);
    }


    // For setupTreasureRound()
    // Random number generator for two arguments (min, max)
    public static int randomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }


    // For spawnNewEnvironmentCards()
    // Random number generator for one argument (max) - default min is 1
    private int randomNumber(int max) {
        return (int) (Math.random() * (max - 1)) + 1;
    }

}