package com.pracownia.spring.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Band {

    @Id
    @GeneratedValue(generator = "gen")
    @SequenceGenerator(name = "gen", sequenceName = "Band_seq")
    @Column(name = "id")
    private int id;

    @Column
    private String name;

    @Column
    private String city;

    @Column(length = 1000)
    private DateTime foundationDate;

    @ElementCollection
    @CollectionTable(name = "albums")
    @Column(name = "album_id")
    private List<String> albums = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy="bandOb")
    private List<Album> albumsOb;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bandOb")
    private List<Artist> artists;

    //required by Hibernate
    public Band(){

    }

    public Band(String name, String city, List<String> albums, DateTime foundationDate) {
        this.name = name;
        this.city = city;
        this.albums = albums;
        this.foundationDate = foundationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getAlbums() {
        return albums;
    }

    public void setAlbums(List<String> albums) {
        this.albums = albums;
    }
}