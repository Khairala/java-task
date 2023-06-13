package com.khairala.task.service;

import com.khairala.task.models.Question;
import com.khairala.task.models.Quiz;

import java.util.List;

public interface QuestionService {
    public Boolean addquestion(Question question);
    public Boolean updatequestion(Question question);
    public List<Question> listquestion();
    public Question getquestionById(int id);
    public Boolean removequestion(int id);
}
