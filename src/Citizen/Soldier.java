package Citizen;

public class Soldier extends Citizen {
	
	public Soldier(String name) {
		super(name);
	}
	
	@Override
	public boolean canVote() {
		return true;
	}
	
	@Override
	public String toString() {
		return "Sierżant " + super.toString();
	}
}
