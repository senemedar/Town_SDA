package Animals;

public abstract class Animal {
	private String name;
	private int age;
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void goToBarn() {
		System.out.println("Twoje zwierzę jest w stodole.");
	}
	
	public void makeSound() { }
	
	
}
