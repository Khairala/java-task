package com.khairala.task.service;

import com.khairala.task.dao.AnnouncmentDao;
import com.khairala.task.models.Announcment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@Service
@EnableTransactionManagement
public class AnnouncmentServiceImp implements AnnouncmentService {
    private final AnnouncmentDao announcementDAO;
    @Autowired
    public AnnouncmentServiceImp(AnnouncmentDao announcementDAO) {
        this.announcementDAO = announcementDAO;
    }

    @Override
    public Boolean addAnnouncement(Announcment announcment) {
        return announcementDAO.addAnnouncement(announcment);
    }

    @Override
    public Boolean updateAnnouncement(Announcment announcment) {
        return announcementDAO.updateAnnouncement(announcment);
    }

    @Override
    public List<Announcment> listAnnouncement() {
        return announcementDAO.listAnnouncement();
    }

    @Override
    public Announcment getAnnouncementById(int id) {
        return announcementDAO.getAnnouncementById(id);
    }

    @Override
    public Boolean removeAnnouncement(int id) {
        return announcementDAO.removeAnnouncement(id);
    }
}
