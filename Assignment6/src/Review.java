// Assignment #6: Arizona State University CSE205
//         Name: Abe Johnson
//    StudentID: 1216031115
//      Lecture: 1:30 - 2:45
//  Description: The class Review represent reviews of a movie.

import java.text.DecimalFormat;

public class Review
 {
   private int numberOfReviews;
   private double sumOfRatings;
   private double average;

   //Constructor to initialize all member variables
   public Review()
    {
     numberOfReviews = 0;
     sumOfRatings = 0.0;
     average = 0.0;
    }

   //It updates the number of REviews and average based on the
   //an additional rating specified by its parameter
   public void updateRating(double rating)
    {
      numberOfReviews++;
      sumOfRatings += rating;
      if (numberOfReviews > 0)
       {
        average = sumOfRatings/numberOfReviews;
       }
      else
        average = 0.0;
    }

   //toString() method returns a string containing its review average
   //and the number of Reviews
   public String toString()
    {
      DecimalFormat fmt = new DecimalFormat("0.00");
      String result = "Reviews:\t" + fmt.format(average) + "("
                    + numberOfReviews + ")";
      return result;
     }
  }
