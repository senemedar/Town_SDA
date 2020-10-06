package Parrot;

public class Main {
	public static void main(String[] args) {
		Parrot polly = new Parrot("Polly");
		polly.say();
		do {
			polly.listen();
//			System.out.println(polly.sayWords());
			polly.sayWords();
			polly.say();
		} while (true);
	}
}