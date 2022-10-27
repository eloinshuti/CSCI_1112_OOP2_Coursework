/*
 * Eloi Nshuti
 * 10/20/2022
 * Exercise 14-15
 */
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class ShowPolygon extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {   
		Scene scene = new Scene(new MyPolygon(), 400, 400);
		primaryStage.setTitle("Exercise14_15"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		
	}
	
	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}

class MyPolygon extends StackPane {
	private void paint() {
		// Create a polygon and place polygon to pane
		Polygon polygon = new Polygon();
		
		polygon.setFill(Color.RED);
		polygon.setStroke(Color.WHITE);
		polygon.setRotate(22.5);
		ObservableList<Double> list = polygon.getPoints();
		
		double centerX = getWidth() / 2, centerY = getHeight() / 2;
		double radius = Math.min(getWidth(), getHeight()) * 0.4;

		// s represents the number of sides of the shape
		// Make sure to update this number when necessary
		int s = 8;
		// Add points to the polygon list
		for (int i = 0; i < s; i++) {
			list.add(centerX + radius * Math.cos(2 * i * Math.PI / s)); 
			list.add(centerY - radius * Math.sin(2 * i * Math.PI / s));
		}     
		getChildren().clear();
		getChildren().add(polygon);
		
		
		Label label = new Label("STOP");
        label.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 
        		FontPosture.REGULAR, 80));
		label.setStyle("-fx-text-fill:white");
        getChildren().add(label);
	}
	
	@Override
	public void setWidth(double width) {
		super.setWidth(width);
		paint();
	}
	
	@Override
	public void setHeight(double height) {
		super.setHeight(height);
		paint();
	}
}
