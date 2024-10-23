import java.awt.Color;
import java.awt.event.*;

public class Enemy extends CardWithFocusListener {
    
    public Enemy() {
        super();

        
        this.getContentPane().setBackground( color.BLACK );
        color = new Color(255,0,0);
        setBorder();
        heightPercentage = 0.2222;
        widthHeightRatio = 1.25;


        setImage("/images/enemyRED.png");
        
    }
    public void slay(){
        isActivated = false;
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    
    @Override
    public void mouseDragged(MouseEvent e) {
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    protected void popCard() {
        this.setVisible(true);
    }
}
