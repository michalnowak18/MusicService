package com.pracownia.spring.services;

import com.pracownia.spring.entities.Song;
import com.pracownia.spring.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongServiceImpl implements SongService{

    @Autowired
    private SongRepository SongRepository;

    @Override
    public Iterable<Song> listAllSongs() {
        return SongRepository.findAll();
    }

    @Override
    public Optional<Song> getSongById(Integer id) {
        return SongRepository.findById(id);
    }

    @Override
    public Song saveSong(Song Song) {
        return SongRepository.save(Song);
    }

    @Override
    public void deleteSong(Integer id) {
        SongRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (SongRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }
}
