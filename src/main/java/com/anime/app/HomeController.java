
package com.anime.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class HomeController {

    private final AnimeService service;

    public HomeController(AnimeService s){this.service=s;}

    @GetMapping("/")
    public String home(Model m){
        m.addAttribute("categories",
            List.of("action","romance","comedy","fantasy","sports"));
        return "categories";
    }

    @GetMapping("/category/{c}")
    public String cat(@PathVariable String c,Model m){
        m.addAttribute("animes",service.byCategory(c));
        return "index";
    }

    @GetMapping("/anime/{id}")
    public String details(@PathVariable int id,Model m){
        m.addAttribute("anime",service.details(id));
        return "details";
    }
}
