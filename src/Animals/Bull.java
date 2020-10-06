package Animals;

public class Bull extends Animal {
	
	public Bull(String name, int age) {
		super(name, age);
	}
	
	@Override
	public void makeSound() {
		System.out.println("Jestem groźnym bykiem!!");
	}
	
	public void charge() {
//		System.out.println("Uważaj!! " + name + " na Ciebie szarżuje!!");
		System.out.println("Uważaj!! Byk na Ciebie szarżuje!!");
	}
}
