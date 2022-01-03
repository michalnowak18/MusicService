package com.pracownia.spring.services;

import com.pracownia.spring.entities.Song;
import java.util.Optional;

public interface SongService {

    Iterable<Song> listAllSongs();

    Optional<Song> getSongById(Integer id);

    Song saveSong(Song Song);

    void deleteSong(Integer id);

    Boolean checkIfExist(Integer id);
}
