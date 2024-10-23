import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
public class CardWithFocusListener extends Card implements FocusListener{
    private List<FocusChaingedListener> listeners = new ArrayList<>();

    @Override
    public void focusLost(FocusEvent e) {
        isActivated = false;
    }

    @Override
    public void focusGained(FocusEvent e) {
       isActivated = true;
       notifyListeners();
    }

    
    protected CardWithFocusListener(){
        super();
        this.addFocusListener(this);
    }


     // Register a listener
     public void addIsActiveListener(FocusChaingedListener listener) {
        listeners.add(listener);
    }

    // Remove a listener
    public void removeIsActiveListener(FocusChaingedListener listener) {
        listeners.remove(listener);
    }

    // Notify all registered listeners about the change
    protected void notifyListeners() {

        for (FocusChaingedListener listener : listeners) {
            listener.somethingGotFocused(this);
        }
    }
    protected void notifyListeners(Card card) {
        if(card instanceof Dagger){
           for (FocusChaingedListener listener : listeners) {
               listener.daggerGotFocused(card);}
        
        } else if(card instanceof Enemy){
            
           for (FocusChaingedListener listener : listeners) {
            listener.enemySlain(card);}
        } else {

           for (FocusChaingedListener listener : listeners) {
            listener.somethingGotFocused(card);}
        }
    }
    
}
