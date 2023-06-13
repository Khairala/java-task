package com.khairala.task.dao;

import com.khairala.task.models.Announcment;
import com.khairala.task.models.Question;
import com.khairala.task.models.Quiz;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
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
public class QuizDaoImpl implements QuizDao{
    private final SessionFactory sessionFactory;

    public QuizDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    public void addDataInitially() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.createSQLQuery("INSERT INTO quiz (id, title,date,subject_id) VALUES (1, 'MATH Quiz',sysdate(),1)").executeUpdate();
            session.createSQLQuery("INSERT INTO quiz (id, title,date,subject_id) VALUES (7, 'MATH Quiz V2',sysdate(),1)").executeUpdate();
            session.createSQLQuery("INSERT INTO quiz (id, title,date,subject_id) VALUES (2, 'ENGLISH Quiz',sysdate(),2)").executeUpdate();
            session.createSQLQuery("INSERT INTO quiz (id, title,date,subject_id) VALUES (3, 'PHYSICS Quiz',sysdate(),3)").executeUpdate();
            session.createSQLQuery("INSERT INTO quiz (id, title,date,subject_id) VALUES (4, 'GEOGRAPHY Quiz',sysdate(),4)").executeUpdate();
            session.createSQLQuery("INSERT INTO quiz (id, title,date,subject_id) VALUES (5, 'SCIENCE Quiz',sysdate(),5)").executeUpdate();
            session.createSQLQuery("INSERT INTO quiz (id, title,date,subject_id) VALUES (6, 'COMPUTER Quiz',sysdate(),6)").executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Boolean addquiz(Quiz quiz) {
        try {
            getCurrentSession().save(quiz);
            return true; // Object was successfully added to the database
        } catch (Exception e) {
            // Handle the exception or log the error
            return false; // Failed to add the object to the database
        }
    }

    @Override
    public Boolean updatequiz(Quiz quiz) {
        try {
            getCurrentSession().update(quiz);
            return true; // Object was successfully added to the database
        } catch (Exception e) {
            // Handle the exception or log the error
            return false; // Failed to add the object to the database
        }
    }

    @Override
    public List<Quiz> listquiz() {
        return getCurrentSession().createQuery("FROM Quiz").getResultList();
    }

    @Override
    public Quiz getquizById(int id) {
        if(id <= 0){
            throw new RuntimeException("This Quiz id is not valid --> " + id);
        }
        return getCurrentSession().get(Quiz.class, id);
    }

    @Override
    public Boolean removequiz(int id) {
        try {
            Quiz quiz  = getquizById(id);
            if (quiz != null) {
                getCurrentSession().delete(quiz);
            }
            return true; // Object was successfully added to the database
        } catch (Exception e) {
            // Handle the exception or log the error
            return false; // Failed to add the object to the database
        }
    }

    @Override
    public List<Question> getAllQuestions(int id) {
        String hql = "SELECT q FROM Question q WHERE q.quiz.id = :quizId";
        Query<Question> query = getCurrentSession().createQuery(hql, Question.class);
        query.setParameter("quizId", id);
        List<Question> questions = query.getResultList();

        return questions;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}
