// Assignment #: 8
//         Name: Abe Johnson
//    StudentID: 1216031115
//      Lecture: T TH 1:30

import java.util.Comparator;

public class ProductionLocationComparator implements Comparator<Movie> {
	
	public ProductionLocationComparator() {
		
	}
	
	public int compare(Movie first, Movie second) {
		int compare = 1;
		compare = first.getProdCompany().getLocationState().compareTo(second.getProdCompany().getLocationState());
		if (compare == 0) {
			compare = first.getProdCompany().getLocationCity().compareTo(second.getProdCompany().getLocationCity());
			return compare;
		} else {
			return compare;
		}
	}
}

//done