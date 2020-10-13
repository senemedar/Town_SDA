package Exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionsDemo {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = 0;
		boolean cont = false;
		do {
			try {
				System.out.println("Podaj jakąś liczbę:");
				cont = false;
				a = sc.nextInt();
			} catch (InputMismatchException e) {
				cont = true;
				System.out.println("Podano litery, nie można przekonwertować to typu 'int'");
			}
			sc.nextLine();
		} while (cont);
		
		System.out.println(a);
	}
}