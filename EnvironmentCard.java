import java.awt.event.*;

public class EnvironmentCard extends Card {
    @Override
    public void focusLost(FocusEvent e) {
        isActivated = false;
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        
    }

    @Override
    public void focusGained(FocusEvent e) {
       isActivated = true;
    }
}
