package com.example.poc_firebase_username.woofingfromhome;

import com.example.poc_firebase_username.woofingfromhome.models.Customer;


import com.example.poc_firebase_username.woofingfromhome.models.Dog;
import com.example.poc_firebase_username.woofingfromhome.models.Match;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)

@SpringBootTest
public class WoofingFromHomeServerTests {

	Customer customer;
	Customer customer2;

	@Before
	public void setup(){
		customer = new Customer("Conrad", true, true, true, true, true, true, true, false, false, false, false, false, false, false, true, true, true, 9, true, true, 6, "33.33", "33.33");
		customer2 = new Customer("Callum", true, true, true, true, true, true, true, false, false, false, false, false, false, false, true, true, true, 9, true, true, 6, "33.33", "33.33");
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void dogNotOKWithCats() {
		Dog dog = new Dog("Bingo","7-12-2021","Cavapoo",3,3,true,true,true,false,false,customer);
		customer.getDogs().add(dog);
		Match match = new Match(customer, customer2, 50, 0);
		assertEquals(0, match.calculateMatchScore(customer, customer2), 0.0);
	}

	@Test
	public void dogOKWithAll() {
		Dog dog = new Dog("Bingo","7-12-2021","Cavapoo",3,3,true,true,true,true,true,customer);
		customer.getDogs().add(dog);
		Match match = new Match(customer, customer2, 50, 0);
		assertEquals(80, match.calculateMatchScore(customer, customer2), 0.0);
	}

	@Test
	public void dogNotOKWithKids() {
		Dog dog = new Dog("Bingo","7-12-2021","Cavapoo",3,3,true,true,false,true,false,customer);
		Dog dog2 = new Dog("Bingo","7-12-2021","Cavapoo",3,3,true,true,false,true,true,customer);
		customer.getDogs().add(dog);
		customer2.getDogs().add(dog2);
		Match match = new Match(customer, customer2, 50, 0);
		assertEquals(0, match.calculateMatchScore(customer, customer2), 0.0);
	}
	@Test
	public void testIsLoopingThroughDogs() {
		Dog dog = new Dog("Bingo","7-12-2021","Cavapoo",3,3,true,true,false,true,true,customer);
		Dog dog2 = new Dog("Bingo","7-12-2021","Cavapoo",3,3,true,true,false,true,false,customer);
		customer.getDogs().add(dog);
		customer.getDogs().add(dog2);
		customer2.getDogs().add(dog2);
		Match match = new Match(customer, customer2, 50, 0);
		assertEquals(0, match.calculateMatchScore(customer, customer2), 0.0);
	}








}
