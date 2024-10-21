public class House extends EnvironmentCard{
    public House() {
        super();
        heightPercentage = 0.5;
        widthHeightRatio = 1.1852;
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