package ua.gnatyuk.yaroslav.music_shop.web.registartion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.gnatyuk.yaroslav.music_shop.dao.user.NewUser;
import ua.gnatyuk.yaroslav.music_shop.domain.user.UserDto;
import ua.gnatyuk.yaroslav.music_shop.services.RegistrationService;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by yaroslav on 4/30/16.
 */
@Controller
@RequestMapping(path = "/registration")
public class Registration {
    private Boolean[] message;           // [0] - email already exist,
                                           // [1] - username already exist,
                                           // [2] - registration complete successful
                                           // [3] - Validation of the user was failed
                                           // [4] - .......
    private Boolean[] validationMessage;   // [0] - email already exist,
                                           // [1] - username already exist,
                                           // [2] - registration complete successful
                                           // [3] - Validation of the user was failed
                                           // [4] - .......
    @Inject
    RegistrationService registrationService;
    @Inject
    NewUser newUser;

    Validator userValidator;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView registration(){
        return new ModelAndView("/registration/registration_form","command", new UserDto());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView registrationComplete(@ModelAttribute(value = "command") UserDto user){
        System.out.println(user);

        message = new Boolean[5];

        boolean existEmail = registrationService.existThisEmail(user.getEmail());
        boolean existName = registrationService.existThisUsername(user.getUsername());

        if(existEmail || existName || !isUserValid(user)) {
            if (existName) {
                message[0] = true;
            }
            if (existEmail) {
                message[1] = true;
            }
            if(!isUserValid(user)){
                fillMessageValidate(user);
                return new ModelAndView("/registration/registration_form","user", user)
                        .addObject("validationMessage", validationMessage);
            }
            message[2] = false;
            return new ModelAndView("/registration/registration_form","user", user)
                    .addObject("message", message);
        }
        else{
            message[2] = true;
            newUser.createNewUser(user);
            return new ModelAndView("/admin/login_form");
        }
    }

    private boolean isUserValid(UserDto user){
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        userValidator = validatorFactory.getValidator();

        userValidator.validate(user).forEach(System.out::println);

        return userValidator.validate(user).isEmpty() ? true : false;
    }

    private void fillMessageValidate(UserDto userDto){
        validationMessage = new Boolean[5];
        for (int i = 0; i < validationMessage.length; i++) {
            validationMessage[i]=false;
        }

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        userValidator = validatorFactory.getValidator();

        Set<ConstraintViolation<UserDto>> violations = userValidator.validate(userDto);
        Iterator iterator = violations.iterator();
        while(iterator.hasNext()){
            ConstraintViolation<UserDto> userDtoConstraintViolation = (ConstraintViolation<UserDto>) iterator.next();

            if(userDtoConstraintViolation.getPropertyPath().toString().equals("username")){
                validationMessage[0] = true;
            }

            if(userDtoConstraintViolation.getPropertyPath().toString().equals("firstName")){
                validationMessage[1] = true;
            }

            if(userDtoConstraintViolation.getPropertyPath().toString().equals("lastName")){
                validationMessage[2] = true;
            }

            if(userDtoConstraintViolation.getPropertyPath().toString().equals("email")){
                validationMessage[3] = true;
            }

            if(userDtoConstraintViolation.getPropertyPath().toString().equals("password")){
                validationMessage[4] = true;
            }

        }
    }
}
