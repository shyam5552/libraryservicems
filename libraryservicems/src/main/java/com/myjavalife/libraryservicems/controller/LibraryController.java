package com.myjavalife.libraryservicems.controller;

import com.myjavalife.libraryservicems.model.Book;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @GetMapping(value = "/books")
    public List<Object> getbooks(){
        RestTemplate restTemplate=new RestTemplate();
        Object[] objects=restTemplate.getForObject("http://localhost:8081/books",Object[].class);
        return Arrays.asList(objects);
    }
    @PostMapping("/books")
    public String savebook(@RequestBody Book book){

        RestTemplate restTemplate=new RestTemplate();
        String res= String.valueOf(restTemplate.postForEntity("http://localhost:8081/books",book, Book.class));
        return res;
    }

    @GetMapping(value = "/books/{book_id}")
     public Book getbook(@PathVariable int book_id){
        RestTemplate restTemplate=new RestTemplate();

        Book b=  restTemplate.getForObject("http://localhost:8081/books/"+book_id,Book.class);
                //getForObject("localhost:8081/books/1",Book.class);
        return b;

    }




}
