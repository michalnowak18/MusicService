package com.pracownia.spring.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.*;

/**
 * Product entity.
 */
@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String albumId;

    @Column
    private String name;

    @Column(length = 1000)
    private DateTime releaseDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Band bandOb = new Band();

    @ElementCollection
    @CollectionTable(name = "songs")
    @Column(name = "song_name")
    private List<String> songNames = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "albumOb", cascade = CascadeType.PERSIST)
    private List<Song> songsOb;

    //required by Hibernate
    public Album(){

    }

    public Album(String albumId, String name, DateTime releaseDate) {
        this.albumId = albumId;
        this.name = name;
        this.releaseDate = releaseDate;
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
    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public DateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(DateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Band getBandOb() {
        return bandOb;
    }

    public void setBandOb(Band bandOb) {
        this.bandOb = bandOb;
    }

    public void setSongsOb(List<Song> songsOb) {
        this.songsOb = songsOb;
    }

    public List<String> getSongNames() {
        return songNames;
    }

    public void setSongNames(List<String> songNames) {
        this.songNames = songNames;
    }
}
