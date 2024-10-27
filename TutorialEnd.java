import java.awt.Color;
import java.awt.*;
public class TutorialEnd extends CardWithFocusListener{

    public TutorialEnd(boolean gameOver){
          super();

          heightPercentage = 0.55;
          widthHeightRatio = 1.25;

          if(gameOver){
            setEnd();
        } else {
            setTutorial();
        }

          int taskbarheight = Toolkit.getDefaultToolkit().getScreenSize().height 
                  - GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
        //Calculate the frame location
          int x = (screenWidth - getWidth()) / 2;
          int y = (screenHeight - getHeight()) / 2 - taskbarheight - 10;

        //Set the new frame location
        setLocation(x, y);   
      

        setBorder();
        setVisible(true);
    }


    private void setTutorial(){
        
        this.getContentPane().setBackground(Color.BLACK);
        color = new Color(100,100,100);

        setImage("/images/tutorial.png");

    }

    private void setEnd(){

        color = new Color(0,0,0);
    
        //TODO CHANGE IMAGE 
        setImage("/images/tutorial.png");
    }
}
