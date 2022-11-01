
import javafx.animation.PathTransition;
import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.collections.ObservableList;
  
  public class Exercise15_Animation extends Application {
    @Override
    public void start(Stage primaryStage) {
    	
      Pane pane = new Pane();      
 
      Polygon polygon = new Polygon();
      pane.getChildren().add(polygon); 
      polygon.setFill(Color.WHITE);
      polygon.setStroke(Color.BLACK);
      polygon.setRotate(125);
      ObservableList<Double> list = polygon.getPoints();
           
      final double WIDTH = 200, HEIGHT = 200;
      double centerX = WIDTH / 2, centerY = HEIGHT / 2;
      double radius = Math.min(WIDTH, HEIGHT) * 0.4;
        
      for (int i = 0; i < 5; i++) {
    	  list.add(centerX + radius * Math.cos(2 * i * Math.PI / 5)); 
          list.add(centerY - radius * Math.sin(2 * i * Math.PI / 5));
          }
      
      Rectangle rectangle = new Rectangle (0, 0, 25, 50);
      rectangle.setFill(Color.RED); 
      pane.getChildren().add(rectangle); 
      
      
      FadeTransition ft = new FadeTransition(Duration.millis(3000), rectangle);
      ft.setFromValue(1.0);
      ft.setToValue(0.1);
      ft.setCycleCount(Timeline.INDEFINITE);
      ft.setAutoReverse(true);
      ft.play();       
      
      PathTransition pt = new PathTransition();
      pt.setDuration(Duration.millis(4000));
      pt.setPath(polygon);
      pt.setNode(rectangle);
      pt.setOrientation(
      PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
      pt.setCycleCount(Timeline.INDEFINITE);
      pt.setAutoReverse(false);
      pt.play(); // Start animation 
      
      polygon.setOnMousePressed(e -> pt.pause());
      polygon.setOnMouseReleased(e -> pt.play());    
      
      Scene scene = new Scene(pane, 250, 200);
      primaryStage.setTitle("PathTransitionDemo"); 
      primaryStage.setScene(scene); 
      primaryStage.show(); 
    }
    public static void main(String[] args) {
        System.out.println("launch application");
        Application.launch(args);
      }

  }