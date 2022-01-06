// Assignment #: 8
//         Name: Abe Johnson
//    StudentID: 1216031115
//      Lecture: T TH 1:30

import java.util.Comparator;

public class MovieYearComparator implements Comparator<Movie>{

	public MovieYearComparator() {	
		
	}
	
	public int compare(Movie first, Movie second) {
		int compare = 1;
		String movieYear1 = String.valueOf(first.getYear());
		String movieYear2 = String.valueOf(second.getYear());
		compare = movieYear1.compareTo(movieYear2);
		return compare;
	}
}

//done