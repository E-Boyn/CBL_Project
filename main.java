import javax.swing.SwingUtilities;

/** The main entry point for the game.
 * Starts the game with round 1 (index 0 --> round 0).
 */
public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Environment gameEnvironment = new Environment(0);  // Start with round 0
        } 
        );
    }
}

