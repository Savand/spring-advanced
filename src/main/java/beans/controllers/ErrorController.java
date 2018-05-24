package beans.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController {

    @RequestMapping(value = "errors", method = RequestMethod.GET)
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {

        ModelAndView errorPage = new ModelAndView("errorPage");
        Integer errorStatusCode = (Integer) httpRequest.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Exception exc = (Exception) httpRequest.getAttribute(RequestDispatcher.ERROR_EXCEPTION);

        String errorMessage = exc == null ? "Oops, smth went wrong" : exc.getMessage();

        errorPage.addObject("errorMessage", errorMessage).addObject("errorStatusCode", errorStatusCode);

        return errorPage;
    }

}
