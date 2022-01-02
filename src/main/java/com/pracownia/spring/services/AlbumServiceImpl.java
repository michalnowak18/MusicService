package com.pracownia.spring.services;

import com.pracownia.spring.entities.Album;
import com.pracownia.spring.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Album service implement.
 */
@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository AlbumRepository;

    @Override
    public Iterable<Album> listAllAlbums() {
        return AlbumRepository.findAll();
    }

    @Override
    public Optional<Album> getAlbumById(Integer id) {
        return AlbumRepository.findById(id);
    }

    @Override
    public Album saveAlbum(Album Album) {
        return AlbumRepository.save(Album);
    }

    @Override
    public void deleteAlbum(Integer id) {
        AlbumRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (AlbumRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }

    @Override
    public Iterable<Album> listAllAlbumsPaging(Integer pageNr, Integer howManyOnPage) {
        return AlbumRepository.findAll(PageRequest.of(pageNr,howManyOnPage));
    }


}
