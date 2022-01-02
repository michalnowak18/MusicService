package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Album;
import com.pracownia.spring.entities.Band;
import com.pracownia.spring.services.AlbumService;
import com.pracownia.spring.services.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

/**
 * Album controller.
 */
@RestController
@RequestMapping("/api")
public class AlbumController {

    @Autowired
    private AlbumService AlbumService;

    /**
     * List all Albums.
     *
     */
    @GetMapping(value = "/albums", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Album> list(Model model) {
        return AlbumService.listAllAlbums();
    }

    // Only for redirect!
    @ApiIgnore
    @RequestMapping(value = "/albums", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Album> redirect(Model model) {
        return AlbumService.listAllAlbums();
    }

    /**
     * View a specific Album by its id.
     *
     * @return
     */
    @GetMapping(value = "/album/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Album getByPublicId(@PathVariable("id") Integer publicId) {
        return AlbumService.getAlbumById(publicId).orElseGet(null);
    }

    /**
     * View a specific Album by its id.
     *
     * @return
     */
    @GetMapping(value = "/album", produces = MediaType.APPLICATION_JSON_VALUE)
    public Album getByParamPublicId(@RequestParam("id") Integer publicId) {
        return AlbumService.getAlbumById(publicId).orElseGet(null);
    }

    /**
     * Save Album to database.
     *
     */
    @PostMapping(value = "/album")
    public ResponseEntity<Album> create(@RequestBody @NonNull @Valid
                                                      Album Album) {
        Album.setAlbumId(UUID.randomUUID().toString());
        AlbumService.saveAlbum(Album);
        return ResponseEntity.ok().body(Album);
    }


    /**
     * Edit Album in database.
     *
     */
    @PutMapping(value = "/Album")
    public ResponseEntity<Void> edit(@RequestBody Album Album) {
        if(!AlbumService.checkIfExist(Album.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            AlbumService.saveAlbum(Album);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    /**
     * Delete Album by its id.
     *
     */
    @DeleteMapping(value = "/Album/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        AlbumService.deleteAlbum(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/Albums/{id}")
    public ResponseEntity deleteBadRequest(@PathVariable Integer id) {
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }


    @GetMapping(value = "/Albums/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Album> list(@PathVariable("page") Integer pageNr,@RequestParam("size") Optional<Integer> howManyOnPage) {
        return AlbumService.listAllAlbumsPaging(pageNr, howManyOnPage.orElse(2));
    }
}
