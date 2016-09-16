package be.vdab.spring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by L on 16/09/2016.
 */
@Controller
public class AddToListController {

    @Autowired
    FilmRepository fr;

    @RequestMapping(value = "/addtolist", method = RequestMethod.GET)

    public String prepareForm(){
        return "addtolist";
    }

    @RequestMapping(value = "/addtolist", method = RequestMethod.POST)

    public String handleForm(Film film){
        fr.save(film);
        return "redirect:/ex";
    }

}
