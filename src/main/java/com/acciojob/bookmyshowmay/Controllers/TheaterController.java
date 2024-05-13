package com.acciojob.bookmyshowmay.Controllers;

import com.acciojob.bookmyshowmay.Models.Theater;
import com.acciojob.bookmyshowmay.Requests.AddTheaterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("theater")
public class TheaterController {

    @PostMapping("add")
    public ResponseEntity addTheater(@RequestBody AddTheaterRequest theaterRequest){


    }
}
