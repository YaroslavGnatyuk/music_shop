package ua.gnatyuk.yaroslav.music_shop.application;

import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Studio;

/**
 * Created by yaroslav on 31.03.16.
 */
public interface StudioService {
    Studio findById(Long id);
    Studio findByName(String nameOfTheStudio);
}
