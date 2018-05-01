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

    @RequestMapping("/ticketsprice")
    public String getTicketPrice(@RequestParam String event, @RequestParam String auditorium,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime, @RequestParam List<Integer> seats,
            @RequestParam long userId, ModelMap model) {

        double ticketPrice = bookingService.getTicketPrice(event, auditorium, dateTime, seats, getUser(userId));
        model.addAttribute("ticketsPrice", ticketPrice);

        return "ticketsPrice";
    }

    @RequestMapping("/bookticket")
    public String bookTicket(Long userId, Long ticketId, ModelMap model) {

        Ticket bookTicket = bookingService.bookTicket(getUser(userId), bookingService.getTicketById(ticketId));
        model.addAttribute("bookTicket", bookTicket);

        return "bookTicket";
    }

    @RequestMapping("/ticketsforevent")
    public String getTicketsForEvent(@RequestParam String event, @RequestParam String auditorium, @RequestParam LocalDateTime date, ModelMap model) {

        List<Ticket> ticketsForEvent = bookingService.getTicketsForEvent(event, auditorium, date);
        model.addAttribute("ticketsForEvent", ticketsForEvent);

        return "ticketsForEvent";
    }
    
    @RequestMapping("/ticketsforuser")
    public String getTicketsForUser(@RequestParam Long userId, ModelMap model) {

        List<Ticket> bookedTickets = bookingService.getTickets(getUser(userId));
        model.addAttribute("bookedTickets", bookedTickets);
        model.addAttribute("time", LocalTime.now());

        return "bookedTickets";
    }
    
    @RequestMapping(value="/download/ticketsforuser", headers="Accept=application/pdf", produces = "application/pdf")
    public String downloadPdfTicketsForUser(@RequestParam Long userId, ModelMap model) {

        List<Ticket> bookedTickets = bookingService.getTickets(getUser(userId));
        model.addAttribute("bookedTickets", bookedTickets);
        model.addAttribute("time", LocalTime.now());

        return "bookedTickets";
    }


    private User getUser(long userId) {
        return userService.getById(userId);
    }

}
