package ua.gnatyuk.yaroslav.music_shop.web.admin;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.gnatyuk.yaroslav.music_shop.application.ArtistService;
import ua.gnatyuk.yaroslav.music_shop.application.StudioService;
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
            String nameStudio = map.getValue();

            Studio studio = studioService.findByName(nameStudio);
            studioService.deleteStudio(studio);
        }

        return new ModelAndView("/admin/studio/deleteStudio").addObject("result",studioService.getAll());
    }

    @RequestMapping(path = "/delete-artist",method = RequestMethod.GET)
    ModelAndView showArtists (){
        List<Artist> artists = artistService.getAll();
        return new ModelAndView("admin/artist/deleteArtist").addObject("artists",artists);
    }
}
