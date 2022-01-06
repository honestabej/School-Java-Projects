// Assignment #7: Arizona State University CSE205
//          Name: Abe Johnson
//     StudentID: 1216031115
//       Lecture: T Th (1:30 - 2:45)
//   Description: The DrawingPane class creates a canvas where we can use
//                mouse key to draw lines with different colors and widths.
//                We can also use the the two buttons to erase the last
//				  drawn line or clear them all.


//import any classes necessary here
//----
import javafx.event.ActionEvent;	
import javafx.event.EventHandler;	
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Line;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;

public class DrawingPane extends BorderPane
{
   private Button undoButton, eraseButton;
   private ComboBox<String> colorCombo, widthCombo;
   private ArrayList<Line> lineList;
   private Pane canvas;
   //declare any other necessary instance variables here
   private double x1, y1, x2, y2;
   private Line line;
   private Color lineColor;
   private Double lineWidth;
   
   //Constructor

   public DrawingPane()
   {
      //Step #1: initialize instance variable and set up layout
      undoButton = new Button("Undo");
      eraseButton = new Button("Erase");
      undoButton.setMinWidth(80.0);
      eraseButton.setMinWidth(80.0);
      

      //Create the color comboBox and width comboBox,
      colorCombo = new ComboBox<String>();
      widthCombo = new ComboBox<String>();
      colorCombo.getItems().addAll("Black", "Blue", "Red", "Yellow", "Green");
      widthCombo.getItems().addAll("1", "3", "5", "7");
      colorCombo.setValue("Black");
      widthCombo.setValue("1");
      
      //initialize lineList, it is a data structure we used
      //to track the lines we created
      //----
      lineList = new ArrayList<Line>(); 
      
      //topPane should contain two combo boxes and two buttons
      HBox topPane = new HBox();
      topPane.setSpacing(40);
      topPane.setPadding(new Insets(10, 10, 10, 10));
      topPane.setStyle("-fx-border-color: black");
      topPane.getChildren().addAll(colorCombo, widthCombo, undoButton, eraseButton);
      
       
       //canvas is a Pane where we will draw lines
      canvas = new Pane();
      canvas.setStyle("-fx-background-color: white;");
      
       

       
      //add the canvas at the center of the pane and top panel
      //should have two combo boxes and two buttons
      this.setCenter(canvas);
      this.setTop(topPane);

       
      //Step #3: Register the source nodes with its handler objects
      canvas.setOnMousePressed(new MouseHandler());
      canvas.setOnMouseDragged(new MouseHandler());
      canvas.setOnMouseReleased(new MouseHandler());
      undoButton.setOnAction(new ButtonHandler());
      eraseButton.setOnAction(new ButtonHandler());
      colorCombo.setOnAction(new ColorHandler());
      widthCombo.setOnAction(new WidthHandler());
   }



    //Step #2(A) - MouseHandler
    private class MouseHandler implements EventHandler<MouseEvent>
    {
        public void handle(MouseEvent event)
        {
            //handle MouseEvent here
            //Note: you can use if(event.getEventType()== MouseEvent.MOUSE_PRESSED)
            //to check whether the mouse key is pressed, dragged or released
            //write your own codes here
            //----
        	if(event.getEventType()== MouseEvent.MOUSE_PRESSED)
            {
				//get the x & y coordinates where we click the mouse
				x1 = event.getX();
				y1 = event.getY();
				
				line = new Line();
				line.setStartX(x1);
				line.setStartY(y1);

			}
			else if(event.getEventType() == MouseEvent.MOUSE_DRAGGED)
			{
				x2 = event.getX();
				y2 = event.getY();
				line.setEndX(x2);
				line.setEndY(y2);
			
				if(colorCombo.getValue() == "Black") {
		    		   lineColor = Color.BLACK;
		    	}else line.setStroke(lineColor);
				
				if(widthCombo.getValue() == "1") {
	     		   	lineWidth = 2.0;
	     	   	}else line.setStrokeWidth(lineWidth);
	     	   	
				lineList.add(line);
				canvas.getChildren().addAll(line);
			}
            else if (event.getEventType()== MouseEvent.MOUSE_RELEASED )
            {
            	
            }
        	
            
            
        }//end handle()
    }//end MouseHandler

    //Step #2(B)- A handler class used to handle events from Undo & Erase buttons
    private class ButtonHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {
            //write your codes here
            //----
            if(undoButton.isArmed()) {
            	canvas.getChildren().remove(line);
            }else if(eraseButton.isArmed()) {
            	canvas.getChildren().clear();
            }
            
            
        }
    }//end ButtonHandler



   //Step #2(C)- A handler class used to handle colors
   private class ColorHandler implements EventHandler<ActionEvent>
   {
       public void handle(ActionEvent event)
       {
           //write your own codes here
           //----
    	   if(colorCombo.getValue() == "Black") {
    		   lineColor = Color.BLACK;
    		   //line.setStroke(lineColor);
    	   }else if(colorCombo.getValue() == "Blue") {
    		   lineColor = Color.BLUE;
    		   //line.setStroke(lineColor);
    	   }else if(colorCombo.getValue() == "Red") {
    		   lineColor = Color.RED;
    		   //line.setStroke(lineColor);
    	   }else if(colorCombo.getValue() == "Yellow") {
    		   lineColor = Color.YELLOW;
    		   //line.setStroke(lineColor);
    	   }else if(colorCombo.getValue() == "Green") {
    		   lineColor = Color.GREEN;
    		   //line.setStroke(lineColor);
    	   }
           
           
           
       }
   }//end ColorHandler
    
    //Step #2(D)- A handler class used to handle widths of lines
    private class WidthHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {
            //write your own codes here
            //----
        	if(widthCombo.getValue() == "1") {
     		   	lineWidth = 2.0;
     	   	}else if(widthCombo.getValue() == "3") {
     	   		lineWidth = 5.0;
     	   	}else if(widthCombo.getValue() == "5") {
     	   		lineWidth = 8.0;
     	   	}else if(widthCombo.getValue() == "7") {
     	   		lineWidth = 11.0;	
     	   	}
            
            
            
        }
    }//end WidthHandler
}//end class DrawingPane