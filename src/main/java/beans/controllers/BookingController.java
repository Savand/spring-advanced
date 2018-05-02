package beans.controllers;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import beans.models.Ticket;
import beans.models.User;
import beans.services.BookingService;
import beans.services.UserService;


@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    // example for test endpoint http://localhost:8080/spring-course/booking/ticketsprice?event=The%20revenant&auditorium=Yellow%20hall&dateTime=2016-02-05T21:18&seats=1&seats=2&userId=1
    @RequestMapping("/ticketsprice")
    public String getTicketPrice(@RequestParam String event, @RequestParam String auditorium,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime, @RequestParam List<Integer> seats,
            @RequestParam long userId, ModelMap model) {

        double ticketPrice = bookingService.getTicketPrice(event, auditorium, dateTime, seats, getUser(userId));
        model.addAttribute("ticketsPrice", ticketPrice);

        return "ticketsPrice";
    }

    // example for test endpoint http://localhost:8080/spring-course/booking/bookticket?userId=1&ticketId=2
    @RequestMapping("/bookticket")
    public String bookTicket(@RequestParam Long userId, @RequestParam Long ticketId, ModelMap model) {

        Ticket bookTicket = bookingService.bookTicket(getUser(userId), bookingService.getTicketById(ticketId));
        model.addAttribute("bookTicket", bookTicket);

        return "bookTicket";
    }

    // example for test endpoint http://localhost:8080/spring-course/booking/ticketsforuser?userId=1
    @RequestMapping("/ticketsforuser")
    public String getTicketsForUser(@RequestParam Long userId, ModelMap model) {

        List<Ticket> bookedTickets = bookingService.getTickets(getUser(userId));
        model.addAttribute("bookedTickets", bookedTickets);
        model.addAttribute("time", LocalTime.now());

        return "bookedTickets";
    }

    // example for test endpoint http://localhost:8080/spring-course/booking/pdf/ticketsforuser?userId=1
    @RequestMapping(value = "/pdf/ticketsforuser", produces = "application/pdf")
    public ModelAndView downloadPdfTicketsForUser(@RequestParam Long userId) {

        List<Ticket> bookedTickets = bookingService.getTickets(getUser(userId));

        return new ModelAndView("pdf", "bookedTickets", bookedTickets);
    }


    private User getUser(long userId) {
        return userService.getById(userId);
    }

}
