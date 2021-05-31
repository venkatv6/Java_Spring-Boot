package com.pratice.springboot.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pratice.springboot.model.Todos;

@Service
public class TodoService {

	private static List<Todos> todos = new ArrayList<>();
	private static int count = 3;

	static {
		todos.add(new Todos(1, "Venkat", "Spring-Boot", new Date(), false));
		todos.add(new Todos(2, "Venkat", "Spring-MVC", new Date(), false));
		todos.add(new Todos(3, "Venkat", "Spring-Cloud", new Date(), false));
	}

	public List<Todos> retireveTodos(String user) {
		List<Todos> filteredTodos = new ArrayList<>();
		for (Todos todo : todos) {
			if (todo.getUser().equalsIgnoreCase(user)) {
				filteredTodos.add(todo);
			}
		}

		return filteredTodos;

	}

	public void addTodos(String user, String desc, Date targetDate, boolean isDone) {

		todos.add(new Todos(++count, user, desc, targetDate, isDone));
	}

	public void deleteTodos(int id) {
		Iterator<Todos> iterator = todos.iterator();
		while (iterator.hasNext()) {
			Todos todos = iterator.next();
			if (todos.getId() == id) {
				iterator.remove();
			}
		}
	}
}
