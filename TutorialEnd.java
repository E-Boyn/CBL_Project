import java.awt.*;

/** Represents  opening (tutorial) and the closing (end) windows/screens of the game.
 * 
 */
public class TutorialEnd extends CardWithFocusListener {

    /** Constructs a `TutorialEnd` card to display either the tutorial or end screen.
     * 
     * @param gameOver Display end screen if true; displays tutorial when not
     */
    public TutorialEnd(boolean gameOver) {
        super();

        heightPercentage = 0.5556;
        widthHeightRatio = 1.5;

        if (gameOver) {
            setEnd();
        } else {
            setTutorial();
        }

        int taskbarheight = Toolkit.getDefaultToolkit().getScreenSize().height 
            - GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;

        //Calculate the frame location
        int x = (screenWidth - getWidth()) / 2;
        int y = (screenHeight - getHeight()) / 2 - taskbarheight - 10;

        //Set the new frame location
        setLocation(x, y);   
      
        setBorder();
        setVisible(true);
    }


    private void setTutorial() {
        
        this.getContentPane().setBackground(Color.BLACK);
        color = new Color(100, 100, 100);

        setImage("/images/tutorial.png");

    }

    private void setEnd() {
        color = new Color(0, 0, 0);
        setImage("/images/endOfGame.png");
        
        System.out.println("Succesful attempt, Game Over!");
    }
}
