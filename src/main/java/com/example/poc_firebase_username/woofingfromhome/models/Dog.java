package com.example.poc_firebase_username.woofingfromhome.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="dogs")

public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "dob")
    private String dob;

    @Column(name = "breed")
    private String breed;

    @Column(name = "size")
    private Integer size;

    @Column(name = "exercise_required")
    private Integer exerciseRequired;

    @Column(name = "hypoallergenic")
    private Boolean hypoallergenic;

    @Column(name = "can_be_left")
    private Boolean canBeLeft;

    @Column(name = "ok_with_kids")
    private Boolean okWithKids;

    @Column(name = "ok_with_cats")
    private Boolean okWithCats;

    @Column(name = "ok_with_dogs")
    private Boolean okWithDogs;

    @JsonIgnoreProperties({"dogs"})
    @ManyToOne
    @JoinColumn(name = "firebase_id", nullable = false)
    private Customer customer;

    public Dog(String name, String dob, String breed, Integer size, Integer exerciseRequired, Boolean hypoallergenic, Boolean canBeLeft, Boolean okWithKids, Boolean okWithCats, Boolean okWithDogs, Customer customer) {
        this.name = name;
        this.dob = dob;
        this.breed = breed;
        this.size = size;
        this.exerciseRequired = exerciseRequired;
        this.hypoallergenic = hypoallergenic;
        this.canBeLeft = canBeLeft;
        this.okWithKids = okWithKids;
        this.okWithCats = okWithCats;
        this.okWithDogs = okWithDogs;
        this.customer = customer;
    }

    public Dog() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getExerciseRequired() {
        return exerciseRequired;
    }

    public void setExerciseRequired(Integer exerciseRequired) {
        this.exerciseRequired = exerciseRequired;
    }

    public Boolean getHypoallergenic() {
        return hypoallergenic;
    }

    public void setHypoallergenic(Boolean hypoallergenic) {
        this.hypoallergenic = hypoallergenic;
    }

    public Boolean getCanBeLeft() {
        return canBeLeft;
    }

    public void setCanBeLeft(Boolean canBeLeft) {
        this.canBeLeft = canBeLeft;
    }

    public Boolean getOkWithKids() {
        return okWithKids;
    }

    public void setOkWithKids(Boolean okWithKids) {
        this.okWithKids = okWithKids;
    }

    public Boolean getOkWithCats() {
        return okWithCats;
    }

    public void setOkWithCats(Boolean okWithCats) {
        this.okWithCats = okWithCats;
    }

    public Boolean getOkWithDogs() {
        return okWithDogs;
    }

    public void setOkWithDogs(Boolean okWithDogs) {
        this.okWithDogs = okWithDogs;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
