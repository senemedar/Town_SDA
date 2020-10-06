package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
		Car ford = new Car("Ford", 28000);
		Car honda = new Car("Honda", 74000);
	
		System.out.println(ford.toString());
		System.out.println(honda.toString());
	
		ford.drive(80000);
	
		System.out.println(ford.toString());
	
		System.out.println("Całkowity przebieg wszystkich samochodów to: " + Car.totalMileage());
    }
}
