package ua.gnatyuk.yaroslav.music_shop.web.admin;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.gnatyuk.yaroslav.music_shop.services.*;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Album;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Artist;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Category;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Studio;
import ua.gnatyuk.yaroslav.music_shop.services.impl.PageImpl;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yaroslav on 4/6/16.
 */
@Controller
@RequestMapping(path = "/admin")
public class FindController {
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
    @Inject
    SessionFactory sessionFactory;

    @RequestMapping(path = "/find-studio-by-id",method = RequestMethod.POST)
    public ModelAndView findStudio(@RequestParam Map<String, String> map){
        Studio studio = studioService.findById(Long.parseLong(map.get("id")));
        page.setResultOfAction(studio, PageImpl.TypeOfMaterial.STUDIO);

        return new ModelAndView("admin/studio/studioMainPage").addObject("page",page);
    }

    @RequestMapping(path = "/find-album-by-id",method = RequestMethod.POST)
    public ModelAndView findAlbum(@RequestParam Map<String, String> map){
        Album album = albumService.findById(Long.parseLong(map.get("id")));
        page.setResultOfAction(album, PageImpl.TypeOfMaterial.ALBUM);

        return new ModelAndView("/admin/album/albumMainPage").addObject("page",page);
    }

    @RequestMapping(path = "/find-category-by-id", method = RequestMethod.POST)
    public ModelAndView findCategory(@RequestParam Map<String,String> map){

        Category category = categoryService.findById(Long.parseLong(map.get("id")));
        page.setResultOfAction(category, PageImpl.TypeOfMaterial.CATEGORY);

        return new ModelAndView("/admin/category/categoryMainPage").addObject("page",page);
    }

    @RequestMapping(path="/find-artist-by-id", method = RequestMethod.POST)
    public ModelAndView findArtist(@RequestParam Map<String,String> request){

        Artist artist= artistService.findById(Long.parseLong(request.get("id")));
        page.setResultOfAction(artist, PageImpl.TypeOfMaterial.ARTIST);
        return new ModelAndView("admin/artist/artistMainPage").addObject("page",page);
    }
}
