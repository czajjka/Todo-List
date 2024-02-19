package com.todolist.controller;

import ch.qos.logback.core.model.Model;
import com.todolist.model.TodoList;
import com.todolist.service.TodoListService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoCreateController {
    @Autowired
    public TodoListService todoListService;

    @GetMapping("/create-todo")
    public String showCreateForm(TodoList todoList) {
        return "todo-createpage";
    }

    @PostMapping("/todo")
    public String createTodoList(@Valid TodoList todoList, BindingResult result, Model model) {

        TodoList list = new TodoList();
        list.setDescription(todoList.getDescription());
        list.setIsComplete(todoList.getIsComplete());

        todoListService.save((todoList));
        return "redirect:/";
    }
}
