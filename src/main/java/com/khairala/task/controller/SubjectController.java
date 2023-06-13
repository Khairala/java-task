package com.khairala.task.controller;

import com.khairala.task.models.Quiz;
import com.khairala.task.models.Subject;
import com.khairala.task.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/api/subjects")
public class SubjectController {

	private final SubjectService subjectService;
	@Autowired
	public SubjectController(SubjectService subjectService) {
		this.subjectService = subjectService;
	}
	@GetMapping(value="/getAllSubjects")
	public List<Subject> showAll () {
		return subjectService.listsubject();
	}

	@GetMapping(value="/getById/{id}")
	public Subject getAnnouncment (@PathVariable int id) {
		return subjectService.getsubjectById(id);
	}

	@PostMapping(value = "/add")
	public String addNew(@RequestBody Subject subject){
		if(subjectService.addsubject(subject)){
			return "New Subject Added Successfully \n  "+ subject.toString();
		}
		return "Something wrong happened Please Contact Support";

	}

	@PutMapping(value = "/update")
	public String updateSubject(@RequestBody Subject subject){
		if(subjectService.updatesubject(subject)){
			return "Updated Successfully \n  "+ subject.toString();
		}
		return "Something wrong happened Please Contact Support";

	}

	@DeleteMapping(value = "/deleteById/{id}")
	public String deleteSubject(@PathVariable int id) {
		if(subjectService.removesubject(id)){
			return "Removed Announce with id -->  "+ id;
		}
		return "Something wrong happened Please Contact Support";

	}

	@GetMapping(value="/getAllQuizzez/{Subjectid}")
	public List<Quiz> getAllQuizzez (@PathVariable int Subjectid) {
		return subjectService.getAllQuizzez(Subjectid);
	}


}
