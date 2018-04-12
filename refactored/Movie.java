// From book: 'Refactoring' by Martin Fowler
// This is the refactored code (Derek Reilly)

public class Movie {

    public static final int CHILDRENS = 2;
    public static final int NEW_RELEASE = 1;
    public static final int REGULAR = 0;
	
    private String _title;
    private Price _price;
	
	public Movie(String title, int priceCode) {
		_title = title;
		setPriceCode (priceCode);
	}
	
	public int getPriceCode() {
	    return _price.getPriceCode ();
	}

	public void setPriceCode (int arg) {
	    _price = Price.createPrice (arg); 
	}

	public String getTitle() {
		return _title;
	}

    public int getFrequentRenterPoints (int daysRented) {
	return _price.getFrequentRenterPoints (daysRented);
    }
	
    public double getCharge (int daysRented) {
	return _price.getCharge (daysRented);
    }
    
	
}
