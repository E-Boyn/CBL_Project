import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            
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

            Card.positionCards(environmentCards, enemyCard, treasureCard, 
                treeCard.screenWidth, treeCard.screenHeight);

        });
    }
}
