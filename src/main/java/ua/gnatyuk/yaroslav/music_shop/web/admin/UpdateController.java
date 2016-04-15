package ua.gnatyuk.yaroslav.music_shop.web.admin;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
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
 * Created by yaroslav on 4/10/16.
 */
@Controller
@RequestMapping("/admin")
public class UpdateController {
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

    @RequestMapping(path = "/update-artist",method = RequestMethod.GET)
    public ModelAndView toUpdateArtist(){
        List<Studio> studios = studioService.getAll();
        List<Category> categories = categoryService.getAll();
        return new ModelAndView("admin/artist/updateArtist","command",new Artist())
                .addObject("studios",studios)
                .addObject("categories",categories);
    }

    @RequestMapping(path = "/update-artist",method = RequestMethod.POST)
    public ModelAndView updateArtistCommit(@ModelAttribute Artist artist, @RequestParam Map<String,String> request){
       if (artistService.findById(artist.getId()) != null){

           artist.setBirthday(LocalDate.parse(request.get("date")));
           artist.setCategory(categoryService.findByName(request.get("category.name")));
           artist.setStudio(studioService.findByName(request.get("studio.name")));

           artistService.updateArtist(artist);

           return new ModelAndView("/admin/artist/resultArtist").addObject("artist",artist);
       }
       else{
           return new ModelAndView("/admin/artist/resultArtist").addObject("messageAboutError","You should input correct id!");
       }
    }
}
