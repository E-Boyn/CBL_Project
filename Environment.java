import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.Timer;

/** Manages environment in the game across different rounds.
 * Spawns environment cards, enemies, treasure.
 * Tracks player progress through rounds.
 */
public class Environment implements FocusChangedListener, SlayListener {

    // Tracks when any card in game gains focus
    @Override
    public void somethingGotFocused(Card card) {
        System.out.println("CARD ADDED");
        daggerdPrepearedFlag = true;
        history.add(card);  // Track focus history
    }

    // Tracks when Dagger card gains focus and slays enemy if it was focused    
    @Override
    public void daggerGotFocused(Card card) {
        if (daggerdPrepearedFlag) {
            System.out.println("Dagger focused");
            int lastFocusedIndex = history.size() - 1;
            history.get(lastFocusedIndex).slay(); 
        }
        daggerdPrepearedFlag = false;
    }

    @Override
    public void TutorialOrEndSlain(Card card) {
        if(!gameOver){
        startGame();
        } else {
            closeCard(playerCard);
        }
    }

    @Override
    public void environmentClosed(Card card) {
        throw new UnsupportedOperationException("Unimplemented method 'environmentClosed'");
    }

    // Progresses game to next round if enemy is slain
    @Override
    public void enemySlain(Card card) {
        System.out.println("Enemy slain! Progressing to next round...");
        enemySlain = true;  // Mark enemy as slain
        progressToNextRound();  // Move to the next round after enemy is slain
    }

    // End game when treasure is found
    @Override
    public void treasureFound(Card card) {
            gameOver = true;
            endGame();
    }

    // =============================================================================================


    private int currentRound = 0;  // Track the current round
    
    // Store environment cards across rounds
    public List<EnvironmentCard> environmentCards = new ArrayList<>();
    
    List<Card> history = new ArrayList<>();  // Track focus history
    Player playerCard;
    Dagger daggerCard;
    Enemy enemyCard; // One per round in round 1-2
    Treasure treasureCard; // One in round 3 or final round
    TutorialEnd tutorial;
    TutorialEnd end;

    int numOfobjects;
    int screenWidth;
    int screenHeight;

    //Control flags
    boolean enemySpawned = false;
    boolean treasureSpawned = false; 
    boolean enemySlain = false;  // If the enemy is slain in the current round
    boolean gameOver = false;  // Ensure game over happens only once
    boolean daggerdPrepearedFlag = false;

    /** Environment constructor that starts game with round 1 (index 0).
     */
    Environment(int round) {
        playerCard = new Player();
        daggerCard = new Dagger();
        tutorial = new TutorialEnd(gameOver);
        
        this.currentRound = round;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.screenWidth = screenSize.width;
        this.screenHeight = screenSize.height;

        // Spawn player & dagger only once at round 1
        spawnDaggerPlayer();
        
        playerCard.addIsActiveListener(this);
        playerCard.addSlayListener(this);
        
        daggerCard.addIsActiveListener(this);  // Ensure dagger card listens for focus
        
        tutorial.addIsActiveListener(this);
        tutorial.addSlayListener(this);

        
        
    }

    

//========================================== Start of Round managment ================================================

    /** Go to next round when enemy is slain.
     */
    public void progressToNextRound() {
        currentRound++;  // Move to the next round
        enemySpawned = false;  // Reset for the new round's enemy
        treasureSpawned = false;  // Reset for the treasure round
        startGame();  // Start next round
    }

    /** Start the game & progress through rounds.
     */
    public void startGame() {
        enemySlain = false;  // Reset enemy slain flag for each round
        history.clear();  // Clear the history to avoid carrying over data between rounds
        if (currentRound == 0) {
            setupRound(4);  // Round 1: 4 environment cards + 1 enemy
        } else if (currentRound == 1) {
            setupRound(6);  // Round 2: 6 new environment cards + 1 enemy
        } else if (currentRound == 2) {
            setupTreasureRound();  // Round 3: Final treasure hunt round (NO enemy)
        }
    }


    // Setup rounds where an enemy is hidden (for round 1-2)
    private void setupRound(int numOfEnvCards) {
        if (!enemySpawned) {
            // Only add new environment cards (keep undestroyed ones)
            numOfobjects = numOfEnvCards;
            spawnNewEnvironmentCards();  // Add new environment cards to existing ones

            // Spawn a new enemy
            enemyCard = new Enemy();
            enemyCard.addSlayListener(this);

            // Add listeners to environment & enemy cards
            for (EnvironmentCard environmentCard : environmentCards) {
                environmentCard.addIsActiveListener(this);  // Listener for interaction
            }

            // Add enemy & dagger listeners
            enemyCard.addIsActiveListener(this);

            positionCards();  // Position cards on screen

            // Set the flag to true to avoid spawning more than 1 enemy in this round
            enemySpawned = true;
        }
    }


    // Setup the final treasure round (NO enemy, just treasure)
    private void setupTreasureRound() {
        if (!treasureSpawned) {
            // Generate 10–20 new environment cards in the final round
            numOfobjects = randomNumber(5, 15);  
            
            // Add new environment cards to existing ones
            spawnNewEnvironmentCards();

            // Spawn treasure (No enemy in this round)
            treasureCard = new Treasure();

            // Add listeners for environment & treasure
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

    private void endGame(){
        
        end = new TutorialEnd(gameOver);

        Timer timer = new Timer(5000, event -> {
            closeCard(playerCard);
           });
        timer.start();
        
    }
   
   

//========================================== End of Rounds ================================================

//==================================== Start of card management ===========================================

// Method to spawn player & dagger cards (called only once at the start)
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

    /** Helper method to position cards (enemy, treasure, environment).
     */
    private void positionCards() {
        int taskbarheight = Toolkit.getDefaultToolkit().getScreenSize().height 
            - GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
        Random rand = new Random();
        List<Rectangle> environmentBounds = new ArrayList<>();

        // Place cards ABOVE Player/Dagger
        int safeZoneHeightOffset = daggerCard.getHeight() + taskbarheight;

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
        // Only position the enemy in round 1-2 
        if (currentRound < 2 && enemyCard != null && !enemyCard.isVisible()) {
            Rectangle chosenEnv = environmentBounds.get(rand.nextInt(environmentBounds.size()));
            Point enemyPos = getTopLeftPointInside(chosenEnv);
            enemyCard.setLocation(enemyPos.x, enemyPos.y);
            enemyCard.setVisible(true);  // Display the enemy card, but it will be covered later
        }

        // Treasure card (if exist) generated in the top-left corner of a random environment card
        // Only position the treasure in final round
        if (treasureCard != null && !treasureCard.isVisible()) { 
            Rectangle chosenEnv = environmentBounds.get(rand.nextInt(environmentBounds.size()));
            Point treasurePos = getTopLeftPointInside(chosenEnv);
            treasureCard.setLocation(treasurePos.x, treasurePos.y);
            treasureCard.setVisible(true);  // Make treasure visible but behind environment
        }

        // Make the environment cards visible (cover enemy & treasure cards)
        for (Card environmentCard : environmentCards) {
            environmentCard.setVisible(true);
        }
    }

//------------------------ -Simple calculation methods --------------------

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


    private void closeCard(Card card){
        card.dispatchEvent(new WindowEvent(card, WindowEvent.WINDOW_CLOSING));
    }
    
}