<<<<<<< HEAD
package uiv3;
=======
package uiv6;
>>>>>>> first commit

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import userInterface.UnitsFormatsWindow;


public class SettingsWindow extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
<<<<<<< HEAD
		Pane pane = new Pane();
=======
		Pane pane = new Pane(); 
>>>>>>> first commit
		Scene scene = new Scene(pane);
        
        pane.setStyle("-fx-background-color: #212121;");
		primaryStage.setScene(scene);
		primaryStage.setTitle("Settings");
		primaryStage.setWidth(350);
		primaryStage.setHeight(700);
		primaryStage.setAlwaysOnTop(false);
		primaryStage.setResizable(false);
		
		
		// Declare
		Label lblTitle, lblSettings; 

		Button btnUnitsFormats, btnFormula, btnPrevCalc, btnBack;
		 
		// Initialize and set
<<<<<<< HEAD
		lblTitle = new Label("Macro Calculator");
=======
		lblTitle = new Label("Macro Calculator"); // initializing and prompt to identify 
>>>>>>> first commit
		lblTitle.setFont(new Font("Arial", 14)); // Set font
		lblTitle.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");
		
		lblSettings = new Label("Settings Window");
		lblSettings.setFont(new Font("Arial", 20)); // Set font
		lblSettings.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");
		
		btnUnitsFormats = new Button("Units and Formats  >");
		btnUnitsFormats.setFont(new Font("Arial", 14));
<<<<<<< HEAD
		btnUnitsFormats.setStyle("-fx-background-color: #424242; -fx-text-fill: #b0b3b8; -fx-font-weight: bold; -fx-background-radius: 11;");
=======
		btnUnitsFormats.setStyle("-fx-background-color: #424242; -fx-text-fill: #b0b3b8; -fx-font-weight: bold; -fx-background-radius: 11;"); // -fx-background-radius: 11 -> making the edges curved 
>>>>>>> first commit
		btnUnitsFormats.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	
            	// Closes itself
<<<<<<< HEAD
=======
            	primaryStage.close();
>>>>>>> first commit
            	
                // Open UnitsFormats Window
                UnitsFormatsWindow ufWindow = new UnitsFormatsWindow();
                Stage ufWindowStage = new Stage();
                
                try {
<<<<<<< HEAD
                    ufWindow.start(ufWindowStage);
                } catch (Exception ex) {
                    System.out.println("Error opening Units and Formats window: " + ex.getMessage());
                    ex.printStackTrace();
=======
                    ufWindow.start(ufWindowStage); // opening UnitsFormatsWindow in new stage
                    
                } catch (Exception ex) {
                    System.out.println("Error opening Units and Formats window: " + ex.getMessage());
                    ex.printStackTrace(); // more detailed error
>>>>>>> first commit
                }
            }
        });
		
		
		btnFormula = new Button("Formula  >");
        btnFormula.setFont(new Font("Arial", 14));
        btnFormula.setStyle("-fx-background-color: #424242; -fx-text-fill: #b0b3b8; -fx-font-weight: bold; -fx-background-radius: 11;");
        btnFormula.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	
            	// Closes itself
            	
                // Open Formula Window
                FormulaWindow fWindow = new FormulaWindow();
                Stage fWindowStage = new Stage();
                
                try {
<<<<<<< HEAD
                    fWindow.start(fWindowStage);
=======
                    fWindow.start(fWindowStage); // opening FormulaWindow in new stage
                    
>>>>>>> first commit
                } catch (Exception ex) {
                    System.out.println("Error opening Formula window: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });

		btnPrevCalc = new Button("Previous Calculations  >");
        btnPrevCalc.setFont(new Font("Arial", 14));
        btnPrevCalc.setStyle("-fx-background-color: #424242; -fx-text-fill: #b0b3b8; -fx-font-weight: bold; -fx-background-radius: 11;");
        btnPrevCalc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	
            	// Closes itself
            	
                // Open PreviousCalculations Window
                PrevCalcWindow pcWindow = new PrevCalcWindow();
                Stage pcWindowStage = new Stage();
                
                try {
<<<<<<< HEAD
                    pcWindow.start(pcWindowStage);
=======
                    pcWindow.start(pcWindowStage); // opening PrevCalcWindow in new stage
                    
>>>>>>> first commit
                } catch (Exception ex) {
                    System.out.println("Error opening Previous Calculations window: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });
        

		btnBack = new Button("<");
		btnBack.setFont(new Font("Arial", 14));
		btnBack.setStyle("-fx-background-color: #424242; -fx-text-fill: #b0b3b8; -fx-font-weight: bold; -fx-background-radius: 11;");
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	
            	// Closes itself
<<<<<<< HEAD
=======
            	primaryStage.close(); 
>>>>>>> first commit
            	
          		 // Open ProfileResult Window
	            ProfileResultWindow prWindow = new ProfileResultWindow();
	            Stage prWindowStage = new Stage();
	            
	            try {
<<<<<<< HEAD
	                prWindow.start(prWindowStage);
=======
	                prWindow.start(prWindowStage); // not perfected yet (plan is to: go to profile window with all the data filled)
	                							   // currently this opens a completely new ProfileReusltWindow

	                
>>>>>>> first commit
	            } catch (Exception ex) {
	               
	                System.out.println("Login Error: " + ex.getMessage());
	                ex.printStackTrace();
	            }
            }
        });
		
		// Column, row
		lblTitle.relocate(117,20);
		pane.getChildren().add(lblTitle);
		
		lblSettings.relocate(95, 100);
		pane.getChildren().add(lblSettings);
		
		btnUnitsFormats.relocate(48, 200);
		pane.getChildren().add(btnUnitsFormats);
	
		btnFormula.relocate(48, 260);
		pane.getChildren().add(btnFormula);
		
		btnPrevCalc.relocate(48, 320);
		pane.getChildren().add(btnPrevCalc);
		
		btnBack.relocate(30, 28);
		pane.getChildren().add(btnBack);
		
		
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
