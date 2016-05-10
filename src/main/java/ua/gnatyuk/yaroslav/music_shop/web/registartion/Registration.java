package ua.gnatyuk.yaroslav.music_shop.web.registartion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.gnatyuk.yaroslav.music_shop.dao.user.CreateUserByUserDto;
import ua.gnatyuk.yaroslav.music_shop.domain.user.UserDto;
import ua.gnatyuk.yaroslav.music_shop.services.UserService;

import javax.inject.Inject;

/**
 * Created by yaroslav on 4/30/16.
 */
@Controller
@RequestMapping(path = "/registration")
public class Registration {
    Boolean[] message; // [0] - email already exist, [1] - username already exist, [2] - registration complete successful

    @Inject
    UserService userService;
    @Inject
    CreateUserByUserDto newUser;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView registration(){
        return new ModelAndView("/registration/registration_form","user", new UserDto());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView registrationComplete(@ModelAttribute("user") UserDto user){

        String username = user.getUsername();
        String email = user.getEmail();

        boolean existEmail = userService.existThisEmail(email);
        boolean existName = userService.existThisUsername(username);

        message = new Boolean[3];

        if(existEmail || existName) {
            if (existName) {
                message[0] = true;
            }
            if (existEmail) {
                message[1] = true;
            }
            message[2] = false;
            return new ModelAndView("/registration/registration_form","user", new UserDto())
                    .addObject("message", message);
        }
        else{
            message[2] = true;
            newUser.createUserByUserDto(user);
            return new ModelAndView("/registration/registration_form","user", new UserDto()).addObject("warnings", message);
        }
    }
}
