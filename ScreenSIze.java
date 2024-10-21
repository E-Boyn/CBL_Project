import java.awt.*;

public class ScreenSize {
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    public Dimension getScreenSize() {
        return screenSize;
    }
}