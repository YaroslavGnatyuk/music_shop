package ua.gnatyuk.yaroslav.music_shop.web.admin;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.gnatyuk.yaroslav.music_shop.services.AlbumService;
import ua.gnatyuk.yaroslav.music_shop.services.ArtistService;
import ua.gnatyuk.yaroslav.music_shop.services.CategoryService;
import ua.gnatyuk.yaroslav.music_shop.services.StudioService;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Album;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Artist;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Category;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Studio;

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
    SessionFactory sessionFactory;



    @RequestMapping(path = "/find-studio-by-id",method = RequestMethod.POST)
    public ModelAndView findStudio(@RequestParam Map<String, String> map){

        Studio studio = studioService.findById(Long.parseLong(map.get("id")));
        System.out.println(studio);
        List<Studio> studios = new ArrayList<>();
        studios.add(studio);
        return new ModelAndView("admin/studio/studioMainPage").addObject("studios",studios);
    }

    @RequestMapping(path = "/find-album-by-id",method = RequestMethod.POST)
    public ModelAndView findAlbum(@RequestParam Map<String, String> map){

        Album album = albumService.findById(Long.parseLong(map.get("id")));
        List<Album> albums = new ArrayList<>();
        albums.add(album);

        return new ModelAndView("/admin/album/albumMainPage").addObject("albums",albums);
    }

    @RequestMapping(path = "/find-category-by-id", method = RequestMethod.POST)
    public ModelAndView findCategory(@RequestParam Map<String,String> map){

        Category category = categoryService.findById(Long.parseLong(map.get("id")));
        List<Category> categories = new ArrayList<Category>();
        categories.add(category);

        return new ModelAndView("/admin/category/categoryMainPage").addObject("categories",categories);
    }

    @RequestMapping(path="/find-artist-by-id", method = RequestMethod.POST)
    public ModelAndView findArtist(@RequestParam Map<String,String> request){

        Artist artist= artistService.findById(Long.parseLong(request.get("id")));

        List<Artist> artists= new ArrayList<>();
        artists.add(artist);
        return new ModelAndView("admin/artist/artistMainPage")
                .addObject("artists",artists);
    }
}
