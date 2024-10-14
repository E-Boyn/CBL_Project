public class Cave extends Card{
    public Cave() {
        super();
        imagePaths = new String[] {
            "/images/cave1.png",
            "/images/cave2.png"
        };
        
        setRandomImage(0.10, 0.10); //tentative percentage (NOT YET CALCULATED) 
    }

    @Override
    protected void popCard() {
        this.setVisible(true);
    }
}