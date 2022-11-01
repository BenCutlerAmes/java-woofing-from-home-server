package com.example.poc_firebase_username.woofingfromhome.components;

import com.example.poc_firebase_username.woofingfromhome.models.Customer;
import com.example.poc_firebase_username.woofingfromhome.models.Dog;
import com.example.poc_firebase_username.woofingfromhome.models.Match;
import com.example.poc_firebase_username.woofingfromhome.repositories.CustomerRepository;
import com.example.poc_firebase_username.woofingfromhome.repositories.DogRepository;
import com.example.poc_firebase_username.woofingfromhome.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test") //Run every time EXCEPT Tests
//@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    DogRepository dogRepository;

    @Autowired
    MatchRepository matchRepository;

    public DataLoader() {}

    public void run(ApplicationArguments args) {
        Customer customer = new Customer("Conrad", true,true,true,true,true,true,true,false,false,false,false,false,false,false,true,true,true,9,true,true,6, "33.33", "33.33");
        customerRepository.save(customer);

        Customer customer2 = new Customer("Callum", true,true,true,true,true,true,true,false,false,false,false,false,false,false,true,true,true,9,true,true,6, "33.33", "33.33");
        customerRepository.save(customer2);

//        Customer customer2 = new Customer("changed1234", true,true,true,true,true,true,true,false,false,false,false,false,false,false,true,true,true,9,true,true,6);
//        customerRepository.save(customer2);
//
//        Customer customer3 = new Customer("newPerson3", true,true,true,true,true,true,true,false,false,false,false,false,false,false,true,true,true,9,true,true,6);
//        customerRepository.save(customer3);
//
//        Customer customer4 = new Customer("newPerson4", true,true,true,true,true,true,true,false,false,false,false,false,false,false,true,true,true,9,true,true,6);
//        customerRepository.save(customer4);
//
//        Customer customer5 = new Customer("newPerson5",true,true,true,true,true,true,true,false,false,false,false,false,false,false,true,true,true,9,true,true,6);
//        customerRepository.save(customer5);
//
//        Customer customer6 = new Customer("newPerson6",true,true,true,true,true,true,true,false,false,false,false,false,false,false,true,true,true,9,true,true,6);
//        customerRepository.save(customer6);
//
        Dog dog = new Dog("Bingo","7-12-2021","Cavapoo",3,3,true,true,true,true,false,customer);
        dogRepository.save(dog);
//
        Match match = new Match(customer, customer2, 1234, 98.3);
        matchRepository.save(match);
//
//        Match match2 = new Match(customer2, customer, 8454, 100);
//        matchRepository.save(match2);
//
//        Match match3 = new Match(customer3, customer4, 9342, 13);
//        matchRepository.save(match3);
//
//        Match match4 = new Match(customer5, customer6, 9641, 35);
//        matchRepository.save(match4);


    }
}
