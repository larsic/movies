package be.vdab.spring.mvc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    FilmRepository fr;

    /**
     * A controller that renders directly without a view
     */

    @RequestMapping("/direct")
    @ResponseBody
    String directExample() {
        return "Hello World!";
    }

    /**
     * A controller that uses an explicit view name
     */

    @RequestMapping("/bar")
    String anyMethodName() {
        return "foo";
    }

    @RequestMapping({"/", "/index"})
    String index() {
        return "index";
    }


    @RequestMapping("/ex")
    public String ex(Model model) {

        //return fr.findAll().toString();

        List<Film> fs = fr.findAll();
        System.out.println(fs);
        model.addAttribute("filmList", fs);
        return "films";
    }

    @RequestMapping("/sortByTitle")
    public String sortTitle(Model model) {
        List<Film> fs = fr.findAll(sortByAsc("title"));
        System.out.println(fs);
        model.addAttribute("filmList", fs);
        return "films";
    }

    @RequestMapping("/sortByDescription")
    public String sortDescription(Model model) {
        List<Film> fs = fr.findAll(sortByAsc("description"));
        System.out.println(fs);
        model.addAttribute("filmList", fs);
        return "films";
    }

    @RequestMapping("/sortByYear")
    public String sortYear(Model model) {
        List<Film> fs = fr.findAll(sortByAsc("releaseYear"));
        System.out.println(fs);
        model.addAttribute("filmList", fs);
        return "films";
    }

    @RequestMapping("/sortByDuration")
    public String sortDuration(Model model) {
        List<Film> fs = fr.findAll(sortByAsc("length"));
        System.out.println(fs);
        model.addAttribute("filmList", fs);
        return "films";
    }

    private Sort sortByAsc(String by) {
        return new Sort(Sort.Direction.ASC, by);
    }

}
