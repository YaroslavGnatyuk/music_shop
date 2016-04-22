package ua.gnatyuk.yaroslav.music_shop.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.gnatyuk.yaroslav.music_shop.application.AlbumService;
import ua.gnatyuk.yaroslav.music_shop.application.ArtistService;
import ua.gnatyuk.yaroslav.music_shop.application.CategoryService;
import ua.gnatyuk.yaroslav.music_shop.application.StudioService;
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
  StudioService studioService;
  @Inject
  AlbumService albumService;
  @Inject
  CategoryService categoryService;
  @Inject
  ArtistService artistService;

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
  public String showAdminMainPage(){
    return "/admin/adminMainPage";
  }

  @RequestMapping(path = "/category-main-page",method = RequestMethod.GET)
  public ModelAndView mainCategory(){
    return new ModelAndView("/admin/category/categoryMainPage")
            .addObject("categories",categoryService.getAll());
  }

  @RequestMapping(path = "/artist-main-page", method = RequestMethod.GET)
  public ModelAndView mainArtist(){
    return new ModelAndView("/admin/artist/artistMainPage")
            .addObject("artists",artistService.getAll());
  }

  @RequestMapping(path = "/album-main-page", method = RequestMethod.GET)
  public ModelAndView mainAlbum(){
    return new ModelAndView("/admin/album/albumMainPage")
            .addObject("albums",albumService.getAll());
  }

  @RequestMapping(path = "/studio-main-page", method = RequestMethod.GET)
  public ModelAndView mainStudio(){
    return new ModelAndView("/admin/studio/studioMainPage")
            .addObject("studios",studioService.getAll());
  }
}
