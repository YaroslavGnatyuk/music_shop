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
import ua.gnatyuk.yaroslav.music_shop.domain.user.User;

import javax.inject.Inject;

/**
 * @author leopold
 * @since 29/03/16
 */
@Controller
@RequestMapping(path = "/admin")
public class LoginController {
  @Inject
  ArtistService artistService;
  @Inject
  StudioService studioService;
  @Inject
  SessionFactory sessionFactory;

  @RequestMapping(method = RequestMethod.GET)
  public String login (@ModelAttribute("user") User user) {
    return "admin/login";
  }

  @RequestMapping(method = RequestMethod.POST)
  public ModelAndView checkLogin(@ModelAttribute("user")User user){
    if (user.getName().equals("admin") && user.getPassword().equals("admin")){
      return new ModelAndView("admin/adminMainPage") ;
    }
    else
      return new ModelAndView("admin/login");
  }


}
