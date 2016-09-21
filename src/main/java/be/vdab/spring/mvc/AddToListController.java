package be.vdab.spring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by L on 16/09/2016.
 */
@Controller
public class AddToListController {

    @Autowired
    FilmRepository fr;

    @RequestMapping(value = "/saveFilm", method = RequestMethod.GET)
    public String prepareForm(Model m){
        Film f = new Film();
        m.addAttribute("myFilm", f);
        return "addtolist";
    }

    @RequestMapping(value = "/saveFilm", method = RequestMethod.POST)
    public String saveFilm(@Valid @ModelAttribute("myFilm") Film film, BindingResult result, Model m){

        if(result.hasErrors()){
            return "addtolist";
        } else{
            fr.save(film);
            return "redirect:/ex";
        }


    }

    @RequestMapping(value = "/deleteFilm", method = RequestMethod.POST)
    public String deleteFilm(@RequestParam("filmid") Integer id){

        fr.delete(id);
        return "redirect:/ex";

    }

    @RequestMapping(value = "/updateFilm", method = RequestMethod.GET)
    public String fillInFilm(Model m, @RequestParam("filmid") Integer id){

        m.addAttribute("myFilm", fr.findById(id));
        return "addtolist";

    }




}
