package com.acciojob.bookmyshowmay.Services;

import com.acciojob.bookmyshowmay.Models.Theater;
import com.acciojob.bookmyshowmay.Repositories.TheaterRepository;
import com.acciojob.bookmyshowmay.Requests.AddTheaterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    public String addTheater(AddTheaterRequest theaterRequest){

        Theater theater = Theater.builder().noOfScreens(theaterRequest.getNoOfScreens())
                .name(theaterRequest.getName())
                .address(theaterRequest.getAddress())
                .build();

        theater = theaterRepository.save(theater);
        return "Theater has been saved to the DB with theaterId "+theater.getTheaterId();

    }
}
