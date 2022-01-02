package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Artist;
import com.pracownia.spring.entities.Artist;
import com.pracownia.spring.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ArtistController {

    @Autowired
    private ArtistService ArtistService;

    /**
     * List all Artists
     *
     */
    @GetMapping(value = "/artists", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Artist> list(Model model) { return ArtistService.listAllArtists(); }

    /**
     * View a specific Artist by its id.
     *
     */
    @GetMapping(value = "/artist/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Artist getByPublicId(@PathVariable("id") Integer publicId) {
        return ArtistService.getArtistById(publicId).orElseGet(null);
    }

    /**
     * View a specific Artist by its id.
     *
     */
    @GetMapping(value = "/artist", produces = MediaType.APPLICATION_JSON_VALUE)
    public Artist getByParamPublicId(@RequestParam("id") Integer publicId) {
        return ArtistService.getArtistById(publicId).orElseGet(null);
    }

    /**
     * Save Artist to database.
     *
     */
    @PostMapping(value = "/artist")
    public ResponseEntity<Artist> create(@RequestBody @NonNull @Valid
                                                Artist Artist) {
        ArtistService.saveArtist(Artist);
        return ResponseEntity.ok().body(Artist);
    }


    /**
     * Edit Artist in database.
     *
     */
    @PutMapping(value = "/artist")
    public ResponseEntity<Void> edit(@RequestBody Artist Artist) {
        if(!ArtistService.checkIfExist(Artist.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            ArtistService.saveArtist(Artist);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    /**
     * Delete Artist by its id.
     *
     */
    @DeleteMapping(value = "/artist/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        ArtistService.deleteArtist(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/artists/{id}")
    public ResponseEntity deleteBadRequest(@PathVariable Integer id) {
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }

}
