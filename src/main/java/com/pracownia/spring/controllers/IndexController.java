package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Album;
import com.pracownia.spring.entities.Artist;
import com.pracownia.spring.entities.Band;
import com.pracownia.spring.entities.Song;
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

        Band band = new Band("Metallica", "Los Angeles", Arrays.asList(a0.getName(), a1.getName()), new DateTime(1981, 11, 28, 0, 0));
        Band band2 = new Band("Black Sabbath", "Birmingham", Arrays.asList(a2.getName(), a3.getName()), new DateTime(1986, 1, 11, 0, 0));
        Band band3 = new Band("Van Halen", "Pasadena", Arrays.asList(a4.getName()), new DateTime(1986, 7, 17, 0, 0));
        Band band4 = new Band("Pink Floyd", "London", Arrays.asList(a5.getName(), a6.getName()), new DateTime(1986, 12, 3, 0, 0));

        Artist art = new Artist("James Hetfield", "Guitar", band);
        Artist art2 = new Artist("Lars Ulrich", "Drums", band);
        Artist art3 = new Artist("Cliff Burton", "Bass", band);
        Artist art4 = new Artist("Kirk Hammett", "Guitar", band);

        Artist art5 = new Artist("Tony Iommi", "Guitar", band2);
        Artist art6 = new Artist("Ozzy Osbourne", "Vocal", band2);
        Artist art7 = new Artist("Geezer Butler", "Bass", band2);
        Artist art8 = new Artist("Bill Ward", "Drums", band2);

        Artist art9 = new Artist("Eddie Van Halen", "Guitar", band3);
        Artist art10 = new Artist("David Lee Roth", "Vocal", band3);

        Artist art11 = new Artist("David Gilmour", "Guitar", band4);
        Artist art12 = new Artist("Nick Mason", "Drums", band4);
        Artist art13 = new Artist("Richard Wright", "Keyboard", band4);
        Artist art14 = new Artist("Roger Waters", "Bass", band4);

        a0.setBandOb(band);
        a1.setBandOb(band);
        a2.setBandOb(band2);
        a3.setBandOb(band2);
        a4.setBandOb(band3);
        a5.setBandOb(band4);
        a6.setBandOb(band4);

        Song s = new Song("Disposable Heroes", "6:51", a0);
        Song s2 = new Song("Leper Messiah", "4:50", a0);
        Song s3 = new Song("Fight fire with fire", "4:48", a1);
        Song s4 = new Song("Creeping Death", "6:33", a1);
        Song s5 = new Song("War pigs", "5:40", a2);
        Song s6 = new Song("Fairies wear boots", "6:13", a2);
        Song s7 = new Song("Sweet leaf", "5:03", a3);
        Song s8 = new Song("Children of the grave", "5:14", a3);
        Song s9 = new Song("Panama", "3:30", a4);
        Song s10 = new Song("Jump", "4:01", a4);
        Song s11 = new Song("Comfortably Numb", "6:22", a5);
        Song s12 = new Song("Hey you", "4:39", a5);
        Song s13 = new Song("Welcome to the machine", "7:33", a6);
        Song s14 = new Song("Wish you were here", "5:04", a6);

        a0.setSongsOb(Arrays.asList(s, s2));
        a1.setSongsOb(Arrays.asList(s3, s4));
        a2.setSongsOb(Arrays.asList(s5, s6));
        a3.setSongsOb(Arrays.asList(s7, s8));
        a4.setSongsOb(Arrays.asList(s9, s10));
        a5.setSongsOb(Arrays.asList(s11, s12));
        a6.setSongsOb(Arrays.asList(s13, s14));

        a0.setSongNames(Arrays.asList(s.getName(), s2.getName()));
        a1.setSongNames(Arrays.asList(s3.getName(), s4.getName()));
        a2.setSongNames(Arrays.asList(s5.getName(), s6.getName()));
        a3.setSongNames(Arrays.asList(s7.getName(), s8.getName()));
        a4.setSongNames(Arrays.asList(s9.getName(), s10.getName()));
        a5.setSongNames(Arrays.asList(s11.getName(), s12.getName()));
        a6.setSongNames(Arrays.asList(s13.getName(), s14.getName()));

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