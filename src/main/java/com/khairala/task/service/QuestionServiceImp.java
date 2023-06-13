package com.khairala.task.service;

import com.khairala.task.dao.QuestionDao;
import com.khairala.task.models.Question;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@Service
@EnableTransactionManagement
public class QuestionServiceImp implements QuestionService{
    private final QuestionDao questionDao;

    public QuestionServiceImp(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public Boolean addquestion(Question question) {
        return questionDao.addquestion(question);
    }

    @Override
    public Boolean updatequestion(Question question) {
        return questionDao.updatequestion(question);
    }

    @Override
    public List<Question> listquestion() {
        return questionDao.listquestion();
    }

    @Override
    public Question getquestionById(int id) {
        return questionDao.getquestionById(id);
    }

    @Override
    public Boolean removequestion(int id) {
        return questionDao.removequestion(id);
    }
}
