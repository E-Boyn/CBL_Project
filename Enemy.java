public class Enemy extends Card {
    public Enemy() {
        super();
        double heightPercentage = 0.1111;
        heightRatio = 1.0;
        
        setImage("/images/enemy.jpg");
    }

    @Override
    protected void popCard() {
        this.setVisible(true);
    }
}
