package com.khairala.task.dao;

import com.khairala.task.models.Question;
import com.khairala.task.models.Quiz;
import com.khairala.task.models.Subject;

import java.util.List;

public interface QuestionDao {
    public Boolean addquestion(Question question);
    public Boolean updatequestion(Question question);
    public List<Question> listquestion();
    public Question getquestionById(int id);
    public Boolean removequestion(int id);
}
