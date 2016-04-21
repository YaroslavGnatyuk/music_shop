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
    @Inject
    SessionFactory sessionFactory;

    @RequestMapping(path = "/delete-studio",method = RequestMethod.GET)
    public ModelAndView showStudios(){
        List<Studio> result = studioService.getAll();
        return new ModelAndView("admin/studio/deleteStudio").addObject("result",result);
    }

    @RequestMapping(path = "/delete-studio",method = RequestMethod.POST)
    public ModelAndView deleteStudio(@RequestParam Map<String,String> request)
    {
        Set<Map.Entry<String,String>> allParam = request.entrySet();

        for (Map.Entry<String,String> map:allParam) {
            System.out.println(map.getKey() + " " + map.getValue());
        }

        for (Map.Entry<String,String> map:allParam) {
            String nameStudio = map.getValue();

            Studio studio = studioService.findByName(nameStudio);
            studioService.deleteStudio(studio);
        }

        return new ModelAndView("/admin/studio/deleteStudio").addObject("result",studioService.getAll());
    }

    @RequestMapping(path = "/delete-artist",method = RequestMethod.GET)
    public ModelAndView showArtists (){
        List<Artist> artists = artistService.getAll();
        return new ModelAndView("admin/artist/deleteArtist").addObject("artists",artists);
    }

    @RequestMapping(path = "/delete-artist",method = RequestMethod.POST)
    public ModelAndView deleteArtist(@RequestParam Map<String,String> request){
        Set<Map.Entry<String,String>> allParam = request.entrySet();

        for (Map.Entry<String,String> pare: allParam) {
            String name = pare.getValue();
            Artist artist = artistService.findByName(name);
            artistService.deleteArtist(artist);
        }

        List<Artist> artists = artistService.getAll();
        return new ModelAndView("admin/artist/deleteArtist").addObject("artists",artists);
    }

    @RequestMapping(path = "/delete-album", method = RequestMethod.GET)
    public ModelAndView showAlbum(){
        List<Album> albums = albumService.getAll();
        return new ModelAndView("/admin/album/deleteAlbum").addObject("albums",albums);
    }

    @RequestMapping(path = "/delete-album", method = RequestMethod.POST)
    public ModelAndView deleteAlbumCommit(@RequestParam Map<String,String> request){
        Set<Map.Entry<String,String>> allParam = request.entrySet();

        for (Map.Entry<String,String> pare: allParam) {
            String name = pare.getValue();
            Album album = albumService.findByName(name);
            albumService.deleteAlbum(album);
        }

        List<Album> albums = albumService.getAll();
        return new ModelAndView("/admin/album/deleteAlbum").addObject("albums",albums);
    }

    @RequestMapping(path = "/delete-category/{id}",method = RequestMethod.GET)
    public ModelAndView deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(categoryService.findById(id));
        return new ModelAndView("admin/category/categoryMainPage").addObject("categories",categoryService.getAll());
    }

}
