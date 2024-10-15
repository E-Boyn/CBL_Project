public class Cave extends Card{
    public Cave() {
        super();
        double heightPercentage = 0.5;
        imagePaths = new String[] {
            "/images/cave1.jpg",
            "/images/cave2.jpg"
        };
        
        setRandomImage(heightPercentage, 1.1852); //tentative percentage (NOT YET CALCULATED) 
    }

    @Override
    protected void popCard() {
        this.setVisible(true);
    }
}