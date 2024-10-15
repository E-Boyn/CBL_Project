import java.awt.*;
import java.awt.event.*;
public class EnviromentCard extends Card {

    @Override
    public void focusLost(FocusEvent e) {
        isActivated = false;
        
       System.out.println("is activated = false, delete" );
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        
    }

    @Override
    public void focusGained(FocusEvent e) {
       isActivated = true;
       System.out.println("is activated = true" );
    }
}
