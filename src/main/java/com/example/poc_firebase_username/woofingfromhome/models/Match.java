package com.example.poc_firebase_username.woofingfromhome.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties({"matches"})
    @ManyToOne
    @JoinColumn(name = "matcher", nullable = false)
    private Customer customer1;

    @JsonIgnoreProperties({"matches"})
    @ManyToOne
    @JoinColumn(name = "matchee", nullable = false)
    private Customer customer2;

    @Column(name = "distance")
    private Integer distance;

    @Column(name = "score")
    private double score;

    public Match(Customer customer1, Customer customer2, Integer distance, double score) {
        this.customer1 = customer1;
        this.customer2 = customer2;
        this.distance = distance;
        this.score = score;
    }

    public Match(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer1() {
        return customer1;
    }

    public void setCustomer1(Customer customer1) {
        this.customer1 = customer1;
    }

    public Customer getCustomer2() {
        return customer2;
    }

    public void setCustomer2(Customer customer2) {
        this.customer2 = customer2;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double calculateMatchScore(Customer customer1, Customer customer2){
        double score = 80;
        //rule out cases where any of customers dogs cannot be around cats and other customer has cat
        //loop through customer 1 dogs and check against customer 2 has cat
        for(Dog dog : customer1.getDogs()){
            if(!dog.getOkWithCats() && customer2.getHasCats()){
                return 0;
            }
        }
        for(Dog dog : customer1.getDogs()){
            if(!dog.getOkWithKids() && customer2.getHasKids()){
                return 0;
            }
        }

        for(Dog dog : customer1.getDogs()){
            if(!dog.getOkWithDogs() && customer2.getDogs().size() > 0){
                return 0;
            }
        }
        return score;

    }
}
