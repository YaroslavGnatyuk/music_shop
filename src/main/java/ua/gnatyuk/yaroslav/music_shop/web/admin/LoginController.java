package ua.gnatyuk.yaroslav.music_shop.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.gnatyuk.yaroslav.music_shop.domain.user.User;

/**
 * @author leopold
 * @since 29/03/16
 */
@Controller
@RequestMapping(path = "/admin")
public class LoginController {
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

  @RequestMapping(path = "/admin-main-page",method = RequestMethod.GET)
  public String toAdminMainPage () {
    return "admin/adminMainPage";
  }

  @RequestMapping(path = "/artist-main-page",method = RequestMethod.GET)
  public String toArtistMainPage () {
    return "admin/artist/artistMainPage";
  }

  @RequestMapping(path = "/album-main-page",method = RequestMethod.GET)
  public String toAlbumMainPage () {
    return "admin/album/albumMainPage";
  }

  @RequestMapping(path = "/studio-main-page",method = RequestMethod.GET)
  public ModelAndView toStudioMainPage () {
    return new ModelAndView("admin/studio/studioMainPage");
  }
}
