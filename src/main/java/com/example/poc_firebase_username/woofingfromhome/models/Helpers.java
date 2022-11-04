package com.example.poc_firebase_username.woofingfromhome.models;

import com.example.poc_firebase_username.woofingfromhome.repositories.CustomerRepository;
import com.example.poc_firebase_username.woofingfromhome.repositories.MatchRepository;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import java.util.List;
import java.util.Objects;

public class Helpers {


    public static double calculateMatchScore(Customer customer1, Customer customer2) {
        double score = 80;
        //rule out cases where any of customers dogs cannot be around cats and other customer has cat
        //loop through customer 1 dogs and check against customer 2 has cat
        for (Dog dog : customer1.getDogs()) {
            if (!dog.getOkWithCats() && customer2.getHasCats()) {
                return 0;
            }
        }
        for (Dog dog : customer1.getDogs()) {
            if (!dog.getOkWithKids() && customer2.getHasKids()) {
                return 0;
            }
        }
        for (Dog dog : customer1.getDogs()) {
            if (!dog.getOkWithDogs() && customer2.getDogs().size() > 0) {
                return 0;
            }
        }
        for (Dog dog : customer1.getDogs()) {
            if (!dog.getHypoallergenic() && customer2.getHasAllergies()) {
                return 0;
            }
        }
        for (Dog dog : customer1.getDogs()) {
            if (!dog.getCanBeLeft() && customer2.getDogLeftAlone()) {
                return 0;
            }
        }
        for (Dog dog : customer1.getDogs()) {
            if (dog.getSize() == 3 && customer2.getDogSizeOffer() == 1) {
                return 0;
            }
        }
        for (Dog dog : customer1.getDogs()) {
            if (dog.getExerciseRequired() == 3 && customer2.getExerciseOffered() == 1) {
                return 0;
            }
        }
        double numberOfMatchedDays = 0;
        double numberOfRequiredDays = 0;
        if (customer1.getRequireMonday()) {
            numberOfRequiredDays += 1;
            if (customer2.getAvailableMonday()) {
                numberOfMatchedDays += 1;
            }
        }
        if (customer1.getRequireTuesday()) {
            numberOfRequiredDays += 1;
            if (customer2.getAvailableTuesday()) {
                numberOfMatchedDays += 1;
            }
        }
        if (customer1.getRequireWednesday()) {
            numberOfRequiredDays += 1;
            if (customer2.getAvailableWednesday()) {
                numberOfMatchedDays += 1;
            }
        }
        if (customer1.getRequireThursday()) {
            numberOfRequiredDays += 1;
            if (customer2.getAvailableThursday()) {
                numberOfMatchedDays += 1;
            }
        }
        if (customer1.getRequireFriday()) {
            numberOfRequiredDays += 1;
            if (customer2.getAvailableFriday()) {
                numberOfMatchedDays += 1;
            }
        }
        if (customer1.getRequireSaturday()) {
            numberOfRequiredDays += 1;
            if (customer2.getAvailableSaturday()) {
                numberOfMatchedDays += 1;
            }
        }
        if (customer1.getRequireSunday()) {
            numberOfRequiredDays += 1;
            if (customer2.getAvailableSunday()) {
                numberOfMatchedDays += 1;
            }
        }
        if (numberOfRequiredDays == 0) {
            return 100;
        }
        score = numberOfMatchedDays / numberOfRequiredDays * 100;
        return score;

    }

    public static void generateMatches(Customer customer, List<Customer> customerList, MatchRepository matchRepository) {
        for (Customer customera : customerList) {
            if (customer.getFirebaseId() == customera.getFirebaseId()) {
                continue;
            }
            double score1 = calculateMatchScore(customer, customera);
            System.out.println("score: "+score1);
            double distance1 = calculateDistanceFromAPI(customer,customera);
            System.out.println("distance: "+distance1);
            Match match1 = new Match(customer, customera, distance1, score1);
            matchRepository.save(match1);
            double score2 = calculateMatchScore(customera, customer);
            Match match2 = new Match(customera, customer, distance1, score2);
            matchRepository.save(match2);
        }
    }

    public static double calculateDistanceFromAPI(Customer customer1, Customer customer2) {
        String apiKey = "5b3ce3597851110001cf6248406081c305d04aabb57e123c78214b06";
        String customer1Coords = customer1.getLongitude() + "," + customer1.getLatitude();
        String customer2Coords = customer2.getLongitude() + "," + customer2.getLatitude();
        String requestString = "https://api.openrouteservice.org/v2/directions/driving-car?api_key=" + apiKey + "&start=" + customer1Coords + "&end=" + customer2Coords;
        Client client = ClientBuilder.newClient();
        Response response = client.target(requestString).request(MediaType.TEXT_PLAIN_TYPE).header("Accept", "application/json, application/geo+json, application/gpx+xml, img/png; charset=utf-8").get();
        double output = 0;
        try {
            output = new JsonParser().parse(response.readEntity(String.class)).getAsJsonObject().get("features").getAsJsonArray().get(0).getAsJsonObject().get("properties").getAsJsonObject().get("summary").getAsJsonObject().get("distance").getAsDouble();
        }catch(NullPointerException){
            output = 0;
        }
        return output;
    }

    public static void updateMatchTable(Customer customer, List<Match> matches, MatchRepository matchRepository) {
        for (Match match : matches) {
            if (Objects.equals(customer.getFirebaseId(), match.getCustomer1().getFirebaseId()) || Objects.equals(customer.getFirebaseId(), match.getCustomer2().getFirebaseId())) {
                double score = calculateMatchScore(match.getCustomer1(), match.getCustomer2());
                match.setScore(score);
                double distance = calculateDistanceFromAPI(match.getCustomer1(),match.getCustomer2());
                match.setDistance(distance);
            }
        }
    }
}
