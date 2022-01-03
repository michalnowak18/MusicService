package com.pracownia.spring.entities;

import com.pracownia.spring.entities.Album;
import com.pracownia.spring.entities.Band;

import javax.persistence.*;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private Album albumOb = new Album();

    @Column
    private String lenght;

    public Song() {

    }

    public Song(String name, String lenght, Album albumOb) {
        this.name = name;
        this.lenght = lenght;
        this.albumOb = albumOb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLenght() {
        return lenght;
    }

    public void setLenght(String lenght) {
        this.lenght = lenght;
    }

    public Album getAlbumOb() {
        return albumOb;
    }

    public void setAlbumOb(Album albumOb) {
        this.albumOb = albumOb;
    }
}