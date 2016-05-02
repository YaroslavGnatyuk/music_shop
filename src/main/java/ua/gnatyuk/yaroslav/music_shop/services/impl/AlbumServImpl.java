package ua.gnatyuk.yaroslav.music_shop.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.gnatyuk.yaroslav.music_shop.services.AlbumService;
import ua.gnatyuk.yaroslav.music_shop.dao.DaoPersist;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Album;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by yaroslav on 31.03.16.
 */
@Service
public class AlbumServImpl implements AlbumService{
    @Inject
    @Named(value = "albumDao")
    DaoPersist<Album> daoAlbum;

    @Transactional
    @Override
    public Album findById(Long id) {
        return daoAlbum.findById(id);
    }

    @Transactional
    @Override
    public Album findByName(String nameOfTheStudio) {
        return daoAlbum.findByName(nameOfTheStudio);
    }

    @Transactional
    @Override
    public void createAlbum(Album album) {
        daoAlbum.create(album);
    }

    @Transactional
    @Override
    public void updateAlbum(Album album) {
        daoAlbum.update(album);
    }

    @Transactional
    @Override
    public void deleteAlbum(Album album) {
        daoAlbum.delete(album);
    }

    @Transactional
    @Override
    public List<Album> getAll() {
        return daoAlbum.getAll();
    }

    @Transactional
    @Override
    public long getCountAllAlbums() {
        return daoAlbum.getTotalRecords();
    }
}
