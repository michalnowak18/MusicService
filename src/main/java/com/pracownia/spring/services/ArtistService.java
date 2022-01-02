package com.pracownia.spring.services;

import com.pracownia.spring.entities.Artist;
import java.util.Optional;

public interface ArtistService {

    Iterable<Artist> listAllArtists();

    Optional<Artist> getArtistById(Integer id);

    Artist saveArtist(Artist artist);

    void deleteArtist(Integer id);

    Boolean checkIfExist(Integer id);
}
