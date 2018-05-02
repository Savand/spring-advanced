package beans.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.NestedServletException;

@Controller
public class ErrorController {
    @RequestMapping(value = "errors", method = RequestMethod.GET)
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {

        ModelAndView errorPage = new ModelAndView("errorPage");
        Integer errorStatusCode = (Integer) httpRequest.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String errorMessage = (String) httpRequest.getAttribute(RequestDispatcher.ERROR_MESSAGE);
        NestedServletException nestedServletException =
                (org.springframework.web.util.NestedServletException) httpRequest.getAttribute(RequestDispatcher.ERROR_EXCEPTION);

        if (nestedServletException != null) {
            errorMessage += nestedServletException.getLocalizedMessage();
        }

        errorPage.addObject("errorMessage", errorMessage);
        errorPage.addObject("errorStatusCode", errorStatusCode);

        return errorPage;
    }
}
