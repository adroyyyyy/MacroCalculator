package uiv6;

import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PrevCalcWindow extends Application {
	private User user; // Store the User object

	public PrevCalcWindow() {
		this.user = null;
	}

	public PrevCalcWindow(User user) {
		this.user = user;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// UI Components
		Label lblTitle = new Label("Previous Calculations");
		Button btnBack = new Button("<");
		Button btnShow = new Button("Show");
		TableView<UserProfile> tblCalcHistory = new TableView<>();

		// Apply dark theme to pane
		Pane pane = new Pane();
		pane.setStyle("-fx-background-color: #212121;");

		// Title setup with dark theme
		Font font = new Font("Arial", 18);
		lblTitle.setFont(font);
		lblTitle.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");
		lblTitle.relocate(50, 20);

		// Back button setup with dark theme
		btnBack.setFont(new Font("Arial", 14));
		btnBack.setStyle(
				"-fx-background-color: #424242; -fx-text-fill: #b0b3b8; -fx-font-weight: bold; -fx-background-radius: 11;");
		btnBack.relocate(10, 20);
		btnBack.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				primaryStage.close(); // closing itself

				SettingsWindow stWindow = new SettingsWindow(user);
				Stage stWindowStage = new Stage();
				try {
					stWindow.start(stWindowStage);
				} catch (Exception ex) {
					System.out.println("Error: " + ex.getMessage());
					ex.printStackTrace();
				}
			}
		});

		// Show button setup with dark theme and debugging
		btnShow.setFont(new Font("Arial", 14));
		btnShow.setStyle(
				"-fx-background-color: #424242; -fx-text-fill: #b0b3b8; -fx-font-weight: bold; -fx-background-radius: 11;");
		btnShow.relocate(250, 20);
		btnShow.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				tblCalcHistory.getItems().clear(); // Clear existing data
				if (user == null || user.getId() <= 0) {
					System.out
							.println("No valid user provided. User: " + (user == null ? "null" : "ID=" + user.getId()));
					return;
				}

				System.out.println("Fetching profiles for user ID: " + user.getId());
				UserCRUD userCrud = new UserCRUD();
				List<UserProfile> profiles = userCrud.viewProfile(user.getId());
				System.out.println("Number of profiles retrieved: " + (profiles == null ? 0 : profiles.size()));

				if (profiles != null && !profiles.isEmpty()) {
					tblCalcHistory.getItems().addAll(profiles);
					System.out.println("Profiles added to TableView:");

				} else {
					System.out.println("No profiles found for user ID: " + user.getId());
				}
			}
		});

		// TableView setup
		tblCalcHistory.setPrefHeight(600);
		tblCalcHistory.setPrefWidth(300);
		tblCalcHistory.relocate(25, 60);

		// Define columns based on UserProfile properties (only BMI, BMR, CALORIES)
		TableColumn<UserProfile, Integer> colProfileId = new TableColumn<>("PROFILE ID");
		TableColumn<UserProfile, Double> colBmi = new TableColumn<>("BMI");
		TableColumn<UserProfile, Double> colBmr = new TableColumn<>("BMR");
		TableColumn<UserProfile, Integer> colCalories = new TableColumn<>("CALORIES");

		// Add columns to TableView
		tblCalcHistory.getColumns().addAll(colProfileId, colBmi, colBmr, colCalories);

		// Bind columns to UserProfile properties
		colProfileId.setCellValueFactory(new PropertyValueFactory<>("profileId"));
		colBmi.setCellValueFactory(new PropertyValueFactory<>("bmi"));
		colBmr.setCellValueFactory(new PropertyValueFactory<>("bmr"));
		colCalories.setCellValueFactory(new PropertyValueFactory<>("dailyCalories"));

		// Scene setup
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setWidth(350);
		primaryStage.setHeight(700);
		primaryStage.setTitle("History Window");

		// Add components to pane
		pane.getChildren().add(lblTitle);
		pane.getChildren().add(btnBack);
		pane.getChildren().add(btnShow);
		pane.getChildren().add(tblCalcHistory);

		// Show the stage
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}