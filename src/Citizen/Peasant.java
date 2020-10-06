package Citizen;

public class Peasant extends Citizen {
	
	public Peasant(String name) {
		super(name);
	}
	
	@Override
	public boolean canVote() {
		return false;
	}
	
	@Override
	public String toString() {
		return "Niejaki " + super.toString();
	}
}
