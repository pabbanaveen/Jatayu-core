package com.my.jatayu.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.my.jatayu.demo.modal.Todo;

@Service
public class TodoService {

    private static List<Todo> listOfTodo = new ArrayList<>(); 
    private static Long idCounter= 0L;
    
    static {
        listOfTodo.add(new Todo(++idCounter, "naveen", "learn full stac", new Date(), true));
        listOfTodo.add(new Todo(++idCounter, "pabba", "learn angular", new Date(), true));
        listOfTodo.add(new Todo(++idCounter, "laxman", "learn JPA", new Date(), true));
        listOfTodo.add(new Todo(++idCounter, "jatayu", "complete Jatayu project", new Date(), true));
        listOfTodo.add(new Todo(++idCounter, "demoj", "AWS", new Date(), false));
    }
    
    public List<Todo> findAll() {
        return listOfTodo;
    }
    
    public Todo deleteById(Long id) {
        Todo todo = findById(id);
        if(todo == null) return null;
        
        if(listOfTodo.remove(todo)) {
            return todo;
        }
        return null;
    }

    public Todo findById(Long id) {
        // TODO Auto-generated method stub
        for(Todo todo : listOfTodo) {
            if(todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }
    
    public Todo save(Todo todo) {
        if(todo.getId() == -1 || todo.getId() == 0) {
            
            todo.setId(++idCounter);
            listOfTodo.add(todo);
        } else {
//            Todo findById = findById(todo.getId());
//            findById.setDescription(todo.getDescription());
//            findById.setTargetDate(todo.getTargetDate());
            deleteById(todo.getId());
            listOfTodo.add(todo);
        }
        
        return todo;
    }
}
