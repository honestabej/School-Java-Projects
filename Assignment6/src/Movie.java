// Assignment #6: Arizona State University CSE205
//         Name: Abe Johnson
//    StudentID: 1216031115
//      Lecture: 1:30 - 2:45
//  Description: The class Movie represents a Movie.

public class Movie
 {
     private String movieTitle;
     private int year;
     private int length;
     private Review movieReview;
     
   //Constructor to initialize all member variables
   public Movie()
    {
      movieTitle = "?";
      length = 0;
      year = 0;
      movieReview = new Review();
    }

   //Acsessor methods
   public String getMovieTitle()
    {
      return movieTitle;
    }

   public int getLength()
    {
      return length;
    }

   public int getYear()
    {
	   return year;
	}

   public Review getReview()
    {
       return movieReview;
    }

   //Mutator methods
   public void setMovieTitle(String aTitle)
    {
     movieTitle = aTitle;
    }

   public void setLength(int aLength)
    {
     length = aLength;
    }

   public void setYear(int aYear)
    {
        year = aYear;
    }

   public void addRating(double rate)
     {
         movieReview.updateRating(rate);
     }

   //toString() method returns a string containing the information on the movie
   public String toString()
    {
      String result = "\nMovie Title:\t\t" + movieTitle
                    + "\nMovie Length:\t\t" + length
                    + "\nMovie Year:\t\t" + year
                    + "\n" + movieReview.toString() + "\n\n";
      return result;
     }
  }