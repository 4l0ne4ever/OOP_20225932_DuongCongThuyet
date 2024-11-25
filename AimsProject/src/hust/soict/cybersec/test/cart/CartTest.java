package AimsProject.src.hust.soict.cybersec.test.cart;

import AimsProject.src.hust.soict.cybersec.aims.cart.Cart;
import AimsProject.src.hust.soict.cybersec.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {

        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Sci-fic", "Geogre Lucas", 87, 22.42f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Alien", "Sci-fic", 14.2f);
        cart.addDigitalVideoDisc(dvd3);

        cart.print();
        cart.searchById(2);
        cart.searchByTitle("Lion King");
        cart.searchByCategory("Sci-fic");
        cart.searchByPrice(2000);
        cart.searchByAmongPrice(1900, 2000);
    }
}
