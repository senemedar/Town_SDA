package Client;

public class KlientDemo {
	public static void main(String[] args) {
		Klient jan = new Klient("Jan", 42, false);
		
		jan.podajDane();
		System.out.println(jan.czyJestesKlientemPremium());
		jan.zmienImie("Agata");
		jan.awansujDoKlientaPremium();
		jan.wyprawUrodziny();
		jan.podajDane();
	}
}
