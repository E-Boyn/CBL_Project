
import java.awt.Color;

/**
 * main
 */
public class main{
public static void main(String[] args) {
    Card card = new Card();
    Card card2 = new Card();
    Card card3 = new Card();
    card2.setSize(700, 800);
    card.getContentPane().setBackground(Color.black);
    card3.getContentPane().setBackground(Color.red);
    card3.setSize(1000, 200);
}
}