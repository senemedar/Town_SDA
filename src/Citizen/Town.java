package Citizen;

import java.util.ArrayList;
import java.util.List;

public class Town {
	
	List<Citizen> listaMieszczuchow = new ArrayList<>();
	
	public List<Citizen> getCitizens() {
		return listaMieszczuchow;
	}
	
	public void addCitizen(Citizen citizen) {
		listaMieszczuchow.add(citizen);
		System.out.println(citizen + " wprowadził się do miasta.");
	}
	
	public int howManyCanVote() {
		int canVote = 0;
		for (Citizen citizen : listaMieszczuchow) {
			if (citizen.canVote())
				canVote++;
		}
		
		return canVote;
	}
	
	public void whoCanVote() {
		StringBuilder sb = new StringBuilder("Mieszkańcy, którzy mogą głosować:\n");
		int no = 0;
		for (Citizen citizen : listaMieszczuchow) {
			if (citizen.canVote()) {
				no++;
				sb.append(no).append(". ").append(citizen).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
