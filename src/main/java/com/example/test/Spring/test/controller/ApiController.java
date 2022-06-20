package com.example.test.Spring.test.controller;

import com.example.test.Spring.test.data.Navbar;
import com.example.test.Spring.test.data.NavbarRepository;
import com.example.test.Spring.test.data.Page;
import com.example.test.Spring.test.data.PageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/api")
public class ApiController {

    private final NavbarRepository navbarRepository;
    private final PageRepository pageRepository;

    public ApiController(NavbarRepository navbarRepository, PageRepository pageRepository) {
        this.navbarRepository = navbarRepository;
        this.pageRepository = pageRepository;
    }

    @RequestMapping(path = "/navbar", method = RequestMethod.GET)
    public List<Navbar> getNavbarElements(){
        return this.navbarRepository.findByParentAndAvailableFor(null, Navbar.AvailableFor.both);
    }
    @RequestMapping(path = "/page/{urlAlias}", method = RequestMethod.GET)
    public Page getPage(@PathVariable String urlAlias){
        return pageRepository.findByUrlAlias(urlAlias);
    }
}
