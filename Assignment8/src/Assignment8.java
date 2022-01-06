// Assignment #: 8
//         Name: Abe Johnson
//    StudentID: 1216031115
//      Lecture: T TH 1:30
//  Description: The Assignment 8 class displays a menu of choices to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered. 

import java.io.*;

public class Assignment8
 {
  public static void main (String[] args)
   {
       char input1;
       String title, yearStr, lengthStr, prodName, prodCity, prodState;
       int year, length;
       boolean operation = false;
       int operation2 = 0;
       String line;
       String filename;
       FileWriter write;
       //FileReader read;

       // create a MovieArrangement object. This is used throughout this class.
       MovieArrangement arrange1 = null;

       try
       {
           // print out the menu
           printMenu();

           // create a BufferedReader object to read input from a keyboard
           InputStreamReader isr = new InputStreamReader (System.in);
           BufferedReader stdin = new BufferedReader (isr);
           
           System.out.print("Please enter a maximum number of movies\n");
           String maxStr = stdin.readLine().trim(); //read in the max number as a string
           int max = Integer.parseInt(maxStr);
           arrange1 = new MovieArrangement(max);

           do
           {
               System.out.print("What action would you like to perform?\n");
               line = stdin.readLine().trim();  //read a line
               input1 = line.charAt(0);
               input1 = Character.toUpperCase(input1);

               if (line.length() == 1)          //check if a user entered only one character
               {
                   switch (input1)
                   {
                       case 'A':   //Add Movie
                           System.out.print("Please enter the Movie information:\n");
                           System.out.print("Enter its title:\n");
                           title = stdin.readLine().trim();
                           System.out.print("Enter its length:\n");
                           lengthStr = stdin.readLine().trim();
                           length = Integer.parseInt(lengthStr);
                           System.out.print("Enter its year:\n");
                           yearStr = stdin.readLine().trim();
                           year = Integer.parseInt(yearStr);
                           System.out.print("Enter its production company name:\n");
                           prodName = stdin.readLine().trim();
                           System.out.print("Enter its production company's city:\n");
                           prodCity = stdin.readLine().trim();
                           System.out.print("Enter its production company's state:\n");
                           prodState = stdin.readLine().trim();

                           operation = arrange1.addMovie(title, length, year, prodName, prodCity, prodState);
                           if (operation == true)
                               System.out.print("movie added\n");
                           else
                               System.out.print("movie not added\n");
                           break;
                       case 'C':  //Create a new movie arrangement
                           System.out.print("Please enter a new maximum number of movies:\n");
                           maxStr = stdin.readLine().trim(); //read in the max number as a string
                           max = Integer.parseInt(maxStr);
                           arrange1 = new MovieArrangement(max);
                           break;
                       case 'D':  //Search by movie
                           System.out.print("Please enter movie title to search:\n");
                           title = stdin.readLine().trim();
                           System.out.print("Please enter movie year to search:\n");
                           yearStr = stdin.readLine().trim();
                           year = Integer.parseInt(yearStr);
                           operation2=arrange1.movieExists(title, year);

                           if (operation2 > -1)
                               System.out.print("movie " + title + " in " + year + " found\n");
                           else
                               System.out.print("movie " + title + " in " + year + " not found\n");
                           break;
                       case 'E':  //Search by production
                           System.out.print("Please enter the name of a production company to search:\n");
                           prodName = stdin.readLine().trim();
                           System.out.print("Please enter the city of a production company to search:\n");
                           prodCity = stdin.readLine().trim();
                           System.out.print("Please enter the state of a production company to search:\n");
                           prodState = stdin.readLine().trim();
                           
                           operation2=arrange1.productionExists(prodName, prodCity, prodState);
                    
                           if (operation2 > -1)
                           {
                               System.out.print("production "  + prodName + " at " + prodCity
                                            + "," + prodState + " found\n");
                           }
                           else
                           {
                               System.out.print("production "  + prodName + " at " + prodCity
                                                + "," + prodState + " not found\n");
                           }
                           break;
                       case 'L':   //List movies
                           System.out.print(arrange1.listMovies());
                           break;
                       case 'N':  // Sort by movie titles
                           arrange1.sortByMovieTitles();
                           System.out.print("sorted by movie titles\n");
                           break;
                       case 'O':  // Sort by movie years
                           arrange1.sortByMovieYears();
                           System.out.print("sorted by movie years\n");
                           break;
                       case 'P':  // Sort by Productions
                           arrange1.sortByProductions();
                           System.out.print("sorted by productions\n");
                           break;
                       case 'Q':   //Quit
                           break;
                       case 'R':  //Remove by movie
                           System.out.print("Please enter movie title to remove:\n");
                           title = stdin.readLine().trim();
                           System.out.print("Please enter movie year to remove:\n");
                           yearStr = stdin.readLine().trim();
                           year = Integer.parseInt(yearStr);
                           operation = arrange1.removeMovie(title, year);
                           if (operation == true)
                               System.out.print("movie " + title + " in " + year + " removed\n");
                           else
                               System.out.print("movie " + title + " in " + year + " not removed\n");

                           break;
                       case 'T':  //Close MovieArrangement
                           arrange1.closeMovieArrangement();
                           System.out.print("movie arrangement system closed\n");
                           break;
                       case 'U':  //Write Text to a File
                           System.out.print("Please enter a file name to write:\n");
                           filename = stdin.readLine().trim();
                           /************************************************************************************
                            ***  ADD your code to write a text (string) to the specified file. Catch exceptions.
                            ************************************************************************************/
                           System.out.println("Please enter a string to write in the file:");
                           String input = stdin.readLine().trim();
                           try { 
                        	   write = new FileWriter(filename);
                        	   write.write(input);
                        	   System.out.println(filename+" was written");
                           } catch(Exception e) {
                        	   System.out.println("Exception Occurred");
                           }
                           break;
                       case 'V':  //Read Text from a File
                           System.out.print("Please enter a file name to read:\n");
                           filename = stdin.readLine().trim();
                           /************************************************************************************
                            ***  ADD your code to read a text (string) from the specified file. Catch exceptions.
                            ************************************************************************************/
                           try {
                        	   String readText;
                        	   stdin = new BufferedReader(new FileReader(filename));
                        	   while (stdin.readLine() != null) {
                        		   readText = stdin.readLine();
                        		   System.out.println(readText);
                        	   }
                           } catch(Exception e) {
                        	   System.out.println("Exception Occurred");
                           }
                           break;
                   case 'W':  //Serialize MovieArrangement to a File
                           System.out.print("Please enter a file name to write:\n");
                           filename = stdin.readLine().trim();
                           /************************************************************************************
                            ***  ADD your code to write the movie arrangement object to the specified file. Catch exceptions.
                            ************************************************************************************/
                           try {
                        	   FileOutputStream fos = new FileOutputStream(filename);
                        	   ObjectOutputStream oos = new ObjectOutputStream(fos);
                        	   oos.writeObject(arrange1);
                        	   oos.close();
                        	   fos.close();
                           } catch(Exception e){
                        	   System.out.println("Exception Occurred");
                           }
                           break;
                       case 'X':  //Deserialize MovieArrangement from a File
                           System.out.print("Please enter a file name to read:\n");
                           filename = stdin.readLine().trim();
                           /************************************************************************************
                            ***  ADD your code to read a  movie arrangement from the specified file. Catch exception.
                            ***********************************************************************************/
                           try {
                        	   FileInputStream fis = new FileInputStream(filename);
                        	   ObjectInputStream ois = new ObjectInputStream(fis);
                        	   ois.readObject();
                        	   ois.close();
                        	   fis.close();
                           } catch (Exception e) {
                        	   System.out.println("Exception Occurred");
                           }
                           break;
                       case '?':   //Display Menu
                           printMenu();
                           break;
                       default:
                           System.out.print("Unknown action\n");
                           break;
                   }
               }
               else
               {
                   System.out.print("Unknown action\n");
               }
           } while (input1 != 'Q' || line.length() != 1);
       }
    catch (IOException exception)
       {
           System.out.print("IO Exception\n");
       }
   }

  /** The method printMenu displays the menu to a user **/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                      "------\t\t------\n" +
                      "A\t\tAdd Movie\n" +
                      "C\t\tCreate MovieArrangement\n" +
                      "D\t\tSearch by Movie\n" +
                      "E\t\tSearch by Production\n" +
                      "L\t\tList Movies\n" +
                      "N\t\tSort by Movie Titles\n" +
                      "O\t\tSort by Movie Years\n" +
                      "P\t\tSort by Productions\n" +
                      "Q\t\tQuit\n" +
                      "R\t\tRemove by Movie\n" +
                      "T\t\tClose MovieArrangement\n" +
                      "U\t\tWrite Text to File\n" +
                      "V\t\tRead Text from File\n" +
                      "W\t\tSerialize MovieArrangement to File\n" +
                      "X\t\tDeserialize MovieArrangement from File\n" +
                      "?\t\tDisplay Help\n\n");
  }
}

