package com.todolist.service;

import com.todolist.model.TodoList;
import com.todolist.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class TodoListService {

    @Autowired
    private TodoListRepository todoListRepository;

    public Iterable<TodoList> getAll() {
        return todoListRepository.findAll();
    }

    public Optional<TodoList> getById(Long id) {
        return todoListRepository.findById(id);
    }

    public TodoList save(TodoList todoList) {
        if (todoList.getId() == null) {
            todoList.setCreatedAt(Instant.now());
        }

        todoList.setUpdatedAt(Instant.now());
        return todoListRepository.save(todoList);
    }

    public void delete(TodoList todoList){
        todoListRepository.delete(todoList);
    }
}
