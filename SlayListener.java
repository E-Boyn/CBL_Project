/** Interface for tracking when a card is slain in the game.
 */
public interface SlayListener {
    
    void environmentSlain(Card card);

    void enemySlain(Card card);

    void playerSlain(Card card);
}