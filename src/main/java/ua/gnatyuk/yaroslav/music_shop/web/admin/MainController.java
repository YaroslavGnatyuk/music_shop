package ua.gnatyuk.yaroslav.music_shop.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.gnatyuk.yaroslav.music_shop.application.CategoryService;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Category;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by yaroslav on 4/20/16.
 */
@Controller
@RequestMapping(path = "/admin")
public class MainController {
    @Inject
    CategoryService categoryService;
    @RequestMapping(path = "/category-main-page",method = RequestMethod.GET)
    public ModelAndView mainCategory(){
        List<Category> categories = categoryService.getAll();

        return new ModelAndView("/admin/category/categoryMainPage")
                .addObject("categories",categories)
                .addObject("pages",categories.size());
    }
}
