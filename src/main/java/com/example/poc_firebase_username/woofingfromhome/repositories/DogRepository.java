package com.example.poc_firebase_username.woofingfromhome.repositories;

import com.example.poc_firebase_username.woofingfromhome.models.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {
}
