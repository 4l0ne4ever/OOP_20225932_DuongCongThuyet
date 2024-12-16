package AimsProject.src.hust.soict.dsai.test.cart;

import javax.naming.LimitExceededException;
import AimsProject.src.hust.soict.dsai.aims.cart.Cart;
import AimsProject.src.hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {

        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Lion King", "Animation", "Roger Allers", 87, 19.95f);
        try {
            cart.addMedia(dvd1);

            DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Sci-fic", "Geogre Lucas", 87, 22.42f);
            cart.addMedia(dvd2);

            DigitalVideoDisc dvd3 = new DigitalVideoDisc("Alien", "Sci-fic", 14.2f);
            cart.addMedia(dvd3);
        } catch (LimitExceededException e) {
            System.err.println(e.getMessage());
        }

        cart.print();
        cart.searchByID(2);
        cart.searchByTitle("Lion King");
        cart.searchByCategory("Sci-fic");
        cart.searchByPrice(2000);
        cart.searchByPrice(1900, 2000);
    }
}
