package org.example.advanced.musictrack;

import java.util.*;

public class MusicLibrary {

    private HashMap<String, HashSet<MusicTrack>> musicLibrary;

    // Constructor MusicLibrary
    public MusicLibrary() {
        musicLibrary = new HashMap<>();
    }

    // Add MusicTrack method
    public void addTrack(MusicTrack track) {
        String genre = track.getGenre();
        musicLibrary.putIfAbsent(genre, new HashSet<MusicTrack>());
        musicLibrary.get(genre).add(track);
        System.out.println("Track is added: " + track );
    }

    public void removeTrack(MusicTrack track) {
        String genre = track.getGenre();
        if (musicLibrary.containsKey(genre)) {
            HashSet<MusicTrack> tracks = musicLibrary.get(genre);
            if (tracks.remove(track)) {
                System.out.println("Removed track: " + track);
            } else {
                System.out.println("Track " + track + "not found");
            }
        } else {
            System.out.println("Genre" + genre + "not found");
        }

    }

    public void getLibSortedByGenre() {
        // Get the genres and sort
        ArrayList<String> sortedGenres = new ArrayList<>(musicLibrary.keySet());
        Collections.sort(sortedGenres);

        System.out.println("Music library sorted by genre");
        for (String genre : sortedGenres) {
            System.out.println("Genre: " + genre);
            for (MusicTrack track : musicLibrary.get(genre)) {
                System.out.println(" " + track);
            }
        }
    }

    public static void main(String[] args) {

        MusicLibrary lib1 = new MusicLibrary();

        // Crate MusicTRack objects
        MusicTrack track1 = new MusicTrack("Hip hop", "Tang", "C.R.E.A.M");
        MusicTrack track2 = new MusicTrack("Folk", "Bob Dylan", "Blowin in the Wind");
        MusicTrack track3 = new MusicTrack("Jazz", "Armstrong", "West and Blues");
        MusicTrack track4 = new MusicTrack("Folk", "Gordon L", "Early Morning Rain");
        MusicTrack track5 = new MusicTrack("Jazz", "Dave B", "Take Five");

        // Add tracks to the library
        lib1.addTrack(track1);
        lib1.addTrack(track2);
        lib1.addTrack(track3);
        lib1.addTrack(track4);
        lib1.addTrack(track5);

        lib1.getLibSortedByGenre();

        lib1.removeTrack(track1);
        lib1.getLibSortedByGenre();

    }

}
