package com.pratice.springboot.spingBootBasic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.pratice.springboot.web.service.TodoService;

@Controller
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping("/todo-list")
	public String todolist(ModelMap model) {
		model.put("todos", todoService.retireveTodos("venkat"));
		return "todolist";
	}

}
