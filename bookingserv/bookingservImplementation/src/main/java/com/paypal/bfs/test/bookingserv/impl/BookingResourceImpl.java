package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.data.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingResourceImpl implements BookingResource {

    @Autowired
    BookingService bookingService;

    @Override
    public ResponseEntity<Booking> create(Booking booking) {
        Boolean success = bookingService.createBooking(booking);
        if(success)
            return ResponseEntity.ok(booking);
        else
            return new ResponseEntity<Booking>(HttpStatus.BAD_REQUEST);
    }
    @Override
    public ResponseEntity<List<Booking>> getAll() {
        List<Booking> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }
}
