package com.pracownia.spring.services;

import com.pracownia.spring.entities.Album;
import java.util.Optional;

public interface AlbumService {

    Iterable<Album> listAllAlbums();

    Optional<Album> getAlbumById(Integer id);

    Album saveAlbum(Album Album);

    void deleteAlbum(Integer id);

    Boolean checkIfExist(Integer id);

    Iterable<Album> listAllAlbumsPaging(Integer pageNr, Integer howManyOnPage);
}
