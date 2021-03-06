package beans.controllers;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import beans.models.Auditorium;
import beans.services.AuditoriumService;

@Controller
public class AuditoriumController {

    @Autowired
    private AuditoriumService service;

    // check endpoint http://localhost:8080/spring-course/auditoriums
    @RequestMapping("/auditoriums")
    public String getAuditoriums(ModelMap model) {

        List<Auditorium> auditoriumList = service.getAuditoriums();
        model.addAttribute("time", LocalTime.now());
        model.addAttribute("auditoriums", auditoriumList);

        return "auditoriums";
    }

}
