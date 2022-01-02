package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Album;
import com.pracownia.spring.entities.Band;
import com.pracownia.spring.services.AlbumService;
import com.pracownia.spring.services.*;
import org.codehaus.plexus.util.dag.DAG;
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

        AlbumService.saveAlbum(a0);
        AlbumService.saveAlbum(a1);
        AlbumService.saveAlbum(a2);
        AlbumService.saveAlbum(a3);
        AlbumService.saveAlbum(a4);
        AlbumService.saveAlbum(a5);
        AlbumService.saveAlbum(a6);

        return "Model Generated";
    }
}