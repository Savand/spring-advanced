package beans.controllers;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import beans.models.Event;
import beans.services.EventService;

@Controller
public class EventController {

    @Autowired
    private EventService service;

    // check endpoint http://localhost:8080/spring-course/events
    @RequestMapping("/events")
    public String getEvents(ModelMap model) {
        List<Event> events = service.getAll();

        model.addAttribute("time", LocalTime.now());
        model.addAttribute("events", events);

        return "events";
    }
}
