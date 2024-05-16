package com.acciojob.bookmyshowmay.Repositories;

import com.acciojob.bookmyshowmay.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,String> {
}
