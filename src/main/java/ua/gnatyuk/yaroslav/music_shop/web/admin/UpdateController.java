package ua.gnatyuk.yaroslav.music_shop.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.gnatyuk.yaroslav.music_shop.services.*;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Album;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Artist;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Category;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Studio;
import ua.gnatyuk.yaroslav.music_shop.services.impl.PageImpl;

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
    Page page;

    @RequestMapping(path = "/update-studio/{id}",method = RequestMethod.GET)
    public ModelAndView toUpdateStudio(@PathVariable("id") Long id){
        return new ModelAndView("admin/studio/updateStudio","command",studioService.findById(id));
    }

    @RequestMapping(path = "/update-studio/{id}",method = RequestMethod.POST)
    public ModelAndView updateStudioCommit(@ModelAttribute Studio studio){
        page.setResultOfAction(studio,PageImpl.TypeOfMaterial.STUDIO);
       studioService.updateStudio(studio);
       return new ModelAndView("admin/studio/studioMainPage").addObject("page",page);
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

        page.setResultOfAction(album, PageImpl.TypeOfMaterial.ALBUM);
        albumService.updateAlbum(album);

        return new ModelAndView("/admin/album/albumMainPage").addObject("page",page);
    }

    @RequestMapping(path = "/update-category/{id}",method = RequestMethod.GET)
    public ModelAndView updateCategory(@PathVariable("id") Long id){
            Category category = categoryService.findById(id);
        return new ModelAndView("/admin/category/updateCategory","command", category);
    }

    @RequestMapping(path = "/update-category/{id}",method = RequestMethod.POST)
    public ModelAndView updateCategoryCommit(@ModelAttribute Category category){
        categoryService.updateCategory(category);
        page.setResultOfAction(category, PageImpl.TypeOfMaterial.CATEGORY);
        return new ModelAndView("/admin/category/categoryMainPage")
                .addObject("page", page);
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

        page.setResultOfAction(artist, PageImpl.TypeOfMaterial.ARTIST);
        artistService.updateArtist(artist);

        return new ModelAndView("/admin/artist/artistMainPage").addObject("page",page);
    }

}
