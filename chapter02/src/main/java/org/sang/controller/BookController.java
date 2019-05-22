package org.sang.controller;

import org.springframework.web.bind.annotation.*;

//跨域
//@CrossOrigin(value = "http://localhost:8081" , maxAge = 1800 ,allowedHeaders = "*")
@RestController
@RequestMapping("/book")
public class BookController {
    @GetMapping("/")
    @CrossOrigin(value = "http://localhost:8081" , maxAge = 1800 ,allowedHeaders = "*")
    public String addBook(String name){
        return "receive" + name;
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(value = "http://localhost:8081" , maxAge = 1800 ,allowedHeaders = "*")
    public String deleteBookById(@PathVariable Long id){
        return String.valueOf(id);
    }
}
