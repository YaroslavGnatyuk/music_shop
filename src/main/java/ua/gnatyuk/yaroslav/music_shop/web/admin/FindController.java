package ua.gnatyuk.yaroslav.music_shop.web.admin;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.gnatyuk.yaroslav.music_shop.application.ArtistService;
import ua.gnatyuk.yaroslav.music_shop.application.StudioService;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Artist;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Studio;

import javax.inject.Inject;

/**
 * Created by yaroslav on 4/6/16.
 */
@Controller
@RequestMapping(path = "/admin")
public class FindController {
    @Inject
    ArtistService artistService;
    @Inject
    StudioService studioService;
    @Inject
    SessionFactory sessionFactory;

    @RequestMapping(path="/find-artist-by-id", method = RequestMethod.GET)
    public ModelAndView findArtistById(){
        return new ModelAndView("admin/artist/findArtistById","command",new Artist());
    }

    @RequestMapping(path="/artist", method = RequestMethod.POST)
    public ModelAndView showArtist(@ModelAttribute Artist artist, ModelMap model){

        Artist searchArtist = artistService.findById(artist.getId());

        if(searchArtist != null){
            model.addAttribute("artist", searchArtist);
            return new ModelAndView("admin/artist/resultArtist");
        }
        else
            return new ModelAndView("admin/artist/findArtistById","command" , new Artist());
    }

    @RequestMapping(path = "/find-studio-by-id",method = RequestMethod.GET)
    public ModelAndView findStudioById(){
        return new ModelAndView("admin/studio/findStudioById","command",new Studio());
    }

    @RequestMapping(path = "/studio",method = RequestMethod.POST)
    public ModelAndView showStudio(@ModelAttribute Studio studio, ModelMap model){
        Studio searchStudio = studioService.findById(studio.getId());

        if(searchStudio != null){
            model.addAttribute("result",searchStudio);
            return new ModelAndView("admin/studio/resultStudio");
        }
        else
            return new ModelAndView("admin/studio/findStudioById","command",new Studio());
    }
}
