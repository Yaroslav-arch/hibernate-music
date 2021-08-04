package ua.lysenko.HW24.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.lysenko.HW24.entity.Track;
import ua.lysenko.HW24.utils.HibernateUtil;


public class TrackDao {
    public void saveTrack(Track track) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(track);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Track getTrack(long id) {

        Transaction transaction = null;
        Track track = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            track = session.get(Track.class, id);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return track;
    }

    public void updateTrack(Track track) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(track);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteTrack(long id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Track track = session.get(Track.class, id);
            if (track != null) {
                session.delete(track);
                System.out.println("Track is deleted");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public void bulkInsert(int quantity) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            for (int i = 0; i < quantity; i++) {
                Track t = new Track("Track #" + (i + 1));
                session.save(t);

                if ( i % 20 == 0 ) {
                    session.flush();
                    session.clear();
                }
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
