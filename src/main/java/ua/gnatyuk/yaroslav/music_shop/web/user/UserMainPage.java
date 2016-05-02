package ua.gnatyuk.yaroslav.music_shop.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yaroslav on 4/24/16.
 */
@Controller
@RequestMapping(path = "/")
public class UserMainPage {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView userMainPage(){
        return new ModelAndView("/user/userMainPage").addObject("myVariable",new Integer(10));
    }
}
