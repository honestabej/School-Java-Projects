
public class Production {
	private String companyName;
	private String locationCity;
	private String locationState;
	
	
	public Production() {
		companyName = "?";
		locationCity = "?";
		locationState = "?";
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public String getLocationCity() {
		return locationCity;
	}
	
	public String getLocationState() {
		return locationState;
	}
	
	public void setCompanyName(String prodName) {
		companyName = prodName;
	}
	
	public void setLocationCity(String prodCity) {
		locationCity = prodCity;
	}
	
	public void setLocationState(String prodState) {
		locationState = prodState;
	}
	
	public String toString() {
		return String.format("Movie Production:\t"+companyName+" at "+locationCity+","+locationState+"\n");
	}

}
