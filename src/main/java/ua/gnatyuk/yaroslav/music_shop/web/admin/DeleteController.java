package ua.gnatyuk.yaroslav.music_shop.web.admin;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.gnatyuk.yaroslav.music_shop.application.ArtistService;
import ua.gnatyuk.yaroslav.music_shop.application.StudioService;

import javax.inject.Inject;

/**
 * Created by yaroslav on 4/6/16.
 */
@Controller
@RequestMapping("/admin")
public class DeleteController {
    @Inject
    ArtistService artistService;
    @Inject
    StudioService studioService;
    @Inject
    SessionFactory sessionFactory;

}
