package ua.gnatyuk.yaroslav.music_shop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author leopold
 * @since 29/03/16
 */
@Controller
@RequestMapping(path = "/111")
public class HelloController {

  @RequestMapping(method = RequestMethod.GET)
  public String hello() {
    return "hello";
  }
}
