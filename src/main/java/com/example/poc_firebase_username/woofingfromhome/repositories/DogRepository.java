package com.example.poc_firebase_username.woofingfromhome.repositories;

import com.example.poc_firebase_username.woofingfromhome.models.Customer;
import com.example.poc_firebase_username.woofingfromhome.models.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {

    List<Dog> findByCustomerFirebaseId(String firebase_Id);


}
