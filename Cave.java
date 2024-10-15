public class Cave extends Card{
    public Cave() {
        super();
        imagePaths = new String[] {
            "/images/cave1.jpg",
            "/images/cave2.jpg"
        };
        
        setRandomImage(0.20, 0.20); //tentative percentage (NOT YET CALCULATED) 
    }

    @Override
    protected void popCard() {
        this.setVisible(true);
    }
}