public class Enemy extends Card {
    public Enemy() {
        super();
        heightPercentage = 0.2222;
        widthHeightRatio = 1.25;

        setImage("/images/enemy.png");
    }

    @Override
    protected void popCard() {
        this.setVisible(true);
    }
}
