package com.paypal.bfs.test.bookingserv.data.domain;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Booking")
public class BookingData {
    @Id
    private Integer id;

    @Column(nullable = false)
    private String first_name;

    @Column
    private String last_name;

    @Column(nullable = false)
    private String date_of_birth;

    @Column(nullable = false)
    private String checkin_date_time;

    @Column(nullable = false)
    private String checkout_date_time;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Double deposit;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="address_id")
    private AddressData address;

}
