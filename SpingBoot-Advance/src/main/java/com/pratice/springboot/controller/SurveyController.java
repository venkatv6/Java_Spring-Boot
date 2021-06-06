package com.pratice.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pratice.springboot.model.Question;
import com.pratice.springboot.service.SurveyService;

@RestController
public class SurveyController {

	@Autowired
	private SurveyService surveyService;
	
	
	@GetMapping("/surveys/{id}/questions")
	///surveys/{Survey1}/questions
	public List<Question> returnQuestionsForSurvey(@PathVariable String id) {
		System.out.println(surveyService.retrieveQuestions(id));
		return surveyService.retrieveQuestions(id);
		
	}
	
}
