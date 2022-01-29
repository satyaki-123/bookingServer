package com.paypal.bfs.test.bookingserv.data.service;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.data.domain.AddressData;
import com.paypal.bfs.test.bookingserv.data.domain.BookingData;
import com.paypal.bfs.test.bookingserv.data.repository.AddressRepository;
import com.paypal.bfs.test.bookingserv.data.repository.BookingDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class BookingService {

    @Autowired
    BookingDataAssembler assembler;

    @Autowired
    BookingDataRepository bookingDataRepository;

    @Autowired
    AddressRepository addressRepository;

    private Boolean checkResource(BookingData bookingData, AddressData address){
        List<BookingData> bookingDataList = bookingDataRepository.findAll();
        boolean check = false;
        for(BookingData bookingDataCheck:bookingDataList){

            if(bookingData.getId().equals(bookingDataCheck.getId()))
                return false;
            check = bookingData.getFirst_name().equals(bookingDataCheck.getFirst_name()) &&
                    bookingData.getDate_of_birth().equals(bookingDataCheck.getDate_of_birth()) &&
                    bookingData.getCheckin_date_time().equals(bookingDataCheck.getCheckin_date_time()) &&
                    bookingData.getCheckout_date_time().equals(bookingDataCheck.getCheckout_date_time()) &&
                    bookingData.getPrice().equals(bookingDataCheck.getPrice()) &&
                    bookingData.getDeposit().equals(bookingDataCheck.getDeposit());
            check = check && bookingDataCheck.getAddress().getLine1().equals(address.getLine1()) &&
                    bookingDataCheck.getAddress().getCity().equals(address.getCity()) &&
                    bookingDataCheck.getAddress().getState().equals(address.getState()) &&
                    bookingDataCheck.getAddress().getZipcode().equals(address.getZipcode());

            if(bookingData.getLast_name() != null && bookingDataCheck.getLast_name() != null)
                check = check && bookingData.getLast_name().equals(bookingDataCheck.getLast_name());
            else if(bookingData.getLast_name() == null && bookingDataCheck.getLast_name() == null)
                check = check&&true;
            else
                check = check && false;

            if(address.getLine2() != null && bookingDataCheck.getAddress().getLine2() != null)
                check = check && bookingDataCheck.getAddress().getLine2().equals(address.getLine2());
            else if(address.getLine2() == null && bookingDataCheck.getAddress().getLine2() == null)
                check = check&&true;
            else
                check = check && false;

            if(check)
                return !check;
        }
        return !check;
    }

    public Boolean createBooking(Booking booking) {
        AddressData address = assembler.toAddressData(booking);
        BookingData bookingData = assembler.toBookingData(booking);
        if(checkResource(bookingData,address)){
            boolean res;
            try {
                AddressData addresssaved = addressRepository.save(address);
                bookingData.setAddress(addresssaved);
                bookingDataRepository.save(bookingData);
                res = true;
            }
            catch(Exception e){
                res = false;
                log.error("Persistence error");
            }
            return res;
        }
        else
            return false;
    }

    public List<Booking> getAllBookings() {
        List<BookingData> bookingDataList = (List<BookingData>)bookingDataRepository.findAll();
        List<Booking> bookingList = new ArrayList<>();
        bookingDataList.forEach(bookingData -> {
            bookingList.add(assembler.toBooking(bookingData));
        });
        return bookingList;
    }
}
