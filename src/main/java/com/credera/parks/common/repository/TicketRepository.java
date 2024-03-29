package com.credera.parks.common.repository;

import com.credera.parks.common.model.Ticket;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByOrderByIdDesc();
    List<Ticket> findByPark_idOrderByIdDesc(Long park_id);
    List<Ticket> findByEmployee_usernameOrderByIdDesc(String employeeUsername);
}
