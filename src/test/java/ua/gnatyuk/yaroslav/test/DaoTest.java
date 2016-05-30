package ua.gnatyuk.yaroslav.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.gnatyuk.yaroslav.music_shop.SpringConfig;
import ua.gnatyuk.yaroslav.music_shop.SpringSequrityConfig;
import ua.gnatyuk.yaroslav.music_shop.dao.user.NewUser;
import ua.gnatyuk.yaroslav.music_shop.domain.FillDataBase;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Address;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Studio;
import ua.gnatyuk.yaroslav.music_shop.domain.user.UserDto;
import ua.gnatyuk.yaroslav.music_shop.services.*;
import ua.gnatyuk.yaroslav.music_shop.services.impl.PageImpl;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by yaroslav on 21.03.16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class, SpringSequrityConfig.class})
public class DaoTest {
    @Inject
    private FillDataBase fillDataBase;
    @Inject
    private StudioService studioService;
    @Inject
    private ArtistService artistService;
    @Inject
    private CategoryService categoryService;
    @Inject
    private RegistrationService registrationService;
    @Inject
    private Page page;
    @Inject
    private NewUser newUser;


    @Ignore
    @Test
    public void deleteDB(){
        fillDataBase.deleteDataFromDB();
    }

    @Ignore
    @Test
    public void createDB(){
        fillDataBase.addDataToDB();
    }

    @Test
    public void findStudioById(){
        long id = 1;
        assertEquals(studioService.findById(id).getName(),"Студия Океана Эльзы");
    }

    @Test
    public void findStudioByName(){
        String name = "Студия Океана Эльзы";
        assertEquals(studioService.findByName(name).getName(),"Студия Океана Эльзы");
    }

    @Test
    public void updateStudio(){
        long id = 1;
        Studio temp = studioService.findById(id);
        temp.setName("Студия Новая для Океана Эльзы");

        studioService.updateStudio(temp);

        assertEquals(studioService.findById(id).getName(),"Студия Новая для Океана Эльзы");

        temp.setName("Студия Океана Эльзы");
        studioService.updateStudio(temp);
    }

    @Test
    public void createStudio(){
        Studio temp = new Studio();
        temp.setName("Студия для Океана Эльзы в Запорожье");
        temp.setAddress(new Address("Ukraine", "Zaporizhya", "Boyko", "11c", 10));

        studioService.createStudio(temp);

        assertEquals(studioService.findByName("Студия для Океана Эльзы в Запорожье").
                getName(),"Студия для Океана Эльзы в Запорожье");
    }

    @Test(expected = NullPointerException.class )
    public void deleteStudio(){
        Studio studio = studioService.findByName("Студия для Океана Эльзы в Запорожье");
        studioService.deleteStudio(studio);

        studioService.findByName("Студия для Океана Эльзы в Запорожье").getName();
    }

    @Test/*(expected = NullPointerException.class)*/
    public void findArtistById(){
        long id = 1;
        assertEquals(artistService.findById(id).getName(),"Wu-tang clan");
    }

    @Test/*(expected = NullPointerException.class)*/
    public void findArtistByName(){
        String name = "Wu-tang clan";
        assertEquals(artistService.findByName(name).getName(),"Wu-tang clan");
    }

    @Test
    public void allStudios(){
        for (int i = 0; i < studioService.getAll().size(); i++) {
            System.out.println(studioService.getAll().get(i).getName());
        }
    }

    @Test
    public void getAllUser(){
        System.out.println("We have: " + registrationService.getCountAllUsers() + " users");
    }

//    @Ignore
    @Test
    public void getAllMaterialsForCategories(){
        Long totalElements = categoryService.getCountAllCategories();
        System.out.println("We have " + totalElements + " materials");
    }

   /* @Ignore*/
    @Test
    public void paginationForCategory(){
        int CURRENT_PAGE = 1;
        page.buildNewPage(CURRENT_PAGE, PageImpl.TypeOfMaterial.USER);
        System.out.println(page);
    }

    @Test
    public void userEmailExist(){
        assertEquals(registrationService.existThisEmail("some#1@email.com"),true);
        assertEquals(registrationService.existThisEmail("some#2@email.com"),true);
        assertEquals(registrationService.existThisEmail("some#3@email.com"),false);
    }

    @Test
    public void usernameExist(){
        assertEquals(registrationService.existThisUsername("admin"),true);
        assertEquals(registrationService.existThisUsername("user"),true);
        assertEquals(registrationService.existThisUsername("some_human"),false);
    }
    @Ignore
    @Test
    public void testRegisterNewUser() {
        UserDto userDto1 = new UserDto("Michel", "Galustyan", "", "11111", "wewweweww@e");

        Validator userValidator;
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        userValidator = validatorFactory.getValidator();

        Set<ConstraintViolation<UserDto>> violations = userValidator.validate(userDto1);
        Iterator iterator = violations.iterator();

        while (iterator.hasNext()){
            ConstraintViolation<UserDto> user = (ConstraintViolation<UserDto>) iterator.next();
            System.out.println(user.getPropertyPath());
        }


        violations.forEach(System.out::println);
        assertEquals(violations.isEmpty(),true);

    }
}