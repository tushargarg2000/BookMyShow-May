package com.acciojob.bookmyshowmay.Controllers;

import com.acciojob.bookmyshowmay.Models.Ticket;
import com.acciojob.bookmyshowmay.Requests.BookTicketRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @PostMapping("bookTicket")
    public Ticket bookTicket(@RequestBody BookTicketRequest bookTicketRequest){



    }
}
