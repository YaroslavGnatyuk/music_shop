package ua.gnatyuk.yaroslav.music_shop.application.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.gnatyuk.yaroslav.music_shop.application.StudioService;
import ua.gnatyuk.yaroslav.music_shop.dao.DaoPersist;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Studio;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by yaroslav on 31.03.16.
 */
@Service
public class StudioServImpl implements StudioService{

    /*@Autowired
    @Qualifier(value = "studioDAO")*/
    @Inject
    @Named(value = "studioDAO")
    DaoPersist<Studio> daoStudio;

    @Transactional
    @Override
    public Studio findById(Long id) {
        return daoStudio.findById(id);
    }

    @Transactional
    @Override
    public Studio findByName(String nameOfTheStudio) {
        return daoStudio.findByName(nameOfTheStudio);
    }
}
