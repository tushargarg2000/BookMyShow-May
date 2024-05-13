package com.acciojob.bookmyshowmay.Controllers;

import com.acciojob.bookmyshowmay.Models.Movie;
import com.acciojob.bookmyshowmay.Requests.AddMovieRequest;
import com.acciojob.bookmyshowmay.Requests.UpdateMovieRequest;
import com.acciojob.bookmyshowmay.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("add")
    public ResponseEntity addMovie(@RequestBody AddMovieRequest movieRequest){

        String response = movieService.addMovie(movieRequest);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity updateMovieAttributes(@RequestBody UpdateMovieRequest updateMovieRequest){

        String response = movieService.updateMovieAttributes(updateMovieRequest);
        return new ResponseEntity(response,HttpStatus.OK);
    }





}
