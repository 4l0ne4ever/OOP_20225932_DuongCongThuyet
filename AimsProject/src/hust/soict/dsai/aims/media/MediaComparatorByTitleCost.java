package AimsProject.src.hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media d1, Media d2) {
        int titleComparison = d1.getTitle().compareTo(d2.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        }
        return Double.compare(d2.getCost(), d1.getCost());
    }

}
