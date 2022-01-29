package com.paypal.bfs.test.bookingserv.data.domain;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "address")
public class AddressData {

    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @EqualsAndHashCode.Include
    @Column(nullable = false)
    private String line1;

    @EqualsAndHashCode.Include
    @Column
    private String line2;

    @EqualsAndHashCode.Include
    @Column(nullable = false)
    private String city;

    @EqualsAndHashCode.Include
    @Column(nullable = false)
    private String state;

    @EqualsAndHashCode.Include
    @Column(nullable = false)
    private String zipcode;

    public void setline2(String line2) {
        this.line2 = line2;
    }
}
