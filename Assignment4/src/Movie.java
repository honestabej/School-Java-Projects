
public class Movie {
	private String movieTitle;
	private int year;
	private int length;
	private Production prodCompany;
	
	public Movie() {
		year = 0;
		length = 0;
		prodCompany = new Production();	
	}
	
	public String getMovieTitle() {
		return movieTitle;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getLength() {
		return length;
	}
	
	public Production getProdCompany() {
		return prodCompany;
	}
	
	public void setMovieTitle(String title) {
		movieTitle = title;
	}
	
	public void setYear(int yearStr) {
		year = yearStr;
	}
	
	public void setLength(int lengthStr) {
		length = lengthStr;
	}
	
	public void setProdCompany(String prodName, String prodCity, String prodState) {
		prodCompany.setCompanyName(prodName);
		prodCompany.setLocationCity(prodCity);
		prodCompany.setLocationState(prodState);
	}
	
	public String toString() {
		return String.format("\nMovie Title:\t\t"+movieTitle+"\nMovie Length:\t\t"+length+"\nMovie Year:\t\t"+year+"\n"+prodCompany.toString()+"\n");
		
	}

}
