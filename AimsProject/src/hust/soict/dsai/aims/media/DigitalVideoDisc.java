package AimsProject.src.hust.soict.dsai.aims.media;

import AimsProject.src.hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

  // Constructor
  public DigitalVideoDisc(String title) {
    super(title);
  }

  public DigitalVideoDisc(String title, String category, float cost) {
    super(title, category, cost);
  }

  public DigitalVideoDisc(String title, String category, String director, float cost) {
    super(title, category, director, cost);
  }

  public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
    super(title, category, director, length, cost);
  }

  @Override
  public String toString() {
    return this.getId() + " - DVD: " + this.getTitle() +
        " - Category: " + this.getCategory() +
        " - Director: " + this.getDirector() +
        " - DVD length: " + this.getLength() +
        " - Cost: " + this.getCost() + "$";
  }

  // Play method
  @Override
  public void play() {
    System.out.println("Playing DVD: " + this.getTitle());
    System.out.println("DVD length: " + this.getLength());
    if (this.getLength() <= 0) {
      System.err.println("ERROR: DVD length is non-positive!");
    }
  }

  public String playGUI() throws PlayerException {
    if (this.getLength() > 0) {
      StringBuilder output = new StringBuilder();
      output.append("Playing DVD: ").append(this.getTitle()).append("\n")
          .append("DVD length: ").append(formatDuration(this.getLength()));
      return output.toString();
    } else {
      throw new PlayerException("ERROR: DVD length is non-positive!");
    }
  }

  // Format duration for display
  public String formatDuration(int length) {
    int hours = length / 3600;
    int minutes = (length % 3600) / 60;
    int seconds = length % 60;
    return String.format("%02d:%02d:%02d", hours, minutes, seconds);
  }
}