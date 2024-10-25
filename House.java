/** Represent House card in game.
 * House card is an Environment card randomly generated and displayed on screen.
 */
public class House extends EnvironmentCard {
    
    /** Constructs Cave card with specific dimension & random image from 2 options.
     */
    public House() {
        super();
        heightPercentage = 0.5;
        widthHeightRatio = 1.1852;
        imagePaths = new String[] {
            "/images/house1.png",
            "/images/house2.png"
        };

        setRandomImage();
    }

    // Displays card on screen
    @Override
    protected void popCard() {
        this.setVisible(true);
    }
    
}