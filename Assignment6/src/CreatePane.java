// Assignment #6: Arizona State University CSE205
//         Name: Abe Johnson
//    StudentID: 1216031115
//      Lecture: 1:30 - 2:45
//  Description: CreatePane generates a pane where a user can enter
//  a movie information and create a list of available movies.

import java.util.ArrayList;
import javafx.scene.layout.HBox;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;	
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;


public class CreatePane extends HBox{
	
    private ArrayList<Movie> movieList;
    
    //The relationship between CreatePane and ReviewPane is Aggregation
    private ReviewPane reviewPane;
    private Button button;
    private Label title;
    private Label length;
    private Label year;
    private Label errorMessage;
    private Label formatHelp;
    private TextField titleField;
    private TextField lengthField;
    private TextField yearField;
    private TextArea textArea;
    
    //constructor
    public CreatePane(ArrayList<Movie> list, ReviewPane rePane){
    	//Step #1: initialize each instance variable and set up the layout
        this.movieList = list;
        this.reviewPane = rePane;
        
        //create a GridPane hold those labels & text fields
        //consider using .setPadding() or setHgap(), setVgap()
        //to control the spacing and gap, etc.
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.TOP_CENTER);
        
        errorMessage = new Label(""); errorMessage.setVisible(false); errorMessage.setTextFill(Color.RED);
        title = new Label("Title:");
        length = new Label("Length:");
        year = new Label("Year:");
        formatHelp = new Label("                         "); GridPane.setHalignment(formatHelp, HPos.RIGHT); formatHelp.setVisible(false);
        
        titleField = new TextField();
        lengthField = new TextField();
        yearField = new TextField();
        
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);		
        pane.setVgap(5.5);
        
        //You might need to create a sub pane to hold the button
        button = new Button("Create a Movie");
        GridPane.setHalignment(button, HPos.RIGHT);
        button.setOnAction(new ButtonHandler());
        
        //Set up the layout for the left half of the CreatePane.
        pane.add(errorMessage, 0, 0, 8, 1);
        pane.add(title,  0, 1, 4, 1);	   	pane.add(titleField, 4, 1);
        pane.add(length, 0, 2, 4, 1);		pane.add(lengthField, 4, 2);
        pane.add(year,   0, 3, 4, 1);		pane.add(yearField, 4, 3);
        pane.add(formatHelp, 3, 4);			pane.add(button, 4, 4);
       
        //the right half of the InputPane is simply a TextArea object
        //Note: a ScrollPane will be added to it automatically when there are no
        //enough space
        textArea = new TextArea();
        textArea.setText("No Movie");
        textArea.setEditable(false);
        
        //Add the left half and right half to the CreatePane
        //Note: CreatePane extends from HBox
        this.getChildren().addAll(pane, textArea);
        
    } //end of constructor

    //Step 2: Create a ButtonHandler class
    //ButtonHandler listens to see if the button "Create a Movie" is pushed or not,
    //When the event occurs, it get a movie's Title, Year, and Length
    //information from the relevant text fields, then create a new movie and add it inside
    //the movieList. Meanwhile it will display the movie's information inside the text area.
    //It also does error checking in case any of the textfields are empty or non-numeric string is typed
    private class ButtonHandler implements EventHandler<ActionEvent> {
        //Override the abstract method handle()
        public void handle(ActionEvent event){
            //declare any necessary local variables here
            Movie movie = new Movie();
            String nameMovie = titleField.getText();
            String textLength = lengthField.getText();
            String textYear = yearField.getText();
            
            //when a text field is empty and the button is pushed
            if (nameMovie.equals("") || textLength.equals("") || textYear.equals("")){
            	errorMessage.setText("Please fill all fields");
            	errorMessage.setVisible(true);
                }
            	else {
            		try {
            			if((textArea.getText()).equalsIgnoreCase("No Movie")) {
            			movie.setMovieTitle(nameMovie);
                       	movie.setLength(Integer.parseInt(textLength));
                       	movie.setYear(Integer.parseInt(textYear));
                       	textArea.setText("");
                       	textArea.appendText(movie.toString());
                       	errorMessage.setText("Movie added");
                       	errorMessage.setVisible(true);
                       	movieList.add(movie);
                       	titleField.setText("");
                       	lengthField.setText("");
                       	yearField.setText("");
                       	reviewPane.updateMovieList(movie); 
            			}else {
            				movie.setMovieTitle(nameMovie);
                           	movie.setLength(Integer.parseInt(textLength));
                           	movie.setYear(Integer.parseInt(textYear));
                           	textArea.appendText(movie.toString());
                           	errorMessage.setText("Movie added");
                           	errorMessage.setVisible(true);
                           	movieList.add(movie);
                           	titleField.setText("");
                           	lengthField.setText("");
                           	yearField.setText("");
                           	reviewPane.updateMovieList(movie);
            			}
            		}catch(NumberFormatException ex) {
            			errorMessage.setText("Incorrect data format");
            			errorMessage.setVisible(true);
            		}   
                }
         } //end of handle() method
   } //end of ButtonHandler class
   
}