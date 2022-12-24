package com.igorfernandes.todoapp.controllers

import com.igorfernandes.todoapp.entities.Todo
import com.igorfernandes.todoapp.entities.TodoRepository
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("api/v1/todos")
class TodoController(val todoRepository: TodoRepository) {

    @GetMapping
    fun getTodos() = todoRepository.findAll();

    @GetMapping("/{todoId}")
    fun getTodo(@PathVariable("todoId") todoId: Long): Optional<Todo> {
        return todoRepository.findById(todoId);
    }

    @PostMapping
    fun newTodo(@RequestBody todo: Todo): Todo {
        return todoRepository.save(todo);
    }

    @PutMapping("/{todoId}")
    fun updateTodo(@PathVariable("todoId") todoId: Long, @RequestBody updatedTodo: Todo): Todo {
        val oldTodo = todoRepository.findById(todoId)
        if (oldTodo == null) {
            return oldTodo;
        }
        return todoRepository.save(updatedTodo);
    }

    @DeleteMapping("/{todoId}")
    fun deleteTodo(@PathVariable("todoId") todoId: Long) {
        todoRepository.deleteById(todoId);
    }
}