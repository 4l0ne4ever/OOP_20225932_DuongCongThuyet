package AimsProject.src.hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.Optional;

import AimsProject.src.hust.soict.dsai.aims.media.Media;

public class Store {

    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        if (itemsInStore.stream().anyMatch(m -> m.equals(media))) {
            System.out.println("The media " + media.getTitle() + " is already in the store!");
        } else {
            itemsInStore.add(media);
            System.out.println("The media " + media.getTitle() + " has been added to the store.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.removeIf(m -> m.equals(media))) {
            System.out.println("The media " + media.getTitle() + " has been removed from the store.");
        } else {
            System.out.println("The media " + media.getTitle() + " is not in the store!");
        }
    }

    public void print() {
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty!");
        } else {
            System.out.println("********************STORE INVENTORY********************");
            itemsInStore.forEach(System.out::println);
            System.out.println("********************************************************");
        }
    }

    public Media search(String title) {
        Optional<Media> media = itemsInStore.stream()
                .filter(m -> m.getTitle().equals(title))
                .findFirst();
        return media.orElse(null);
    }
}