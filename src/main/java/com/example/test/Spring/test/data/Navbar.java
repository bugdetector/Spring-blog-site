package com.example.test.Spring.test.data;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Navbar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    private String title;
    private String icon_class;
    private String link_class;
    private String url;
    @Column(name = "available_for")
    private String availableFor;
    private Integer weight;
    private Integer parent;
    private Date created_at;
    private Date last_updated;

    @OneToMany(mappedBy = "parent")
    private List<Navbar> subitems;


    @Autowired
    public  Navbar() {}
    public Navbar(int ID, String title, String icon_class, String link_class, String url, String available_for, Integer weight, Integer parent, Date created_at, Date last_updated) {
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

    public String getAvailableFor() {
        return availableFor;
    }

    public void setAvailableFor(String availableFor) {
        this.availableFor = availableFor;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
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