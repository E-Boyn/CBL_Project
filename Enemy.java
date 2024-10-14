public class Enemy extends Card {
    public Enemy() {
        super();
        double heightPercentage = 0.1111;
        setImage("/images/enemy.png", heightPercentage, 1.0);
    }

    @Override
    protected void popCard() {
        this.setVisible(true);
    }
}
