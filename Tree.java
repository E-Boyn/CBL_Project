public class Tree extends Card {
    public Tree() {
        super();
        double heightPercentage = 0.6481;
        heightRatio = 0.5143;

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
