package ServiceTest;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.data.domain.AddressData;
import com.paypal.bfs.test.bookingserv.data.domain.BookingData;
import com.paypal.bfs.test.bookingserv.data.service.BookingDataAssembler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DataAssemblerTest {

    @InjectMocks
    BookingDataAssembler assembler;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void toAddressDataTest(){
        AddressData addressDataAssembled = assembler.toAddressData(TestHelper.getSampleBookingDetails("firstName","lastName"));
        Boolean check = addressDataAssembled.equals(TestHelper.getSampleAddressData());
        Assert.assertEquals(check,true);
    }

    @Test
    public void toBookingDatatest(){
        BookingData assembledBookingData = assembler.toBookingData(TestHelper.getSampleBookingDetails("firstName","lastName"));
        Boolean check = assembledBookingData.equals(TestHelper.getSampleBookingData(1,"firstName","lastName"));
        Assert.assertEquals(check,true);
    }

//    @Test
//    public void toBookingTest(){
//        BookingData sampleBookingData = TestHelper.getSampleBookingData();
//        sampleBookingData.setAddress(TestHelper.getSampleAddressData());
//        Booking assembledBooking = assembler.toBooking(sampleBookingData);
//        Boolean check = assembledBooking.equals(TestHelper.getSampleBookingDetails());
//        Assert.assertEquals(check,true);
//    }
}
