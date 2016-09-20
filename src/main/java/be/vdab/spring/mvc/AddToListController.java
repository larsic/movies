package be.vdab.spring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by L on 16/09/2016.
 */
@Controller
public class AddToListController {

    @Autowired
    FilmRepository fr;

    @RequestMapping(value = "/saveFilm", method = RequestMethod.GET)
    public String prepareForm(){
        return "addtolist";
    }

    @RequestMapping(value = "/saveFilm", method = RequestMethod.POST)
    public String saveFilm(Film film){
        fr.save(film);
        return "redirect:/ex";

    }

    @RequestMapping(value = "/deleteFilm", method = RequestMethod.POST)
    public String deleteFilm(@RequestParam("filmid") Integer id){

        fr.delete(id);
        return "redirect:/ex";

    }


}
