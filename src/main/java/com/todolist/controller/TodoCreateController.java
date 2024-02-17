package com.todolist.controller;

import com.todolist.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoCreateController {
    @Autowired
    public TodoListService todoListService;

    @GetMapping("/create-todo")
    public String showCreateForm() {
        return "new-todo-list";
    }
}
