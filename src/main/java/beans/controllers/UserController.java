package beans.controllers;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import beans.models.User;
import beans.services.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/users")
    public String getAuditoriums(ModelMap model) {

        List<User> users = service.getAll();

        model.addAttribute("time", LocalTime.now());
        model.addAttribute("users", users);

        return "users";
    }

}
