package com.pratice.springboot.spingBootBasic;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pratice.springboot.web.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping("/todo-list")
	public String todolist(ModelMap model) {
		String name = (String) model.get("name");
		model.put("todos", todoService.retireveTodos(name));
		return "todolist";
	}

	@GetMapping("/addtodo")
	public String addtodo(ModelMap model) {
		return "todo";
	}
	
	@PostMapping("/addtodo")
	public String addTodo(ModelMap model, @RequestParam String desc){
		todoService.addTodos((String) model.get("name"), desc, new Date(), false);
		return "redirect:/todo-list";
	}
	
	@GetMapping("/deletetodo")
	public String deletetodo(int id) {
		todoService.deleteTodos(id);
		return "redirect:/todo-list";
	}
}
