// Assignment #: Arizona State University CSE205 #12
//         Name: Abe Johnson
//    StudentID: 1216031115
//      Lecture: 1216031115
//  Description: Controls the visuals of the firework animation

import javafx.scene.paint.Color;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.util.Duration;

public class FireworkPane extends Pane {
	
	private Color color;
	private Timeline timeline1;
	private KeyFrame kf;
	private int centerX;
	private int centerY;
	private double radiusLimit;
	private double radius;
	private int beamNum;
	private double angleSize;
	private double step;
	private int rate;
	
	
	public FireworkPane(Color color, int width) {
		
		this.color = color;
		centerX = width/2;
		centerY = width/2;
		radiusLimit = (width - 10)/(4);
		radius = 25.0;
		beamNum = 8;
		angleSize = 360/(beamNum*2);
		step = 2.0;
		rate = 500;
		this.setStyle("-fx-background-color: #000000;");
		
		for (int currentAngle=0; currentAngle <= 360; currentAngle += 2*angleSize) {
	        Arc arc1 = new Arc(centerX, centerY, radius, radius, currentAngle, angleSize);
	        arc1.setFill(color);
	        arc1.setStroke(color);
	        arc1.setType(ArcType.ROUND);
	        getChildren().add(arc1);
	      }
		
		kf = new KeyFrame(Duration.millis(rate), new FireworkHandler());
		timeline1 = new Timeline(kf);
		timeline1.setCycleCount(Timeline.INDEFINITE);
	    timeline1.setRate(20);  //default rate = 20
	    timeline1.setAutoReverse(true);
	    timeline1.play();
	}
	
	public void resume() {
		timeline1.play();
	}
	
	public void suspend() {
		timeline1.pause();
	}
	
	public void changeColor(Color anotherColor) {
		color = anotherColor;
	}
	
	public void setBeamNumber(int beam) {
		beamNum = beam;
	}
	
	public void setRate(int rate1) {
		timeline1.setRate(rate1);
	}
	
	private class FireworkHandler implements EventHandler<ActionEvent> {
		
		public void handle(ActionEvent event) {
			radius = radius + step;
			getChildren().clear();
			angleSize = 360/(beamNum*2);
			
		    for (int currentAngle=0; currentAngle <= 360; currentAngle += 2*angleSize)
		      {
		        Arc arc1 = new Arc(centerX, centerY, radius, radius, currentAngle, angleSize);
		        arc1.setFill(color);
		        arc1.setStroke(color);
		        arc1.setType(ArcType.ROUND);
		        getChildren().add(arc1);
		      }
		    
		    if (radius > radiusLimit) {
		    	radius = 0;
		    }
		}
	}

}
