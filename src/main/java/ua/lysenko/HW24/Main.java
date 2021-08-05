package ua.lysenko.HW24;

import ua.lysenko.HW24.dao.*;
import ua.lysenko.HW24.entity.*;

public class Main {
    AlbumDao albumDao = new AlbumDao();
    ArtistDao artistDao = new ArtistDao();
    CustomerDao customerDao = new CustomerDao();
    OrderDao orderDao = new OrderDao();
    TrackDao trackDao = new TrackDao();

    public static void main(String[] args) {


        Main main = new Main();

        Album album = new Album("Fear of the dark");
        Artist artist = new Artist("Iron Maiden");
        Customer customer = new Customer("Donald Trump");
        Order order = new Order(123);
        Track track = new Track("The trooper");

        artist.getAlbums().add(album);
        album.getTracks().add(track);
        customer.getOrders().add(order);
        order.getAlbums().add(album);

        album.setArtist(artist);
        track.setAlbum(album);
        order.setCustomer(customer);
        album.getOrders().add(order);

//        main.trackDao.saveTrack(track);
//        main.artistDao.saveArtist(artist);
//        main.albumDao.saveAlbum(album);
//        main.customerDao.saveCustomer(customer);
//        main.orderDao.saveOrder(order);


        Service.run();
    }

    public void bulkInsertTrack() {
        trackDao.bulkInsert(1_000_000);
    }
}