/** Interface tracking focus changes on game cards.
 * Provides method to handle different card events
 */
public interface FocusChangedListener {
    
    void somethingGotFocused(Card card);
    
    void treasureFound(Card card);

    void environmentClosed(Card card);

    void daggerGotFocused(Card card);
}
