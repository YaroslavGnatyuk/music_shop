package ua.gnatyuk.yaroslav.music_shop.web.admin;

import org.apache.commons.io.FileUtils;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ua.gnatyuk.yaroslav.music_shop.domain.article.Article;
import ua.gnatyuk.yaroslav.music_shop.domain.user.User;
import ua.gnatyuk.yaroslav.music_shop.services.*;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Album;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Artist;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Category;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Studio;
import ua.gnatyuk.yaroslav.music_shop.services.impl.PageImpl;
import ua.gnatyuk.yaroslav.music_shop.utils.Connection;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by yaroslav on 4/10/16.
 */
@Controller
@RequestMapping("/admin")
public class UpdateController {
    @Inject
    private ArticleService articleService;
    @Inject
    private UserService userService;
    @Inject
    private AlbumService albumService;
    @Inject
    private ArtistService artistService;
    @Inject
    private StudioService studioService;
    @Inject
    private CategoryService categoryService;

    @Inject
    private Page page;
    @Inject
    private Connection connection;
    @Inject
    private Environment env;

    @RequestMapping(path = "/update-article/{id}",method = RequestMethod.GET)
    public ModelAndView updateArticle(@PathVariable("id") Long id){
        Article article = articleService.findById(id);
        return new ModelAndView("/admin/article/updateArticle","command",article);
    }

    @RequestMapping(path = "/update-article/{id}",method = RequestMethod.POST)
    public ModelAndView updateArticleComit(@PathVariable("id") Long id,
                                           @ModelAttribute Article article,
                                           @RequestParam Map<String, String> request){
        article.setDate(LocalDate.parse(request.get("dateField")));
        article.setShortDesription();
        articleService.updateArticle(article);

        page.buildNewPage(Page.FIRST_PAGE, PageImpl.TypeOfMaterial.ARTICLE);
        return new ModelAndView("/admin/article/articleMainPage").addObject("page",page);
    }



    @RequestMapping(path = "/update-user/{id}", method = RequestMethod.GET)
    public ModelAndView updateUser(@PathVariable("id") Long id){
        User user = userService.findUserById(id);

        return new ModelAndView("/admin/user/updateUser","command",user);
    }

    @RequestMapping(path = "/update-user/{id}",method = RequestMethod.POST)
    public ModelAndView updateUserCommit(@ModelAttribute User user,
                                         @RequestParam MultiValueMap<String,String> request,
                                         @PathVariable("id") Long id){

        user.setPassword(userService.findUserById(id).getPassword()); //add user password, because i can't get it from jsp
        List<String> roles = request.get("userRole");  //get roles from jsp
        userService.addRolesById(user.getId(), roles); //set user new roles
        userService.updateUser(user);
        page.buildNewPage(Page.FIRST_PAGE,PageImpl.TypeOfMaterial.USER);

        return new ModelAndView("/admin/user/userMainPage").addObject("page", page);
    }

    @RequestMapping(path = "/update-studio/{id}",method = RequestMethod.GET)
    public ModelAndView toUpdateStudio(@PathVariable("id") Long id){
        return new ModelAndView("admin/studio/updateStudio","command",studioService.findById(id));
    }

    @RequestMapping(path = "/update-studio/{id}",method = RequestMethod.POST)
    public ModelAndView updateStudioCommit(@ModelAttribute Studio studio){
        studioService.updateStudio(studio);
        page.buildNewPage(Page.FIRST_PAGE,PageImpl.TypeOfMaterial.STUDIO);
        return new ModelAndView("admin/studio/studioMainPage").addObject("page",page);
    }

    @RequestMapping(path = "/update-album/{id}", method = RequestMethod.GET)
    public ModelAndView updateAlbum(@PathVariable("id") Long id){
        Album album = albumService.findById(id);



        List<Studio> studios = studioService.getAll();
        List<Category> categories = categoryService.getAll();
        List<Artist> artists = artistService.getAll();

        return new ModelAndView("/admin/album/updateAlbum","command", album)
                .addObject("studios",studios)
                .addObject("categories",categories)
                .addObject("artists",artists);
    }

    @RequestMapping(path = "/update-album/{id}", method = RequestMethod.POST)
    public ModelAndView updateAlbumCommit(@PathVariable("id") Long id,
                                          @ModelAttribute Album album,
                                          @RequestParam Map<String,String> request,
                                          @RequestParam("file") MultipartFile file){

        LocalDate date = LocalDate.parse(request.get("date"));
        Studio studio = studioService.findByName(request.get("studio.name"));
        Artist artist = artistService.findByName(request.get("artist.name"));
        Category category = categoryService.findByName(request.get("category.name"));

        if(!file.isEmpty()){
            String []temp = albumService.findById(id).getHttpPathToAlbumsCover().split("/");
            connection.changeDirectory(env.getProperty("ftp.path.img.album"));
            connection.deleteFile(temp[temp.length-1]);

            File pic = createFileForUpload(album.getArtist().getName() + " " + album.getName(), file);
            connection.uploadFile(pic, env.getProperty("ftp.path.img.album"));
            album.setPathToAlbumsCover(env.getProperty("http.path.img.album") + pic.getName());

            pic.delete();
        }

        album.setStudio(studio);
        album.setCategory(category);
        album.setArtist(artist);
        album.setReleaseDate(date);

        albumService.updateAlbum(album);
        page.buildNewPage(Page.FIRST_PAGE, PageImpl.TypeOfMaterial.ALBUM);

        return new ModelAndView("/admin/album/albumMainPage")
                .addObject("page",page);
    }

    @RequestMapping(path = "/update-category/{id}",method = RequestMethod.GET)
    public ModelAndView updateCategory(@PathVariable("id") Long id){
            Category category = categoryService.findById(id);
        return new ModelAndView("/admin/category/updateCategory","command", category);
    }

    @RequestMapping(path = "/update-category/{id}",method = RequestMethod.POST)
    public ModelAndView updateCategoryCommit(@ModelAttribute Category category){
        categoryService.updateCategory(category);
        page.buildNewPage(Page.FIRST_PAGE, PageImpl.TypeOfMaterial.CATEGORY);
        return new ModelAndView("/admin/category/categoryMainPage")
                .addObject("page", page);
    }

    @RequestMapping(path = "/update-artist/{id}",method = RequestMethod.GET)
    public ModelAndView updateArtist(@PathVariable("id")Long id){
        Artist artist = artistService.findById(id);
        List<Studio> studios = studioService.getAll();
        List<Category> categories = categoryService.getAll();
        return new ModelAndView("admin/artist/updateArtist","command",artist)
                .addObject("studios",studios)
                .addObject("categories",categories);
    }

    @RequestMapping(path = "/update-artist/{id_artist}",method = RequestMethod.POST)
    public ModelAndView updateArtistCommit(@ModelAttribute Artist artist, @RequestParam Map<String,String> request){
        Studio studio = studioService.findById(Long.parseLong(request.get("studio.id")));
        Category category = categoryService.findById(Long.parseLong(request.get("category.id")));
        LocalDate date = LocalDate.parse(request.get("date"));

        artist.setBirthday(date);
        artist.setCategory(category);
        artist.setStudio(studio);

        artistService.updateArtist(artist);
        page.buildNewPage(Page.FIRST_PAGE, PageImpl.TypeOfMaterial.ARTIST);

        return new ModelAndView("/admin/artist/artistMainPage").addObject("page",page);
    }

    private String getNameForImage(String name){
        return name.replace(" ","_").toLowerCase();
    }

    private File createFileForUpload(String fileName, MultipartFile multipartFile){
        File pic= new File(getNameForImage(getNameForImage(fileName)) + ".jpg");

        try {
            FileUtils.writeByteArrayToFile(pic, multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pic;
    }
}