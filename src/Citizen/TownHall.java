package Citizen;

public class TownHall {
	public static void main(String[] args) {
		
		Town ciechocinek = new Town();
		
//		Citizen artur = new King("Król Artur");
//		Citizen janek = new Peasant("Jan Kowalski");
		
		ciechocinek.addCitizen(new King("Artur"));
		ciechocinek.addCitizen(new Peasant("Jan Kowalski"));
		ciechocinek.addCitizen(new Soldier("Mariusz Pudzianowski"));
		ciechocinek.addCitizen(new Townsman("Jan Kochanowski"));
		
		System.out.println();
		
		for (Citizen citizen : ciechocinek.getCitizens()) {
			if (citizen.canVote()) {
				System.out.println(citizen + " może brać udział w wyborach.");
			} else {
				System.out.println(citizen + " niestety nie może głosować.");
			}
			
		}
		
		System.out.println();
		System.out.println("W mieście może głosować " + ciechocinek.howManyCanVote() + " mieszkańców.");
		System.out.println();
		ciechocinek.whoCanVote();
	}
}
