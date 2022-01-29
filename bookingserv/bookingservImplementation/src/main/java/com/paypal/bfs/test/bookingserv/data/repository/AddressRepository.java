package com.paypal.bfs.test.bookingserv.data.repository;

import com.paypal.bfs.test.bookingserv.data.domain.AddressData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressData,Long> {
}
