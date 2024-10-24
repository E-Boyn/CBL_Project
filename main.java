import javax.swing.*;

public class main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            Player player = new Player();
            Dagger dagger = new Dagger();

            Environment gameEnvironment = new Environment(0, player, dagger);  // Start with round 0
            gameEnvironment.startGame();
        } 
        );
    }
}
