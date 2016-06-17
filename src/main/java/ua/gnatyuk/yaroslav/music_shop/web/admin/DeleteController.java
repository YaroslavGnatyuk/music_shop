package ua.gnatyuk.yaroslav.music_shop.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Album;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Category;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Studio;
import ua.gnatyuk.yaroslav.music_shop.domain.user.User;
import ua.gnatyuk.yaroslav.music_shop.services.*;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Artist;
import ua.gnatyuk.yaroslav.music_shop.services.impl.PageImpl;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by yaroslav on 4/6/16.
 */
@Controller
@RequestMapping("/admin")
public class DeleteController {
    @Inject
    UserService userService;
    @Inject
    CategoryService categoryService;
    @Inject
    AlbumService albumService;
    @Inject
    ArtistService artistService;
    @Inject
    StudioService studioService;
    @Inject
    Page page;

    @RequestMapping(path = "/delete-user/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(userService.findUserById(id));
        page.buildNewPage(Page.FIRST_PAGE, PageImpl.TypeOfMaterial.USER);

        return new ModelAndView("admin/user/userMainPage").addObject("page",page);
    }

    @RequestMapping(path = "/delete-studio/{id}",method = RequestMethod.GET)
    public ModelAndView deleteStudio(@PathVariable("id") Long id){
        Studio studio = studioService.findById(id);
        page.setResultOfAction(studio,PageImpl.TypeOfMaterial.STUDIO);
        studioService.deleteStudio(studio);

        return new ModelAndView("admin/studio/studioMainPage").addObject("page",page);
    }

    @RequestMapping(path = "/delete-artist/{id}",method = RequestMethod.GET)
    public ModelAndView deleteArtists (@PathVariable("id") Long id){
        Artist artist = artistService.findById(id);
        page.setResultOfAction(artist, PageImpl.TypeOfMaterial.ARTIST);
        artistService.deleteArtist(artist);

        return new ModelAndView("admin/artist/artistMainPage").addObject("page",page);
    }

    @RequestMapping(path = "/delete-category/{id}",method = RequestMethod.GET)
    public ModelAndView deleteCategory(@PathVariable("id") Long id){
        Category category = categoryService.findById(id);
        page.setResultOfAction(category, PageImpl.TypeOfMaterial.CATEGORY);
        categoryService.deleteCategory(category);

        return new ModelAndView("admin/category/categoryMainPage").addObject("page",page);
    }

    @RequestMapping(path = "/delete-album/{id}", method = RequestMethod.GET)
    public ModelAndView showAlbum(@PathVariable("id") Long id){
        Album album = albumService.findById(id);
        page.setResultOfAction(album, PageImpl.TypeOfMaterial.ALBUM);
        albumService.deleteAlbum(album);

        return new ModelAndView("/admin/album/albumMainPage").addObject("page",page);
    }
}
