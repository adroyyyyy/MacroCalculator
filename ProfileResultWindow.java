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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ProfileResultWindow extends Application {
<<<<<<< HEAD
    private User user;          // Store User object
    private MacroResult result; // Store MacroResult object

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Scene scene = new Scene(pane);
        
        pane.setStyle("-fx-background-color: #212121;");
        primaryStage.setScene(scene);
        primaryStage.setTitle("User Search Window");
        primaryStage.setWidth(350);
        primaryStage.setHeight(700);
        primaryStage.setAlwaysOnTop(false);
        primaryStage.setResizable(false);
        
        // Declare
=======
    private User user;          // store User object
    private MacroResult result; // store MacroResult object

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane(); 
        Scene scene = new Scene(pane); // scene to hold the pane
        
        pane.setStyle("-fx-background-color: #212121;"); // setting up background color 
        primaryStage.setScene(scene);
        primaryStage.setTitle("User Search Window"); // title of window 
        primaryStage.setWidth(350); // window width
        primaryStage.setHeight(700); // window height
        primaryStage.setAlwaysOnTop(false); 
        primaryStage.setResizable(false); 
        
        // Declare UI components
>>>>>>> first commit
        Label lblTitle, lblProfile, lblHeight, lblWeight, lblGender, lblAge, 
              lblActivityLevel, lblFitnessGoal, lblResult, lblBMR, lblBMI, 
              lblMessage, lblBMRResult, lblBMIResult;
        TextField txtHeight, txtWeight, txtAge;
        Button btnCalculate, btnProfileWindow, btnDCRWindow, btnSettings;
        ComboBox<String> cbGender, cbActivityLevel, cbFitnessGoal;
        
<<<<<<< HEAD
        // Initialize and set (unchanged UI setup)
        lblTitle = new Label("User Search Form");
        lblTitle.setFont(new Font("Arial", 14));
        lblTitle.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");
=======
        // Initialize and set UI components
        lblTitle = new Label("User Search Form"); // initializing and prompt to identify
        lblTitle.setFont(new Font("Arial", 14)); // Set font
        lblTitle.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;"); // light gray and bold text 
>>>>>>> first commit
        
        lblProfile = new Label("Profile");
        lblProfile.setFont(new Font("Arial", 18));
        lblProfile.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");
        
        lblHeight = new Label("Height");
        lblHeight.setFont(new Font("Arial", 14));
        lblHeight.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");
        
        lblWeight = new Label("Weight");
        lblWeight.setFont(new Font("Arial", 14));
        lblWeight.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");
        
        lblGender = new Label("Gender");
        lblGender.setFont(new Font("Arial", 14));
        lblGender.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");
        
        lblAge = new Label("Age");
        lblAge.setFont(new Font("Arial", 14));
        lblAge.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");
        
        lblActivityLevel = new Label("Activity Level");
        lblActivityLevel.setFont(new Font("Arial", 14));
        lblActivityLevel.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");
        
        lblFitnessGoal = new Label("Fitness Goal");
        lblFitnessGoal.setFont(new Font("Arial", 14));
        lblFitnessGoal.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");
        
        lblResult = new Label("Result");
        lblResult.setFont(new Font("Arial", 18));
        lblResult.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");
        
        lblBMR = new Label("Basal Metabolic Rate");
        lblBMR.setFont(new Font("Arial", 14));
        lblBMR.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");
        
        lblBMI = new Label("Body Mass Index");
        lblBMI.setFont(new Font("Arial", 14));
        lblBMI.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");
        
<<<<<<< HEAD
        lblBMRResult = new Label("");
        lblBMRResult.setFont(new Font("Arial", 14));
        lblBMRResult.setStyle("-fx-text-fill: #ffffff;");
        
        lblBMIResult = new Label("");
        lblBMIResult.setFont(new Font("Arial", 14));
        lblBMIResult.setStyle("-fx-text-fill: #ffffff;");
        
        lblMessage = new Label("");
=======
        lblBMRResult = new Label(""); // BMR result display
        lblBMRResult.setFont(new Font("Arial", 14));
        lblBMRResult.setStyle("-fx-text-fill: #ffffff; -fx-font-weight: bold;"); // White text
        
        lblBMIResult = new Label("");
        lblBMIResult.setFont(new Font("Arial", 14));
        lblBMIResult.setStyle("-fx-text-fill: #ffffff; -fx-font-weight: bold;");
        
        lblMessage = new Label(""); // lblMessage for error messages
>>>>>>> first commit
        lblMessage.setFont(new Font("Arial", 12));
        lblMessage.setStyle("-fx-text-fill: #ff4444; -fx-font-weight: bold;");
        
        txtHeight = new TextField();
        txtHeight.setPrefWidth(50);
<<<<<<< HEAD
        txtHeight.setStyle("-fx-background-color: #424242; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-background-radius: 11;");
=======
        txtHeight.setStyle("-fx-background-color: #424242; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-background-radius: 11;"); // Dark gray input with rounded corners
>>>>>>> first commit
        
        txtWeight = new TextField();
        txtWeight.setPrefWidth(50);
        txtWeight.setStyle("-fx-background-color: #424242; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-background-radius: 11;");
        
        txtAge = new TextField();
        txtAge.setPrefWidth(50);
        txtAge.setStyle("-fx-background-color: #424242; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-background-radius: 11;");
        
<<<<<<< HEAD
        cbGender = new ComboBox<>();
        cbGender.getItems().addAll("Male", "Female");
        cbGender.setPrefWidth(88);
        cbGender.setStyle("-fx-background-color: #212121; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-background-radius: 11;");
        cbGender.setButtonCell(new ListCell<String>() {
=======
        cbGender = new ComboBox<>(); 
        cbGender.getItems().addAll("Male", "Female");
        cbGender.setPrefWidth(88);
        cbGender.setStyle("-fx-background-color: #212121; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-background-radius: 11;");
        cbGender.setButtonCell(new ListCell<String>() { 
>>>>>>> first commit
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item);
                setStyle("-fx-background-color: #424242; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-background-radius: 11;");
            }
        });
        
        cbActivityLevel = new ComboBox<>();
<<<<<<< HEAD
        cbActivityLevel.getItems().addAll("     Low       ", "Moderate    ", "    High       ");
=======
        cbActivityLevel.getItems().addAll("     Low       ", "Moderate    ", "    High       "); // spaced for alignment
>>>>>>> first commit
        cbActivityLevel.setPrefWidth(109);
        cbActivityLevel.setStyle("-fx-background-color: #212121; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-background-radius: 11;");
        cbActivityLevel.setButtonCell(new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item);
                setStyle("-fx-background-color: #424242; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-background-radius: 11;");
            }
        });
        
        cbFitnessGoal = new ComboBox<>();
        cbFitnessGoal.getItems().addAll("        Lose weight", "      Maintain weight", "      Increase weight");
        cbFitnessGoal.setPrefWidth(168);
        cbFitnessGoal.setStyle("-fx-background-color: #212121; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-background-radius: 11;");
        cbFitnessGoal.setButtonCell(new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item);
                setStyle("-fx-background-color: #424242; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-background-radius: 11;");
            }
        });
        
        btnCalculate = new Button("Calculate");
        btnCalculate.setFont(new Font("Arial", 14));
        btnCalculate.setStyle("-fx-background-color: #424242; -fx-text-fill: #b0b3b8; -fx-font-weight: bold; -fx-background-radius: 11;");
        btnCalculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
<<<<<<< HEAD
                lblMessage.setText("");
                lblBMRResult.setText("");
                lblBMIResult.setText("");

=======
                lblMessage.setText(""); // clearing previous messages 
                lblBMRResult.setText("");
                lblBMIResult.setText("");

                // retrieving input values
>>>>>>> first commit
                String heightText = txtHeight.getText();
                String weightText = txtWeight.getText();
                String ageText = txtAge.getText();
                String genderValue = cbGender.getValue();
                String activityValue = cbActivityLevel.getValue();
                String fitnessValue = cbFitnessGoal.getValue();
                
<<<<<<< HEAD
=======
                // Validate inputs
>>>>>>> first commit
                if (heightText == null || heightText.isEmpty() || weightText == null || weightText.isEmpty() || 
                    ageText == null || ageText.isEmpty() || genderValue == null || activityValue == null || fitnessValue == null) {
                    lblMessage.setText("Please fill all the data");
                    return;
                }
                
                try {
<<<<<<< HEAD
                    double height = Double.parseDouble(heightText.trim());
                    double weight = Double.parseDouble(weightText.trim());
                    int age = Integer.parseInt(ageText.trim());

                    if (height <= 0 || weight <= 0 || age <= 0) {
=======
                    double height = Double.parseDouble(heightText.trim()); // trim() to remove excess spaces
                    double weight = Double.parseDouble(weightText.trim());
                    int age = Integer.parseInt(ageText.trim());

                    if (height <= 0 || weight <= 0 || age <= 0) { // making user values are +ve numbers 
>>>>>>> first commit
                        lblMessage.setText("Values must be positive numbers");
                        return;
                    }

<<<<<<< HEAD
                    String activityLevel;
                    switch (activityValue.trim()) {
                        case "Low":
                            activityLevel = "Sedentary";
                            break;
                        case "Moderate":
                            activityLevel = "Moderate";
                            break;
                        case "High":
                            activityLevel = "Active";
                            break;
                        default:
                            activityLevel = "Sedentary";
                            break;
                    }

                    String fitnessGoal;
                    switch (fitnessValue.trim()) {
                        case "Lose weight":
                            fitnessGoal = "Weight Loss";
                            break;
                        case "Maintain weight":
                            fitnessGoal = "Maintenance";
                            break;
                        case "Increase weight":
                            fitnessGoal = "Muscle Gain";
                            break;
                        default:
=======
                    String activityLevel; 
                    switch (activityValue.trim()) {
                    
                        case "Low": // if user chose low 
                            activityLevel = "Normal"; 
                            break;
                            
                        case "Moderate": // if user chose moderate 
                            activityLevel = "Moderate"; 
                            break;
                            
                        case "High": // if user chose high
                            activityLevel = "Active";
                            break;
                            
                        default:
                            activityLevel = "Normal";
                            break;
                    }

                    String fitnessGoal; 
                    switch (fitnessValue.trim()) {
                    
                        case "Lose weight": // if user chose lose weight
                            fitnessGoal = "Weight Loss";
                            break;
                            
                        case "Maintain weight": // if user chose maintain weight 
                            fitnessGoal = "Maintenance";
                            break;
                            
                        case "Increase weight": // if user chose to increase weight 
                            fitnessGoal = "Muscle Gain";
                            break;
                            
                        default: // else default value 
>>>>>>> first commit
                            fitnessGoal = "Maintenance";
                            break;
                    }
                    
<<<<<<< HEAD
                    // Create and store User object
                    user = new User(height, weight, age, genderValue, activityLevel);
                    
                    // Calculate and store MacroResult
                    MacroCalculator calculator = new MacroCalculator();
                    result = calculator.calculate(user, "Mifflin-St Jeor", "Standard", fitnessGoal);
                   
                    /*
                    // Save the profile
                    UserProfile userProfile = new UserProfile(
                        user.getId(),
                        result.getBmi(),
                        result.getBmr(),
                        (int) result.getCalories(),
                        (int) result.getCarbs(),
                        (int) result.getProtein(),
                        (int) result.getFat()
                    );
                    UserCRUD userCrud = new UserCRUD();
                    userCrud.saveProfile(userProfile);
                    */
                    
                    // Display results
=======
                    user = new User(height, weight, age, genderValue, activityLevel); // initializing user object with parameters 
                    
                    MacroCalculator calculator = new MacroCalculator();
                    result = calculator.calculate(user, "Mifflin-St Jeor", "Standard", fitnessGoal); // calculate macros 
                    
                    // display result 
>>>>>>> first commit
                    lblBMRResult.setText(String.format("%.0f cal", result.getBmr()));
                    lblBMIResult.setText(String.format("%.1f", result.getBmi()));
                    
                } catch (NumberFormatException ex) {
                    lblMessage.setText("Please fill the credentials properly");
<<<<<<< HEAD
                } catch (Exception ex) {
                    lblMessage.setText("An error occurred: " + ex.getMessage());
                    ex.printStackTrace();
=======
                    
                } catch (Exception ex) {
                    lblMessage.setText("An error occurred: " + ex.getMessage());
                    ex.printStackTrace(); // gets detailed error message 
                    
>>>>>>> first commit
                }
            }
        });
        
<<<<<<< HEAD
        btnSettings = new Button("Settings");
=======
        btnSettings = new Button("Settings"); 
>>>>>>> first commit
        btnSettings.setStyle("-fx-background-color: transparent; -fx-text-fill: #b0b3b8; -fx-font-size: 14;");
        btnSettings.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                SettingsWindow stWindow = new SettingsWindow();
                Stage stWindowStage = new Stage();
                try {
                    stWindow.start(stWindowStage);
                } catch (Exception ex) {
                    System.out.println("Login Error: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });
        
        btnProfileWindow = new Button("Profile");
        btnProfileWindow.setStyle("-fx-background-color: transparent; -fx-text-fill: #b0b3b8; -fx-font-size: 14;");
<<<<<<< HEAD
        btnProfileWindow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ProfileResultWindow prWindow = new ProfileResultWindow();
                Stage prWindowStage = new Stage();
                try {
                    prWindow.start(prWindowStage);
                } catch (Exception ex) {
                    System.out.println("Login Error: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });    
=======
        // no action button 
>>>>>>> first commit
        
        btnDCRWindow = new Button("Daily Caloric Requirement");
        btnDCRWindow.setStyle("-fx-background-color: transparent; -fx-text-fill: #b0b3b8; -fx-font-size: 14;");
        btnDCRWindow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
<<<<<<< HEAD
                if (user != null && result != null) {
                    DailyCaloricRequirementWindow dcrWindow = new DailyCaloricRequirementWindow(user, result);
                    Stage dcrWindowStage = new Stage();
                    try {
                        dcrWindow.start(dcrWindowStage);
                    } catch (Exception ex) {
                        System.out.println("Error: " + ex.getMessage());
                        ex.printStackTrace();
=======
            	
            	primaryStage.close(); // closes the current window 
            	
                if (user != null && result != null) {
                	
                    DailyCaloricRequirementWindow dcrWindow = new DailyCaloricRequirementWindow(user, result);
                    Stage dcrWindowStage = new Stage();
                    
                    try {
                        dcrWindow.start(dcrWindowStage); // starts DCRwindow on new stage 
                        
                    } catch (Exception ex) {
                        System.out.println("Error: " + ex.getMessage()); 
                        ex.printStackTrace(); 
>>>>>>> first commit
                    }
                } else {
                    lblMessage.setText("Please calculate results first");
                }
            }
        });    
        
<<<<<<< HEAD
        


        
        
        // Column, row (unchanged layout)
        lblTitle.relocate(117, 20);
        pane.getChildren().add(lblTitle);
        lblProfile.relocate(28, 55);
        pane.getChildren().add(lblProfile);
        lblHeight.relocate(28, 100);
        pane.getChildren().add(lblHeight);
        txtHeight.relocate(270, 95);
        pane.getChildren().add(txtHeight);
        lblWeight.relocate(28, 145);
        pane.getChildren().add(lblWeight);
        txtWeight.relocate(270, 140);
        pane.getChildren().add(txtWeight);
        lblAge.relocate(28, 190);
        pane.getChildren().add(lblAge);
        txtAge.relocate(270, 185);
        pane.getChildren().add(txtAge);
        lblGender.relocate(28, 235);
        pane.getChildren().add(lblGender);
        cbGender.relocate(259, 230);
        pane.getChildren().add(cbGender);
        lblActivityLevel.relocate(28, 280);
        pane.getChildren().add(lblActivityLevel);
        cbActivityLevel.relocate(238, 275);
        pane.getChildren().add(cbActivityLevel);
        lblFitnessGoal.relocate(28, 325);
        pane.getChildren().add(lblFitnessGoal);
        cbFitnessGoal.relocate(180, 320);
        pane.getChildren().add(cbFitnessGoal);
        lblResult.relocate(28, 390);
        pane.getChildren().add(lblResult);
        lblBMR.relocate(28, 435);
        pane.getChildren().add(lblBMR);
        lblBMRResult.relocate(200, 435);
        pane.getChildren().add(lblBMRResult);
        lblBMI.relocate(28, 480);
        pane.getChildren().add(lblBMI);
        lblBMIResult.relocate(200, 480);
        pane.getChildren().add(lblBMIResult);
        btnCalculate.relocate(28, 525);
        pane.getChildren().add(btnCalculate);
        lblMessage.relocate(28, 560);
        pane.getChildren().add(lblMessage);
        btnProfileWindow.relocate(70, 600);
        pane.getChildren().add(btnProfileWindow);
        btnDCRWindow.relocate(140, 600);
        pane.getChildren().add(btnDCRWindow);
        btnSettings.relocate(300, 20);
        pane.getChildren().add(btnSettings);
        
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
=======
        // (columns, row)
        lblTitle.relocate(117, 20);
        pane.getChildren().add(lblTitle);
        
        lblProfile.relocate(28, 55);
        pane.getChildren().add(lblProfile);
        
        lblHeight.relocate(28, 100);
        pane.getChildren().add(lblHeight);
        
        txtHeight.relocate(270, 95);
        pane.getChildren().add(txtHeight);
        
        lblWeight.relocate(28, 145);
        pane.getChildren().add(lblWeight);
        
        txtWeight.relocate(270, 140);
        pane.getChildren().add(txtWeight);
        
        lblAge.relocate(28, 190);
        pane.getChildren().add(lblAge);
        
        txtAge.relocate(270, 185);
        pane.getChildren().add(txtAge);
        
        lblGender.relocate(28, 235);
        pane.getChildren().add(lblGender);
        
        cbGender.relocate(259, 230);
        pane.getChildren().add(cbGender);
        
        lblActivityLevel.relocate(28, 280);
        pane.getChildren().add(lblActivityLevel);
        
        cbActivityLevel.relocate(238, 275);
        pane.getChildren().add(cbActivityLevel);
        
        lblFitnessGoal.relocate(28, 325);
        pane.getChildren().add(lblFitnessGoal);
        
        cbFitnessGoal.relocate(180, 320);
        pane.getChildren().add(cbFitnessGoal);
        
        lblResult.relocate(28, 390);
        pane.getChildren().add(lblResult);
        
        lblBMR.relocate(28, 435);
        pane.getChildren().add(lblBMR);
        
        lblBMRResult.relocate(200, 435);
        pane.getChildren().add(lblBMRResult);
        
        lblBMI.relocate(28, 480);
        pane.getChildren().add(lblBMI);
        
        lblBMIResult.relocate(200, 480);
        pane.getChildren().add(lblBMIResult);
        
        btnCalculate.relocate(28, 525);
        pane.getChildren().add(btnCalculate);
        
        lblMessage.relocate(28, 560);
        pane.getChildren().add(lblMessage);
        
        btnProfileWindow.relocate(70, 600);
        pane.getChildren().add(btnProfileWindow);
        
        btnDCRWindow.relocate(140, 600);
        pane.getChildren().add(btnDCRWindow);
        
        btnSettings.relocate(300, 20);
        pane.getChildren().add(btnSettings);
        
        primaryStage.show(); // displays the window
        
    }

    public static void main(String[] args) {
        launch(args); // launches the JavaFX application
        
    }
    
    
>>>>>>> first commit
}