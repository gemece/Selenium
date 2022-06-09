package junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class prueba {

	// Declaramos variables Rental, Customer y Movie
	private static List<Rental> rentals = new ArrayList<Rental>();;
	private static Customer customer;
	private static List<Movie> movies = new ArrayList<Movie>();;
	
	@BeforeAll
	public static void setUp() throws Exception {
	// Creamos películas de diferentes tipo
		Movie movie1 = new Movie("Hulk", Movie.PriceCodes.Regular);
		Movie movie2 = new Movie("IronMan", Movie.PriceCodes.Childrens);
		Movie movie3 = new Movie("Spiderman", Movie.PriceCodes.NewRelease);
		movies.add(movie1);
		movies.add(movie2);
		movies.add(movie3);
	// Creamos alquileres
		Rental rental1 = new Rental(movies.get(0), 2);
		Rental rental2 = new Rental(movies.get(1), 3);
		Rental rental3 = new Rental(movies.get(2), 4);
		rentals.add(rental1);
		rentals.add(rental2);
		rentals.add(rental3);
	// Creamos clientes
		customer = new Customer("Guillermo");
	}
	
	@Test
	public void testMovies(){
	// Comprobamos que el nombre de las películas creadas es correcto
		assertEquals(movies.get(0).getTitle(),"Hulk");
	// Comprobamos que el código del precio de las películas es correcto
		assertEquals(movies.get(0).getPriceCode(),Movie.PriceCodes.Regular);
		assertEquals(movies.get(1).getPriceCode(),Movie.PriceCodes.Childrens);
		assertEquals(movies.get(2).getPriceCode(),Movie.PriceCodes.NewRelease);
	}
	
	@Test
	public void testCustomers(){
	// Comprobamos que los clientes se han creado con el nombre correcto
		assertEquals(customer.getName(), "Guillermo");
	}
	
	@Test
	public void testRentals() {
	// Comprobamos que la película asociada al alquiler es correcta
		assertEquals(rentals.get(0).getMovie(), movies.get(0));
	// Comprobamos que los días asociados a cada alquiler son correctos
		assertEquals(rentals.get(0).getDaysRented(), 2);
	}
	
	@Test
	public void testStatement(){
	// Añadimos los alquileres a uno de los clientes
		customer.addRental(rentals.get(0));
	// Obtenemos el string que devuelve statement()
		String cadena = customer.statement();
	// Construimos un string que el resultado que creemos debe devolver
	// statement()
	// Comprobamos que statement() ha devuelto lo mismo que esper ́abamos
		assertEquals(cadena, message(rentals.get(0).getMovie().getTitle(), 2.0, 2.0, 1));
	}
	
	
	@Test
	public void testGetCharge(){
	// Comprobamos que el precio que devuelve getCharge de los
	//alquileres que hemos creado es el que hemos calculado
		assertEquals(rentals.get(0).getCharge(), 2.0);
	//a mano que debe ser
	}
	
	@Test
	public void testGetFrequentRenterPoint(){
		assertEquals(rentals.get(0).getFrequentRenterPoint(), 1);
	}
	
	private static String message(String rental, double price, double total, int renterPoints) {
		return "Rental record for Guillermo\n\t" + rental + "\t" + price + "\nAmount owed is " + total + "\nYou earned " + renterPoints + " frequent renter points.";
	}
	

}
