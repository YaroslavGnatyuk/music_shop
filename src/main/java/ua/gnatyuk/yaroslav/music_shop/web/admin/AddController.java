package ua.gnatyuk.yaroslav.music_shop.web.admin;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Album;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Artist;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Category;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Studio;
import ua.gnatyuk.yaroslav.music_shop.services.*;
import ua.gnatyuk.yaroslav.music_shop.services.impl.PageImpl;
import ua.gnatyuk.yaroslav.music_shop.utils.Connection;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Created by yaroslav on 4/6/16.
 */

@Controller
@RequestMapping("/admin")
public class AddController {
    @Inject
    private Environment env;
    @Inject
    private CategoryService categoryService;
    @Inject
    private ArtistService artistService;
    @Inject
    private StudioService studioService;
    @Inject
    private AlbumService albumService;
    @Inject
    private Page page;
    @Inject
    @Named(value = "ftpUpload")
    private Connection connection;

    @RequestMapping(path = "/add-studio",method = RequestMethod.GET)
    public ModelAndView addStudio(){
        return new ModelAndView("admin/studio/addStudio","command", new Studio());
    }

    @RequestMapping(path = "/add-studio",method = RequestMethod.POST)
    public ModelAndView confirmAddStudio(@ModelAttribute Studio studio){
        studioService.createStudio(studio);
        page.setResultOfAction(studio, PageImpl.TypeOfMaterial.STUDIO);

        return new ModelAndView("/admin/studio/studioMainPage").addObject("page",page);
    }

    @RequestMapping(path = "/add-artist",method = RequestMethod.GET)
    public ModelAndView addArtist(ModelMap map){
        List<Category> categories = categoryService.getAll();
        List<Studio> studios = studioService.getAll();

        map.addAttribute("categories",categories)
                .addAttribute("studios",studios);

        return new ModelAndView("/admin/artist/addArtist","command",new Artist()).addAllObjects(map);
    }

    @RequestMapping(path = "/add-artist",method = RequestMethod.POST)
    public ModelAndView confirmAddArtist(@ModelAttribute Artist artist, @RequestParam Map<String, String> request){

        Studio studio = studioService.findById(Long.parseLong(request.get("studio.id")));
        Category category = categoryService.findById(Long.parseLong(request.get("category.id")));
        LocalDate date = LocalDate.parse(request.get("date"));

        artist.setBirthday(date);
        artist.setCategory(category);
        artist.setStudio(studio);

        page.setResultOfAction(artist, PageImpl.TypeOfMaterial.ARTIST);
        artistService.createArtist(artist);

        return new ModelAndView("/admin/artist/artistMainPage").addObject("page",page);
    }

    @RequestMapping(path = "/add-album",method = RequestMethod.GET)
    public ModelAndView addAlbum(ModelMap modelMap){
        List<Studio> studios = studioService.getAll();
        List<Artist> artists = artistService.getAll();
        List<Category> categories = categoryService.getAll();

        modelMap.addAttribute("studios",studios)
            .addAttribute("artists",artists)
            .addAttribute("categories",categories);
        return new ModelAndView("/admin/album/addAlbum","command", new Album()).addAllObjects(modelMap);
    }

    @RequestMapping(path = "/add-album",method = RequestMethod.POST)
    public ModelAndView confirmAddAlbum(@ModelAttribute Album album,
                                        @RequestParam Map<String, String> request,
                                        @RequestParam("file") MultipartFile file){

        if(file.isEmpty()){
            album.setPathToAlbumsCover(env.getProperty("http.path.img.default"));
        }
        else {
            File pic = createFileForUpload(album.getArtist().getName() + " " + album.getName(), file);
            connection.uploadFile(pic, env.getProperty("ftp.path.img.album"));
            album.setPathToAlbumsCover(env.getProperty("http.path.img.album") + pic.getName());
            pic.delete();
        }

        Studio studio = studioService.findByName(request.get("studio.name"));
        Artist artist = artistService.findByName(request.get("artist.name"));
        Category category = categoryService.findByName(request.get("category.name"));
        LocalDate date = LocalDate.parse(request.get("date"));

        album.setReleaseDate(date);
        album.setStudio(studio);
        album.setArtist(artist);
        album.setCategory(category);

        albumService.createAlbum(album);
        page.buildNewPage(Page.FIRST_PAGE, PageImpl.TypeOfMaterial.ALBUM);

        return new ModelAndView("/admin/album/albumMainPage")
                .addObject("page",page);
    }

    @RequestMapping(path = "/add-category",method = RequestMethod.GET)
    public ModelAndView addCategory(){
        return new ModelAndView("/admin/category/addCategory","command", new Category());
    }

    @RequestMapping(path = "/add-category",method = RequestMethod.POST)
    public ModelAndView addCategoryConfirm(@ModelAttribute Category category){
        categoryService.createCategory(category);
        page.setResultOfAction(category, PageImpl.TypeOfMaterial.CATEGORY);
        return new ModelAndView("/admin/category/categoryMainPage").addObject("page",page);
    }

    private String getNameForImage(String name){
        return name.replace(" ","_").toLowerCase();
    }

    private File createFileForUpload(String fileName, MultipartFile multipartFile){
        File pic= new File(getNameForImage(getNameForImage(fileName)) + ".jpg");
        try {
            OutputStream outputStream = new FileOutputStream(pic);
            outputStream.write(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pic;
    }
}
