package AimsProject.src.hust.soict.cybersec.test.store;

import AimsProject.src.hust.soict.cybersec.aims.disc.DigitalVideoDisc;
import AimsProject.src.hust.soict.cybersec.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addDvd(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Sci-fic", "Geogre Lucas", 87, 22.42f);
        store.addDvd(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Alien", "Sci-fic", 14.2f);
        store.addDvd(dvd3);
        store.print();
        store.removeDVD(dvd3);
        store.print();
    }
}
