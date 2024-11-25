package AimsProject.src.hust.soict.cybersec.aims.cart;

import java.util.Arrays;

import AimsProject.src.hust.soict.cybersec.aims.disc.DigitalVideoDisc;

public class Cart {
  public static final int MAX_NUMBERS_ORDERED = 20;
  private DigitalVideoDisc quantity[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
  private int qtyOrdered = 0;

  public void browseDVD() {
    Arrays.sort(quantity, (a, b) -> {
      if (a == null)
        return 1;
      if (b == null)
        return -1;
      return a.getDate().compareTo(b.getDate());
    });
    for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
      if (quantity[i] != null)
        System.out.println(quantity[i].getDate());
    }
  }

  public void addDigitalVideoDisc(DigitalVideoDisc disc) {
    for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
      if (quantity[i] == null) {
        quantity[i] = disc;
        System.out.println("The disc has been added");
        return;
      }
    }
    System.out.println("The cart is almost full");
  }

  public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
    if (dvdList.length + qtyOrdered > MAX_NUMBERS_ORDERED) {
      System.out.println("The cart is almost full!");
    } else {
      for (DigitalVideoDisc dvd : dvdList) {
        quantity[qtyOrdered] = dvd;
        System.out.println(dvd.getTitle() + " has been added!");
        qtyOrdered++;
      }
    }
  }

  public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
    DigitalVideoDisc[] dvdList = { dvd1, dvd2 };
    addDigitalVideoDisc(dvdList);
  }

  public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
    for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
      if (quantity[i] == disc) {
        quantity[i] = null;
        System.out.println("The disc has been removed");
        break;
      }
    }
  }

  public void playDemo(DigitalVideoDisc dvd) {
    System.out.println("Playing demo of " + dvd.getTitle());
  }

  public float totalCost() {
    float total = 0.0f;
    for (DigitalVideoDisc disc : quantity) {
      total += disc.getCost();
    }
    return total;
  }

  public void searchById(int id) {
    boolean found = false;
    for (DigitalVideoDisc disc : quantity) {
      if (disc != null && disc.getId() == id) {
        System.out.println("Found DVD: " + disc.getTitle() + " - " + disc.getCategory() + " - "
            + disc.getDirector() + " - " + disc.getLength() + ": " + disc.getCost() + " $");
        found = true;
      }
    }
    if (!found) {
      System.out.println("No DVD found with id: " + id);
    }
  }

  public void searchByTitle(String title) {
    boolean found = false;
    for (DigitalVideoDisc disc : quantity) {
      if (disc != null && disc.getTitle() == title) {
        System.out.println("Found DVD: " + disc.getTitle() + " - " + disc.getCategory() + " - "
            + disc.getDirector() + " - " + disc.getLength() + ": " + disc.getCost() + " $");
        found = true;
      }
    }
    if (!found) {
      System.out.println("No DVD found with id: " + title);
    }
  }

  public void searchByCategory(String category) {
    boolean found = false;
    for (DigitalVideoDisc disc : quantity) {
      if (disc != null && disc.getCategory().equalsIgnoreCase(category)) {
        System.out.println("Found DVD: " + disc.getTitle() + " - " + disc.getCategory() + " - "
            + disc.getDirector() + " - " + disc.getLength() + ": " + disc.getCost() + " $");
        found = true;
      }
    }
    if (!found) {
      System.out.println("No DVD found with category: " + category);
    }
  }

  public void searchByPrice(float price) {
    boolean found = false;
    for (DigitalVideoDisc disc : quantity) {
      if (disc != null && disc.getCost() == price) {
        System.out.println("Found DVD: " + disc.getTitle() + " - " + disc.getCategory() + " - "
            + disc.getDirector() + " - " + disc.getLength() + ": " + disc.getCost() + " $");
        found = true;
      }
    }
    if (!found) {
      System.out.println("No DVD found with price: " + price);
    }
  }

  public void searchByAmongPrice(float min, float max) {
    boolean found = false;
    for (DigitalVideoDisc disc : quantity) {
      if (disc != null && (disc.getCost() >= min && disc.getCost() <= max)) {
        System.out.println("Found DVD: " + disc.getTitle() + " - " + disc.getCategory() + " - "
            + disc.getDirector() + " - " + disc.getLength() + ": " + disc.getCost() + " $");
        found = true;
      }
    }
    if (!found) {
      System.out.println("No DVD found among price: " + min + " and " + max);
    }
  }

  public void print() {
    System.out.println("***********************CART**********************");
    System.out.println("Ordered Items:");
    int i = 1;
    for (DigitalVideoDisc disc : quantity) {
      if (disc != null) {
        System.out.println(i + ". DVD - " + disc.getTitle() + " - " + disc.getCategory() + " - "
            + disc.getDirector() + " - " + disc.getLength() + ": " + disc.getCost() + " $");
        i++;
      }
    }
  }
}