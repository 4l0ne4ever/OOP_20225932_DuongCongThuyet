package AimsProject.src.hust.soict.dsai.test.media;

import java.util.*;

import AimsProject.src.hust.soict.dsai.aims.media.*;

public class MediaCompareTest {

    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<>();

        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        Book book = new Book("The Valley of Fear", "Detective", 20.00f);
        Book book1 = new Book("A Living Remedy: A Memoir", "Biography", 202.00f);
        Book book2 = new Book("On the Origin of Time: Stephen Hawking's Final Theory", "Science", 120.00f);
        Book book3 = new Book("Looking Glass Sound", "Horror", 1.00f);

        CompactDisc cd = new CompactDisc("Adele - 30", "Music", "Adele", 1500.98f);
        Track track1 = new Track("All Night Parking (interlude)", 161);
        Track track2 = new Track("To Be Loved", 403);
        Track track3 = new Track("Woman Like Me", 300);

        cd.addTrack(track1);
        cd.addTrack(track2);
        cd.addTrack(track3);

        mediae.add(cd);
        mediae.add(book);
        mediae.add(book1);
        mediae.add(book2);
        mediae.add(book3);
        mediae.add(dvd);
        mediae.add(dvd2);
        mediae.add(dvd3);

        System.out.println();
        System.out.println("*******SORT USING OVERRIDE compareTo method*******");
        Collections.sort(mediae);
        mediae.forEach(media -> System.out.println(media.toString()));
        System.out.println("**************************************************");

        System.out.println();
        System.out.println("**********SORT BY TITLE USING COMPARATOR**********");
        mediae.sort(Media.COMPARE_BY_TITLE_COST);
        mediae.forEach(media -> System.out.println(media.toString()));
        System.out.println("**************************************************");

        System.out.println();
        System.out.println("**********SORT BY COST USING COMPARATOR************");
        mediae.sort(Media.COMPARE_BY_COST_TITLE);
        mediae.forEach(media -> System.out.println(media.toString()));
        System.out.println("**************************************************");
    }
}
