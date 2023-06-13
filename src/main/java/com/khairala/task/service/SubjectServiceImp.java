package com.khairala.task.service;

import com.khairala.task.dao.AnnouncmentDao;
import com.khairala.task.dao.SubjectDao;
import com.khairala.task.models.Quiz;
import com.khairala.task.models.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImp implements SubjectService{


    private final SubjectDao subjectDao;
    @Autowired
    public SubjectServiceImp(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    @Override
    public Boolean addsubject(Subject subject) {
        return subjectDao.addsubject(subject);
    }

    @Override
    public Boolean updatesubject(Subject subject) {
        return subjectDao.updatesubject(subject);
    }

    @Override
    public List<Subject> listsubject() {
        return subjectDao.listsubject();
    }

    @Override
    public Subject getsubjectById(int id) {
        return subjectDao.getsubjectById(id);
    }

    @Override
    public Boolean removesubject(int id) {
        return subjectDao.removesubject(id);
    }

    @Override
    public List<Quiz> getAllQuizzez(int id) {
        return subjectDao.getAllQuizzez(id);
    }
}
