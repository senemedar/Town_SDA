package Client;

public class Klient {
	private String name;
	private int age;
	private boolean isPremium;
	
	public Klient(String name, int age, boolean isPremium) {
		this.name = name;
		this.age = age;
		this.isPremium = isPremium;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setPremium(boolean premium) {
		this.setPremium(premium);
	}
	
	public void podajDane() {
		System.out.println("Klient " + this.getName() + ", wiek " + this.getAge() + ", premium: " + this.czyJestesKlientemPremium());
	}
	
	public void wyprawUrodziny () {
		System.out.println("Ktoś ma dzisiaj urodziny...!!!");
		this.setAge(this.age + 1);
	}
	
	public void zmienImie(String newName) {
		this.setName(newName);
	}
	
	public boolean czyJestesKlientemPremium() {
		return this.isPremium;
	}
	
	public void awansujDoKlientaPremium() {
		this.isPremium = true;
	}
}
