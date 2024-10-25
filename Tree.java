/** Represent Tree card in game.
 * Tree card is an Environment card randomly generated and displayed on screen.
 */
public class Tree extends EnvironmentCard {

    /** Constructs Tree card with specific dimension & random image from 2 options.
     */
    public Tree() {
        super();
        heightPercentage = 0.6481;
        widthHeightRatio = 0.5143;

        imagePaths = new String[] {
            "/images/tree1.png",
            "/images/tree2.png"
        };
        setRandomImage();
    }

    // Displays card on screen
    @Override
    protected void popCard() {
        this.setVisible(true);
    }
    
}