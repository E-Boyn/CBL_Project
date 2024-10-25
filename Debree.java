import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.*;

public class Debree extends Card{
    int type;
    EnvironmentCard originalCard;
    Dimension originalSize = new Dimension();
    Random rand = new Random();

public Debree(EnvironmentCard originalCard){
    super();
    this.originalCard = originalCard;

    originalSize.width = originalCard.getSize().width;
    originalSize.height = originalCard.getSize().height;
    
    color = Color.BLACK;
    System.out.println("Constructiong debree");
    chooseType();
    System.out.println("Type chosen to = "+ type);
    setRandomImage();

    setPosition();
}

@Override
protected void setImage(String imagePath) {
    // Load original image
    // Load original image
    ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagePath));
    Image image = imageIcon.getImage();

    int cardHeight;
    // Calculate height based on screen size and percentage
    if(type ==0 ){
        cardHeight =  rand.nextInt(originalSize.height / 8) + 100;
    } else {
        cardHeight =  rand.nextInt(originalSize.height / 4) + 200;
    }
    int cardWidth = (int) (cardHeight * this.widthHeightRatio);

    // Resize image to fit card
    Image scaledImage = image.getScaledInstance(cardWidth, cardHeight, Image.SCALE_SMOOTH);
    ImageIcon scaledIcon = new ImageIcon(scaledImage);

    // Set scaled image in JLabel
    JLabel diplayImage = new JLabel(scaledIcon);
    this.add(diplayImage);

    this.setSize(cardWidth, cardHeight);
    this.pack(); // Adjust frame to fit image
}

private void chooseType(){ 
    Random random = new Random();
        
    // Generate a random integer: 0 or 1
    type = random.nextInt(2);

    if(type == 0){
         this.heightPercentage = 37.04;
         this.widthHeightRatio = 1.5;

         this.imagePaths = new String[] {
             "/images/debreeHorizontal1.png",
             "/images/debreeHorizontal2.png",
             "/images/debreeHorizontal3.png"
             };

    } else {

        this.heightPercentage = 55.56;
        this.widthHeightRatio = 0.67;

        this.imagePaths = new String[] {
             "/images/debreeVertical1.png",
             "/images/debreeVertical2.png",
             "/images/debreeVertical3.png"
             };
        }
    }

    private void setPosition() {
        
        int xOffset = rand.nextInt(originalSize.width);
        int yOffset = rand.nextInt(originalSize.height);

        Point debrisPosition = new Point(originalCard.getX() + xOffset, originalCard.getY() + yOffset);
        
        this.setLocation(debrisPosition.x, debrisPosition.y);
    }

}
