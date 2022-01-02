package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Artist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArtistRepository extends CrudRepository<Artist, Integer> {

    List<Artist> findByName(String name);

    @Query("select count(*) from Artist p where p.id = ?1")
    Integer checkIfExist(Integer id);

}