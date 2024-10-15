public class House extends Card{
    public House() {
        super();
        heightPercentage = 0.5;
        heightRatio = 1.1852;
        imagePaths = new String[] {
            "/images/house1.png",
            "/images/house2.png"
        };

        setRandomImage();
    }

    @Override
    protected void popCard() {
        this.setVisible(true);
    }
}