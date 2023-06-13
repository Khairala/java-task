package com.khairala.task.service;

import com.khairala.task.models.Quiz;
import com.khairala.task.models.Subject;

import java.util.List;

public interface SubjectService {
    public Boolean addsubject(Subject subject);
    public Boolean updatesubject(Subject subject);
    public List<Subject> listsubject();
    public Subject getsubjectById(int id);
    public Boolean removesubject(int id);
    public List<Quiz> getAllQuizzez(int id);

}
