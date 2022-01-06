// Assignment #: 8
//         Name: Abe Johnson
//    StudentID: 1216031115
//      Lecture: T TH 1:30

import java.io.Serializable;

public class MovieArrangement implements Serializable{

		private Movie[] movieList;
		private int currentMovieCount;
		private int maxSize;
		
		public MovieArrangement(int maximumSize) {
			this.maxSize = maximumSize;
			this.movieList = new Movie[maxSize];
			for (int i = 0; i < this.maxSize; i++) {
				movieList[i] = null;
			}
			currentMovieCount = 0;
		}
		
		public int movieExists(String movieTitle, int year) {
			for (int i = 0; i < this.maxSize; i++) {
				Movie movie = this.movieList[i];
				if (movie.getMovieTitle().equalsIgnoreCase(movieTitle) && movie.getYear() == year) {
					return i;
				} 
			}
			return -1;
		}
		
		public int productionExists(String companyName, String locationCity, String locationState) {
			for (int i = 0; i < this.maxSize; i++) {
				Movie movie = this.movieList[i];
				if (movie.getProdCompany().getCompanyName().equalsIgnoreCase(companyName)
				&& movie.getProdCompany().getLocationCity().equalsIgnoreCase(locationCity)
				&& movie.getProdCompany().getLocationState().equalsIgnoreCase(locationState)) {
					return i;
				}
			}
			return -1;
		}
		
		public boolean addMovie(String movieTitle, int length, int year, String companyName, String locationCity, String locationState) {
			Movie movie = new Movie();
			movie.setMovieTitle(movieTitle);
			movie.setLength(length);
			movie.setYear(year);
			movie.setProdCompany(companyName, locationCity, locationState);
			if (productionExists(companyName, locationCity, locationState)<0) {
				if (this.currentMovieCount < this.maxSize) {
					movieList[this.currentMovieCount] = movie;
					this.currentMovieCount++;
					return true;
				}
			}
			return false;
		}
		
		public boolean removeMovie(String movieTitle, int year) {
			Movie movie = new Movie();
			for (int i = 0; i < this.maxSize; i++) {
				if (movie.getMovieTitle().equalsIgnoreCase(movieTitle) && movie.getYear() == year) {
					movieList[i] = null;
					this.currentMovieCount--;
					for (int k = i+1; k < this.maxSize; k++) {
						this.movieList[k-1] = this.movieList[k];
					}
					return true;
				}
			}
			return false;
		}
		
		public void sortByMovieTitles() {
			MovieTitleComparator mtc = new MovieTitleComparator();
			Sorts.sort(movieList, maxSize, mtc);
		}
		
		public void sortByMovieYears() {
			MovieYearComparator myc = new MovieYearComparator();
			Sorts.sort(movieList, maxSize, myc);
		}
		
		public void sortByProductions() {
			ProductionLocationComparator plc = new ProductionLocationComparator();
			Sorts.sort(movieList, maxSize, plc);
		}
		
		public String listMovies() {
			Movie movie = new Movie();
			String movies = null;
			if (currentMovieCount > 0) {
				for (int i = 0; i < this.maxSize; i++) {
					movies += movie.toString();
				}
				return movies;
			} else {
				return "\nno movie\n\n";
			}
		}
		
		public void closeMovieArrangement() {
			this.currentMovieCount = 0;
			for (int i = 0; i < this.maxSize; i++) {
				this.movieList[i] = null;
			}
		}
}

//done
