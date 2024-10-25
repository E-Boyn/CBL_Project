/** Represent Cave card in game.
 * Cave card is an Environment card randomly generated and displayed on screen.
 */
public class Cave extends EnvironmentCard {

    /** Constructs Cave card with specific dimension & random image from 2 options.
     */
    public Cave() {
        super();
        heightPercentage = 0.5;
        widthHeightRatio = 1.1852;
        imagePaths = new String[] {
            "/images/cave1.png",
            "/images/cave2.png"
            };
        
        setRandomImage();
    }

    // Displays card on screen
    @Override
    protected void popCard() {
        this.setVisible(true);
    }
    
}