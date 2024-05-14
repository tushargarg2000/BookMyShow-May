package com.acciojob.bookmyshowmay.Controllers;

import com.acciojob.bookmyshowmay.Models.Theater;
import com.acciojob.bookmyshowmay.Requests.AddTheaterRequest;
import com.acciojob.bookmyshowmay.Requests.AddTheaterSeatsRequest;
import com.acciojob.bookmyshowmay.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("theater")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @PostMapping("add")
    public ResponseEntity addTheater(@RequestBody AddTheaterRequest theaterRequest){

        String response = theaterService.addTheater(theaterRequest);
        return new ResponseEntity(response, HttpStatus.OK);
    }


    @PutMapping("associateSeats")
    public ResponseEntity associateSeats(@RequestBody AddTheaterSeatsRequest theaterSeatsRequest){

        String response = theaterService.associateTheaterSeats(theaterSeatsRequest);
        return new ResponseEntity(response,HttpStatus.OK);
    }


}
