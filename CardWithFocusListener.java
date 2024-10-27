import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/** Represents card with focus listener capabilities.
 * Card can notify listeners when:
 *      - It gains or loses focus
 *      - It gets "slain"
 */
public class CardWithFocusListener extends Card implements FocusListener {

    // Notifies that card has lost focus
    @Override
    public void focusLost(FocusEvent e) {
        isActivated = false;
    }

    // Notifies that card has gained focus & triggers necessary listeners
    @Override
    public void focusGained(FocusEvent e) {
        isActivated = true;
        notifyIsActiveListeners();
    }

    // Dispatch window-closing event when card is slain & notify slay listeners
    @Override
    public void slay() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        notifySlayListeners();
    }

    //======================================================================    

    private List<FocusChangedListener> focusListeners = new ArrayList<>();
    private List<SlayListener> slayListeners = new ArrayList<>();

    /** Constructs a CardWithFocusListener object.
     * Initializes the card, 
     * sets up necessary focus listeners, 
     * and ensures card can notify listeners when it gains or loses focus.
     */
    protected CardWithFocusListener() {
        super();
        this.addFocusListener(this);
    }


    // Register a listener
    public void addIsActiveListener(FocusChangedListener listener) {
        focusListeners.add(listener);
    }


    // Remove a listener
    public void removeIsActiveListener(FocusChangedListener listener) {
        focusListeners.remove(listener);
    }


    // Register a Slay listener
    public void addSlayListener(SlayListener listener) {
        slayListeners.add(listener);
    }


    // Remove a Slay listener
    public void removeSlayListener(SlayListener listener) {
        slayListeners.remove(listener);
    }

    
    /** Notify all registered isActive listeners that card gained focus.
     *  Determines card type.
     */
    protected void notifyIsActiveListeners() {

        if (this instanceof Dagger) {
            for (FocusChangedListener listener : focusListeners) {
                listener.daggerGotFocused(this);
            }
         
        } else if (this instanceof Treasure) {
            for (FocusChangedListener listener : focusListeners) {
                listener.treasureFound(this);
            }
        } else {
            for (FocusChangedListener listener : focusListeners) {
                listener.somethingGotFocused(this);
            }
        }
    }
    

    /** Notifies all registered isActive listeners that card has been slain.
     */
    protected void notifySlayListeners() {
        if (this instanceof Tutorial) {
            for (SlayListener listener : slayListeners) {
                
            System.out.println("Notifying tutorial slay listeners");
                listener.TutorialOrEndSlain(this);
            }

        } else if (this instanceof Enemy) {
            System.out.println("Notifying enemy slay listeners");
            for (SlayListener listener : slayListeners) {
                listener.enemySlain(this);
            }
        }
    }
}