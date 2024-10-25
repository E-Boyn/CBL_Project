
import java.awt.*;

/** Utility class to retrieve the screen size of the user's display.
 */
public class ScreenSIze {
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    public Dimension getScreenSize() {
        return screenSize;
    }
}