import java.awt.Color;
import java.awt.*;
public class TutorialEnd extends CardWithFocusListener{

    public TutorialEnd(boolean gameOver){
          super();

          heightPercentage = 0.5556;
          widthHeightRatio = 1.5;

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
        setImage("/images/endOfGame2.png");
        
        System.out.println("sucsesfull");
    }
}
