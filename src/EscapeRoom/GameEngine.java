package EscapeRoom;

import java.util.Scanner;

public class GameEngine {
	
	public static void init() {
		Player currentPlayer = new Player("Antek");
		Room pokoj = new Room();
		
//		pickUp(pokoj, gracz, pokoj.getItemsList().get(0));
		
		// The game begins
		pokoj.walkIn(currentPlayer);
		System.out.println(pokoj);
		
//		useItem(currentPlayer, pokoj, pokoj.getItemsList().get(0));
		Scanner sc = new Scanner(System.in);
		// the Game
		boolean cont = true;
		do {
//			System.out.println("\n-------------------------------------\n" + pokoj);
			
			System.out.println("\nCo " + currentPlayer.getName() + " ma teraz zrobić?");
			System.out.println("1. Użyj przedmiotu znalezionego w pokoju.");
			System.out.println("2. Rozejrzyj się po pokoju.");
			System.out.println("3. Zobacz, jakie przedmioty posiada obecnie " + currentPlayer.getName());
			System.out.println("0. Zakończ rozgrywkę.");
			int choice = sc.nextInt();
			switch (choice) {
				case 1 -> {
					System.out.println("Który przedmiot chcesz użyć?");
					int choice2 = sc.nextInt();
					if (useItem(currentPlayer, pokoj, pokoj.getItemsList().get(choice2 - 1)))
						cont = false;    // the doors are now open; end the game
				}
				case 2 -> System.out.println(pokoj);
				case 3 -> System.out.println(currentPlayer.getItemsList());
				case 0 -> cont = false;
			}
			
		} while(cont);
		
		System.out.println("\nGratulacje! Udało Ci się wydostać z pokoju!!");
	}
	
	public static boolean useItem(Player player, Room room, Item item) {
		int cont = item.use(player);
		if (cont == 1) {
			room.removeItem(item);    // player has picked up item so we need to remove it from the room's inventory
			room.listItems();
			return false;
		} else return cont == -1;    // if using item returned '-1' then we're ending the game
		
	}
	
}
