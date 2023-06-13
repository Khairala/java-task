package com.khairala.task.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.khairala.task.models.Announcment;
import com.khairala.task.service.AnnouncmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Transactional
@RequestMapping("/api/announcements")
public class AnnouncmentController {

	private final AnnouncmentService announcmentService;
	@Autowired
	public AnnouncmentController(AnnouncmentService announcmentService) {
		this.announcmentService = announcmentService;
	}
	@GetMapping(value="/getAll")
	public List<Announcment> showAll () {
		return announcmentService.listAnnouncement();
	}

	@GetMapping(value="/getById/{id}")
	public Announcment getAnnouncment (@PathVariable int id) {
		return announcmentService.getAnnouncementById(id);
	}

	@PostMapping(value = "/add")
	public String addNew(@RequestBody Announcment announcment){
		if(announcmentService.addAnnouncement(announcment)){
			return "New Announced Added Successfully \n  "+ announcment.toString();
		}
		return "Something wrong happened Please Contact Support";

	}

	@PutMapping(value = "/update")
	public String updateAnnouncment(@RequestBody Announcment announcment){
		if(announcmentService.updateAnnouncement(announcment)){
			return "Updated Successfully \n  "+ announcment.toString();
		}
		return "Something wrong happened Please Contact Support";

	}

	@DeleteMapping(value = "/deleteById/{id}")
	public String deleteAnnouncment(@PathVariable int id) {
		if(announcmentService.removeAnnouncement(id)){
			return "Removed Announce with id -->  "+ id;
		}
		return "Something wrong happened Please Contact Support";

	}



}
