package com.my.jatayu.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.my.jatayu.demo.modal.Todo;
import com.my.jatayu.demo.service.TodoService;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TodoResource {

    @Autowired
    private TodoService todoService;
    
    @GetMapping("/users/{username}/todos")
    public List<Todo> getTodos(@PathVariable("username") String username){
        return todoService.findAll();
    }
    
    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodoById(@PathVariable String username, @PathVariable Long id){
        return todoService.findById(id);
    }
    
    @CrossOrigin(origins="http://localhost:4200")
    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable Long id) {
                
        Todo todo = todoService.deleteById(id);
        if(todo !=null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
    
    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo) {
        ResponseEntity<Todo> respEn = null;
        respEn = new ResponseEntity<>(todoService.save(todo), HttpStatus.OK);
         return respEn;
    }
    
    
    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Void> saveTodo(@PathVariable String username, @RequestBody Todo todo) {
        Todo save = todoService.save(todo);
        
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
