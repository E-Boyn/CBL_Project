import java.awt.Color;

public class Player extends CardWithFocusListener {
    public Player() {
        super();
        heightPercentage = 0.1111;
        widthHeightRatio = 1.0;
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        color = new Color(78, 36, 247);
        setBorder();
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
