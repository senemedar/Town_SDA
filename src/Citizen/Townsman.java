package Citizen;

public class Townsman extends Citizen {
	
	public Townsman(String name) {
		super(name);
	}
	
	@Override
	public boolean canVote() {
		return true;
	}
	
	@Override
	public String toString() {
		return "Obywatel " + super.toString();
	}
}
