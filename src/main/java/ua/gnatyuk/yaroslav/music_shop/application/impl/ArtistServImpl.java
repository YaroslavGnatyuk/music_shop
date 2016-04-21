package ua.gnatyuk.yaroslav.music_shop.application.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.gnatyuk.yaroslav.music_shop.application.ArtistService;
import ua.gnatyuk.yaroslav.music_shop.dao.DaoPersist;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Artist;

import java.util.List;

/**
 * Created by yaroslav on 31.03.16.
 */
@Service
public class ArtistServImpl implements ArtistService {
    @Autowired
    @Qualifier(value = "artistDAO")
    DaoPersist<Artist> daoArtist;

    @Transactional
    @Override
    public Artist findById(Long id) {
        return daoArtist.findById(id);
    }

    @Transactional
    @Override
    public Artist findByName(String nameOfTheStudio) {
        return daoArtist.findByName(nameOfTheStudio);
    }

    @Transactional
    @Override
    public void createArtist(Artist artist) {
        daoArtist.create(artist);
    }

    @Transactional
    @Override
    public void updateArtist(Artist artist) {
        daoArtist.update(artist);
    }

    @Transactional
    @Override
    public void deleteArtist(Artist artist) {
        daoArtist.delete(artist);
    }

    @Transactional
    @Override
    public List<Artist> getAll() {
        return daoArtist.getAll();
    }
}
