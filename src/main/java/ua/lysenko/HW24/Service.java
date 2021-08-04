package ua.lysenko.HW24;

import ua.lysenko.HW24.dao.*;
import ua.lysenko.HW24.entity.Album;
import ua.lysenko.HW24.entity.Artist;
import ua.lysenko.HW24.entity.Customer;
import ua.lysenko.HW24.entity.Track;

import java.util.Scanner;

public class Service {
    static Scanner scanner = new Scanner(System.in);
    static AlbumDao albumDao = new AlbumDao();
    static ArtistDao artistDao = new ArtistDao();
    static CustomerDao customerDao = new CustomerDao();
    static OrderDao orderDao = new OrderDao();
    static TrackDao trackDao = new TrackDao();

    public static void run() {
        System.out.println("Please choose operation: 1 Save track(album,artist) \n 2 Create customer \n 3 Get track by ID");

        switch (scanner.nextInt()) {
            case 1 -> saveTrack();
            case 2 -> createCustomer();
            case 3 -> {
                System.out.println("Please enter track ID");
                trackDao.getTrack(scanner.nextLong());
            }
        }
    }

    private static void saveTrack() {
        System.out.println("Please enter track name");
        Track track = new Track(scanner.next());
        trackDao.saveTrack(track);

        System.out.println("Please enter album name");
        Album album = new Album(scanner.next());
        albumDao.saveAlbum(album);

        System.out.println("Please enter artist name");
        Artist artist = new Artist(scanner.next());
        artistDao.saveArtist(artist);

        System.out.println("Track saved. Track ID is: " + track.getId());
    }

    private static void createCustomer() {
        System.out.println("Please enter customer name");
        Customer customer = new Customer(scanner.next());
        customerDao.saveCustomer(customer);
    }

}
