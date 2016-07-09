package ua.gnatyuk.yaroslav.music_shop.web.admin;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Album;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Category;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Studio;
import ua.gnatyuk.yaroslav.music_shop.services.*;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Artist;
import ua.gnatyuk.yaroslav.music_shop.services.impl.PageImpl;
import ua.gnatyuk.yaroslav.music_shop.utils.Connection;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by yaroslav on 4/6/16.
 */
@Controller
@RequestMapping("/admin")
public class DeleteController {
    @Inject
    private ArticleService articleService;
    @Inject
    private UserService userService;
    @Inject
    private CategoryService categoryService;
    @Inject
    private AlbumService albumService;
    @Inject
    private ArtistService artistService;
    @Inject
    private StudioService studioService;
    @Inject
    @Named(value = "ftpUpload")
    private Connection connection;
    @Inject
    private Page page;
    @Inject
    private Environment env;

    @RequestMapping(path = "/delete-article/{id}")
    public ModelAndView deleteArticle(@PathVariable("id") Long id){
        articleService.deleteArticle(articleService.findById(id));
        page.buildNewPage(Page.FIRST_PAGE, PageImpl.TypeOfMaterial.ARTICLE);
        return new ModelAndView("admin/article/articleMainPage")
                .addObject("page",page);
    }

    @RequestMapping(path = "/delete-user/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(userService.findUserById(id));
        page.buildNewPage(Page.FIRST_PAGE, PageImpl.TypeOfMaterial.USER);

        return new ModelAndView("admin/user/userMainPage").addObject("page",page);
    }

    @RequestMapping(path = "/delete-studio/{id}",method = RequestMethod.GET)
    public ModelAndView deleteStudio(@PathVariable("id") Long id){
        Studio studio = studioService.findById(id);
        studioService.deleteStudio(studio);
        page.buildNewPage(Page.FIRST_PAGE,PageImpl.TypeOfMaterial.STUDIO);

        return new ModelAndView("admin/studio/studioMainPage").addObject("page",page);
    }

    @RequestMapping(path = "/delete-artist/{id}",method = RequestMethod.GET)
    public ModelAndView deleteArtist(@PathVariable("id") Long id){
        Artist artist = artistService.findById(id);
        artistService.deleteArtist(artist);
        page.buildNewPage(Page.FIRST_PAGE, PageImpl.TypeOfMaterial.ARTIST);

        return new ModelAndView("admin/artist/artistMainPage").addObject("page",page);
    }

    @RequestMapping(path = "/delete-category/{id}",method = RequestMethod.GET)
    public ModelAndView deleteCategory(@PathVariable("id") Long id){
        Category category = categoryService.findById(id);
        categoryService.deleteCategory(category);
        page.buildNewPage(Page.FIRST_PAGE, PageImpl.TypeOfMaterial.CATEGORY);

        return new ModelAndView("admin/category/categoryMainPage").addObject("page",page);
    }

    @RequestMapping(path = "/delete-album/{id}", method = RequestMethod.GET)
    public ModelAndView deleteAlbum(@PathVariable("id") Long id){
        Album album = albumService.findById(id);
        albumService.deleteAlbum(album);

        String[] temp  = album.getHttpPathToAlbumsCover().split("/");
        String fileName = temp[temp.length-1];
        String ftpPathToFile = env.getProperty("ftp.path.img.album");

        connection.deleteFile(ftpPathToFile + fileName);

        page.buildNewPage(Page.FIRST_PAGE, PageImpl.TypeOfMaterial.ALBUM);
        return new ModelAndView("/admin/album/albumMainPage").addObject("page",page);
    }
}
