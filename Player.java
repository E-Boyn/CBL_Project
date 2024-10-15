public class Player extends Card {
    public Player() {
        super();
        heightPercentage = 0.1111;
        widthHeightRatio = 1.0;

        setImage("/images/player.png");
    }

    @Override
    protected void popCard() {
        int taskbarHeightOffset = 50;  // Adjustable -- should not be covered by taskbar

        // Set card location to the bottom-left corner, but above the taskbar
        int x = 0;  // Bottom-left means x = 0
        int y = screenHeight - this.getHeight() - taskbarHeightOffset;

        this.setLocation(x, y);
        this.setVisible(true);
    }
}
