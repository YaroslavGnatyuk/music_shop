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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaroslav on 4/30/16.
 */
@Controller
@RequestMapping(path = "/registration")
public class Registration {
    Boolean regSuccessful;
    List<String> warnings = new ArrayList<>(2);
    private static final String EMAIL_EXIST = new String("This email already exists");
    private static final String NAME_EXIST = new String("This name already exists");
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
        warnings.clear();

        String username = user.getUsername();
        String email = user.getEmail();
        if(userService.isExistThisEmail(email) || userService.isExistThisUsername(username)) {
            if (userService.isExistThisEmail(email))
                warnings.add(EMAIL_EXIST);
            if (userService.isExistThisUsername(username))
                warnings.add(NAME_EXIST);
            regSuccessful = false;
            return new ModelAndView("/registration/registration_form","user", new UserDto())
                    .addObject("emailExist", warnings.get(0))
                    .addObject("nameExist", warnings.get(1))
                    .addObject("registration",regSuccessful);
        }
        else{
            regSuccessful = true;
            newUser.createUserByUserDto(user);
            return new ModelAndView("/registration/registration_form","user", new UserDto())
                    .addObject("registration",regSuccessful);
        }
    }
}
