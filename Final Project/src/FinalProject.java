/*  Eloi Nshuti
 *  12/01/2022
 *  Final Project
 */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;     
import javafx.scene.text.*;
import javafx.collections.*;
import javafx.geometry.*;
import java.util.ArrayList;
import java.io.*; 
import java.util.Scanner;


public class FinalProject extends Application  {
	@Override 
	public void start(Stage primaryStage) throws IOException{
		BorderPane pane = new BorderPane();
		
		GridPane paneInput = new GridPane();
		paneInput.setAlignment(Pos.CENTER);
		paneInput.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		paneInput.setHgap(5.5);
		paneInput.setVgap(5.5);
		 
		TextField firstName = new TextField();
		TextField middleName = new TextField();
		TextField lastName = new TextField();
		TextField grade = new TextField();
		TextField score = new TextField();
		TextField fileName = new TextField();
		
		paneInput.add(new Label("First Name:"), 0, 0);
		paneInput.add(firstName, 1, 0);
		paneInput.add(new Label("MI:"), 0, 1); 
		paneInput.add(middleName, 1, 1);
		paneInput.add(new Label("Last Name:"), 0, 2);
		paneInput.add(lastName, 1, 2);
		paneInput.add(new Label("Score:"), 2, 0); 
		paneInput.add(score, 3, 0);
		paneInput.add(new Label("Grade:"), 2, 1);
		paneInput.add(grade, 3, 1);
		paneInput.add(new Label("Text file name:"), 0, 5); 
		paneInput.add(fileName, 1, 5);
		
		HBox paneForButtons = new HBox(5.5);
		Button btRecord = new Button("Record");
		Button btTxt = new Button("Create text file");
		Button btSortedTxt = new Button("Create sorted text file");   
		paneForButtons.getChildren().addAll(btRecord, btTxt, btSortedTxt); 
		paneInput.add(btRecord, 0, 4);
		paneInput.add(btTxt, 0, 6);
		paneInput.add(btSortedTxt, 1, 6);
		pane.setCenter(paneInput);

		ArrayList<String> firstNameList = new ArrayList<>();
		ArrayList<String> middleNameList = new ArrayList<>();
		ArrayList<String> lastNameList = new ArrayList<>();
		ArrayList<String> gradeList = new ArrayList<>();
		ArrayList<String> scoreList = new ArrayList<>();
		
		btRecord.setOnAction(e -> {
			firstNameList.add(firstName.getText());
			firstName.setText("");
			middleNameList.add(middleName.getText());
			middleName.setText("");
			lastNameList.add(lastName.getText());
			lastName.setText("");
			gradeList.add(grade.getText());
			grade.setText("");
			scoreList.add(score.getText());
			score.setText("");
			});

		btTxt.setOnAction(e -> {
		java.io.File file = new java.io.File(fileName.getText() +".txt");
		try (
				java.io.PrintWriter output = new java.io.PrintWriter(file);
		         ) {
			for(int i = 0; i < firstNameList.size(); i++) {
			output.println("First name:  "+firstNameList.get(i));
			output.println("Middle name: "+middleNameList.get(i));
			output.println("Last name:   "+lastNameList.get(i));
			output.println("Score:       "+scoreList.get(i));
			output.println("Grade:       "+gradeList.get(i));
			output.println();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		});

		btSortedTxt.setOnAction(e -> {
		java.io.File file = new java.io.File(fileName.getText() +".txt");
		try (
				java.io.PrintWriter output = new java.io.PrintWriter(file);
		         ) {
			sort(scoreList,firstNameList,middleNameList,lastNameList,gradeList);
			for(int i = 0; i < firstNameList.size(); i++) {
			output.println("First name:  "+firstNameList.get(i));
			output.println("Middle name: "+middleNameList.get(i));
			output.println("Last name:   "+lastNameList.get(i));
			output.println("Score:       "+scoreList.get(i));
			output.println("Grade:       "+gradeList.get(i));
			output.println();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			}
		});

		ComboBox<String> cBox = new ComboBox<>();
		String[] fontColors = {"Black", "Red", "Blue", "Orange", "Green"};
		ObservableList<String> items = FXCollections.observableArrayList
				(fontColors);
		cBox.getItems().addAll(items); 
		HBox paneForFont = new HBox(20);
		Label lb = new Label("Font color");
		paneForFont.setPadding(new Insets(5, 5, 5, 5)); 
		paneForFont.setStyle ("-fx-border-width: 2px; -fx-border-color: grey");
		RadioButton rbBold = new RadioButton("Bold");
		RadioButton rbItalics = new RadioButton("Italics");
		paneForFont.getChildren().addAll(lb, cBox,rbBold,rbItalics);
		pane.setTop(paneForFont);

		cBox.setOnAction(e -> {
			firstName.setStyle(setFontColor(items.indexOf(cBox.getValue())));
			middleName.setStyle(setFontColor(items.indexOf(cBox.getValue())));
			lastName.setStyle(setFontColor(items.indexOf(cBox.getValue())));
			grade.setStyle(setFontColor(items.indexOf(cBox.getValue())));
			score.setStyle(setFontColor(items.indexOf(cBox.getValue())));
		});
		
		Font fontBoldItalic = Font.font("Times New Roman", 
				FontWeight.BOLD, FontPosture.ITALIC, 15);
		Font fontBold = Font.font("Times New Roman", 
				FontWeight.BOLD, FontPosture.REGULAR, 15);
		Font fontItalic = Font.font("Times New Roman",
				FontWeight.NORMAL, FontPosture.ITALIC, 15);
		Font fontNormal = Font.font("Times New Roman", 
				FontWeight.NORMAL, FontPosture.REGULAR, 15); 
		
		firstName.setFont(fontNormal);
		middleName.setFont(fontNormal);
		lastName.setFont(fontNormal);
		grade.setFont(fontNormal);
		score.setFont(fontNormal);
		
		EventHandler<ActionEvent> handler = e -> { 
			if (rbBold.isSelected() && rbItalics.isSelected()) {
				firstName.setFont(fontBoldItalic);
				middleName.setFont(fontBoldItalic);
				lastName.setFont(fontBoldItalic);
				grade.setFont(fontBoldItalic);
				score.setFont(fontBoldItalic);
				}
			else if (rbBold.isSelected()) {
				firstName.setFont(fontBold);
				middleName.setFont(fontBold);
				lastName.setFont(fontBold);
				grade.setFont(fontBold);
				score.setFont(fontBold);
				}
			else if (rbItalics.isSelected()) {
				firstName.setFont(fontItalic);
				middleName.setFont(fontItalic);
				lastName.setFont(fontItalic);
				grade.setFont(fontItalic);
				score.setFont(fontItalic);
				}
			else {
				firstName.setFont(fontNormal);
				middleName.setFont(fontNormal);
				lastName.setFont(fontNormal);
				grade.setFont(fontNormal);
				score.setFont(fontNormal);
				}
			};
			rbBold.setOnAction(handler);
			rbItalics.setOnAction(handler);
			
			HBox paneForNote = new HBox(5.5);
			paneForNote.setPadding(new Insets(5, 5, 5, 5)); 
			paneForNote.setStyle ("-fx-border-width: 2px; -fx-border-color: grey");
			Text noteText = new Text(50, 50, "NOTE: Record after each input.");
			paneForNote.getChildren().add(noteText);
			pane.setBottom(paneForNote);
		
		Scene scene = new Scene(pane, 600, 450);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
		public static void main(String[] args) {
			Application.launch(args);
			}
		public String setFontColor (int index) {
			String[] fontColorsLib = {"black", "red", "blue", "orange", "green"};
			String colorSetting = "-fx-text-fill: " + fontColorsLib[index];
			return colorSetting;
			}
		public static <E extends Comparable<E>> void sort(
				ArrayList<E> list, ArrayList<E> flist, ArrayList<E> mlist, 
				ArrayList<E> llist, ArrayList<E> glist) {
			
			E element,felement,melement,lelement,gelement;
			int elementIndex;
			
			for (int i = 0; i < list.size()-1; i++) {
				element = list.get(i);
				elementIndex = i;
				felement = flist.get(i);
				melement = mlist.get(i);
				lelement = llist.get(i);
				gelement = glist.get(i);
				for (int j = i + 1; j < list.size(); j++) {
					if (element.compareTo(list.get(j)) < 0) {
						element = list.get(j);
						elementIndex = j;
						felement = flist.get(j);
						melement = mlist.get(j);
						lelement = llist.get(j);
						gelement = glist.get(j);
						}
					}
				if(elementIndex > 1) {
					  list.set(elementIndex, list.get(i));
					  list.set(i, element);
					  flist.set(elementIndex, flist.get(i));
					  flist.set(i, felement);
					  mlist.set(elementIndex, mlist.get(i));
					  mlist.set(i, melement);
					  llist.set(elementIndex, llist.get(i));
					  llist.set(i, lelement);
					  glist.set(elementIndex, glist.get(i));
					  glist.set(i, gelement);
					  }
				  }
			  }
		}