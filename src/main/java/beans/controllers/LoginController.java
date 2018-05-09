package beans.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping("/login.html")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {

        return new ModelAndView("login");

    }
}
