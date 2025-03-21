<<<<<<< HEAD
package uiv3;
=======
package uiv6;
>>>>>>> first commit

import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PrevCalcWindow extends Application {
    private User user; // Store the User object to access userId and profile data

    // Constructor to accept the User object
    public PrevCalcWindow() {
        this.user = null;
    }

    public PrevCalcWindow(User user) {
        this.user = user;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Scene scene = new Scene(pane);
        
        pane.setStyle("-fx-background-color: #212121;");
        primaryStage.setScene(scene);
        primaryStage.setTitle("History Window");
        primaryStage.setWidth(350);
        primaryStage.setHeight(700);
        primaryStage.setAlwaysOnTop(false);
        primaryStage.setResizable(false);
        
        // Declare
        Label lblTitle, lblProfile, lblPrevCalc;
        Button btnBack;
        VBox profileInfo = new VBox(10); // VBox for user profile info
        VBox calcHistory = new VBox(10); // VBox for calculation history
        
        // Initialize and set
        lblTitle = new Label("Macro Calculator");
        lblTitle.setFont(new Font("Arial", 14));
        lblTitle.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");
        
        lblProfile = new Label("User Profile");
        lblProfile.setFont(new Font("Arial", 18));
        lblProfile.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");
        
        lblPrevCalc = new Label("Previous Calculations");
        lblPrevCalc.setFont(new Font("Arial", 18));
        lblPrevCalc.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");
        
        btnBack = new Button("<");
        btnBack.setFont(new Font("Arial", 14));
        btnBack.setStyle("-fx-background-color: #424242; -fx-text-fill: #b0b3b8; -fx-font-weight: bold; -fx-background-radius: 11;");
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.close();
                // Open the previous window (e.g., ProfileResultWindow)
                if (user != null) {
                    ProfileResultWindow prWindow = new ProfileResultWindow();
                    Stage prWindowStage = new Stage();
                    try {
                        prWindow.start(prWindowStage);
                    } catch (Exception ex) {
                        System.out.println("Error: " + ex.getMessage());
                        ex.printStackTrace();
                    }
                }
            }
        });
        
        // Display user profile info
        if (user != null) {
            Label heightLabel = new Label(String.format("Height: %.1f cm", user.getHeight()));
            heightLabel.setFont(new Font("Arial", 14));
            heightLabel.setStyle("-fx-text-fill: #ffffff;");
            
            Label weightLabel = new Label(String.format("Weight: %.1f kg", user.getWeight()));
            weightLabel.setFont(new Font("Arial", 14));
            weightLabel.setStyle("-fx-text-fill: #ffffff;");
            
            Label ageLabel = new Label(String.format("Age: %d years", user.getAge()));
            ageLabel.setFont(new Font("Arial", 14));
            ageLabel.setStyle("-fx-text-fill: #ffffff;");
            
            Label activityLevelLabel = new Label(String.format("Activity Level: %s", user.getActivityLevel()));
            activityLevelLabel.setFont(new Font("Arial", 14));
            activityLevelLabel.setStyle("-fx-text-fill: #ffffff;");
            
            Label fitnessGoalLabel = new Label(String.format("Fitness Goal: %s", getFitnessGoalFromContext())); // Placeholder
            fitnessGoalLabel.setFont(new Font("Arial", 14));
            fitnessGoalLabel.setStyle("-fx-text-fill: #ffffff;");
            
            profileInfo.getChildren().addAll(heightLabel, weightLabel, ageLabel, activityLevelLabel, fitnessGoalLabel);
        } else {
            Label noData = new Label("No user data available");
            noData.setFont(new Font("Arial", 14));
            noData.setStyle("-fx-text-fill: #ffffff;");
            profileInfo.getChildren().add(noData);
        }
        
        // Load and display previous calculations
        if (user != null && user.getId() > 0) {
            UserCRUD userCrud = new UserCRUD();
            List<UserProfile> profiles = userCrud.viewProfile(user.getId());
            if (profiles != null && !profiles.isEmpty()) {
                for (UserProfile profile : profiles) {
                    Label entry = new Label(String.format(
                        "Profile #%d - BMI: %.1f, BMR: %.0f cal, Calories: %d cal",
                        profile.getProfileId(),
                        profile.getBmi(),
                        profile.getBmr(),
                        profile.getDailyCalories()
                    ));
                    entry.setFont(new Font("Arial", 14));
                    entry.setStyle("-fx-text-fill: #ffffff;");
                    calcHistory.getChildren().add(entry);
                }
            } else {
                Label noData = new Label("No previous calculations available");
                noData.setFont(new Font("Arial", 14));
                noData.setStyle("-fx-text-fill: #ffffff;");
                calcHistory.getChildren().add(noData);
            }
        } else {
            Label noData = new Label("No user data available");
            noData.setFont(new Font("Arial", 14));
            noData.setStyle("-fx-text-fill: #ffffff;");
            calcHistory.getChildren().add(noData);
        }
        
        // Layout
        lblTitle.relocate(117, 20);
        pane.getChildren().add(lblTitle);
        
        lblProfile.relocate(50, 50);
        profileInfo.setLayoutX(50);
        profileInfo.setLayoutY(80);
        pane.getChildren().addAll(lblProfile, profileInfo);
        
        lblPrevCalc.relocate(50, 250);
        calcHistory.setLayoutX(50);
        calcHistory.setLayoutY(280);
        pane.getChildren().addAll(lblPrevCalc, calcHistory);
        
        btnBack.relocate(30, 28);
        pane.getChildren().add(btnBack);
        
        primaryStage.show();
    }

    // Placeholder method to simulate fitness goal (should be retrieved from calculation context)
    private String getFitnessGoalFromContext() {
        // In a real scenario, this would come from the MacroResult or user input
        // For now, return a default value
        return "Maintenance"; // Replace with actual logic if available
    }

    public static void main(String[] args) {
        launch(args);
    }
}