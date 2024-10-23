import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

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


    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
  /*          
        Tree tree = new Tree();
        tree.setVisible(true);

        House house = new House();
        house.setVisible(true);
        
        Card card=new Card();
        card.setSize(100,200);
        card.setVisible(true);
*/


            // //Display player & dagger at fixed positions
            // Player playerCard = new Player();
            // playerCard.popCard();
            // Dagger daggerCard = new Dagger();
            // daggerCard.popCard();
            

            // Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            
            // Enemy enemyCard = new Enemy();
            // Treasure treasureCard = new Treasure();
            // Tree treeCard = new Tree();
            // House houseCard = new House();
            // Cave caveCard = new Cave();

            
            // Cave caveCard2 = new Cave();
            // enemyCard.setVisible(true);
            // caveCard.setVisible(true);
            // caveCard2.setVisible(true);
            
            // Treasure treasure = new Treasure();
            // treasure.setVisible(true);

            // List<Card> environmentCards = new ArrayList<>();
            // environmentCards.add(treeCard);
            // environmentCards.add(houseCard);
            // environmentCards.add(caveCard);

            
            //Display player & dagger at fixed positions
            Player player = new Player();
            Dagger dagger = new Dagger();

            new Enviroment(0, player, dagger);

            Tree tree = new Tree();
            Enviroment first = new Enviroment(tree);   

            Enviroment second = new Enviroment(tree);     

        } );
    }
}
