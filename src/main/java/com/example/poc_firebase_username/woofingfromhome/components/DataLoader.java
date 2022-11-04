package com.example.poc_firebase_username.woofingfromhome.components;

import com.example.poc_firebase_username.woofingfromhome.models.Customer;
import com.example.poc_firebase_username.woofingfromhome.models.Dog;
import com.example.poc_firebase_username.woofingfromhome.models.Helpers;
import com.example.poc_firebase_username.woofingfromhome.models.Match;
import com.example.poc_firebase_username.woofingfromhome.repositories.CustomerRepository;
import com.example.poc_firebase_username.woofingfromhome.repositories.DogRepository;
import com.example.poc_firebase_username.woofingfromhome.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.MathContext;

@Profile("!test") //Run every time EXCEPT Tests
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    DogRepository dogRepository;

    @Autowired
    MatchRepository matchRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {
        Customer ben = new Customer("Ben", true, true, true, false, false, false, false, false, false, false, false, true, false, false, false, true, false, 2, false, false, 3, "-3.1351147", "55.901599");
        customerRepository.save(ben);

        Customer conrad = new Customer("Conrad", true, false, false, false, true, false, false, false, true, true, true, false, false, false, false, true, false, 3, false, true, 3, "-3.1352243", "55.902431");
        customerRepository.save(conrad);

        Customer callum = new Customer("Callum", false, true, true, false, true, false, false, true, false, false, true, false, false, false, false, true, false, 3, false, false, 3, "-3.129965", "55.100000");
        customerRepository.save(callum);

        Customer katie = new Customer("Katie", true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, 3, false, false, 1, "-3.131012", "55.956403");
        customerRepository.save(katie);

        Dog saffy = new Dog("Saffy", "9-12-2016", "Old English Sheepdog", 3, 2, true, false, true, true, true, ben);
        dogRepository.save(saffy);

        Dog teddy = new Dog("Teddy", "14-3-2018", "Golden Retriever", 2, 3, false, true, true, true, true, callum);
        dogRepository.save(teddy);

        Dog flo = new Dog("Flo", "4-07-2020", "Cavapoo", 1, 1, true, false, true, false, true, conrad);
        dogRepository.save(flo);

        Match match1 = new Match(ben, callum,Helpers.calculateDistanceFromAPI(ben,callum), Helpers.calculateMatchScore(ben,callum));
        matchRepository.save(match1);


        Match match2 = new Match(ben, conrad, Helpers.calculateDistanceFromAPI(ben, conrad), Helpers.calculateMatchScore(ben, conrad));
        matchRepository.save(match2);

        Match match3 = new Match(ben, katie, Helpers.calculateDistanceFromAPI(ben, katie), Helpers.calculateMatchScore(ben, katie));
        matchRepository.save(match3);

        Match match4 = new Match(callum, ben, Helpers.calculateDistanceFromAPI(callum, ben), Helpers.calculateMatchScore(callum, ben));
        matchRepository.save(match4);

        Match match5 = new Match(callum, conrad, Helpers.calculateDistanceFromAPI(callum, conrad), Helpers.calculateMatchScore(callum, conrad));
        matchRepository.save(match5);

        Match match6 = new Match(callum, katie, Helpers.calculateDistanceFromAPI(callum, katie), Helpers.calculateMatchScore(callum, katie));
        matchRepository.save(match6);

        Match match7 = new Match(conrad, ben, Helpers.calculateDistanceFromAPI(conrad, ben), Helpers.calculateMatchScore(conrad, ben));
        matchRepository.save(match7);

        Match match8 = new Match(conrad, callum, Helpers.calculateDistanceFromAPI(conrad, callum), Helpers.calculateMatchScore(conrad, callum));
        matchRepository.save(match8);

        Match match9 = new Match(conrad, katie, Helpers.calculateDistanceFromAPI(conrad, katie), Helpers.calculateMatchScore(conrad, katie));
        matchRepository.save(match9);

        Match match10 = new Match(katie, ben, Helpers.calculateDistanceFromAPI(katie, ben), Helpers.calculateMatchScore(katie, ben));
        matchRepository.save(match10);

        Match match11 = new Match(katie, callum, Helpers.calculateDistanceFromAPI(katie, callum), Helpers.calculateMatchScore(katie, callum));
        matchRepository.save(match11);

        Match match12 = new Match(katie, conrad, Helpers.calculateDistanceFromAPI(katie, conrad), Helpers.calculateMatchScore(katie, conrad));
        matchRepository.save(match12);

//        ignore
    }
}
