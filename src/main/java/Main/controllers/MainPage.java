package Main.controllers;

import Main.Model.Apartment;
import Main.Services.MainPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class MainPage {

    @Autowired
    MainPageService service;

    @RequestMapping("/")
    public ModelAndView getIndexPage(ModelAndView model) {
        List<Apartment> allApartments = service.getAllApartments();
        model.addObject("apartments", allApartments);
        model.setViewName("index");
        return model;
    }

}
