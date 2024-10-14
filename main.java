import javax.swing.SwingUtilities;

public class main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            
            Player playerCard = new Player();
            playerCard.popCard();

            Dagger daggerCard = new Dagger();
            daggerCard.popCard();

            //Tree treeCard = new Tree();
            //treeCard.popCard();

            //House houseCard = new House();
            //houseCard.popCard(); 

            //Treasure treasureCard = new Treasure();
            //treasureCard.popCard(); 

        });
    }
}
