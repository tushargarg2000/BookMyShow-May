package com.acciojob.bookmyshowmay.Controllers;

import com.acciojob.bookmyshowmay.Models.Ticket;
import com.acciojob.bookmyshowmay.Requests.BookTicketRequest;
import com.acciojob.bookmyshowmay.Responses.TicketResponse;
import com.acciojob.bookmyshowmay.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("bookTicket")
    public String bookTicket(@RequestBody BookTicketRequest bookTicketRequest){

        return ticketService.bookTicket(bookTicketRequest);
    }

    @GetMapping("generateTicket")
    public TicketResponse generateTicket(@RequestParam("ticketId") String ticketId) {

        return ticketService.generateTicket(ticketId);
    }
}
