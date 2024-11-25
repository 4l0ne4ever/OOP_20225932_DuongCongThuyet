package AimsProject.src;

import java.util.Arrays;

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
}