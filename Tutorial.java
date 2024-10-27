import java.awt.Color;
import java.awt.*;
public class Tutorial extends CardWithFocusListener{
    public Tutorial(boolean gameOver){
    //     super();

    //     this.getContentPane().setBackground(Color.BLACK);
    //     color = new Color(255, 0, 0);
    //     setBorder();
    //     heightPercentage = 55.56;
    //     widthHeightRatio = 1.5;

    //     setImage("/images/tutorial.png");
    
    super();

    if(!gameOver) {
    this.getContentPane().setBackground(Color.BLACK);
    color = new Color(100,100,100);
    setBorder();
    heightPercentage = 0.55;
    widthHeightRatio = 1.25;

    setImage("/images/tutorial.png");
    }//TODO
    
    int taskbarheight = Toolkit.getDefaultToolkit().getScreenSize().height 
            - GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;

  //Calculate the frame location
  int x = (screenWidth - getWidth()) / 2;
  int y = (screenHeight - getHeight()) / 2 - taskbarheight - 10;
 
  //Set the new frame location
  setLocation(x, y);   
  setVisible(true);
    }
    
    @Override
    protected void popCard() {
        this.setVisible(true);
    }
}
