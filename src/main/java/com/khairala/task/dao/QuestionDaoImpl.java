package com.khairala.task.dao;

import com.khairala.task.models.Question;
import com.khairala.task.models.Quiz;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
@EnableTransactionManagement
public class QuestionDaoImpl implements QuestionDao{

    private final SessionFactory sessionFactory;
    @Autowired
    public QuestionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    public void addDataInitially() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.createSQLQuery("INSERT INTO Question (id, title, quiz_id) VALUES (1, 'SAMPLE Question 1' ,1 )").executeUpdate();
            session.createSQLQuery("INSERT INTO Question (id, title, quiz_id) VALUES (2, 'SAMPLE Question 2' ,1 )").executeUpdate();
            session.createSQLQuery("INSERT INTO Question (id, title, quiz_id) VALUES (3, 'SAMPLE Question 1' ,2 )").executeUpdate();
            session.createSQLQuery("INSERT INTO Question (id, title, quiz_id) VALUES (4, 'SAMPLE Question 2' ,2 )").executeUpdate();
            session.createSQLQuery("INSERT INTO Question (id, title, quiz_id) VALUES (5, 'SAMPLE Question 3' ,2 )").executeUpdate();
            session.createSQLQuery("INSERT INTO Question (id, title, quiz_id) VALUES (6, 'SAMPLE Question 1' ,3 )").executeUpdate();
            session.createSQLQuery("INSERT INTO Question (id, title, quiz_id) VALUES (7, 'SAMPLE Question 1' ,4 )").executeUpdate();
            session.createSQLQuery("INSERT INTO Question (id, title, quiz_id) VALUES (8, 'SAMPLE Question 1' ,5 )").executeUpdate();
            session.createSQLQuery("INSERT INTO Question (id, title, quiz_id) VALUES (9, 'SAMPLE Question 1' ,6 )").executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Boolean addquestion(Question question) {
        try {
            getCurrentSession().save(question);
            return true; // Object was successfully added to the database
        } catch (Exception e) {
            // Handle the exception or log the error
            return false; // Failed to add the object to the database
        }    }

    @Override
    public Boolean updatequestion(Question question) {
        try {
            getCurrentSession().update(question);
            return true; // Object was successfully added to the database
        } catch (Exception e) {
            // Handle the exception or log the error
            return false; // Failed to add the object to the database
        }    }

    @Override
    public List<Question> listquestion() {
        return  getCurrentSession().createQuery("FROM Question").getResultList();
    }

    @Override
    public Question getquestionById(int id) {
        if(id <= 0){
            throw new RuntimeException("This Quiz id is not valid --> " + id);
        }
        return getCurrentSession().get(Question.class, id);
    }

    @Override
    public Boolean removequestion(int id) {
        try {
            Question question  = getquestionById(id);
            if (question != null) {
                getCurrentSession().delete(question);
            }
            return true; // Object was successfully added to the database
        } catch (Exception e) {
            // Handle the exception or log the error
            return false; // Failed to add the object to the database
        }      }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}
