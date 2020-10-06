package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Car {
	private static int TO_MOT = 100_000;
	private static ArrayList<Car> listOfCars= new ArrayList<>();
	private String make;
	private int miles;
	
	public Car(String make, int miles) {
		this.make = make;
		this.miles = miles;
		listOfCars.add(this);
	}
	
	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public int getMiles() {
		return miles;
	}
	
	public void setMiles(int miles) {
		this.miles = miles;
	}
	
	public void drive(int distance) {
		this.miles += distance;
	}
	
	public static ArrayList<Car> getListOfCars() {
		return listOfCars;
	}
	
	public static int totalMileage() {
		int totalMileage = 0;
		for (Car car: listOfCars) {
			totalMileage += car.getMiles();
		}
		return totalMileage;
	}
	
	public String toMOT() {
		String reply = "";
		int mot = TO_MOT - this.getMiles();
		if (mot > 0) {
			reply += "Do przeglądu zostało: " + mot + " mil.";
		} else if (mot <= 0) {
			reply += "Powinieneś zrobić przegląd " + (-mot) + " mil temu!";
		}
		
		return reply;
	}
	
	@Override
	public String toString() {
		return "Ten samochód to " + this.getMake() + ". Jego przebieg to: " + this.getMiles() +
				"\n" + toMOT() + "\n";
	}
}
