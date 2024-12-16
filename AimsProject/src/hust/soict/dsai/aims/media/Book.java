package AimsProject.src.hust.soict.dsai.aims.media;

import java.util.*;

public class Book extends Media {

    private List<String> authors = new ArrayList<>();

    // Constructor
    public Book(String title) {
        super(title);
    }

    public Book(String title, String category) {
        super(title, category);
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    // Add and remove author
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author " + authorName + " has been added.");
        } else {
            System.out.println("Author " + authorName + " already exists.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author " + authorName + " has been removed.");
        } else {
            System.out.println("Author " + authorName + " does not exist.");
        }
    }

    // Get authors
    public List<String> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        return this.getId() + " - Book: " + this.getTitle() +
                " - Category: " + this.getCategory() +
                " - Cost: " + this.getCost() + "$" +
                " - Authors: " + String.join(", ", authors);
    }
}