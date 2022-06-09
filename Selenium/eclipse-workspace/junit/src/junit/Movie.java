package junit;

public class Movie {

	public enum PriceCodes {
		Regular, NewRelease, Childrens
	}
	
    private String title;
    private PriceCodes price;

    public Movie(String title, PriceCodes priceCode) {
        this.title = title;
        this.price = priceCode;
    }

    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title){
    	this.title = title;
    }
    

    public PriceCodes getPriceCode() {
        return price;
    }

    public void setPriceCode(PriceCodes price){
    	this.price = price;
    }
    
}