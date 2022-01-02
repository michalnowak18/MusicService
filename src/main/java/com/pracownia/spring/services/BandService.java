package com.pracownia.spring.services;

import com.pracownia.spring.entities.Band;

import java.util.List;
import java.util.Optional;

public interface BandService {

    Iterable<Band> listAllBands();

    Optional<Band> getBandById(Integer id);

    Band saveBand(Band Band);

    void deleteBand(Integer id);

    List<Band> getByName(String name);

    Integer getNumberOfAlbums(Integer id);
}
