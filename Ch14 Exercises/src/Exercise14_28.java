/*
 * Eloi Nshuti
 * 10/20/2022
 * Exercise 14-28
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;          
import javafx.stage.Stage;                  
import javafx.scene.layout.*;            
import javafx.scene.text.*;                
import javafx.scene.paint.Color;       
import javafx.scene.shape.*;           
import javafx.scene.image.*;            
import javafx.geometry.*;
import javafx.scene.shape.Line;

public class Exercise14_28 extends Application {
	    @Override 
	    public void start(Stage primaryStage) {
	     
	      ClockPane clock = new ClockPane();
	      clock.setSecondHandVisible(false);
	      
          int minute = (int)(Math.random() * 10);
	      
	      if(minute % 2 == 0)
	    	  clock.setMinute(0);
	      else
	    	  clock.setMinute(30);
	    	  
	      int hour = (int)(Math.random() * 10);
	      clock.setHour(hour);
	  
	      
	      BorderPane pane = new BorderPane();
	      pane.setCenter(clock);
	  
	  
	      
	      Scene scene = new Scene(pane, 250, 250);
	      primaryStage.setTitle("DisplayClock"); 
	      primaryStage.setScene(scene); 
	      primaryStage.show(); 
	    }
	    public static void main(String[] args) {
	        System.out.println("launch application");
	        Application.launch(args);
	      }
	  }