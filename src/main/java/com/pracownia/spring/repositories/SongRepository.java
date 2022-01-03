package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Song;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SongRepository extends CrudRepository<Song, Integer> {

    List<Song> findByName(String name);

    @Query("select count(*) from Artist p where p.id = ?1")
    Integer checkIfExist(Integer id);
}
