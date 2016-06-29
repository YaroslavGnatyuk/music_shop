package ua.gnatyuk.yaroslav.music_shop.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Album;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Category;
import ua.gnatyuk.yaroslav.music_shop.services.AlbumService;
import ua.gnatyuk.yaroslav.music_shop.services.ArtistService;
import ua.gnatyuk.yaroslav.music_shop.services.CategoryService;
import ua.gnatyuk.yaroslav.music_shop.services.Page;
import ua.gnatyuk.yaroslav.music_shop.services.impl.PageImpl;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by yaroslav on 4/24/16.
 */
@Controller
@RequestMapping(path = "/user")
public class UserMainPage {
    @Inject
    AlbumService albumService;
    @Inject
    ArtistService artistService;
    @Inject
    CategoryService categoryService;
    @Inject
    Page page;

    @RequestMapping(path = "/main-page",method = RequestMethod.GET) //
    public ModelAndView userMainPage(){
        page.buildNewPage(Page.FIRST_PAGE, PageImpl.TypeOfMaterial.ALBUM);
        return new ModelAndView("/user/userMainPage")
                .addObject("page",page);
    }
}
