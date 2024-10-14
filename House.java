public class House extends Card{
    public House() {
        super();
        double heightPercentage = 0.5;
        imagePaths = new String[] {
            "/images/house1.png",
            "/images/house2.png"
        };

        setRandomImage(heightPercentage, 1.1852);
    }

    @Override
    protected void popCard() {
        this.setVisible(true);
    }
}