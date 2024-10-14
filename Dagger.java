public class Dagger extends Card {
    public Dagger() {
        super();
        double heightPercentage = 0.3704;
        setImage("/images/dagger.png", heightPercentage, 0.6);
    }

    @Override
    protected void popCard() {
        int taskbarHeightOffset = 50;  // Adjustable -- should not be covered by taskbar

        // Set card location to the bottom-center but above taskbar
        int x = (screenWidth - this.getWidth()) / 2;  // Center horizontally
        int y = screenHeight - this.getHeight() - taskbarHeightOffset;

        this.setLocation(x, y);
        this.setVisible(true); 
    }
}
