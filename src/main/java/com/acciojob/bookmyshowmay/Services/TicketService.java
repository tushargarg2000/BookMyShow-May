package com.acciojob.bookmyshowmay.Services;

import com.acciojob.bookmyshowmay.Enums.SeatType;
import com.acciojob.bookmyshowmay.Models.Show;
import com.acciojob.bookmyshowmay.Models.ShowSeat;
import com.acciojob.bookmyshowmay.Models.Ticket;
import com.acciojob.bookmyshowmay.Models.User;
import com.acciojob.bookmyshowmay.Repositories.ShowRepository;
import com.acciojob.bookmyshowmay.Repositories.ShowSeatRepository;
import com.acciojob.bookmyshowmay.Repositories.TicketRepository;
import com.acciojob.bookmyshowmay.Repositories.UserRepository;
import com.acciojob.bookmyshowmay.Requests.BookTicketRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public Ticket bookTicket(BookTicketRequest bookTicketRequest){

        //1. Find the Show Entity
        Show show = showRepository.findById(bookTicketRequest.getShowId()).get();

        //2. Find the User Entity
        User user = userRepository.findById(bookTicketRequest.getUserId()).get();

        //3. Mark those Seats as booked now and calculate total Amount
        Integer totalAmount = 0;
        List<ShowSeat> showSeatList = show.getShowSeatList();

        for(ShowSeat showSeat : showSeatList) {

            String seatNo = showSeat.getSeatNo();
            if(bookTicketRequest.getRequestedSeats().contains(seatNo)) {
                showSeat.setIsBooked(Boolean.TRUE);


                if(showSeat.getSeatType().equals(SeatType.CLASSIC))
                    totalAmount = totalAmount + 100;
                else
                    totalAmount = totalAmount+150;
            }
        }

        //4. Create the Ticket Entity and set the attributes
        Ticket ticket = Ticket.builder().showDate(show.getShowDate())
                .showTime(show.getShowTime())
                .movieName(show.getMovie().getMovieName())
                .theaterName(show.getTheater().getName())
                .totalAmount(totalAmount)
                .show(show)
                .user(user)
                .build();


        showSeatRepository.saveAll(showSeatList);
        ticket = ticketRepository.save(ticket);
        //5. save the ticket into DB and return Ticket Entity (Ticket Response)
        return ticket;
    }

}
