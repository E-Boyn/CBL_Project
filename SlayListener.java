public interface SlayListener {
    
    void environmentSlain(Card card);

    void enemySlain(Card card);

    void playerSlain(Card card);

    void treasureFound(Card card);
}
