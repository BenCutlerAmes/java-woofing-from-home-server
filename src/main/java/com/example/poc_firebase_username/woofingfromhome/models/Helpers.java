package com.example.poc_firebase_username.woofingfromhome.models;

import com.example.poc_firebase_username.woofingfromhome.repositories.CustomerRepository;

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

    public static void generateMatches(Customer customer, CustomerRepository customerRepository){
        for (Customer customera: customerRepository.findAll()){

        }
    }
}
