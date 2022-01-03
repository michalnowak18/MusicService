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
    private int id;

    @Column
    private String name;

    @Column
    private String city;

    @Column(length = 1000)
    private DateTime foundationDate;

    @ElementCollection
    @CollectionTable(name = "albums")
    @Column(name = "album_name")
    private List<String> albumNames = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy="bandOb")
    private List<Album> albumsOb;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bandOb")
    private List<Artist> artists;

    //required by Hibernate
    public Band(){

    }

    public Band(String name, String city, List<String> albumNames, DateTime foundationDate) {
        this.name = name;
        this.city = city;
        this.albumNames = albumNames;
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

    public List<String> getAlbumNames() {
        return albumNames;
    }

    public void setAlbumNames(List<String> albumNames) {
        this.albumNames = albumNames;
    }
}