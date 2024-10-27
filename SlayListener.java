/** Interface for tracking when a card is slain in the game.
 */
public interface SlayListener {

    void enemySlain(Card card);

    void tutorialOrEndSlain(Card card);
    
}