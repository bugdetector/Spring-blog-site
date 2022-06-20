package com.example.test.Spring.test.controller;

import com.example.test.Spring.test.data.Navbar;
import com.example.test.Spring.test.data.NavbarRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/api")
public class ApiController {

    private final NavbarRepository navbarRepository;

    public ApiController(NavbarRepository navbarRepository) {
        this.navbarRepository = navbarRepository;
    }

    @RequestMapping(path = "/navbar", method = RequestMethod.GET)
    public List<Navbar> getNavbarElements(){
        return this.navbarRepository.findByParentAndAvailableFor(null, "both");
    }
}
