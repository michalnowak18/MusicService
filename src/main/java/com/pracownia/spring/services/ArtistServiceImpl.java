package com.pracownia.spring.services;

import com.pracownia.spring.entities.Artist;
import com.pracownia.spring.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService{

    @Autowired
    private ArtistRepository ArtistRepository;

    @Override
    public Iterable<Artist> listAllArtists() {
        return ArtistRepository.findAll();
    }

    @Override
    public Optional<Artist> getArtistById(Integer id) {
        return ArtistRepository.findById(id);
    }

    @Override
    public Artist saveArtist(Artist artist) {
        return ArtistRepository.save(artist);
    }

    @Override
    public void deleteArtist(Integer id) {
        ArtistRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (ArtistRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }
}
