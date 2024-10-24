import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class Treasure extends CardWithFocusListener{

    public Treasure() {
        super();

        
        color = new Color(255, 238, 0);
        setBorder();
        heightPercentage = 0.2222;
        widthHeightRatio = 1.25;

        setImage("/images/treasure.png");
    }

    @Override
    protected void popCard() {
        this.setVisible(true);
    }
    
    //Program ends after 2 seconds of the treasure card gaining focus
    @Override
    public void focusGained(FocusEvent e) {
        isActivated = true;

        Timer timer = new Timer(1000, event -> {

            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

            }
            );
        
        timer.start();
    }
}
