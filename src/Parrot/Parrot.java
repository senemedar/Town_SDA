package Parrot;

import java.util.Random;
import java.util.Scanner;

public class Parrot {
	Random rand = new Random();
	Scanner sc = new Scanner(System.in);
	private String name;
	private String[] vocabulary = new String[] {"Arrr", "Arrr", "Arrr", "Arrr", "Arrr"};
	
	public Parrot(String name) {
		this.name = name;
	}
	
	public void listen() {
		System.out.println("Uczymy papugę słowa: ");
		String newWord = sc.nextLine();
		vocabulary[rand.nextInt(5)] = newWord;
	}
	
	public void say() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.name).append(" mówi: ");
		for (int i = 0; i < rand.nextInt(4) + 1; i++) {
			sb.append(vocabulary[rand.nextInt(vocabulary.length)]).append(" ");
		}
		
		System.out.println(sb.toString());
	}
	
	public String sayWords() {
		StringBuilder sb = new StringBuilder();
		for (String word : vocabulary) {
			sb.append(word).append(" ");
		}
		return sb.toString();
	}
}
