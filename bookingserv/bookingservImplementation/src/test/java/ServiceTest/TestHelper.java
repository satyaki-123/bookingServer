package ServiceTest;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.data.domain.AddressData;
import com.paypal.bfs.test.bookingserv.data.domain.BookingData;

import java.util.ArrayList;
import java.util.List;

public class TestHelper {

    public static Booking getSampleBookingDetails(String firstname, String secondName){
        Address sampleAddress = new Address();
        sampleAddress = new Address();
        sampleAddress.setLine1("line1");
        sampleAddress.setLine2("line2");
        sampleAddress.setCity("city");
        sampleAddress.setState("state");
        sampleAddress.setZipCode("560067");
        Booking sampleBooking = new Booking();
        sampleBooking = new Booking();
        sampleBooking.setId(1);
        sampleBooking.setDateOfBirth("17/10/1997");
        sampleBooking.setFirstName(firstname);
        sampleBooking.setLastName(secondName);
        sampleBooking.setCheckinDateTime("checkintime");
        sampleBooking.setCheckoutDateTime("checkouttime");
        sampleBooking.setTotalPrice(1000.0);
        sampleBooking.setDeposit(1000.0);
        sampleBooking.setAddress(sampleAddress);
        return sampleBooking;
    }

    public static Address getSampleAddress(){
        Address sampleAddress = new Address();
        sampleAddress = new Address();
        sampleAddress.setLine1("line1");
        sampleAddress.setLine2("line2");
        sampleAddress.setCity("city");
        sampleAddress.setState("state");
        sampleAddress.setZipCode("560067");
        return sampleAddress;
    }

    public static BookingData getSampleBookingData(int id,String firstName,String lastname){
        BookingData bookingData = new BookingData(id,firstName,lastname,"17/10/1997","checkintime","checkouttime",1000.0,1000.0,null);
        return bookingData;
    }

    public static List<BookingData> getSampleBookingDataWithAddress(){
        List<BookingData> bookings = new ArrayList<>();
        AddressData addressData = new AddressData(1L,"line1","line2","city","state","560067");
        BookingData bookingData1 = new BookingData(1,"firstName","lastName","17/10/1997","checkintime","checkouttime",1000.0,1000.0,addressData);
        bookings.add(bookingData1);
        BookingData bookingData2 = new BookingData(2,"firstName1","lastName1","17/10/1997","checkintime","checkouttime",1000.0,1000.0,addressData);
        bookings.add(bookingData2);
        return bookings;
    }
    public static AddressData getSampleAddressData(){
        AddressData addressData = new AddressData(1L,"line1","line2","city","state","560067");
        return addressData;
    }
}
