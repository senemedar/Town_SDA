package Citizen;

public abstract class Citizen {
	private String name;
	
	public Citizen(String name) {
		this.name = name;
	}
	
	public abstract boolean canVote();
	
	@Override
	public String toString() {
		return name;
	}
}
