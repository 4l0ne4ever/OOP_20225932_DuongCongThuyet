package AimsProject.src.hust.soict.dsai.aims.media;

public class Disc extends Media {
    private String director;
    private int length;

    // Constructors
    public Disc(String title) {
        super(title);
    }

    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Disc(String title, String category, String director, float cost) {
        super(title, category, cost);
        this.director = director;
    }

    public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }

    // Getters and Setters
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        if (director != null && !director.isEmpty()) {
            this.director = director;
        } else {
            throw new IllegalArgumentException("Director cannot be null or empty");
        }
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (length > 0) {
            this.length = length;
        } else {
            throw new IllegalArgumentException("Length must be positive");
        }
    }

    @Override
    public int compareTo(Media other) {
        if (other instanceof Disc) {
            Disc otherDisc = (Disc) other;
            int titleComparison = this.getTitle().compareTo(otherDisc.getTitle());
            if (titleComparison != 0) {
                // Compare by title
                return titleComparison;
            } else {
                // Compare by decreasing length
                int lengthComparison = Integer.compare(otherDisc.getLength(), this.getLength());
                if (lengthComparison != 0) {
                    return lengthComparison;
                } else {
                    // Compare by cost
                    return Double.compare(this.getCost(), otherDisc.getCost());
                }
            }
        } else {
            // If the media object is not a Disc, use the default method of the Media class
            return super.compareTo(other);
        }
    }

    @Override
    public String toString() {
        return String.format("Disc [title=%s, category=%s, director=%s, length=%d, cost=%.2f]",
                getTitle(), getCategory(), director, length, getCost());
    }
}