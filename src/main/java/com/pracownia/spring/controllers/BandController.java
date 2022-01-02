package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Band;
import com.pracownia.spring.services.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.view.RedirectView;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BandController {

    @Autowired
    private BandService BandService;

    @GetMapping(value = "/bands", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Band> list(Model model) {
        return BandService.listAllBands();
    }

    // Only for redirect!
    @ApiIgnore
    @DeleteMapping(value = "/bands", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Band> redirect(Model model) {
        return BandService.listAllBands();
    }

    @PostMapping(value = "/band")
    public ResponseEntity<Band> create(@RequestBody @Validated(Band.class) @NonNull Band Band) {
        BandService.saveBand(Band);
        return ResponseEntity.ok().body(Band);
    }

    @PutMapping(value = "/band")
    public ResponseEntity<Void> edit(@RequestBody Band Band) {
        Optional<Band> BandFromData = BandService.getBandById(Band.getId());
        if(Objects.nonNull(BandFromData)) {
            BandService.saveBand(Band);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/band/{id}")
    public RedirectView delete(HttpServletResponse response, @PathVariable Integer id) {
        BandService.deleteBand(id);
        return new RedirectView("/api/Bands", true);
    }

    @GetMapping(value = "/band/{name}")
    public List<Band> getByName(@PathVariable String name) {
        return BandService.getByName(name);
    }

    @GetMapping(value = "/band/Albums/{id}")
    public Integer getAlbumsSize(@PathVariable Integer id) {
        return BandService.getNumberOfAlbums(id);
    }

    @GetMapping(value = "/band/{id}", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    @ResponseBody
    public ResponseEntity<Band> getBandByPublicId(@PathVariable("id") Integer publicId) {
        Optional<Band> Band = BandService.getBandById(publicId);
        if(Band.isPresent()) {
            return ResponseEntity.ok(Band.get());
        } else
            return ResponseEntity.noContent().build();
    }
}
