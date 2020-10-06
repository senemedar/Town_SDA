package Citizen;

public class King extends Citizen {
	
	public King(String name) {
		super(name);
	}
	
	@Override
	public boolean canVote() {
		return false;
	}
	
	@Override
	public String toString() {
		return "Król " + super.toString();
	}
}
