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
import ua.gnatyuk.yaroslav.music_shop.domain.article.Article;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Address;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Studio;
import ua.gnatyuk.yaroslav.music_shop.domain.user.User;
import ua.gnatyuk.yaroslav.music_shop.services.*;
import ua.gnatyuk.yaroslav.music_shop.services.impl.ArticleServImpl;
import ua.gnatyuk.yaroslav.music_shop.services.impl.PageImpl;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by yaroslav on 21.03.16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class, SpringSequrityConfig.class})
public class DaoTest {
    @Inject
    private ArticleService articleService;
    @Inject
    private FillDataBase fillDataBase;
    @Inject
    private StudioService studioService;
    @Inject
    private ArtistService artistService;
    @Inject
    private CategoryService categoryService;
    @Inject
    private UserService userService;
    @Inject
    private Page page;


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
        System.out.println(studioService.findByName(name).getName());
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
        System.out.println("We have: " + userService.getCountAllUsers() + " users");
    }

    @Ignore
    @Test
    public void getAllMaterialsForCategories(){
        Long totalElements = categoryService.getCountAllCategories();
        System.out.println("We have " + totalElements + " materials");
    }

    @Ignore
    @Test
    public void paginationForCategory(){
        int CURRENT_PAGE = 1;
        page.buildNewPage(CURRENT_PAGE, PageImpl.TypeOfMaterial.USER);
        System.out.println(page);
    }

    @Test
    public void userEmailExist(){
        assertEquals(userService.existThisEmail("some#1@email.com"),true);
        assertEquals(userService.existThisEmail("some#2@email.com"),true);
        assertEquals(userService.existThisEmail("some#3@email.com"),false);
    }

    @Test
    public void usernameExist(){
        assertEquals(userService.existThisUsername("admin"),true);
        assertEquals(userService.existThisUsername("user"),true);
        assertEquals(userService.existThisUsername("some_human"),false);
    }
    @Ignore
    @Test
    public void testRegisterNewUser() {
        User userDto1 = new User("Michel", "Galustyan", "", "11111", "wewweweww@e", true);

        Validator userValidator;
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        userValidator = validatorFactory.getValidator();

        Set<ConstraintViolation<User>> violations = userValidator.validate(userDto1);
        Iterator iterator = violations.iterator();

        while (iterator.hasNext()){
            ConstraintViolation<User> user = (ConstraintViolation<User>) iterator.next();
            System.out.println(user.getPropertyPath());
        }


        violations.forEach(System.out::println);
        assertEquals(violations.isEmpty(),true);

    }

    @Test
    public void findUser(){
        System.out.println(userService.findUserById(2L).getUserRole());
    }

    @Ignore
    @Test
    public void addRolesById(){
        List<String> roles = new ArrayList<>(3);
        roles.add("ROLE_USER");
//        roles.add("ROLE_ADMIN");
        userService.addRolesById(30L, roles);
        System.out.println(userService.findUserById(30L).getUserRole());
    }

    @Ignore
    @Test
    public void createNewArticle(){
        StringBuilder art = new StringBuilder("Taylor Swift has penned a touching note sending her love and sympathies to the families of those killed in the Orlando shooting massacre on Sunday (12Jun16).\n" +
                "\n" +
                "In what has become the deadliest mass shooting in American history, 49 people were killed and more than 50 others were injured after a gunman opened fire at a gay nightclub in Florida.\n" +
                "\n" +
                "On Friday (17Jun16), funerals for the victims began as their loved ones said their final goodbyes and the pop star took time to acknowledge the difficult process via a heartfelt message on Instagram.\n" +
                "\n" +
                "A snap posted on Friday featured a handwritten note which began with, \"To the families of...\", and finished with the 49 names of those who perished in the massacre.\n" +
                "\n" +
                "She added the caption, \"As you bury your loved ones this week, please know that there are millions of us sending you love and our deepest sympathy in the face of this unthinkable and devastating tragedy.\"\n" +
                "\n" +
                "Swift posted the same photo on Twitter, and also wrote, \"With heavy heart...\".\n" +
                "\n" +
                "The emotional post comes after the Style star had a different kind of heartbreak of her own, as she recently split with her boyfriend of over a year, DJ Calvin Harris.\n" +
                "\n" +
                "On Thursday (15Jun16), it was clear the 26 year old had moved on from Harris after she was photographed locking lips with actor Tom Hiddleston on a beach near her Rhode Island home.\n" +
                "\n" +
                "The two later enjoyed a date night and took off in Swift's private jet, and the Thor star was spotted going to a meeting in New York City on Friday.\n" +
                "\n" +
                "Meanwhile, Harris was on the other side of the country in Los Angeles, where he was approached by TMZ photographers about his ex-girlfriend.\n" +
                "\n" +
                "In a video posted on the site, the snapper asks the Scottish music star if he would ever consider taking Swift back, but Harris scoffed at the idea and simply laughed at the photographer.");

        String author = new String("incognito");
        String name = new String("Taylor Swift sends love to Orlando victims' families");

        Article article = new Article(author, name, art.toString());
        articleService.createNewArticle(article);
    }

//    @Test
}