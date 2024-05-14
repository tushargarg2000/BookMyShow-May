package com.acciojob.bookmyshowmay.Repositories;

import com.acciojob.bookmyshowmay.Models.TheaterSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterSeatsRepository extends JpaRepository<TheaterSeat,Integer> {
}
