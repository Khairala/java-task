package com.khairala.task.controller;

import com.khairala.task.models.Question;
import com.khairala.task.models.Quiz;
import com.khairala.task.models.Subject;
import com.khairala.task.service.QuizService;
import com.khairala.task.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/api/quizzes")
public class QuizController {

	private final QuizService quizService;
	@Autowired
	public QuizController(QuizService quizService) {
		this.quizService = quizService;
	}
	@GetMapping(value="/getAllQuizez")
	public List<Quiz> showAll () {
		return quizService.listquiz();
	}

	@GetMapping(value="/getById/{id}")
	public Quiz getQuiz (@PathVariable int id) {
		return quizService.getquizById(id);
	}

	@PostMapping(value = "/add")
	public String addNew(@RequestBody Quiz quiz){
		if(quizService.addquiz(quiz)){
			return "New Quiz Added Successfully \n  "+ quiz.toString();
		}
		return "Something wrong happened Please Contact Support";

	}

	@PutMapping(value = "/update")
	public String updateQuiz(@RequestBody Quiz quiz){
		if(quizService.updatequiz(quiz)){
			return "Updated Successfully \n  "+ quiz.toString();
		}
		return "Something wrong happened Please Contact Support";

	}

	@DeleteMapping(value = "/deleteById/{id}")
	public String deleteQuiz(@PathVariable int id) {
		if(quizService.removequiz(id)){
			return "Removed Quiz with id -->  "+ id;
		}
		return "Something wrong happened Please Contact Support";

	}

	@GetMapping(value="/getAllQuestions/{Quizid}")
	public List<Question> getAllQuestions (@PathVariable int Quizid) {
		return quizService.getAllQuestions(Quizid);
	}



}
