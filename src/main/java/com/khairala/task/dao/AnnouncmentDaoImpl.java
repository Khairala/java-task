package com.khairala.task.dao;

import com.khairala.task.models.Announcment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@Repository
@EnableTransactionManagement
public class AnnouncmentDaoImpl implements AnnouncmentDao{
    private final SessionFactory sessionFactory;
    @Autowired
    public AnnouncmentDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    public void addDataInitially() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.createSQLQuery("INSERT INTO Announcment (id, text, date) VALUES (1, 'SAMPLE TEXT 1' ,sysdate() )").executeUpdate();
            session.createSQLQuery("INSERT INTO Announcment (id, text, date) VALUES (2, 'SAMPLE TEXT 2' ,sysdate() )").executeUpdate();
            session.createSQLQuery("INSERT INTO Announcment (id, text, date) VALUES (3, 'SAMPLE TEXT 3' ,sysdate() )").executeUpdate();
            session.createSQLQuery("INSERT INTO Announcment (id, text, date) VALUES (4, 'SAMPLE TEXT 4' ,sysdate() )").executeUpdate();
            session.createSQLQuery("INSERT INTO Announcment (id, text, date) VALUES (5, 'SAMPLE TEXT 5' ,sysdate() )").executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }
    @Override
    public Boolean addAnnouncement(Announcment announcment) {
        try {
            if(announcment.getAnnounmentDate() == null){
                announcment.setAnnounmentDate(new Date());
            }
            getCurrentSession().save(announcment);
            return true; // Object was successfully added to the database
        } catch (Exception e) {
            // Handle the exception or log the error
            return false; // Failed to add the object to the database
        }
    }

    @Override
    public Boolean updateAnnouncement(Announcment announcment) {
        try {
            getCurrentSession().update(announcment);
            return true; // Object was successfully added to the database
        } catch (Exception e) {
            // Handle the exception or log the error
            return false; // Failed to add the object to the database
        }
    }

    @Override
    public List<Announcment> listAnnouncement() {
        return getCurrentSession().createQuery("FROM Announcment").getResultList();
    }

    @Override
    public Announcment getAnnouncementById(int id) {
        if(id <= 0){
            throw new RuntimeException("This id is not valid --> " + id);
        }
        return getCurrentSession().get(Announcment.class, id);
    }

    @Override
    public Boolean removeAnnouncement(int id) {
        try {
            Announcment announcment = getAnnouncementById(id);
            if (announcment != null) {
                getCurrentSession().delete(announcment);
            }
            return true; // Object was successfully added to the database
        } catch (Exception e) {
            // Handle the exception or log the error
            return false; // Failed to add the object to the database
        }

    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
