package uiv6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FormulaWindow extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Scene scene = new Scene(pane);
        
        pane.setStyle("-fx-background-color: #212121;");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Formula Window");
        primaryStage.setWidth(350);
        primaryStage.setHeight(700);
        primaryStage.setAlwaysOnTop(false);
        primaryStage.setResizable(false);
        
        // Declare
        Label lblTitle, lblFormula, lblHarris, lblMifflin; 
        ToggleGroup tg;
        RadioButton rbHarris, rbMifflin;
        Button btnBack;
        
        // Initialize and set
        lblTitle = new Label("Macro Calculator");
        lblTitle.setFont(new Font("Arial", 14)); // Set font
        lblTitle.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");
        
        lblFormula = new Label("Formula");
        lblFormula.setFont(new Font("Arial", 20)); // Set font
        lblFormula.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");
        
        lblHarris = new Label("Harris-Benedict");
        lblHarris.setFont(new Font("Arial", 14)); // Set font
        lblHarris.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold; ");
        
        lblMifflin = new Label("Mifflin-St Jeor");
        lblMifflin.setFont(new Font("Arial", 14)); // Set font
        lblMifflin.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold; ");
        
        tg = new ToggleGroup();
            
        rbHarris = new RadioButton("");
        rbHarris.setToggleGroup(tg);
        rbHarris.setSelected(true);
        rbHarris.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-mark-color: #424242;");

        rbMifflin = new RadioButton("");
        rbMifflin.setToggleGroup(tg);
        rbMifflin.setStyle(rbHarris.getStyle());
        
        btnBack = new Button("<");
        btnBack.setFont(new Font("Arial", 14));
        btnBack.setStyle("-fx-background-color: #424242; -fx-text-fill: #b0b3b8; -fx-font-weight: bold; -fx-background-radius: 11;");
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // Closes itself
                primaryStage.close();
                
                // Opens previous window (settings window)
                SettingsWindow stWindow = new SettingsWindow();
                Stage stWindowStage = new Stage();
                
                try {
                    stWindow.start(stWindowStage);
                } 
                catch (Exception ex) {
                    System.out.println("Login Error: " + ex.getMessage());
                }
            }
        });

        // Column, row
        lblTitle.relocate(117,20);
        pane.getChildren().add(lblTitle);
        
        lblFormula.relocate(135, 85);
        pane.getChildren().add(lblFormula);
        
        lblHarris.relocate(55, 200);
        pane.getChildren().add(lblHarris);
        
        rbHarris.relocate(285, 199);
        pane.getChildren().add(rbHarris);
        
        lblMifflin.relocate(55, 245);
        pane.getChildren().add(lblMifflin);
        
        rbMifflin.relocate(285, 244);
        pane.getChildren().add(rbMifflin);
        
        btnBack.relocate(30, 28);
        pane.getChildren().add(btnBack);
        
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}