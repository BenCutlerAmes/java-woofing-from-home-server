package com.example.poc_firebase_username.woofingfromhome.repositories;

import com.example.poc_firebase_username.woofingfromhome.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{

}
