public class Treasure extends Card {

    public Treasure() {
        super();
        heightPercentage = 0.2222;
        widthHeightRatio = 1.25;

        setImage("/images/treasure.png");
    }

    @Override
    protected void popCard() {
        this.setVisible(true);
    }
}
