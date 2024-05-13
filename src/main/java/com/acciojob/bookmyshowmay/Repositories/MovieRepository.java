package com.acciojob.bookmyshowmay.Repositories;

import com.acciojob.bookmyshowmay.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {

    Movie findMovieByMovieName(String movieName);
}
