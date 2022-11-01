package com.example.poc_firebase_username.woofingfromhome.repositories;

import com.example.poc_firebase_username.woofingfromhome.models.Dog;
import com.example.poc_firebase_username.woofingfromhome.models.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    List<Match> findByCustomer1FirebaseId(String firebaseId);
}