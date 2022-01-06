// Assignment #6: Arizona State University CSE205
//         Name: Abe Johnson
//    StudentID: 1216031115
//      Lecture: 1:30 - 2:45
//  Description: ReviewPane displays a list of available movies
//  from which a user can select to review.

import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;	//**Need to import to handle event
import javafx.event.EventHandler;	//**Need to import to handle event
import java.util.ArrayList;
import javafx.scene.layout.GridPane;	
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class ReviewPane extends VBox{
   
  
	private ArrayList<Movie> movieList;

   //A ListView to display movies created
	private ListView<Movie> movieListView;

   //declare all other necessary GUI variables here
	private Label instructions;
	private RadioButton poor, fair, average, good, excellent;
	private Button button;
	private double poorRB = 1, fairRB = 2, averageRB = 3, goodRB = 4, excellentRB = 5;

	
	
    
   //constructor
   public ReviewPane(ArrayList<Movie> list)
   {
       //initialize instance variables
       this.movieList = list;

       //set up the layout
       //----
       instructions = new Label("Choose a movie to give a review, and select a rating:");
       
       
       movieListView = new ListView<>();
       
       poor = new RadioButton("1 Poor");
       fair = new RadioButton("2 Fair");
       average = new RadioButton("3 Average");
       good = new RadioButton("4 Good");
       excellent = new RadioButton("5 Excellent");
       
       RatingHandler handler = new RatingHandler();
       poor.setOnAction(handler);
       fair.setOnAction(handler);
       average.setOnAction(handler);
       good.setOnAction(handler);
       excellent.setOnAction(handler);
       
       ToggleGroup toggle = new ToggleGroup();
       poor.setToggleGroup(toggle);
       fair.setToggleGroup(toggle);
       average.setToggleGroup(toggle);
       good.setToggleGroup(toggle);
       excellent.setToggleGroup(toggle);
       
       TilePane ratebuttons = new TilePane();
       ratebuttons.getChildren().addAll(poor, fair, average, good, excellent);
       
       button = new Button("Submit Review");
       GridPane.setHalignment(button, HPos.LEFT);
       button.setOnAction(handler);
       
       
       //ReviewPane is a VBox - add the components here
       this.getChildren().addAll(instructions, movieListView, ratebuttons, button);
       
       
       
       
   } //end of constructor

 //This method refresh the ListView whenever there's new movie added in CreatePane
 //you will need to update the underline ObservableList object in order for ListView
 //object to show the updated movie list
 public void updateMovieList(Movie newMovie){
	 movieList.clear();
     movieList.add(newMovie);
     movieListView.getItems().addAll(movieList);
     
 }

 //Step 2: Create a RatingHandler class
 private class RatingHandler implements EventHandler<ActionEvent>
    {
	 	
        //Override the abstract method handle()
        public void handle(ActionEvent event)
        {
        	
    	 	Review review1 = new Review();
            //When "Submit Review" button is pressed and a movie is selected from
            //the list view's average rating is updated by adding a additional
            //rating specified by a selected radio button
    	 	if(button.isArmed()) {
    	 		Movie movie1 = movieListView.getSelectionModel().getSelectedItem();
        		if(poor.isSelected()){
        			review1.updateRating(poorRB);
        			movie1.addRating(poorRB);
        		} else if(fair.isSelected()) {
        			review1.updateRating(fairRB);
        			movie1.addRating(fairRB); 
        		} else if(average.isSelected()) {
        			review1.updateRating(averageRB);
        			movie1.addRating(averageRB); 
        		} else if(good.isSelected()) {
        			review1.updateRating(goodRB);
        			movie1.addRating(goodRB); 
        		} else if(excellent.isSelected()) {
        			review1.updateRating(excellentRB);
        			movie1.addRating(excellentRB); 
        		}
        		
        			movieListView.refresh();
        	}
        }
    } //end of RatingHandler
} //end of ReviewPane class