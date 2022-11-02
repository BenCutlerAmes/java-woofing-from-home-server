package com.example.poc_firebase_username.woofingfromhome;

import com.example.poc_firebase_username.woofingfromhome.models.Customer;


import com.example.poc_firebase_username.woofingfromhome.models.Dog;
import com.example.poc_firebase_username.woofingfromhome.models.Helpers;
import com.example.poc_firebase_username.woofingfromhome.models.Match;
import org.hibernate.id.uuid.Helper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)

@SpringBootTest
public class WoofingFromHomeServerTests {

	Customer customer;
	Customer customer2;

	@Before
	public void setup(){
		customer = new Customer("Conrad", true, true, true, true, true, true, true, false, false, false, false, false, false, false, true, true, true, 9, true, true, 6, "33.33", "33.33");
		customer2 = new Customer("Callum", true, true, true, true, true, true, true, false, false, false, false, false, false, false, true, true, true, 1, true, true, 1, "33.33", "33.33");
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void dogNotOKWithCats() {
		Dog dog = new Dog("Bingo","7-12-2021","Cavapoo",3,3,true,true,true,false,false,customer);
		customer.getDogs().add(dog);
		Match match = new Match(customer, customer2, 50, 0);
		assertEquals(0, Helpers.calculateMatchScore(customer, customer2), 0.0);
	}

	@Test
	public void dogOKWithAll() {
		Dog dog = new Dog("Bingo","7-12-2021","Cavapoo",2,2,true,true,true,true,true,customer);
		customer.getDogs().add(dog);
		Match match = new Match(customer, customer2, 50, 0);
		assertEquals(100, Helpers.calculateMatchScore(customer, customer2), 0.0);
	}

	@Test
	public void dogNotOKWithKids() {
		Dog dog = new Dog("Bingo","7-12-2021","Cavapoo",3,3,true,true,false,true,false,customer);
		Dog dog2 = new Dog("Bingo","7-12-2021","Cavapoo",3,3,true,true,false,true,true,customer);
		customer.getDogs().add(dog);
		customer2.getDogs().add(dog2);
		Match match = new Match(customer, customer2, 50, 0);
		assertEquals(0, Helpers.calculateMatchScore(customer, customer2), 0.0);
	}
	@Test
	public void testIsLoopingThroughDogs() {
		Dog dog = new Dog("Bingo","7-12-2021","Cavapoo",3,3,true,true,false,true,true,customer);
		Dog dog2 = new Dog("Bingo","7-12-2021","Cavapoo",3,3,true,true,false,true,false,customer);
		customer.getDogs().add(dog);
		customer.getDogs().add(dog2);
		customer2.getDogs().add(dog2);
		Match match = new Match(customer, customer2, 50, 0);
		assertEquals(0, Helpers.calculateMatchScore(customer, customer2), 0.0);
	}

	@Test
	public void customer2HasAllergiesButDogHypoallergenic() {
		Dog dog = new Dog("Bingo","7-12-2021","Cavapoo",2,1,true,true,true,true,true,customer);
		customer.getDogs().add(dog);
		Match match = new Match(customer, customer2, 50, 0);
		assertEquals(100, Helpers.calculateMatchScore(customer, customer2), 0.0);
	}

	@Test
	public void customer2HasAllergiesButDogNotHypoallergenic() {
		Dog dog = new Dog("Bingo","7-12-2021","Cavapoo",3,3,false,true,true,true,true,customer);
		customer.getDogs().add(dog);
		Match match = new Match(customer, customer2, 50, 0);
		assertEquals(0, Helpers.calculateMatchScore(customer, customer2), 0.0);
	}

	@Test
	public void dogCannotBeLeftAlone() {
		Dog dog = new Dog("Bingo","7-12-2021","Cavapoo",3,3,true,false,true,true,true,customer);
		customer.getDogs().add(dog);
		Match match = new Match(customer, customer2, 50, 0);
		assertEquals(0, Helpers.calculateMatchScore(customer, customer2), 0.0);
	}

	@Test
	public void largeDog() {
		Dog dog = new Dog("Bingo","7-12-2021","Cavapoo",3,3,true,true,true,true,true,customer);
		customer.getDogs().add(dog);
		Match match = new Match(customer, customer2, 50, 0);
		assertEquals(0, Helpers.calculateMatchScore(customer, customer2), 0.0);
	}

	@Test
	public void dogNeedsHighExercise() {
		Dog dog = new Dog("Bingo","7-12-2021","Cavapoo",1,3,true,true,true,true,true,customer);
		customer.getDogs().add(dog);
		Match match = new Match(customer, customer2, 50, 0);
		assertEquals(0, Helpers.calculateMatchScore(customer, customer2), 0.0);
	}

	@Test
	public void testHasNoRequirements() {
		customer = new Customer("Conrad", false, true, true, true, true, true, true, false, false, false, false, false, false, false, true, true, true, 2, true, true, 2, "33.33", "33.33");
		customer2 = new Customer("Callum", false, true, true, true, true, true, true, true, false, false, false, false, false, false, true, true, true, 2, true, true, 2, "33.33", "33.33");
		Dog dog = new Dog("Bingo","7-12-2021","Cavapoo",2,2,true,true,true,true,true,customer);
		customer.getDogs().add(dog);
		Match match = new Match(customer, customer2, 50, 0);
		assertEquals(100, Helpers.calculateMatchScore(customer, customer2), 0.0);
	}

	@Test
	public void testMeets3DaysOf5Requirements() {
		customer = new Customer("Conrad", false, true, true, true, true, true, true, true, true, true, true, true, false, false, true, true, true, 2, true, true, 2, "33.33", "33.33");
		customer2 = new Customer("Callum", false, false, true, true, true, true, true, true, false, false, false, false, false, false, true, true, true, 2, true, true, 2, "33.33", "33.33");
		Dog dog = new Dog("Bingo","7-12-2021","Cavapoo",2,2,true,true,true,true,true,customer);
		customer.getDogs().add(dog);
		Match match = new Match(customer, customer2, 50, 0);
		assertEquals(60, Helpers.calculateMatchScore(customer, customer2), 0.0);
	}

}
