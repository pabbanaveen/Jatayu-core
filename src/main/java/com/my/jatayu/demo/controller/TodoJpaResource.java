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
import com.my.jatayu.demo.repository.TodoRepository;
import com.my.jatayu.demo.service.TodoService;

@RestController
public class TodoJpaResource {

    @Autowired
    private TodoService todoService;
    
    @Autowired
    private TodoRepository todoRepository;
    
    @GetMapping("/jpa/users/{username}/todos")
    public List<Todo> getTodos(@PathVariable("username") String username){
        return todoRepository.findByUsername(username);
    }
    
    @GetMapping("/jpa/users/{username}/todos/{id}")
    public Todo getTodoById(@PathVariable String username, @PathVariable long id){
       

        return todoRepository.findById(id).get();
    }
    
    
   @DeleteMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
                
        todoRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo) {
        ResponseEntity<Todo> respEn = null;
        respEn = new ResponseEntity<>(todoRepository.save(todo), HttpStatus.OK);
         return respEn;
    }
    
    
    @PostMapping("/jpa/users/{username}/todos")
    public ResponseEntity<Void> saveTodo(@PathVariable String username, @RequestBody Todo todo) {
        Todo save = todoRepository.save(todo);
        
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
