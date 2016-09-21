package be.vdab.spring.mvc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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


    /**
     * printing the movie list
     */

    @RequestMapping("/ex")
    public String ex(Model model) {

        List<Film> fs = fr.findAll();
        System.out.println(fs);
        model.addAttribute("filmList", fs);
        return "films";
    }

    /**
     * sorting the movie list
     */

    @RequestMapping("/sortAsc")
    public String sortAsc(Model model,@RequestParam(value="field") String string) {

        List<Film> fs = fr.findAll(sortByAsc(string));
        System.out.println(fs);
        model.addAttribute("filmList", fs);
        return "films";
    }


    private Sort sortByAsc(String by) {
        return new Sort(Sort.Direction.ASC, by);
    }

}
