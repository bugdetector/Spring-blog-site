package com.example.test.Spring.test.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Navbar {
    public enum AvailableFor {
        logged_in, non_logged_in, both;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private String title;
    private String icon_class;
    private String link_class;
    private String url;
    @Column(name = "available_for")
    @Enumerated(EnumType.STRING)
    private AvailableFor availableFor;
    private Integer weight;
    @OneToOne
    private Navbar parent;
    @CreatedDate
    private Date created_at;
    @LastModifiedDate
    private Date last_updated;

    @OneToMany(mappedBy = "parent")
    private List<Navbar> subitems;


    @Autowired
    public  Navbar() {}
    public Navbar(int ID, String title, String icon_class, String link_class, String url, AvailableFor available_for, Integer weight, Navbar parent, Date created_at, Date last_updated) {
        this.ID = ID;
        this.title = title;
        this.icon_class = icon_class;
        this.link_class = link_class;
        this.url = url;
        this.availableFor = available_for;
        this.weight = weight;
        this.parent = parent;
        this.created_at = created_at;
        this.last_updated = last_updated;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon_class() {
        return icon_class;
    }

    public void setIcon_class(String icon_class) {
        this.icon_class = icon_class;
    }

    public String getLink_class() {
        return link_class;
    }

    public void setLink_class(String link_class) {
        this.link_class = link_class;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public AvailableFor getAvailableFor() {
        return availableFor;
    }

    public void setAvailableFor(AvailableFor availableFor) {
        this.availableFor = availableFor;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Navbar getParent() {
        return parent;
    }

    public void setParent(Navbar parent) {
        this.parent = parent;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(Date last_updated) {
        this.last_updated = last_updated;
    }

    public List<Navbar> getSubitems() {
        return subitems;
    }

    public void setSubitems(List<Navbar> subitems) {
        this.subitems = subitems;
    }
}