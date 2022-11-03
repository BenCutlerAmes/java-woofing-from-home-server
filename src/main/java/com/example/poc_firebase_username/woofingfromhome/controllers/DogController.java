package com.example.poc_firebase_username.woofingfromhome.controllers;

import com.example.poc_firebase_username.woofingfromhome.models.Customer;
import com.example.poc_firebase_username.woofingfromhome.models.Dog;
import com.example.poc_firebase_username.woofingfromhome.models.Helpers;
import com.example.poc_firebase_username.woofingfromhome.models.Match;
import com.example.poc_firebase_username.woofingfromhome.repositories.DogRepository;
import com.example.poc_firebase_username.woofingfromhome.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DogController {

    @Autowired
    DogRepository dogRepository;

    @Autowired
    MatchRepository matchRepository;


    @GetMapping(value = "/dogs")
    public ResponseEntity<List<Dog>> getAllDogs(@RequestParam(required = false, name = "firebaseId") String firebaseId) {
        if (firebaseId != null) {
            return new ResponseEntity<>(dogRepository.findByCustomerFirebaseId(firebaseId), HttpStatus.OK);
        }
        return new ResponseEntity<>(dogRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/dogs/{id}")
    public ResponseEntity getDogs(@PathVariable Long id) {
        return new ResponseEntity<>(dogRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/dogs")
    public ResponseEntity<Dog> postDog(@RequestBody Dog dog) {
        dogRepository.save(dog);
        Customer customer = dog.getCustomer();
        Helpers.updateMatchTable(customer,matchRepository.findAll(),matchRepository);
        return new ResponseEntity<>(dog, HttpStatus.CREATED);
    }

    @PutMapping(value = "/dogs/{id}")
    public ResponseEntity<Dog> updateDog(@PathVariable Long id, @RequestBody Dog dog) {
        dogRepository.save(dog);
        Customer customer = dog.getCustomer();
        Helpers.updateMatchTable(customer,matchRepository.findAll(),matchRepository);
        return new ResponseEntity<>(dog, HttpStatus.OK);
    }

    @DeleteMapping(value = "/dogs/{id}")
    public ResponseEntity deleteDog(@PathVariable Long id) {
        dogRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
