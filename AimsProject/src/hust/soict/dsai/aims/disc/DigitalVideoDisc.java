package AimsProject.src.hust.soict.dsai.aims.disc;

import java.util.Date;

public class DigitalVideoDisc {
  private String title;
  private String category;
  private String director;
  private int length;
  private float cost;
  private static int nbDigitalVideoDiscs = 0;
  private int id;
  private Date date;

  public String getTitle() {
    return title;
  }

  public String getCategory() {
    return category;
  }

  public String getDirector() {
    return director;
  }

  public int getLength() {
    return length;
  }

  public float getCost() {
    return cost;
  }

  public int getId() {
    return id;
  }

  public static int nbDigitalVideoDiscs() {
    return nbDigitalVideoDiscs;
  }

  public DigitalVideoDisc(String title, String category, float cost) {
    this.title = title;
    this.category = category;
    this.cost = cost;
    this.id = ++nbDigitalVideoDiscs;
  }

  public DigitalVideoDisc(String title) {
    this.title = title;
    this.id = ++nbDigitalVideoDiscs;
  }

  public DigitalVideoDisc(String title, String category, String director, float cost) {
    this.title = title;
    this.category = category;
    this.director = director;
    this.cost = cost;
    this.id = ++nbDigitalVideoDiscs;
  }

  public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
    this.title = title;
    this.category = category;
    this.director = director;
    this.length = length;
    this.cost = cost;
    this.id = ++nbDigitalVideoDiscs;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public void setCost(float cost) {
    this.cost = cost;
  }

  @Override
  public String toString() {
    return this.id + ". DVD: " + this.title +
        " - Category: " + this.category +
        " - Director: " + this.title +
        " - DVD length: " + this.length +
        " - Cost: " + this.cost + "$";
  }
}
