package com.khairala.task.dao;

import com.khairala.task.models.Announcment;

import java.util.List;

public interface AnnouncmentDao {
    public Boolean addAnnouncement(Announcment announcment);
    public Boolean updateAnnouncement(Announcment announcment);
    public List<Announcment> listAnnouncement();
    public Announcment getAnnouncementById(int id);
    public Boolean removeAnnouncement(int id);
}
