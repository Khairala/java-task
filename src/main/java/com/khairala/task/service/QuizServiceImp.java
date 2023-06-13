package com.khairala.task.service;

import com.khairala.task.dao.QuizDao;
import com.khairala.task.models.Question;
import com.khairala.task.models.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;
@Service
@EnableTransactionManagement
public class QuizServiceImp implements QuizService{

    private final QuizDao quizDao;
    @Autowired
    public QuizServiceImp(QuizDao quizDao) {
        this.quizDao = quizDao;
    }

    @Override
    public Boolean addquiz(Quiz quiz) {
        return quizDao.addquiz(quiz);
    }

    @Override
    public Boolean updatequiz(Quiz quiz) {
        return quizDao.updatequiz(quiz);
    }

    @Override
    public List<Quiz> listquiz() {
        return quizDao.listquiz();
    }

    @Override
    public Quiz getquizById(int id) {
        return quizDao.getquizById(id);
    }

    @Override
    public Boolean removequiz(int id) {
        return quizDao.removequiz(id);
    }

    @Override
    public List<Question> getAllQuestions(int id) {
        return quizDao.getAllQuestions(id);
    }
}
