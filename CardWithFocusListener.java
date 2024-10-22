import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class CardWithFocusListener extends Card implements FocusListener{
    
    @Override
    public void focusLost(FocusEvent e) {
        isActivated = false;
    }

    @Override
    public void focusGained(FocusEvent e) {
       isActivated = true;
    }
    protected CardWithFocusListener(){
        super();
        this.addFocusListener(this);
    }

}
