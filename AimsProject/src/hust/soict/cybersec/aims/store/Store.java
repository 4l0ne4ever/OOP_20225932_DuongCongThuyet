package AimsProject.src.hust.soict.cybersec.aims.store;

import java.util.ArrayList;
import java.util.List;

import AimsProject.src.hust.soict.cybersec.aims.disc.DigitalVideoDisc;

public class Store {
    private List<DigitalVideoDisc> itemsInStore;

    public Store() {
        itemsInStore = new ArrayList<>();
    }

    public void addDvd(DigitalVideoDisc dvd) {
        itemsInStore.add(dvd);

    }

    public void removeDVD(DigitalVideoDisc dvd) {
        boolean isRemoved = itemsInStore.remove(dvd);
        if (isRemoved) {
            System.out.println(dvd.getTitle() + " has been removed from the store.");
        } else {
            System.out.println(dvd.getTitle() + " is not found in the store.");
        }
    }

    public void print() {
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println(i + 1 + ". " + itemsInStore.get(i));
        }
    }

    public int getTotalItems() {
        return itemsInStore.size();
    }

    public DigitalVideoDisc findDVDByTitle(String title) {
        for (DigitalVideoDisc dvd : itemsInStore) {
            if (dvd.getTitle().equalsIgnoreCase(title)) {
                return dvd;
            }
        }
        return null;
    }

    public List<DigitalVideoDisc> getItemsInStore() {
        return new ArrayList<>(itemsInStore);
    }
}