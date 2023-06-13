package com.khairala.task.service;


import com.khairala.task.models.Announcment;

import java.util.List;

public interface AnnouncmentService {
    public Boolean addAnnouncement(Announcment announcment);
    public Boolean updateAnnouncement(Announcment announcment);
    public List<Announcment> listAnnouncement();
    public Announcment getAnnouncementById(int id);
    public Boolean removeAnnouncement(int id);

}
