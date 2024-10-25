import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class CardWithFocusListener extends Card implements FocusListener{

    @Override
    public void focusLost(FocusEvent e) {
        isActivated = false;
    }

    @Override
    public void focusGained(FocusEvent e) {
        isActivated = true;
        notifyIsActiveListeners();
    }

    @Override
    public void slay() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        notifySlayListeners();
    }

    //======================================================================    

    private List<FocusChangedListener> focusListeners = new ArrayList<>();
    private List<SlayListener> slayListeners = new ArrayList<>();


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


    // Notify all registered isActive listeners about this card getting focused
    protected void notifyIsActiveListeners() {

        if (this instanceof Dagger) {
            for (FocusChangedListener listener : focusListeners) {
                listener.daggerGotFocused(this);
            }
         
        } else if(this instanceof Treasure) {
            for (FocusChangedListener listener : focusListeners) {
                listener.treasureFound(this);
            }
            } else {
            for (FocusChangedListener listener : focusListeners) {
                listener.somethingGotFocused(this);
            }
        }
    }
    

    protected void notifySlayListeners() {
        if (this instanceof EnvironmentCard) {
            for (SlayListener listener : slayListeners) {
                listener.environmentSlain(this);
            }

        } else if (this instanceof Enemy) {
            System.out.println("Notifying enemy slay listeners");
            for (SlayListener listener : slayListeners) {
                listener.enemySlain(this);
            }
        }
    }
}
