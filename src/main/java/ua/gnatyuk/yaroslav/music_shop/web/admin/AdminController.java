package ua.gnatyuk.yaroslav.music_shop.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.gnatyuk.yaroslav.music_shop.services.*;
import ua.gnatyuk.yaroslav.music_shop.domain.user.User;
import ua.gnatyuk.yaroslav.music_shop.services.impl.PaginationImpl;

import javax.inject.Inject;

/**
 * @author leopold
 * @since 29/03/16
 */
@Controller
@RequestMapping(path = "/admin")
public class AdminController {
  @Inject
  StudioService studioService;
  @Inject
  AlbumService albumService;
  @Inject
  CategoryService categoryService;
  @Inject
  ArtistService artistService;
  @Inject
  Pagination pagination;

  @RequestMapping(path = "/category-main-page",method = RequestMethod.GET)
  public ModelAndView mainCategory(){
    pagination.buildNewPage(1,PaginationImpl.TypeOfMaterial.CATEGORY);
    return new ModelAndView("/admin/category/categoryMainPage")
            .addObject("pagenation",pagination);
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

@Controller
@RequestMapping(path = "/login")
class LoginController {
  @RequestMapping( method = RequestMethod.GET)
  public String main (@ModelAttribute("user")User user) {
    return "admin/login_form";
  }
}