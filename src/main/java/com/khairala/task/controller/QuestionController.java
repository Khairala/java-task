package com.khairala.task.controller;

import com.khairala.task.models.Question;
import com.khairala.task.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/api/questions")
public class QuestionController {

	private final QuestionService questionService;
	@Autowired
	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}
	@GetMapping(value="/getAll")
	public List<Question> showAll () {
		return questionService.listquestion();
	}

	@GetMapping(value="/getById/{id}")
	public Question getQuestion (@PathVariable int id) {
		return questionService.getquestionById(id);
	}

	@PostMapping(value = "/add")
	public String addNew(@RequestBody Question question){
		if(questionService.addquestion(question)){
			return "New Question Added Successfully \n  "+ question.toString();
		}
		return "Something wrong happened Please Contact Support";

	}

	@PutMapping(value = "/update")
	public String updateQuestion(@RequestBody Question question){
		if(questionService.updatequestion(question)){
			return "Updated Successfully \n  "+ question.toString();
		}
		return "Something wrong happened Please Contact Support";

	}

	@DeleteMapping(value = "/deleteById/{id}")
	public String deleteQuestion(@PathVariable int id) {
		if(questionService.removequestion(id)){
			return "Removed Question with id -->  "+ id;
		}
		return "Something wrong happened Please Contact Support";

	}



}
