package com.pracownia.spring.entities;

import javax.persistence.*;

@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private Band bandOb = new Band();

    @Column
    private String instrument;

    public Artist() {

    }

    public Artist(String name, String instrument) {
        this.name = name;
        this.instrument = instrument;
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

    public Band getBandOb() {
        return bandOb;
    }

    public void setBandOb(Band bandOb) {
        this.bandOb = bandOb;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }
}
