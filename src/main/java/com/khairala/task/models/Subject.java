package com.khairala.task.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String subjectname;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Quiz> quizez;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public List<Quiz> getQuizez() {
        return quizez;
    }

    public void setQuizez(List<Quiz> quizez) {
        this.quizez = quizez;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", subjectname='" + subjectname + '\'' +
                ", quizez=" + quizez +
                '}';
    }


}
