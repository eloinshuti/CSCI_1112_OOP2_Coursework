/*  Eloi Nshuti
 *  11/03/2022
 *  Exercise 16-1
 */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;     
import javafx.scene.text.Text;

public class Exercise16_1 extends Application {
	protected Text text = new Text(50, 50, "JavaFX Programming");
	
	protected BorderPane getPane() {
		BorderPane pane = new BorderPane();
		
		HBox paneForButtons = new HBox(20);
		Button btLeft = new Button("<=");
		Button btRight = new Button("=>");   
		paneForButtons.getChildren().addAll(btLeft, btRight); 
		paneForButtons.setAlignment(Pos.CENTER);
		paneForButtons.setStyle("-fx-border-color: black");
		
		pane.setBottom(paneForButtons); 
		
		Pane paneForText = new Pane();
		paneForText.getChildren().add(text);
		
		pane.setCenter(paneForText);
		
		btLeft.setOnAction(e -> text.setX(text.getX() > 0?
	    		  text.getX() - 10 : text.getX()));
		
		btRight.setOnAction(e -> text.setX( text.getX() < paneForText.getWidth()- 120?
	    		  text.getX() + 10 : text.getX()));
		
		
		
		HBox paneForRadioButtons = new HBox(20);
		paneForRadioButtons.setPadding(new Insets(5, 5, 5, 5)); 
		
		paneForRadioButtons.setStyle ("-fx-border-width: 2px; -fx-border-color: black");
		RadioButton rbRed = new RadioButton("Red");
		RadioButton rbYellow = new RadioButton("Yellow");
		RadioButton rbBlack = new RadioButton("Black");
		RadioButton rbOrange = new RadioButton("Orange");
		RadioButton rbGreen = new RadioButton("Green");
		paneForRadioButtons.getChildren().addAll(rbRed, rbYellow, rbBlack, rbOrange, rbGreen);
		
		pane.setTop(paneForRadioButtons);
		
		ToggleGroup group = new ToggleGroup();
		rbRed.setToggleGroup(group);
		rbYellow.setToggleGroup(group);
		rbBlack.setToggleGroup(group);
		rbOrange.setToggleGroup(group);
		rbGreen.setToggleGroup(group);
		
		rbRed.setOnAction(e -> {
			if (rbRed.isSelected()) {
				text.setFill(Color.RED);
			}
		});		
		rbYellow.setOnAction(e -> {
			if (rbYellow.isSelected()) {
				text.setFill(Color.YELLOW);
			}
		});	
		rbBlack.setOnAction(e -> {
			if (rbBlack.isSelected()) {
				text.setFill(Color.BLACK);
			}
		});	
		rbOrange.setOnAction(e -> {
			if (rbOrange.isSelected()) {
				text.setFill(Color.ORANGE);
			}
		});
		rbGreen.setOnAction(e -> {
					if (rbGreen.isSelected()) {
						text.setFill(Color.GREEN);
					}
				});
		return pane;
	}
	@Override 
	public void start(Stage primaryStage) {
		Scene scene = new Scene(getPane(), 450, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
        System.out.println("launch application");
        Application.launch(args);
      }
}