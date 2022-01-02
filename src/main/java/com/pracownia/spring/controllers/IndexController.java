package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Album;
import com.pracownia.spring.entities.Artist;
import com.pracownia.spring.entities.Band;
import com.pracownia.spring.services.AlbumService;
import com.pracownia.spring.services.ArtistService;
import com.pracownia.spring.services.*;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

/**
 * Homepage controller.
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private AlbumService AlbumService;

    @Autowired
    private ArtistService ArtistService;

    @GetMapping(value = "")
    String index() {
        return "index";
    }


    @PostMapping(value = "generateModel", produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateModel() {

        Album a0 = new Album(UUID.randomUUID().toString(),"Master of Puppets", new DateTime(1986, 3, 3, 0, 0));
        Album a1 = new Album(UUID.randomUUID().toString(),"Ride the lightning", new DateTime(1984, 11, 7, 0, 0));
        Album a2 = new Album(UUID.randomUUID().toString(),"Paranoid", new DateTime(1970, 1, 2, 0, 0));
        Album a3 = new Album(UUID.randomUUID().toString(),"Master of Reality", new DateTime(1971, 11, 8, 0, 0));
        Album a4 = new Album(UUID.randomUUID().toString(),"1984", new DateTime(1984, 8, 15, 0, 0));
        Album a5 = new Album(UUID.randomUUID().toString(),"The Wall", new DateTime(1979, 3, 11, 0, 0));
        Album a6 = new Album(UUID.randomUUID().toString(),"Wish You Were Here", new DateTime(1975, 2, 3, 0, 0));

        Artist art = new Artist("James Hetfield", "Guitar");
        Artist art2 = new Artist("Lars Ulrich", "Drums");
        Artist art3 = new Artist("Cliff Burton", "Bass");
        Artist art4 = new Artist("Kirk Hammett", "Guitar");

        Artist art5 = new Artist("Tony Iommi", "Guitar");
        Artist art6 = new Artist("Ozzy Osbourne", "Vocal");
        Artist art7 = new Artist("Geezer Butler", "Bass");
        Artist art8 = new Artist("Bill Ward", "Drums");

        Artist art9 = new Artist("Eddie Van Halen", "Guitar");
        Artist art10 = new Artist("David Lee Roth", "Vocal");

        Artist art11 = new Artist("David Gilmour", "Guitar");
        Artist art12 = new Artist("Nick Mason", "Drums");
        Artist art13 = new Artist("Richard Wright", "Keyboard");
        Artist art14 = new Artist("Roger Waters", "Bass");

        Band band = new Band("Metallica", "Los Angeles", Arrays.asList(a0.getAlbumId(), a1.getAlbumId()), new DateTime(1981, 11, 28, 0, 0));
        Band band2 = new Band("Black Sabbath", "Birmingham", Arrays.asList(a2.getAlbumId(), a3.getAlbumId()), new DateTime(1986, 1, 11, 0, 0));
        Band band3 = new Band("Van Halen", "Pasadena", Arrays.asList(a4.getAlbumId()), new DateTime(1986, 7, 17, 0, 0));
        Band band4 = new Band("Pink Floyd", "London", Arrays.asList(a5.getAlbumId(), a6.getAlbumId()), new DateTime(1986, 12, 3, 0, 0));

        a0.setBandOb(band);
        a1.setBandOb(band);
        a2.setBandOb(band2);
        a3.setBandOb(band2);
        a4.setBandOb(band3);
        a5.setBandOb(band4);
        a6.setBandOb(band4);

        art.setBandOb(band);
        art2.setBandOb(band);
        art3.setBandOb(band);
        art4.setBandOb(band);

        art5.setBandOb(band2);
        art6.setBandOb(band2);
        art7.setBandOb(band2);
        art8.setBandOb(band2);

        art9.setBandOb(band3);
        art10.setBandOb(band3);

        art11.setBandOb(band4);
        art12.setBandOb(band4);
        art13.setBandOb(band4);
        art14.setBandOb(band4);

        AlbumService.saveAlbum(a0);
        AlbumService.saveAlbum(a1);
        AlbumService.saveAlbum(a2);
        AlbumService.saveAlbum(a3);
        AlbumService.saveAlbum(a4);
        AlbumService.saveAlbum(a5);
        AlbumService.saveAlbum(a6);

        ArtistService.saveArtist(art);
        ArtistService.saveArtist(art2);
        ArtistService.saveArtist(art3);
        ArtistService.saveArtist(art4);
        ArtistService.saveArtist(art5);
        ArtistService.saveArtist(art6);
        ArtistService.saveArtist(art7);
        ArtistService.saveArtist(art8);
        ArtistService.saveArtist(art9);
        ArtistService.saveArtist(art10);
        ArtistService.saveArtist(art11);
        ArtistService.saveArtist(art12);
        ArtistService.saveArtist(art13);
        ArtistService.saveArtist(art14);

        return "Model Generated";
    }
}