package com.pratice.springboot.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pratice.springboot.model.Question;
import com.pratice.springboot.service.SurveyService;

@RestController
public class SurveyController {

	@Autowired
	private SurveyService surveyService;

	@GetMapping("/surveys/{id}/questions")
	public List<Question> returnQuestionsForSurvey(@PathVariable String id) {
		System.out.println(surveyService.retrieveQuestions(id));
		return surveyService.retrieveQuestions(id);

	}

	@GetMapping("/surveys/{id}/questions/{questionId}")
	public Question returnQuestionsWithNumber(@PathVariable String id, @PathVariable String questionId) {
		return surveyService.retrieveQuestion(id, questionId);

	}

	@PostMapping("/surveys/{id}/questions")
	public ResponseEntity<Void> addQuestionsToSurvey(@PathVariable String id, @RequestBody Question newquestion) {
		Question question = surveyService.addQuestion(id, newquestion);
			if(question==null) {
				return ResponseEntity.noContent().build();
			}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(question.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

}
