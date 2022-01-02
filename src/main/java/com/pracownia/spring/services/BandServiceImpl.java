package com.pracownia.spring.services;

import com.pracownia.spring.entities.Album;
import com.pracownia.spring.entities.Band;
import com.pracownia.spring.repositories.AlbumRepository;
import com.pracownia.spring.repositories.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BandServiceImpl implements BandService {

    @Autowired
    private BandRepository BandRepository;

    @Autowired
    private AlbumRepository AlbumRepository;

    @Override
    public Iterable<Band> listAllBands() {
        return BandRepository.findAll();
    }

    @Override
    public Optional<Band> getBandById(Integer id) {
        return BandRepository.findById(id);
    }

    @Override
    public Band saveBand(Band Band) {
        return BandRepository.save(Band);
    }

    @Override
    public void deleteBand(Integer id) {
        BandRepository.deleteById(id);
    }

    @Override
    public List<Band> getByName(String name) {
        return BandRepository.findByName(name);
    }

    @Override
    public Integer getNumberOfAlbums(Integer id) {
        return BandRepository.countAlbumsById(id);
    }

}
