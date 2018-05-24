package beans.controllers;

import beans.models.User;
import beans.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalTime;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    // check endpoint http://localhost:8080/spring-course/users
    @RequestMapping("/users")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getUsers(ModelMap model) {
        List<User> users = service.getAll();

        model.addAttribute("time", LocalTime.now());
        model.addAttribute("users", users);

        return "users";
    }

}
