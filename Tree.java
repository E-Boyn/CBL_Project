public class Tree extends Card {
    public Tree() {
        super();
        heightPercentage = 0.6481;
        widthHeightRatio = 0.5143;

        imagePaths = new String[] {
            "/images/tree1.png",
            "/images/tree2.png"
        };
        setRandomImage();
    }

    @Override
    protected void popCard() {
        this.setVisible(true);
    }
}
