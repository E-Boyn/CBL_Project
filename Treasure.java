public class Treasure extends Card {

    public Treasure() {
        super();
        double heightPercentage = 0.2222;
        setImage("/images/treasure.png", heightPercentage, 1.25);
    }

    @Override
    protected void popCard() {
        this.setVisible(true);
    }
}
