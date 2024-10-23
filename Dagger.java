import java.awt.Color;
import java.awt.event.*;

public class Dagger extends CardWithFocusListener {
    public Dagger() {
        super();
        isDagger = true;
        heightPercentage = 0.22;
        widthHeightRatio = 0.6;
        
        color = new Color(78, 36, 247);
        setBorder();
        setImage("/images/dagger.png");
    }

    @Override
    public void focusGained(FocusEvent e) {
       isActivated = true;
       notifyListeners(this);
    }

    @Override
    protected void popCard() {
        int taskbarHeightOffset = 50;  // Adjustable -- should not be covered by taskbar

        // Set card location to the bottom-center but above taskbar
        int x = (screenWidth - this.getWidth()) / 2;  // Center horizontally
        int y = screenHeight - this.getHeight() - taskbarHeightOffset;

        this.setLocation(x, y);
        this.setVisible(true); 
    }
}
