package com.example.poc_firebase_username.woofingfromhome.controllers;

import com.example.poc_firebase_username.woofingfromhome.models.Dog;
import com.example.poc_firebase_username.woofingfromhome.models.Match;
import com.example.poc_firebase_username.woofingfromhome.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatchController {


    @Autowired
    MatchRepository matchRepository;

    @GetMapping(value = "/matches")
    public ResponseEntity<List<Match>> getAllMatches(@RequestParam(required = false, name = "firebaseId") String firebaseId) {
        if (firebaseId != null) {
            return new ResponseEntity<>(matchRepository.findByCustomer1_FirebaseIdAndScoreGreaterThanOrCustomer2_FirebaseId(firebaseId, 0, firebaseId), HttpStatus.OK);
        }
        return new ResponseEntity<>(matchRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/matches/{id}")
    public ResponseEntity getCustomers(@PathVariable Long id) {
        return new ResponseEntity<>(matchRepository.findById(id), HttpStatus.OK);
    }

}

