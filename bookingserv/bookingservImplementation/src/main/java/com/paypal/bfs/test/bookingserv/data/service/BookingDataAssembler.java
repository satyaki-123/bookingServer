package com.paypal.bfs.test.bookingserv.data.service;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.data.domain.AddressData;
import com.paypal.bfs.test.bookingserv.data.domain.BookingData;
import org.springframework.stereotype.Component;

@Component
public class BookingDataAssembler {

    public AddressData toAddressData(Booking booking){
        AddressData address = AddressData.builder()
                .line1(booking.getAddress().getLine1())
                .city(booking.getAddress().getCity())
                .state(booking.getAddress().getState())
                .zipcode(booking.getAddress().getZipCode())
                .build();
        if(booking.getAddress().getLine2() != null)
            address.setline2(booking.getAddress().getLine2());
        return address;
    }
    public BookingData toBookingData(Booking booking){
        BookingData bookingData = BookingData.builder()
                .id(booking.getId())
                .first_name(booking.getFirstName())
                .last_name(booking.getLastName())
                .date_of_birth(booking.getDateOfBirth())
                .checkin_date_time(booking.getCheckinDateTime())
                .checkout_date_time(booking.getCheckoutDateTime())
                .price(booking.getTotalPrice())
                .deposit(booking.getDeposit())
                .build();
        return bookingData;
    }

    public Booking toBooking(BookingData bookingData){
        Booking booking = new Booking();
        booking.setId(bookingData.getId());
        booking.setFirstName(bookingData.getFirst_name());
        booking.setLastName(bookingData.getLast_name());
        booking.setCheckinDateTime(bookingData.getCheckin_date_time());
        booking.setCheckoutDateTime(bookingData.getCheckout_date_time());
        booking.setTotalPrice(bookingData.getPrice());
        booking.setDeposit(bookingData.getDeposit());
        booking.setDateOfBirth(bookingData.getDate_of_birth());
        com.paypal.bfs.test.bookingserv.api.model.Address addressModel = new com.paypal.bfs.test.bookingserv.api.model.Address();
        addressModel.setLine1(bookingData.getAddress().getLine1());
        addressModel.setLine2(bookingData.getAddress().getLine2());
        addressModel.setCity(bookingData.getAddress().getCity());
        addressModel.setState(bookingData.getAddress().getState());
        addressModel.setZipCode(bookingData.getAddress().getZipcode());
        booking.setAddress(addressModel);
        return booking;
    }
}
