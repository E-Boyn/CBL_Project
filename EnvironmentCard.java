import java.awt.event.*;

public class EnvironmentCard extends CardWithFocusListener{
    @Override
    public void focusLost(FocusEvent e) {
        isActivated = false;
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
