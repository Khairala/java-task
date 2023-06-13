package com.khairala.task.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Announcment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "text")
    private String announmenText;

    @Column(name = "date")
    private Date announmentDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnnounmenText() {
        return announmenText;
    }

    public void setAnnounmenText(String announmenText) {
        this.announmenText = announmenText;
    }

    public Date getAnnounmentDate() {
        return announmentDate;
    }

    public void setAnnounmentDate(Date announmentDate) {
        this.announmentDate = announmentDate;
    }

    @Override
    public String toString() {
        return "Announcment{" +
                "id=" + id +
                ", announmenText='" + announmenText + '\'' +
                ", announmentDate=" + announmentDate +
                '}';
    }
}
