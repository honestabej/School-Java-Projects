// Assignment #: 8
//         Name: Abe Johnson
//    StudentID: 1216031115
//      Lecture: T TH 1:30

import java.util.Comparator;

public class MovieTitleComparator implements Comparator<Movie>{
	
	public MovieTitleComparator() {
		
	}
	
	public int compare(Movie first, Movie second) {
		int compare = 1;
		compare = first.getMovieTitle().compareTo(second.getMovieTitle());
		return compare;
	}
}

//done