package com.abhishek.ecommercebackendsystem.Repositories;

import com.abhishek.ecommercebackendsystem.Models.Customer;
import com.abhishek.ecommercebackendsystem.Models.Order;
//import org.hibernate.mapping.List;
import java.util.List;
import java.util.Optional;

import com.abhishek.ecommercebackendsystem.Models.Order;
import com.abhishek.ecommercebackendsystem.Models.OrderStatus;
import jakarta.annotation.Nullable;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByUsername(String username);

    @Override
    @NonNull
    Optional<Customer> findById(Long id);

    @Override
    @NonNull
    List<Customer> findAll();

    @Override
    @NonNull
    Customer save(Customer customer);


}
