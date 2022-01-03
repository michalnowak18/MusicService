package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Song;
import com.pracownia.spring.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class SongController {

    @Autowired
    private SongService SongService;

    /**
     * List all Songs
     *
     */
    @GetMapping(value = "/songs", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Song> list(Model model) { return SongService.listAllSongs(); }

    /**
     * View a specific Song by its id.
     *
     */
    @GetMapping(value = "/song/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Song getByPublicId(@PathVariable("id") Integer publicId) {
        return SongService.getSongById(publicId).orElseGet(null);
    }

    /**
     * View a specific Song by its id.
     *
     */
    @GetMapping(value = "/song", produces = MediaType.APPLICATION_JSON_VALUE)
    public Song getByParamPublicId(@RequestParam("id") Integer publicId) {
        return SongService.getSongById(publicId).orElseGet(null);
    }

    /**
     * Save Song to database.
     *
     */
    @PostMapping(value = "/song")
    public ResponseEntity<Song> create(@RequestBody @NonNull @Valid
                                                 Song Song) {
        SongService.saveSong(Song);
        return ResponseEntity.ok().body(Song);
    }


    /**
     * Edit Song in database.
     *
     */
    @PutMapping(value = "/song")
    public ResponseEntity<Void> edit(@RequestBody Song Song) {
        if(!SongService.checkIfExist(Song.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            SongService.saveSong(Song);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    /**
     * Delete Song by its id.
     *
     */
    @DeleteMapping(value = "/song/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        SongService.deleteSong(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/songs/{id}")
    public ResponseEntity deleteBadRequest(@PathVariable Integer id) {
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }
}
