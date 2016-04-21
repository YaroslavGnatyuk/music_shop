package ua.gnatyuk.yaroslav.music_shop.web.admin;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.gnatyuk.yaroslav.music_shop.application.AlbumService;
import ua.gnatyuk.yaroslav.music_shop.application.ArtistService;
import ua.gnatyuk.yaroslav.music_shop.application.CategoryService;
import ua.gnatyuk.yaroslav.music_shop.application.StudioService;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Album;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Artist;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Studio;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by yaroslav on 4/6/16.
 */
@Controller
@RequestMapping("/admin")
public class DeleteController {
    @Inject
    CategoryService categoryService;
    @Inject
    AlbumService albumService;
    @Inject
    ArtistService artistService;
    @Inject
    StudioService studioService;

    @RequestMapping(path = "/delete-studio/{id}",method = RequestMethod.GET)
    public ModelAndView showStudios(@PathVariable("id") Long id){
        studioService.deleteStudio(studioService.findById(id));
        return new ModelAndView("admin/studio/studioMainPage").addObject("studios",studioService.getAll());
    }

    @RequestMapping(path = "/delete-artist/{id}",method = RequestMethod.GET)
    public ModelAndView deleteArtists (@PathVariable("id") Long id){
        artistService.deleteArtist(artistService.findById(id));
        List<Artist> artists = artistService.getAll();
        return new ModelAndView("admin/artist/artistMainPage").addObject("artists",artists);
    }

    @RequestMapping(path = "/delete-category/{id}",method = RequestMethod.GET)
    public ModelAndView deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(categoryService.findById(id));
        return new ModelAndView("admin/category/categoryMainPage").addObject("categories",categoryService.getAll());
    }

    @RequestMapping(path = "/delete-album/{id}", method = RequestMethod.GET)
    public ModelAndView showAlbum(@PathVariable("id") Long id){
        albumService.deleteAlbum(albumService.findById(id));
        return new ModelAndView("/admin/album/albumMainPage").addObject("albums",albumService.getAll());
    }
}
