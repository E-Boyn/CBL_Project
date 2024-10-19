import java.awt.*;
import java.awt.event.*;
public class Cave extends EnviromentCard{

    public Cave() {
        super();
        heightPercentage = 0.5;
        widthHeightRatio = 1.1852;
        imagePaths = new String[] {
                                    "/images/cave1.png",
                                    "/images/cave2.png"
                                  };
        


        setRandomImage(); //tentative percentage (NOT YET CALCULATED) 
    }

    @Override
    protected void popCard() {
        this.setVisible(true);
    }
}