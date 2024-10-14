import java.util.Random;

public class Tree extends Card{
    
    // Array storing tree images
    private static String[] treeImages = {
        "/images/tree1.png",
        "/images/tree2.png"
    }; 

    // Method to choose random tree image
    private String getRandomTreeImage() {
        Random random = new Random();
        int randomIndex = random.nextInt(treeImages.length);
        return treeImages[randomIndex];
    }

    public Tree() {
        super();
        String randomTreeImage = getRandomTreeImage();
        setImage(randomTreeImage, 0.15, 0.15); //tentative percentage (NOT YET CALCULATED) 
    }

    @Override
    protected void popCard() {
        this.setVisible(true);
    }
}
