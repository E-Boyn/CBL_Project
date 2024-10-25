import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class EnvironmentCard extends CardWithFocusListener{
    @Override
    public void focusLost(FocusEvent e) {
        
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        isActivated = false;
    }
    
    // DOES NOT WORK!!!!!! Debugging statements don't even work goddamn
    // TODO optional
 
    @Override
    public void slay() {
        System.out.println("Slay method called in EnvironmentCard.");  // Debugging statement
    
    

        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        Debris debreObjects = new Debris(this);

        // // Get the original card's position and size
        // Point origin = this.getLocation();
        // Dimension size = this.getSize();
    
        // System.out.println("Card location: " + origin 
        //     + ", Card size: " + size);  // Debugging statement
            
        // // Generate debris fragments
        // int debrisCount = 5; 
        // List<Debris> debrisList = new ArrayList<>();
            
        // for (int i = 0; i < debrisCount; i++) {
        //     Debris debris = new Debris(origin, this);
        //     debrisList.add(debris);
        //     System.out.println("Debris created at: " + debris.getLocation() 
        //         + " with size: " + debris.getSize());  // Debugging statement
        // }
    
        // // Set the debris to visible
        // for (Debris debris : debrisList) {
        //     debris.setVisible(true);
        //     System.out.println("Debris made visible.");  // Debugging statement



            
        // Close the original environment card
        
    }
}