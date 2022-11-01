/*
 * Eloi Nshuti
 * 11/01/2022
 * Exercise 15 - 03
 */
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercise15_Listeners extends Application {
	private CirclePane circlePane = new CirclePane();
	
	@Override
    public void start(Stage primaryStage) {
		 
		  HBox hBox = new HBox();
	      hBox.setSpacing(5);
	      hBox.setAlignment(Pos.CENTER);
	      
	      Button btLeft = new Button("Left");
	      Button btRight = new Button("Right");
	      Button btUp = new Button("Up");
	      Button btDown = new Button("Down");
	      hBox.getChildren().addAll(btLeft,btRight,btUp,btDown);
	      
	      btLeft.setOnAction(e -> circlePane.left());
	      btRight.setOnAction(e -> circlePane.right());
	      btUp.setOnAction(e -> circlePane.up());
	      btDown.setOnAction(e -> circlePane.down());
	  
	      BorderPane borderPane = new BorderPane();
	      borderPane.setPadding(new Insets(1,0,1,0));
	      borderPane.setCenter(circlePane);
	      borderPane.setBottom(hBox);
	      BorderPane.setAlignment(hBox, Pos.CENTER);
	      
	      Scene scene = new Scene(borderPane, 200, 200);
	      primaryStage.setTitle("Exercise15_03"); 
	      primaryStage.setScene(scene); 
	      primaryStage.show(); 
	}
	
	public static void main(String[] args) {
        System.out.println("launch application");
        Application.launch(args);
      }

class CirclePane extends Pane {
    private Circle circle = new Circle(100, 100, 10);
    
    public CirclePane() {
      getChildren().add(circle);
      circle.setStroke(Color.BLACK);
      circle.setFill(Color.RED);
    }
    public void left() {
    	circle.setCenterX(circle.getCenterX() > circle.getRadius() ?
    			circle.getCenterX() - 10 : circle.getCenterX());
    	circle.setCenterY(circle.getCenterY());
    }
    public void right() {
    	circle.setCenterX(circle.getCenterX() + circle.getRadius() < getWidth() ? 
    			circle.getCenterX() + 10 : circle.getCenterX());
    	circle.setCenterY(circle.getCenterY());
    }
    public void up() {
    	circle.setCenterY(circle.getCenterY() > circle.getRadius() ?
    			circle.getCenterY() - 10 : circle.getCenterY());
    	circle.setCenterX(circle.getCenterX());
    }
    public void down() {
    	circle.setCenterY(circle.getCenterY() + circle.getRadius() < getHeight() ? 
    			circle.getCenterY() + 10 : circle.getCenterY());
    	circle.setCenterX(circle.getCenterX());
    }
  }
}