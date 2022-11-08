/*  Eloi Nshuti
 *  11/08/2022
 *  Exercise 16-21
 */
import javafx.application.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.geometry.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.animation.*;
import javafx.util.Duration;
import javafx.event.*;
import javafx.scene.input.KeyCode;

public class Exercise16_21 extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		StackPane pane = new StackPane();       
	    
	    TextField tf = new TextField();
	    tf.setFont(Font.font(60));
        tf.setPrefColumnCount(5);
        tf.setAlignment(Pos.CENTER);
        tf.setFocusTraversable(false);
        pane.getChildren().add(tf);
	    
	    Timeline animation = new Timeline(
	    		new KeyFrame(Duration.millis(1000), e-> {
	    			tf.setText((Integer.parseInt(tf.getText()) - 1) + "");
	    		}));
	
	    tf.setOnKeyPressed(e -> {
	    	if (e.getCode() == KeyCode.ENTER) {
	            animation.setCycleCount(Integer.parseInt(tf.getText()));
	            tf.setEditable(false);
	            animation.play();
	    	} 	 
	    });
	    
	    Media media = new Media
        		("https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3");
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        
        animation.setOnFinished(event -> {
            mediaPlayer.play();
        });

		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise 16-21");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
     System.out.println("launch application");
     
     Application.launch(args);
   }
}