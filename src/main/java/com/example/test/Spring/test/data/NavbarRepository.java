package com.example.test.Spring.test.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NavbarRepository extends JpaRepository<Navbar, Integer> {
    List<Navbar> findByParentAndAvailableFor(Integer parent, Navbar.AvailableFor availableFor);
}
