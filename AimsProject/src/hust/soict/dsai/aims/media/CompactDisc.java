package AimsProject.src.hust.soict.dsai.aims.media;

import java.util.*;

import AimsProject.src.hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Media implements Playable {

    private String artist;
    private List<Track> tracks = new ArrayList<Track>();;

    // Getter method
    public String getArtist() {
        return artist;
    }

    // Constructor
    public CompactDisc(String title) {
        super(title);
    }

    public CompactDisc(String title, String category, String artist, float cost) {
        super(title, category, cost);
        this.artist = artist;
    }

    // Add and remove track
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track: " + track.getTitle() + " has been added to CD: " + this.getTitle());
        } else {
            System.out.println("Track already exists in CD.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track: " + track.getTitle() + " has been removed from CD: " + this.getTitle());
        } else {
            System.out.println("Track does not exist in CD.");
        }
    }

    // Get length of the track
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    // Play method
    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public String toString() {
        return this.getId() + " - CD: " + this.getTitle() +
                " - Category: " + this.getCategory() +
                " - Artist: " + this.getArtist() +
                " - Length: " + this.getLength() + " seconds" +
                " - Cost: " + this.getCost() + "$";
    }

    public String playGUI() throws PlayerException {
        if (this.getLength() > 0) {
            StringBuilder output = new StringBuilder();
            output.append("Playing CD: ").append(this.getTitle()).append("\n")
                    .append("CD length: ").append(formatDuration(this.getLength())).append("\n\n");
            for (Track track : tracks) {
                try {
                    output.append(track.playGUI()).append("\n");
                } catch (PlayerException e) {
                    System.err.println("Error playing track: " + track.getTitle());
                    throw e;
                }
            }
            return output.toString();
        } else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }
}