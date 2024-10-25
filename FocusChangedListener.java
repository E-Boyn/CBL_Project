public interface FocusChangedListener {
    void somethingGotFocused(Card card);
    
    void treasureFound(Card card);

    void environmentClosed(Card card);

    void daggerGotFocused(Card card);
}
