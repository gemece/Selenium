package junit;

public class Rental {

	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public double getCharge() {
		double result = 0;
		switch (movie.getPriceCode()) {
		case Regular:
			result += 2;
			if (daysRented > 2) {
				result += (daysRented - 2) * 1.5;
			}
			break;
		case NewRelease:
			result += daysRented * 3;
			break;
		case Childrens:
			result += 1.5;
			if (daysRented > 3) {
				result = (daysRented - 3) * 1.5;
			}
			break;
		}
		return result;
	}

	public int getFrequentRenterPoint(){
		if ((movie.getPriceCode() == Movie.PriceCodes.NewRelease) &&
		(daysRented > 1)) {
		return 2;
		}
		else return 1;
	}
}
