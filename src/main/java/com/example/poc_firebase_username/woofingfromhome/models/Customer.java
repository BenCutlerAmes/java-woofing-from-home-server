package com.example.poc_firebase_username.woofingfromhome.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="customers")
public class Customer {

    @Id
    private String firebaseId;

    @Column(name = "available_monday")
    private Boolean availableMonday;
    @Column(name = "available_tuesday")
    private Boolean availableTuesday;
    @Column(name = "available_wednesday")
    private Boolean availableWednesday;
    @Column(name = "available_thursday")
    private Boolean availableThursday;
    @Column(name = "available_friday")
    private Boolean availableFriday;
    @Column(name = "available_saturday")
    private Boolean availableSaturday;
    @Column(name = "available_sunday")
    private Boolean availableSunday;

    @Column(name = "require_monday")
    private Boolean requireMonday;
    @Column(name = "require_tuesday")
    private Boolean requireTuesday;
    @Column(name = "require_wednesday")
    private Boolean requireWednesday;
    @Column(name = "require_thursday")
    private Boolean requireThursday;
    @Column(name = "require_friday")
    private Boolean requireFriday;
    @Column(name = "require_saturday")
    private Boolean requireSaturday;
    @Column(name = "require_sunday")
    private Boolean requireSunday;

    @Column(name = "has_kids")
    private Boolean hasKids;

    @Column(name = "has_other_dogs")
    private Boolean hasOtherDogs;

    @Column(name = "has_cats")
    private Boolean hasCats;

    @Column(name = "exercise_offered")
    private Integer exerciseOffered;

    @Column(name = "dog_left_alone")
    private Boolean dogLeftAlone;

    @Column(name = "has_allergies")
    private Boolean hasAllergies;

    @Column(name = "dog_size_offer")
    private Integer dogSizeOffer;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "latitude")
    private String latitude;

    @OneToMany (mappedBy = "customer" , fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties({"customer"})
    private List<Dog> dogs;

    @OneToMany(mappedBy = "customer1", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Match> matches1;

    @OneToMany(mappedBy = "customer2", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Match> matches2;

    public Customer(String firebaseId, Boolean availableMonday, Boolean availableTuesday, Boolean availableWednesday, Boolean availableThursday, Boolean availableFriday, Boolean availableSaturday, Boolean availableSunday, Boolean requireMonday, Boolean requireTuesday, Boolean requireWednesday, Boolean requireThursday, Boolean requireFriday, Boolean requireSaturday, Boolean requireSunday, Boolean hasKids, Boolean hasOtherDogs, Boolean hasCats, Integer exerciseOffered, Boolean dogLeftAlone, Boolean hasAllergies, Integer dogSizeOffer, String longitude, String latitude) {
        this.firebaseId = firebaseId;
        this.availableMonday = availableMonday;
        this.availableTuesday = availableTuesday;
        this.availableWednesday = availableWednesday;
        this.availableThursday = availableThursday;
        this.availableFriday = availableFriday;
        this.availableSaturday = availableSaturday;
        this.availableSunday = availableSunday;
        this.requireMonday = requireMonday;
        this.requireTuesday = requireTuesday;
        this.requireWednesday = requireWednesday;
        this.requireThursday = requireThursday;
        this.requireFriday = requireFriday;
        this.requireSaturday = requireSaturday;
        this.requireSunday = requireSunday;
        this.hasKids = hasKids;
        this.hasOtherDogs = hasOtherDogs;
        this.hasCats = hasCats;
        this.exerciseOffered = exerciseOffered;
        this.dogLeftAlone = dogLeftAlone;
        this.hasAllergies = hasAllergies;
        this.dogSizeOffer = dogSizeOffer;
        this.longitude = longitude;
        this.latitude = latitude;
        this.dogs = new ArrayList<>();
    }

    public Customer(){}

    public String getFirebase_id() {
        return firebaseId;
    }

    public void setFirebase_id(String firebase_id) {
        this.firebaseId = firebaseId;
    }

    public Boolean getAvailableMonday() {
        return availableMonday;
    }

    public void setAvailableMonday(Boolean availableMonday) {
        this.availableMonday = availableMonday;
    }

    public Boolean getAvailableTuesday() {
        return availableTuesday;
    }

    public void setAvailableTuesday(Boolean availableTuesday) {
        this.availableTuesday = availableTuesday;
    }

    public Boolean getAvailableWednesday() {
        return availableWednesday;
    }

    public void setAvailableWednesday(Boolean availableWednesday) {
        this.availableWednesday = availableWednesday;
    }

    public Boolean getAvailableThursday() {
        return availableThursday;
    }

    public void setAvailableThursday(Boolean availableThursday) {
        this.availableThursday = availableThursday;
    }

    public Boolean getAvailableFriday() {
        return availableFriday;
    }

    public void setAvailableFriday(Boolean availableFriday) {
        this.availableFriday = availableFriday;
    }

    public Boolean getAvailableSaturday() {
        return availableSaturday;
    }

    public void setAvailableSaturday(Boolean availableSaturday) {
        this.availableSaturday = availableSaturday;
    }

    public Boolean getAvailableSunday() {
        return availableSunday;
    }

    public void setAvailableSunday(Boolean availableSunday) {
        this.availableSunday = availableSunday;
    }

    public Boolean getRequireMonday() {
        return requireMonday;
    }

    public void setRequireMonday(Boolean requireMonday) {
        this.requireMonday = requireMonday;
    }

    public Boolean getRequireTuesday() {
        return requireTuesday;
    }

    public void setRequireTuesday(Boolean requireTuesday) {
        this.requireTuesday = requireTuesday;
    }

    public Boolean getRequireWednesday() {
        return requireWednesday;
    }

    public void setRequireWednesday(Boolean requireWednesday) {
        this.requireWednesday = requireWednesday;
    }

    public Boolean getRequireThursday() {
        return requireThursday;
    }

    public void setRequireThursday(Boolean requireThursday) {
        this.requireThursday = requireThursday;
    }

    public Boolean getRequireFriday() {
        return requireFriday;
    }

    public void setRequireFriday(Boolean requireFriday) {
        this.requireFriday = requireFriday;
    }

    public Boolean getRequireSaturday() {
        return requireSaturday;
    }

    public void setRequireSaturday(Boolean requireSaturday) {
        this.requireSaturday = requireSaturday;
    }

    public Boolean getRequireSunday() {
        return requireSunday;
    }

    public void setRequireSunday(Boolean requireSunday) {
        this.requireSunday = requireSunday;
    }

    public Boolean getHasKids() {
        return hasKids;
    }

    public void setHasKids(Boolean hasKids) {
        this.hasKids = hasKids;
    }

    public Boolean getHasOtherDogs() {
        return hasOtherDogs;
    }

    public void setHasOtherDogs(Boolean hasOtherDogs) {
        this.hasOtherDogs = hasOtherDogs;
    }

    public Boolean getHasCats() {
        return hasCats;
    }

    public void setHasCats(Boolean hasCats) {
        this.hasCats = hasCats;
    }

    public Integer getExerciseOffered() {
        return exerciseOffered;
    }

    public void setExerciseOffered(Integer exerciseOffered) {
        this.exerciseOffered = exerciseOffered;
    }

    public Boolean getDogLeftAlone() {
        return dogLeftAlone;
    }

    public void setDogLeftAlone(Boolean dogLeftAlone) {
        this.dogLeftAlone = dogLeftAlone;
    }

    public Boolean getHasAllergies() {
        return hasAllergies;
    }

    public void setHasAllergies(Boolean hasAllergies) {
        this.hasAllergies = hasAllergies;
    }

    public Integer getDogSizeOffer() {
        return dogSizeOffer;
    }

    public void setDogSizeOffer(Integer dogSizeOffer) {
        this.dogSizeOffer = dogSizeOffer;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }
}
