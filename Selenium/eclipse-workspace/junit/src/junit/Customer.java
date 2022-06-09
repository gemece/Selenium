package junit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {

	private String name;
	private List<Rental> rentals = new ArrayList<>();

	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> iteradorRentals = rentals.iterator();

		String result = "Rental record for " + name + "\n";

		while (iteradorRentals.hasNext()) {
			Rental each = iteradorRentals.next();


			frequentRenterPoints += each.getFrequentRenterPoint();

			result += "\t" + each.getMovie().getTitle() + "\t" + Double.toString(each.getCharge()) + "\n";

			totalAmount += each.getCharge();
		}

		result += "Amount owed is " + Double.toString(totalAmount) + "\n";
		result += "You earned " + Integer.toString(frequentRenterPoints) + " frequent renter points.";
		return result;
	}

}
