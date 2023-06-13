package com.khairala.task.dao;


import com.khairala.task.models.Quiz;
import com.khairala.task.models.Subject;

import java.util.List;

public interface SubjectDao {
    public Boolean addsubject(Subject subject);
    public Boolean updatesubject(Subject subject);
    public List<Subject> listsubject();
    public Subject getsubjectById(int id);
    public Boolean removesubject(int id);
    public List<Quiz> getAllQuizzez(int id);

}
