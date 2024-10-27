package AimsProject;

public class Aims {
  public static void main(String[] args) {
    Cart anOrder = new Cart();
    DigitalVideoDisc dvd1 = new DigitalVideoDisc("Lion King", "Animation", "Roger Allers", 87, 19.95f);
    anOrder.addDigitalVideoDisc(dvd1);
    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Sci-fic", "Geogre Lucas", 87, 22.42f);
    anOrder.addDigitalVideoDisc(dvd2);
    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Alien", "Sci-fic", 14.2f);
    anOrder.addDigitalVideoDisc(dvd3);

    anOrder.playDemo(dvd1);

    anOrder.browseDVD();

    System.out.print("Total of cost is: ");
    System.out.println(anOrder.totalCost());

    anOrder.removeDigitalVideoDisc(dvd3);
    System.out.print("Now, total of cost is: ");
    System.out.println(anOrder.totalCost());

  }
}
