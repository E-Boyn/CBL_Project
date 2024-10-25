import javax.swing.*;

public class main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            // Tree tree = new Tree();
            
            // tree.popCard();
            // tree.slay();

            Environment gameEnvironment = new Environment(0);  // Start with round 0
            gameEnvironment.startGame();
        } 
        );
    }
}
