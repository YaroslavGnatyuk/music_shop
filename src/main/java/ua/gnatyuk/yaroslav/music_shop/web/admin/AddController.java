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
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Studio;

import javax.inject.Inject;

/**
 * Created by yaroslav on 4/6/16.
 */

@Controller
@RequestMapping("/admin")
public class AddController {
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

}
