package Main.controllers;

import Main.Model.OrderResult;
import Main.Services.MainPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class OrderController {

    @Autowired
    MainPageService service;

    @PostMapping(value = "/order", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView orderApartment(@RequestParam(value = "name", required = true) String name,
                                       @RequestParam(value = "phone", required = true) String phone,
                                       @RequestParam(value = "date", required = true) String date,
                                       @RequestParam(value = "apartmentId", required = true) int apartmentId,
                                       ModelAndView modelAndView) {
        OrderResult result = service.makeNewOrder(name, phone, date, apartmentId);
        modelAndView.addObject("apartments", service.getAllApartments());
        modelAndView.addObject("name", name);
        modelAndView.addObject("phone", phone);
        modelAndView.addObject("date", date);
        modelAndView.addObject("status", result.isStatus());
        modelAndView.addObject("apartment", service.getApartmentById(apartmentId).getDescription());
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
