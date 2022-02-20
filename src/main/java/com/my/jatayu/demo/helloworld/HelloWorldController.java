package com.my.jatayu.demo.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {
    
    

    @GetMapping("/hello-world")
    public String getHelle() {
        return "Hello World";
    }

    @GetMapping(path="/hello-world-bean")
    public HelloWorld getBean() {
        return new HelloWorld("Hello World");
//        throw new RuntimeException("Something went worng!!!");
    }

    @GetMapping(path="/hello-world/{name}")
    public HelloWorld getBeanWithParam(@PathVariable String name) {
        return new HelloWorld(String.format("Hello World, %s", name));
    }

}
