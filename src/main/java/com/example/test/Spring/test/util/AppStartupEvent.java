package com.example.test.Spring.test.util;

import com.example.test.Spring.test.data.Blog;
import com.example.test.Spring.test.data.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    public final BlogRepository blogRepository;

    public AppStartupEvent(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Blog> blogs = blogRepository.findAll();
        blogs.forEach(System.out::println);
    }
}
