package ua.lysenko.HW24.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.lysenko.HW24.entity.Artist;
import ua.lysenko.HW24.utils.HibernateUtil;

public class ArtistDao {
    public void saveArtist(Artist artist) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(artist);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Artist getArtist(long id) {

        Transaction transaction = null;
        Artist artist = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            artist = session.get(Artist.class, id);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return artist;
    }

    public void updateArtist(Artist artist) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(artist);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteArtist(long id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Artist artist = session.get(Artist.class, id);
            if (artist != null) {
                session.delete(artist);
                System.out.println("Artist is deleted");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
