package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Album;
import com.pracownia.spring.entities.Band;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BandRepository extends CrudRepository<Band, Integer> {

    List<Band> findByName(String name);

    @Query("select count(*) from Band s join s.albumsOb p where s.id = ?1")
    Integer countAlbumsById(Integer id);
}
