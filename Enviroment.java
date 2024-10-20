
import java.util.List;
import java.util.Random;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
public class Enviroment {

    List<Card> environmentCards = new ArrayList<>();
    Player playerCard;
    Dagger daggerCard;
    Enemy enemyCard;
    Treasure treasureCard;

    int round;
    int numOfobjects;
    int screenWidth;
    int screenHeight;
    boolean enemyFlag= true;
    boolean treasureFlag = false;

    private int randomNumber(int num){
        return (int) ((Math.random() * (num - 1)) + 1);
    }


    Enviroment(int round){

        this.round = round;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.screenWidth = screenSize.width;
        this.screenHeight = screenSize.height;
        
        if(round == 0){
            numOfobjects = 4;
            spawnDaggerPlayer();
            spawnCards();
            enemyCard = new Enemy();
            positionCards();
        } else if(round == 1){
            numOfobjects = 6;
            spawnCards();
            enemyCard = new Enemy();
            positionCards();
        } else{
            numOfobjects = randomNumber(20);
            spawnCards();
            treasureCard = new Treasure();
            enemyFlag = false;
            treasureFlag = true;
            positionCards();
        } 
    }

private void spawnDaggerPlayer(){
    playerCard = new Player();
    playerCard.popCard();
    daggerCard = new Dagger();
    daggerCard.popCard();
}
    
    private void spawnCards(){
        int numOfTree = randomNumber(numOfobjects);
        numOfobjects = numOfobjects - numOfTree;

        int numOfHouse = randomNumber(numOfobjects);
        numOfobjects = numOfobjects - numOfHouse;

        int numOfCave = randomNumber(numOfobjects);


            for(int i = 0; i < numOfTree ; i++){
                environmentCards.add(new Tree());
            }
            for(int i = 0; i < numOfHouse ; i++){
                environmentCards.add(new House());
            }
            for(int i = 0; i < numOfCave ; i++){
                environmentCards.add(new Cave());
            }

    }
    

    void positionCards() {
        
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
        if(enemyFlag){
             placeCardBehindEnvironment(rand, enemyCard, environmentBounds);
             enemyCard.setVisible(true);
        }
        if(treasureFlag){
             placeCardBehindEnvironment(rand, treasureCard, environmentBounds);
         treasureCard.setVisible(true);
        }
    }

    // Helper method to place a card behind environment cards
    private static void placeCardBehindEnvironment(Random rand, Card card, 
        List<Rectangle> environmentBounds) {

        Rectangle chosenEnv = environmentBounds.get(rand.nextInt(environmentBounds.size()));
        int x = chosenEnv.x + rand.nextInt(Math.max(1, chosenEnv.width - card.getWidth()));
        int y = chosenEnv.y + rand.nextInt(Math.max(1, chosenEnv.height - card.getHeight()));
        card.setLocation(x, y);
    }


    // public void setUpDaggerListener (){ 
        
    //     daggerCard.addFocusListener(new FocusAdapter() {
    //     @Override
    //     public void focusGained(FocusEvent e) {
    //         // Action to perform when the frame gains focus
    //         System.out.println("The frame is now focused. Action triggered!");
    //     }

    //     @Override
    //     public void focusLost(FocusEvent e) {
    //         // Optional: Action to perform when the frame loses focus
    //         System.out.println("The frame lost focus.");
    //     }
    // });
            
    //     }
    



}

