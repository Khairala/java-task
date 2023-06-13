package com.khairala.task.dao;

import com.khairala.task.models.Announcment;
import com.khairala.task.models.Quiz;
import com.khairala.task.models.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
@EnableTransactionManagement
public class SubjectDaoImpl implements SubjectDao{

    private final SessionFactory sessionFactory;
    @Autowired
    public SubjectDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    public void addDataInitially() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.createSQLQuery("INSERT INTO subject (id, name) VALUES (1, 'MATH')").executeUpdate();
            session.createSQLQuery("INSERT INTO subject (id, name) VALUES (2, 'ENGLISH')").executeUpdate();
            session.createSQLQuery("INSERT INTO subject (id, name) VALUES (3, 'PHYSICS')").executeUpdate();
            session.createSQLQuery("INSERT INTO subject (id, name) VALUES (4, 'GEOGRAPHY')").executeUpdate();
            session.createSQLQuery("INSERT INTO subject (id, name) VALUES (5, 'SCIENCE')").executeUpdate();
            session.createSQLQuery("INSERT INTO subject (id, name) VALUES (6, 'COMPUTER')").executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }


    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Boolean addsubject(Subject subject) {
        try {
            getCurrentSession().save(subject);
            return true; // Object was successfully added to the database
        } catch (Exception e) {
            // Handle the exception or log the error
            return false; // Failed to add the object to the database
        }    }

    @Override
    public Boolean updatesubject(Subject subject) {
        try {
            getCurrentSession().update(subject);
            return true; // Object was successfully added to the database
        } catch (Exception e) {
            // Handle the exception or log the error
            return false; // Failed to add the object to the database
        }    }

    @Override
    public List<Subject> listsubject() {
        return getCurrentSession().createQuery("FROM Subject").getResultList();
    }

    @Override
    public Subject getsubjectById(int id) {
        if(id <= 0){
            throw new RuntimeException("This id is not valid --> " + id);
        }
        return getCurrentSession().get(Subject.class, id);    }

    @Override
    public Boolean removesubject(int id) {
        try {
            Subject subject = getsubjectById(id);
            if (subject != null) {
                getCurrentSession().delete(subject);
            }
            return true; // Object was successfully added to the database
        } catch (Exception e) {
            // Handle the exception or log the error
            return false; // Failed to add the object to the database
        }    }

    @Override
    public List<Quiz> getAllQuizzez(int id) {

        String hql = "SELECT q FROM Quiz q WHERE q.subject.id = :subjectId";
        Query<Quiz> query = getCurrentSession().createQuery(hql, Quiz.class);
        query.setParameter("subjectId", id);
        List<Quiz> quizzes = query.getResultList();
        return quizzes;

    }
}
