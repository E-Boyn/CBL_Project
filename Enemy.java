public class Enemy extends Card {
    public Enemy() {
        super();
        heightPercentage = 0.1111;
        widthHeightRatio = 1.0;

        setImage("/images/enemy.jpg");
    }

    @Override
    protected void popCard() {
        this.setVisible(true);
    }
}
