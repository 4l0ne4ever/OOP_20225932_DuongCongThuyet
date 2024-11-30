package AimsProject.src.hust.soict.dsai.aims.cart;

import java.util.*;
import java.util.stream.Collectors;

import AimsProject.src.hust.soict.dsai.aims.media.Media;

public class Cart {
  public static final int MAX_NUMBERS_ORDERED = 20;
  private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

  public int qtyOrdered = 0;

  public void addMedia(Media media) {
    if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
      System.out.println("The cart is almost full!");
    } else if (itemsOrdered.contains(media)) {
      System.out.println(media.getTitle() + " is already in the cart!");
    } else {
      itemsOrdered.add(media);
      System.out.println(media.getTitle() + " has been added!");
      qtyOrdered += 1;
    }
  }

  public void removeMedia(Media media) {
    if (itemsOrdered.size() == 0) {
      System.out.println("Nothing to remove!");
    } else {
      if (itemsOrdered.remove(media)) {
        System.out.println(media.getTitle() + " has been removed from the cart.");
        qtyOrdered -= 1;
      } else {
        System.out.println("Media not found in cart!");
      }
    }
  }

  public Media searchToRemove(String title) {
    for (Media media : itemsOrdered) {
      if (media.getTitle().equals(title)) {
        return media;
      }
    }
    return null;
  }

  public void searchByTitle(String keyword) {
    List<Media> results = itemsOrdered.stream()
        .filter(media -> media.isMatch(keyword))
        .collect(Collectors.toList());

    if (results.isEmpty()) {
      System.out.println("No media were found with \"" + keyword + "\" in the title!");
    } else {
      results.forEach(media -> System.out.println("Found " + media));
    }
  }

  public void searchByCategory(String category) {
    List<Media> results = itemsOrdered.stream()
        .filter(media -> media.getCategory().equalsIgnoreCase(category))
        .collect(Collectors.toList());

    if (results.isEmpty()) {
      System.out.println("No media matching the \"" + category + "\" category were found!");
    } else {
      results.forEach(media -> System.out.println("Found " + media));
    }
  }

  public void searchByPrice(float maxCost) {
    List<Media> results = itemsOrdered.stream()
        .filter(media -> media.getCost() <= maxCost)
        .collect(Collectors.toList());

    if (results.isEmpty()) {
      System.out.println("No media were found that match the maximum cost provided!");
    } else {
      results.forEach(media -> System.out.println("Found " + media));
    }
  }

  public void searchByPrice(float minCost, float maxCost) {
    List<Media> results = itemsOrdered.stream()
        .filter(media -> media.getCost() >= minCost && media.getCost() <= maxCost)
        .collect(Collectors.toList());

    if (results.isEmpty()) {
      System.out.println("No media were found that match the cost range between your specified minimum and maximum!");
    } else {
      results.forEach(media -> System.out.println("Found " + media));
    }
  }

  public void searchByID(int id) {
    List<Media> results = itemsOrdered.stream()
        .filter(media -> media.getId() == id)
        .collect(Collectors.toList());

    if (results.isEmpty()) {
      System.out.println("No media were found that match the ID provided!");
    } else {
      results.forEach(media -> System.out.println("Found " + media));
    }
  }

  public float totalCost() {
    float totalCost = 0;
    for (Media media : itemsOrdered) {
      totalCost += media.getCost();
    }
    return totalCost;
  }

  public void print() {
    System.out.println("***********************CART***********************");
    System.out.println("Ordered Items:");
    for (Media media : itemsOrdered) {
      System.out.println(media);
    }
    System.out.println("Total items: " + qtyOrdered);
    System.out.println("Total cost: " + totalCost());
    System.out.println("***************************************************");
  }

  public void empty() {
    if (getNumberOfItems() == 0) {
      System.out.println("Nothing to remove!");
    } else {
      qtyOrdered = 0;
      itemsOrdered.clear();
      System.out.println("Order created.");
      System.out.println("Now your current cart will be empty!");
      System.out.println();
    }
  }

  public int getNumberOfItems() {
    return itemsOrdered.size();
  }

  public void sortMediaByTitle() {
    itemsOrdered.stream()
        .sorted(Media.COMPARE_BY_TITLE_COST)
        .forEach(media -> System.out.println(media));
  }

  public void sortMediaByCost() {
    itemsOrdered.stream()
        .sorted(Media.COMPARE_BY_COST_TITLE)
        .forEach(media -> System.out.println(media));
  }
}