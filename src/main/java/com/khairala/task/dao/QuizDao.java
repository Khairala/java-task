package com.khairala.task.dao;

import com.khairala.task.models.Question;
import com.khairala.task.models.Quiz;

import java.util.List;

public interface QuizDao {
    public Boolean addquiz(Quiz quiz);
    public Boolean updatequiz(Quiz quiz);
    public List<Quiz> listquiz();
    public Quiz getquizById(int id);
    public Boolean removequiz(int id);
    public List<Question> getAllQuestions(int id);

}
