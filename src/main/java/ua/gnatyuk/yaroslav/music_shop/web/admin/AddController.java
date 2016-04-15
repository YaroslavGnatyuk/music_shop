package ua.gnatyuk.yaroslav.music_shop.web.admin;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.gnatyuk.yaroslav.music_shop.application.ArtistService;
import ua.gnatyuk.yaroslav.music_shop.application.CategoryService;
import ua.gnatyuk.yaroslav.music_shop.application.StudioService;
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
    SessionFactory sessionFactory;

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
        String date = new String();
        String studio = new String();
        String category = new String();
        List<Category> categories = categoryService.getAll();
        List<Studio> studios = studioService.getAll();

        map.addAttribute("categories",categories)
                .addAttribute("studios",studios)
                .addAttribute("date",date)
                .addAttribute("studio",studio)
                .addAttribute("category",category);

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

        return new ModelAndView("/admin/artist/resultArtist").addObject("artist",artist);
    }


}
