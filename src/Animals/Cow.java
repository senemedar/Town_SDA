package Animals;

public class Cow extends Animal implements FarmAnimal {
	
	private boolean hasMilk;
	
	public Cow(String name) {
		super(name, 5);
	}
	
	@Override
	public void makeSound() {
		if (hasMilk) {
			System.out.println("Moooooo!!");
		} else {
			System.out.println("Munch, munch...");
		}
	}
	
	public void milk() {
		this.hasMilk = false;
//		System.out.println("Brawo! Wydoiłeś " + name);
		System.out.println("Brawo! Wydoiłeś swoją krowę.");
	}
}
