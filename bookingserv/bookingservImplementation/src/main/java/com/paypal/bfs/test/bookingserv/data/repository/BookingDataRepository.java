package com.paypal.bfs.test.bookingserv.data.repository;

import com.paypal.bfs.test.bookingserv.data.domain.BookingData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDataRepository extends JpaRepository<BookingData,Long> {

}
