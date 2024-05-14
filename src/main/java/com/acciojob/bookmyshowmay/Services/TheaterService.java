package com.acciojob.bookmyshowmay.Services;

import com.acciojob.bookmyshowmay.Enums.SeatType;
import com.acciojob.bookmyshowmay.Models.Theater;
import com.acciojob.bookmyshowmay.Models.TheaterSeat;
import com.acciojob.bookmyshowmay.Repositories.TheaterRepository;
import com.acciojob.bookmyshowmay.Repositories.TheaterSeatsRepository;
import com.acciojob.bookmyshowmay.Requests.AddTheaterRequest;
import com.acciojob.bookmyshowmay.Requests.AddTheaterSeatsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private TheaterSeatsRepository theaterSeatsRepository;

    public String addTheater(AddTheaterRequest theaterRequest){

        Theater theater = Theater.builder().noOfScreens(theaterRequest.getNoOfScreens())
                .name(theaterRequest.getName())
                .address(theaterRequest.getAddress())
                .build();

        theater = theaterRepository.save(theater);
        return "Theater has been saved to the DB with theaterId "+theater.getTheaterId();
    }

    public String associateTheaterSeats(AddTheaterSeatsRequest theaterSeatsRequest){

        int theaterId = theaterSeatsRequest.getTheaterId();
        int noOfClassicSeats = theaterSeatsRequest.getNoOfClassicSeats();
        int noOfPremiumSeats = theaterSeatsRequest.getNoOfPremiumSeats();

        List<TheaterSeat> theaterSeatList = new ArrayList<>();

        //1. Get the theaterEntity from DB
        Theater theater = theaterRepository.findById(theaterId).get();

        //2. Generate those seatNos through for Classic Seats

        int noOfRowsOfClassicSeats = noOfClassicSeats/5; //Complete rows that i can build
        int noOfSeatsInLastRow = noOfClassicSeats%5;
        int row;
        for(row= 1;row<=noOfRowsOfClassicSeats;row++) {

            for(int j=1;j<=5;j++) {

                char ch = (char)('A'+j-1);
                String seatNo = "" + row + ch;

                TheaterSeat theaterSeat = TheaterSeat.builder().seatNo(seatNo)
                        .seatType(SeatType.CLASSIC)
                        .theater(theater)
                        .build();
                theaterSeatList.add(theaterSeat);
            }
        }
        //For the last row
        for(int j=1;j<=noOfSeatsInLastRow;j++){
            char ch = (char)('A'+j-1);
            String seatNo = "" + row + ch;
            TheaterSeat theaterSeat = TheaterSeat.builder().seatNo(seatNo)
                    .seatType(SeatType.CLASSIC)
                    .theater(theater)
                    .build();
            theaterSeatList.add(theaterSeat);

        }


        //Same logic for the premium seats

        int noOfRowsInPremiumSeats = noOfPremiumSeats/5;
        noOfSeatsInLastRow = noOfPremiumSeats%5;

        for(row= 1;row<noOfRowsInPremiumSeats ; row++) {
            for(int j=1;j<=5;j++) {
                char ch = (char)('A'+j-1);
                String seatNo = "" + row + ch;
                TheaterSeat theaterSeat = TheaterSeat.builder().seatNo(seatNo)
                        .seatType(SeatType.PREMIUM)
                        .theater(theater)
                        .build();
                theaterSeatList.add(theaterSeat);
            }
        }
        //For the last row
        for(int j=1;j<=noOfSeatsInLastRow;j++){
            char ch = (char)('A'+j-1);
            String seatNo = "" + row + ch;
            TheaterSeat theaterSeat = TheaterSeat.builder().seatNo(seatNo)
                    .seatType(SeatType.PREMIUM)
                    .theater(theater)
                    .build();
            theaterSeatList.add(theaterSeat);
        }

        //Save all the generated Theater seats into the DB

        theaterSeatsRepository.saveAll(theaterSeatList);
        return "The theater seats have been associated";

    }
}
