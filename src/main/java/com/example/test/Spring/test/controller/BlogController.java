package com.example.test.Spring.test.controller;

import com.example.test.Spring.test.data.Blog;
import com.example.test.Spring.test.data.BlogRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/blog")
public class BlogController {

    public final BlogRepository blogRepository;

    public BlogController(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @RequestMapping(path = "/blogs")
    public List<Blog> blogs(){
        return blogRepository.findAll();
    }
}
