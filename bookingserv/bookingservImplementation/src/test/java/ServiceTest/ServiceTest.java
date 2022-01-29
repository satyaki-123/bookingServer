package ServiceTest;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.data.domain.AddressData;
import com.paypal.bfs.test.bookingserv.data.domain.BookingData;
import com.paypal.bfs.test.bookingserv.data.repository.AddressRepository;
import com.paypal.bfs.test.bookingserv.data.repository.BookingDataRepository;
import com.paypal.bfs.test.bookingserv.data.service.BookingDataAssembler;
import com.paypal.bfs.test.bookingserv.data.service.BookingService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {

    @InjectMocks
    BookingService service;

    @Mock
    BookingDataAssembler assembler;

    @Mock
    BookingDataRepository bookingDataRepository;

    @Mock
    AddressRepository addressRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkResourceTestNegative(){
        Booking booking = TestHelper.getSampleBookingDetails("firstName","lastName");
        BookingData bookingdata = TestHelper.getSampleBookingData(1,"firstName","lastName");
        List<BookingData> bookingDatas= TestHelper.getSampleBookingDataWithAddress();
        AddressData addressData = TestHelper.getSampleAddressData();
        Mockito.when(assembler.toAddressData(booking)).thenReturn(TestHelper.getSampleAddressData());
        Mockito.when(assembler.toBookingData(booking)).thenReturn(bookingdata);
        Mockito.when(bookingDataRepository.findAll()).thenReturn(bookingDatas);
        boolean check = service.createBooking(booking);
        Assert.assertEquals(check,false);
    }

    @Test
    public void checkResourceTestPositive(){
        Booking booking = TestHelper.getSampleBookingDetails("firstName3","lastName3");
        BookingData bookingdata = TestHelper.getSampleBookingData(5,"firstName3","lastName3");
        List<BookingData> bookingDatas= TestHelper.getSampleBookingDataWithAddress();
        AddressData addressData = TestHelper.getSampleAddressData();
        Mockito.when(assembler.toAddressData(booking)).thenReturn(TestHelper.getSampleAddressData());
        Mockito.when(assembler.toBookingData(booking)).thenReturn(bookingdata);
        Mockito.when(bookingDataRepository.findAll()).thenReturn(bookingDatas);
        Mockito.when(addressRepository.save(addressData)).thenReturn(addressData);
        Mockito.when(bookingDataRepository.save(bookingdata)).thenReturn(null);
        boolean check = service.createBooking(booking);
        Assert.assertEquals(check,true);
    }

    @Test
    public void getallBookings(){
        List<BookingData> bookingDatas= new ArrayList<>(Arrays.asList(TestHelper.getSampleBookingDataWithAddress().get(0)));
        Mockito.when(bookingDataRepository.findAll()).thenReturn(bookingDatas);
        Mockito.when(assembler.toBooking(TestHelper.getSampleBookingData(1,"firstName","LastName"))).thenReturn(TestHelper.getSampleBookingDetails("firstName","LastName"));
        List<Booking> bookings = service.getAllBookings();
        Assert.assertEquals(bookings.size(),1);
    }
}
