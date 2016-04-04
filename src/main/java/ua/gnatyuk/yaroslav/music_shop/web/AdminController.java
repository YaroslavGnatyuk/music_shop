package ua.gnatyuk.yaroslav.music_shop.web;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.gnatyuk.yaroslav.music_shop.application.ArtistService;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Artist;
import ua.gnatyuk.yaroslav.music_shop.domain.user.User;

import javax.inject.Inject;

/**
 * @author leopold
 * @since 29/03/16
 */
@Controller
@RequestMapping(path = "/admin")
public class AdminController {
  @Inject
  ArtistService artistService;
  @Inject
  SessionFactory sessionFactory;

  @RequestMapping(method = RequestMethod.GET)
  public String login (@ModelAttribute("user")User user) {
    System.out.println("In login");

    return "login";
  }

  @RequestMapping(method = RequestMethod.POST)
  public ModelAndView checkLogin(@ModelAttribute("user")User user){
    System.out.println("In check login");

    if (user.getName().equals("admin") && user.getPassword().equals("admin")){
      return new ModelAndView("adminMainPage") ;
    }
    else
      return new ModelAndView("login");
  }

  @RequestMapping(path="/find-artist-by-id", method = RequestMethod.GET)
  public ModelAndView findById(@ModelAttribute Artist artist){
    return new ModelAndView("findByID");
  }

  @RequestMapping(path="/find-artist-by-id", method = RequestMethod.POST)
  public ModelAndView showEntity(@ModelAttribute Artist artist){
    artist = artistService.findById(artist.getId());

    if(artist != null){
      return new ModelAndView("result").addObject("result",artist);
    }
    else
      return new ModelAndView("findByID");
  }
}
