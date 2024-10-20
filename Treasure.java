import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
public class Treasure extends Card{

    public Treasure() {
        super();
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

        Timer timer = new Timer(2000, event -> {

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

        });
        
        timer.start();
    }
}
