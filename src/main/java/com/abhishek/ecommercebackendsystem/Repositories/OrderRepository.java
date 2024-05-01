package com.abhishek.ecommercebackendsystem.Repositories;

import com.abhishek.ecommercebackendsystem.Models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    @Override
    Orders save(Orders order);

    @Override
    Optional<Orders> findById(Long aLong);
}
