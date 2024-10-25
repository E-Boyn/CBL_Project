import java.awt.event.*;

/** Represents environment card in game. 
 * Environment cards can be focused and destroyed to debris by the Dagger.
 */
public class EnvironmentCard extends CardWithFocusListener {
    
    
    // Notifies that environment card lost focus i.e. explored and get closed
    @Override
    public void focusLost(FocusEvent e) {
        
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        isActivated = false;
    }

    // Slay or destroy environment card  to debris.
    @Override
    public void slay() {
        System.out.println("Slay method called in EnvironmentCard.");  // Debugging statement
    
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        Debris debreObjects = new Debris(this); 
        // It says debreObjects not used when it is literally used???
    }
}