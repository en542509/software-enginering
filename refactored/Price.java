// From book: 'Refactoring' by Martin Fowler
// Refactoring from chapter 1 applied (Derek Reilly)

public abstract class Price {

    public static Price createPrice (int priceCode) {
	Price thePrice = null;
	switch (priceCode) {
	case Movie.REGULAR: thePrice = new RegularPrice ();
	    break;
	case Movie.CHILDRENS: thePrice = new ChildrensPrice ();
	    break;
	case Movie.NEW_RELEASE: thePrice = new NewReleasePrice ();
	    break;
	default:
	    throw new IllegalArgumentException ("unrecognized price code: " + priceCode);
	}
	return thePrice;
    }

    public abstract int getPriceCode() ;

    public int getFrequentRenterPoints (int daysRented) { return 1; }
    public abstract double getCharge (int daysRented) ;
}

class NewReleasePrice extends Price {
    public int getPriceCode () { return Movie.NEW_RELEASE; }
    public double getCharge (int daysRented) {
	return daysRented * 3;
    }
    public int getFrequentRenterPoints (int daysRented) {
	return (daysRented > 1) ? 2: 1;
    }
}

class ChildrensPrice extends Price {
    public int getPriceCode () { return Movie.CHILDRENS; }
    public double getCharge (int daysRented) {
	double result = 1.5; 
	if (daysRented > 3)
	    result += (daysRented - 3) * 1.5; 
	return result;
    }
}

class RegularPrice extends Price {
    public int getPriceCode () { return Movie.REGULAR; }
    public double getCharge (int daysRented) {
	double result = 2; 
	if (daysRented > 2)
	    result += (daysRented - 2) * 1.5; 
	return result;
    }
}

