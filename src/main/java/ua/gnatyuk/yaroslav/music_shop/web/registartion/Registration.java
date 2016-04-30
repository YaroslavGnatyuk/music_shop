package ua.gnatyuk.yaroslav.music_shop.web.registartion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.gnatyuk.yaroslav.music_shop.domain.user.User;

/**
 * Created by yaroslav on 4/30/16.
 */
@Controller
@RequestMapping(path = "/registration")
public class Registration {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView registration(){
        return new ModelAndView("/registration/registration_form","user", new User());
    }
}
