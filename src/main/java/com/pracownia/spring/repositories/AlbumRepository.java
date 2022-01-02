package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Album;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

public interface AlbumRepository extends CrudRepository<Album, Integer>, PagingAndSortingRepository<Album, Integer>  {

    @Query("select count(*) from Album p where p.id = ?1")
    Integer checkIfExist(Integer id);
}
