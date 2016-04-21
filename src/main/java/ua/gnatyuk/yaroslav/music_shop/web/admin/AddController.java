package ua.gnatyuk.yaroslav.music_shop.web.admin;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.gnatyuk.yaroslav.music_shop.application.AlbumService;
import ua.gnatyuk.yaroslav.music_shop.application.ArtistService;
import ua.gnatyuk.yaroslav.music_shop.application.CategoryService;
import ua.gnatyuk.yaroslav.music_shop.application.StudioService;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Album;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Artist;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Category;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Studio;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Created by yaroslav on 4/6/16.
 */

@Controller
@RequestMapping("/admin")
public class AddController {
    @Inject
    CategoryService categoryService;
    @Inject
    ArtistService artistService;
    @Inject
    StudioService studioService;
    @Inject
    AlbumService albumService;

    @RequestMapping(path = "/add-studio",method = RequestMethod.GET)
    public ModelAndView addStudio(){
        return new ModelAndView("admin/studio/addStudio","command", new Studio());
    }

    @RequestMapping(path = "/add-studio",method = RequestMethod.POST)
    public ModelAndView confirmAddStudio(@ModelAttribute Studio studio, ModelMap model){
        studioService.createStudio(studio);
        model.addAttribute("result",studio);

        return new ModelAndView("/admin/studio/resultStudio");
    }

    @RequestMapping(path = "/add-artist",method = RequestMethod.GET)
    public ModelAndView addArtist(ModelMap map){
        List<Category> categories = categoryService.getAll();
        List<Studio> studios = studioService.getAll();

        map.addAttribute("categories",categories)
                .addAttribute("studios",studios);

        return new ModelAndView("/admin/artist/addArtist","command",new Artist()).addAllObjects(map);
    }

    @RequestMapping(path = "/add-artist",method = RequestMethod.POST)
    public ModelAndView confirmAddArtist(@ModelAttribute Artist artist, @RequestParam Map<String, String> request){

        Studio studio = studioService.findByName(request.get("studio.name"));
        Category category = categoryService.findByName(request.get("category.name"));
        LocalDate date = LocalDate.parse(request.get("date"));

        artist.setBirthday(date);
        artist.setCategory(category);
        artist.setStudio(studio);

        artistService.createArtist(artist);

        return new ModelAndView("/admin/artist/artistMainPage").addObject("artists",artistService.getAll());
    }

    @RequestMapping(path = "/add-album",method = RequestMethod.GET)
    public ModelAndView addAlbum(ModelMap modelMap){
        List<Studio> studios = studioService.getAll();
        List<Artist> artists = artistService.getAll();
        List<Category> categories = categoryService.getAll();

        modelMap.addAttribute("studios",studios)
            .addAttribute("artists",artists)
            .addAttribute("categories",categories);
        return new ModelAndView("/admin/album/addAlbum","command", new Album()).addAllObjects(modelMap);
    }

    @RequestMapping(path = "/add-album",method = RequestMethod.POST)
    public ModelAndView confirmAddAlbum(@ModelAttribute Album album, @RequestParam Map<String, String> request){
        Studio studio = studioService.findByName(request.get("studio.name"));
        Artist artist = artistService.findByName(request.get("artist.name"));
        Category category = categoryService.findByName(request.get("category.name"));
        LocalDate date = LocalDate.parse(request.get("date"));

        album.setReleaseDate(date);
        album.setStudio(studio);
        album.setArtist(artist);
        album.setCategory(category);

        albumService.createAlbum(album);

        return new ModelAndView("/admin/album/albumMainPage").addObject("albums",albumService.getAll());
    }

    @RequestMapping(path = "/add-category",method = RequestMethod.GET)
    public ModelAndView addCategory(){
        return new ModelAndView("/admin/category/addCategory","command", new Category());
    }

    @RequestMapping(path = "/add-category",method = RequestMethod.POST)
    public ModelAndView addCategoryConfirm(@ModelAttribute Category category){
        categoryService.createCategory(category);
        List<Category> categories = categoryService.getAll();
        return new ModelAndView("/admin/category/categoryMainPage").addObject("categories",categories);
    }
}
