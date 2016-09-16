package be.vdab.spring.mvc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/ex")
    public String ex(Model model) {

        //return fr.findAll().toString();

        List<Film> fs = fr.findAll();
        System.out.println(fs);
        model.addAttribute("filmList", fs);




        return "films";
    }
}
