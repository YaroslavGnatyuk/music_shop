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
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Category;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Studio;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Created by yaroslav on 4/10/16.
 */
@Controller
@RequestMapping("/admin")
public class UpdateController {
    @Inject
    AlbumService albumService;
    @Inject
    ArtistService artistService;
    @Inject
    StudioService studioService;
    @Inject
    CategoryService categoryService;
    @Inject
    SessionFactory sessionFactory;

    @RequestMapping(path = "/update-studio",method = RequestMethod.GET)
    public ModelAndView toUpdateStudio(){
        return new ModelAndView("admin/studio/updateStudio","command",new Studio())
                .addObject("aboutUpdatePage",new String("Input id of the studio for update"));
    }

    @RequestMapping(path = "/update-studio",method = RequestMethod.POST)
    public ModelAndView updateStudioCommit(@ModelAttribute Studio studio){
       if(studioService.findById(studio.getId()) != null){
           System.out.println("Created studio!");
           studioService.updateStudio(studio);

           return new ModelAndView("admin/studio/updateStudio","command",studio)
                   .addObject("aboutUpdatePage",new String("Input id of the studio for update"));
       }
        else{
           System.out.println("Didn't create studio!");
           return new ModelAndView("admin/studio/updateStudio","command",studio)
                   .addObject("aboutUpdatePage",new String("input other id! Previous doesn't exist!"));
       }
    }



    @RequestMapping(path = "/update-album/{id}", method = RequestMethod.GET)
    public ModelAndView inputAlbum(@PathVariable("id") Long id){
        Album album = albumService.findById(id);

        List<Studio> studios = studioService.getAll();
        List<Category> categories = categoryService.getAll();
        List<Artist> artists = artistService.getAll();

        return new ModelAndView("/admin/album/updateAlbum","command", album)
                .addObject("studios",studios)
                .addObject("categories",categories)
                .addObject("artists",artists);
    }

    @RequestMapping(path = "/update-album/{id}", method = RequestMethod.POST)
    public ModelAndView updateAlbumCommit(@ModelAttribute Album album, @RequestParam Map<String,String> request){

        LocalDate date = LocalDate.parse(request.get("date"));
        Studio studio = studioService.findByName(album.getStudio().getName());
        Category category = categoryService.findByName(album.getCategory().getName());
        Artist artist = artistService.findByName(album.getArtist().getName());

        album.setStudio(studio);
        album.setCategory(category);
        album.setArtist(artist);
        album.setReleaseDate(date);

        albumService.updateAlbum(album);

        return new ModelAndView("/admin/album/albumMainPage").addObject("albums",albumService.getAll());
    }

    @RequestMapping(path = "/update-category/{id}",method = RequestMethod.GET)
    public ModelAndView updateCategory(@PathVariable("id") Long id){
            Category category = categoryService.findById(id);
        return new ModelAndView("/admin/category/updateCategory","command", category);
    }

    @RequestMapping(path = "/update-category/{id}",method = RequestMethod.POST)
    public ModelAndView updateCategoryCommit(@ModelAttribute Category category){
        categoryService.updateCategory(category);
        return new ModelAndView("/admin/category/categoryMainPage")
                .addObject("categories", categoryService.getAll());
    }

    @RequestMapping(path = "/update-artist/{id}",method = RequestMethod.GET)
    public ModelAndView updateArtist(@PathVariable("id")Long id){
        Artist artist = artistService.findById(id);
        List<Studio> studios = studioService.getAll();
        List<Category> categories = categoryService.getAll();
        return new ModelAndView("admin/artist/updateArtist","command",artist)
                .addObject("studios",studios)
                .addObject("categories",categories);
    }

    @RequestMapping(path = "/update-artist/{id}",method = RequestMethod.POST)
    public ModelAndView updateArtistCommit(@ModelAttribute Artist artist, @RequestParam Map<String,String> request){
        artist.setBirthday(LocalDate.parse(request.get("date")));
        artist.setCategory(categoryService.findByName(request.get("category.name")));
        artist.setStudio(studioService.findByName(request.get("studio.name")));

        artistService.updateArtist(artist);

        return new ModelAndView("/admin/artist/artistMainPage").addObject("artists",artistService.getAll());
    }

}
