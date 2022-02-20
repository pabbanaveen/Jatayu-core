package com.my.jatayu.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.jatayu.demo.modal.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{

    List<Todo> findByUsername(String username);
}
