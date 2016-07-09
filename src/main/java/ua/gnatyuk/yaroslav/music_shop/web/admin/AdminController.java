package ua.gnatyuk.yaroslav.music_shop.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.gnatyuk.yaroslav.music_shop.domain.user.User;
import ua.gnatyuk.yaroslav.music_shop.domain.user.UserRole;
import ua.gnatyuk.yaroslav.music_shop.services.*;
import ua.gnatyuk.yaroslav.music_shop.services.impl.PageImpl;

import javax.inject.Inject;
import java.util.Set;

/**
 * @author leopold
 * @since 29/03/16
 */
@Controller
@RequestMapping(path = "/admin")
public class AdminController {
  @Inject
  private Page page;

  @RequestMapping(path = "/article-main-page")
  public ModelAndView mainArticle(){
    page.buildNewPage(Page.FIRST_PAGE, PageImpl.TypeOfMaterial.ARTICLE);
    return new ModelAndView("/admin/article/articleMainPage")
            .addObject("page",page);
  }

  @RequestMapping(path = "/user-main-page",method = RequestMethod.GET)
  public ModelAndView mainUser(){
    page.buildNewPage(Page.FIRST_PAGE, PageImpl.TypeOfMaterial.USER);
    return new ModelAndView("/admin/user/userMainPage")
             .addObject("page", page);
  }

  @RequestMapping(path = "/user-page-{id}",method = RequestMethod.GET)
  public ModelAndView userNavigate(@PathVariable("id") Integer id){

    page.buildNewPage(id, PageImpl.TypeOfMaterial.USER);

    return new ModelAndView("/admin/user/userMainPage")
            .addObject("page", page);
  }

  @RequestMapping(path = "/category-main-page",method = RequestMethod.GET)
  public ModelAndView mainCategory(){

    page.buildNewPage(Page.FIRST_PAGE, PageImpl.TypeOfMaterial.CATEGORY);
    return new ModelAndView("/admin/category/categoryMainPage")
            .addObject("page", page);
  }

  @RequestMapping(path = "/category-page-{id}",method = RequestMethod.GET)
  public ModelAndView categoryNavigate(@PathVariable("id") Integer id){

    page.buildNewPage(id, PageImpl.TypeOfMaterial.CATEGORY);
    return new ModelAndView("/admin/category/categoryMainPage")
            .addObject("page", page);
  }

  @RequestMapping(path = "/artist-main-page", method = RequestMethod.GET)
  public ModelAndView mainArtist(){
    page.buildNewPage(Page.FIRST_PAGE, PageImpl.TypeOfMaterial.ARTIST);
    return new ModelAndView("/admin/artist/artistMainPage")
            .addObject("page",page);
  }

  @RequestMapping(path = "/artist-page-{id}",method = RequestMethod.GET)
  public ModelAndView artistNavigate(@PathVariable("id") Integer id){
    page.buildNewPage(id, PageImpl.TypeOfMaterial.ARTIST);
    return new ModelAndView("/admin/artist/artistMainPage")
            .addObject("page", page);
  }

  @RequestMapping(path = "/album-main-page", method = RequestMethod.GET)
  public ModelAndView mainAlbum(){
    page.buildNewPage(Page.FIRST_PAGE, PageImpl.TypeOfMaterial.ALBUM);
    return new ModelAndView("/admin/album/albumMainPage")
            .addObject("page",page);
  }

  @RequestMapping(path = "/album-page-{id}",method = RequestMethod.GET)
  public ModelAndView albumNavigate(@PathVariable("id") Integer id){
    page.buildNewPage(id, PageImpl.TypeOfMaterial.ALBUM);
    return new ModelAndView("/admin/album/albumMainPage")
            .addObject("page", page);
  }

  @RequestMapping(path = "/studio-main-page", method = RequestMethod.GET)
  public ModelAndView mainStudio(){
    page.buildNewPage(Page.FIRST_PAGE, PageImpl.TypeOfMaterial.STUDIO);
    return new ModelAndView("/admin/studio/studioMainPage")
            .addObject("page",page);
  }

  @RequestMapping(path = "/studio-page-{id}",method = RequestMethod.GET)
  public ModelAndView studioNavigate(@PathVariable("id") Integer id){
    page.buildNewPage(id, PageImpl.TypeOfMaterial.STUDIO);
    return new ModelAndView("/admin/studio/studioMainPage")
            .addObject("page", page);
  }

}

@Controller
class LoginController {
  @RequestMapping(path = {"/login","/"}, method = RequestMethod.GET)
  public String main (@ModelAttribute("user")User user) {
    return "admin/login_form";
  }
 }