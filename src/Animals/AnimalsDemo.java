package Animals;

/*
Przygotuj swoją własną wersję przykładu ze zwierzętami.
Stwórz dwie klasy zwierząt, nadaj im po dwie wspólne cechy (pola) oraz dwie metody, jedną drukującą dźwięk zwierzęcia, drugą robiącą coś charakterystycznego tylko dla niego,
trzecią całkowicie wspólną dla obu (np. goToSleep). Zbierz w main różne zwierzęta do wspólnej listy (<Animal>) i wywołaj ich wspólną odziedziczoną z klasy bazowej metodę.

Stwórz metodę wydającą dźwięk już w klasie bazowej Animal i nadpisz ją odpowiednio w klasach swoich zwierząt.
Przetestuj ją wywołując nadpisaną metodę w pętli na zbiorze zwierząt.
Przenieś do klasy bazowej Animal pola z klas poszczególnych zwierząt i wykorzystaj słowo kluczowe ‘super’ w konstruktorach klas dziedziczących aby mogły przekazywać
odpowiednie dane do tych pól.
 */

public class AnimalsDemo {
	public static void main(String[] args) {
		Cow krowa = new Cow("Mućka");
		
		krowa.makeSound();
		krowa.milk();
		krowa.makeSound();
		
		Bull byk = new Bull("Maciek", 5);
		byk.charge();
		
		Animal[] animals = new Animal[] {krowa, byk};
		for (Animal animal : animals) {
			animal.makeSound();
			animal.goToBarn();
		}
		
	}
}
