package junit;

import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {

		// Declaramos variables Rental, Customer y Movie
		List<Rental> rentals;
		Customer customer;
		List<Movie> movies;
		
		movies = new ArrayList<Movie>();
		Movie movie1 = new Movie("Hulk", Movie.PriceCodes.Regular);
		Movie movie2 = new Movie("IronMan", Movie.PriceCodes.Childrens);
		Movie movie3 = new Movie("Spiderman", Movie.PriceCodes.NewRelease);
		movies.add(movie1);
		movies.add(movie2);
		movies.add(movie3);
	// Creamos alquileres
		rentals = new ArrayList<Rental>();
		Rental rental1 = new Rental(movies.get(0), 2);
		Rental rental2 = new Rental(movies.get(1), 3);
		Rental rental3 = new Rental(movies.get(2), 4);
		rentals.add(rental1);
		rentals.add(rental2);
		rentals.add(rental3);
	// Creamos clientes
		customer = new Customer("Guillermo");
		customer.addRental(rentals.get(0));
	// Obtenemos el string que devuelve statement()
		String cadena = customer.statement();
		System.out.println(cadena);
		System.out.println("Cadena final");
		System.out.println(message(rentals.get(0).getMovie().getTitle(), 2.0, 2.0, 1));
		if(cadena.equals(message(rentals.get(0).getMovie().getTitle(), 2.0, 2.0, 1))) {
			System.out.println("Funciona correctamente");
		}
	}
	
	public static String message(String rental, double price, double total, int renterPoints) {
		return "Rental record for Guillermo\n\t" + rental + "\t" + price + "\nAmount owed is " + total + "\nYou earned " + renterPoints + " frequent renter points.";
	}

}
