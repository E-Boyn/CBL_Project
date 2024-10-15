public class Cave extends Card{

    public Cave() {
        super();
        heightPercentage = 0.5;
        heightRatio = 1.1852;
        imagePaths = new String[] {
                                    "/images/cave1.jpg",
                                    "/images/cave2.jpg"
                                  };
        


        setRandomImage(); //tentative percentage (NOT YET CALCULATED) 
    }

    @Override
    protected void popCard() {
        this.setVisible(true);
    }
}