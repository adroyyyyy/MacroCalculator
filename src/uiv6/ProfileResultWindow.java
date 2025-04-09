package uiv6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ProfileResultWindow extends Application {
	private User user; // Store User object
	private MacroResult result; // Store MacroResult object

	// default constructor
	public ProfileResultWindow() {
		this.user = null;
		this.result = null;
	}

	// parameterized constructor
	public ProfileResultWindow(User user) {
		this.user = user;
		this.result = null;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane pane = new Pane();
		Scene scene = new Scene(pane); // scene to hold the pane

		pane.setStyle("-fx-background-color: #212121;"); // setting up background color
		primaryStage.setScene(scene);
		primaryStage.setTitle("Profile Window"); // title of window
		primaryStage.setWidth(350); // window width 
		primaryStage.setHeight(700); // window height
		primaryStage.setAlwaysOnTop(false);
		primaryStage.setResizable(false);

		// Declare UI components
		Label lblTitle, lblProfile, lblHeight, lblWeight, lblGender, lblAge, lblActivityLevel, lblFitnessGoal,
				lblResult, lblBMR, lblBMI, lblMessage, lblBMRResult, lblBMIResult, lblHeightUnit, lblWeightUnit;
		TextField txtHeight, txtWeight, txtAge;
		Button btnCalculate, btnProfileWindow, btnDCRWindow, btnSettings;
		ComboBox<String> cbGender, cbActivityLevel, cbFitnessGoal;

		// Initialize and set UI components
		lblTitle = new Label("Macro Calculator"); // initializing and prompt to identify
		lblTitle.setFont(new Font("Arial", 14)); // set font 
		lblTitle.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;"); // light gray and bold text

		lblProfile = new Label("Profile");
		lblProfile.setFont(new Font("Arial", 18));
		lblProfile.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");

		lblHeight = new Label("Height");
		lblHeight.setFont(new Font("Arial", 14));
		lblHeight.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");

		lblHeightUnit = new Label(UnitsFormatsWindow.heightUnit);
		lblHeightUnit.setFont(new Font("Arial", 12));
		lblHeightUnit.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");

		lblWeight = new Label("Weight");
		lblWeight.setFont(new Font("Arial", 14));
		lblWeight.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");

		lblWeightUnit = new Label(UnitsFormatsWindow.weightUnit);
		lblWeightUnit.setFont(new Font("Arial", 12));
		lblWeightUnit.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");

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

		lblBMRResult = new Label("");
		lblBMRResult.setFont(new Font("Arial", 14));
		lblBMRResult.setStyle("-fx-text-fill: #ffffff; -fx-font-weight: bold;");

		lblBMIResult = new Label("");
		lblBMIResult.setFont(new Font("Arial", 14));
		lblBMIResult.setStyle("-fx-text-fill: #ffffff; -fx-font-weight: bold;");

		lblMessage = new Label("");
		lblMessage.setFont(new Font("Arial", 12));
		lblMessage.setStyle("-fx-text-fill: #ff4444; -fx-font-weight: bold;");

		txtHeight = new TextField();
		txtHeight.setPrefWidth(50);
		txtHeight.setStyle(
				"-fx-background-color: #424242; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-background-radius: 11;"); // dark gray input with rounded border corners 

		txtWeight = new TextField();
		txtWeight.setPrefWidth(50);
		txtWeight.setStyle(
				"-fx-background-color: #424242; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-background-radius: 11;");

		txtAge = new TextField();
		txtAge.setPrefWidth(50);
		txtAge.setStyle(
				"-fx-background-color: #424242; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-background-radius: 11;");

		cbGender = new ComboBox<>();
		cbGender.getItems().addAll("Male", "Female");
		cbGender.setPrefWidth(88);
		cbGender.setStyle(
				"-fx-background-color: #212121; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-background-radius: 11;");
		cbGender.setButtonCell(new ListCell<String>() {
			@Override
			protected void updateItem(String item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item);
				setStyle(
						"-fx-background-color: #424242; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-background-radius: 11;");
			}
		});

		cbActivityLevel = new ComboBox<>();
		cbActivityLevel.getItems().addAll("     Low       ", "Moderate    ", "    High       "); // spaced for alignment
		cbActivityLevel.setPrefWidth(109);
		cbActivityLevel.setStyle(
				"-fx-background-color: #212121; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-background-radius: 11;");
		cbActivityLevel.setButtonCell(new ListCell<String>() {
			@Override
			protected void updateItem(String item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item);
				setStyle(
						"-fx-background-color: #424242; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-background-radius: 11;");
			}
		});

		cbFitnessGoal = new ComboBox<>();
		cbFitnessGoal.getItems().addAll("        Lose weight", "      Maintain weight", "      Increase weight");
		cbFitnessGoal.setPrefWidth(168);
		cbFitnessGoal.setStyle(
				"-fx-background-color: #212121; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-background-radius: 11;");
		cbFitnessGoal.setButtonCell(new ListCell<String>() {
			@Override
			protected void updateItem(String item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item);
				setStyle(
						"-fx-background-color: #424242; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-background-radius: 11;");
			}
		});

		btnCalculate = new Button("Calculate");
		btnCalculate.setFont(new Font("Arial", 14));
		btnCalculate.setStyle(
				"-fx-background-color: #424242; -fx-text-fill: #b0b3b8; -fx-font-weight: bold; -fx-background-radius: 11;");
		btnCalculate.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				lblMessage.setText("");
				lblBMRResult.setText("");
				lblBMIResult.setText("");

				String heightText = txtHeight.getText();
				String weightText = txtWeight.getText();
				String ageText = txtAge.getText();
				String genderValue = cbGender.getValue();
				String activityValue = cbActivityLevel.getValue();
				String fitnessValue = cbFitnessGoal.getValue();

				if (heightText == null || heightText.isEmpty() || weightText == null || weightText.isEmpty()
						|| ageText == null || ageText.isEmpty() || genderValue == null || activityValue == null
						|| fitnessValue == null) {
					lblMessage.setText("Please fill all the data");
					return;
				}

				try {
					// Handle height based on UnitsFormatsWindow.heightUnit
					double height;
					if ("ft/in".equals(UnitsFormatsWindow.heightUnit)) {
						String[] parts = heightText.trim().split("\\s+"); // Split by whitespace
						if (parts.length != 2) {
							lblMessage.setText("Invalid height format (use '5 7' for 5 feet 7 inches)");
							return;
						}
						int feet = Integer.parseInt(parts[0]);
						int inches = Integer.parseInt(parts[1]);

						// Validate
						if (feet < 0 || inches < 0 || inches >= 12) {
							lblMessage.setText("Invalid height (inches must be 0-11)");
							return;
						}
						height = (feet * 12 + inches) * 2.54; // Convert total inches to cm
					} else {
						// Assume cm
						height = Double.parseDouble(heightText.trim());
					}

					// Handle weight based on UnitsFormatsWindow.weightUnit
					double weight;
					if ("lbs".equals(UnitsFormatsWindow.weightUnit)) {
						weight = Double.parseDouble(weightText.trim()) * 0.453592; // Convert lbs to kg
					} else {
						// Assume kg
						weight = Double.parseDouble(weightText.trim());
					}

					int age = Integer.parseInt(ageText.trim());

					if (height <= 0 || weight <= 0 || age <= 0) { // making sure users values are +ve numbers
						lblMessage.setText("Values must be positive numbers");
						return;
					}

					String activityLevel;
					switch (activityValue.trim()) { // conditions to choose from 
					case "Low":
						activityLevel = "Normal";
						break;
					case "Moderate":
						activityLevel = "Moderate";
						break;
					case "High":
						activityLevel = "Active";
						break;
					default:
						activityLevel = "Normal";
						break;
					}

					String fitnessGoal; 
					switch (fitnessValue.trim()) { // fitness goals users can choose
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
						fitnessGoal = "Maintenance";
						break;
					}

					if (user == null) {
						lblMessage.setText("No logged-in user. Please log in first.");
						return;
					}

					// update User object with input data
					user.setHeight(height); // cm
					user.setWeight(weight); // kg
					user.setAge(age);
					user.setGender(genderValue);
					user.setActivityLevel(activityLevel);
					user.setFitnessGoal(fitnessGoal);

					// calculate macros using selected formula
					MacroCalculator calculator = new MacroCalculator();
					result = calculator.calculate(user, FormulaWindow.selectedFormula, "Standard", fitnessGoal);

					// display results
					lblBMRResult.setText(String.format("%.0f cal", result.getBmr()));
					lblBMIResult.setText(String.format("%.1f", result.getBmi()));

					// save to database
					UserCRUD userCrud = new UserCRUD();
					userCrud.updateUser(user);

					UserProfile profile = new UserProfile(user.getId(), result.getBmi(), result.getBmr(),
							(int) result.getCalories(), (int) result.getCarbs(), (int) result.getProtein(),
							(int) result.getFat());
					userCrud.saveProfile(profile);

					lblMessage.setText("Data saved successfully!");

				} catch (NumberFormatException ex) {
					lblMessage.setText("Please enter valid numbers (e.g., '5 7' for ft/in, numeric for weight)");
				} catch (Exception ex) {
					lblMessage.setText("An error occurred: " + ex.getMessage());
					ex.printStackTrace(); // gets detailed error message
				}
			}
		});

		btnSettings = new Button();
		try {
			// Load image from Imge folder 
			Image settingsImage = new Image(getClass().getResourceAsStream("/settings.png"));
			ImageView settingsView = new ImageView(settingsImage);
			settingsView.setFitHeight(25);
			settingsView.setFitWidth(25);
			btnSettings.setGraphic(settingsView);
		} catch (Exception ex) {
			System.out.println("Error loading settings icon: " + ex.getMessage());
		}
		btnSettings.setStyle("-fx-background-color: transparent; -fx-text-fill: #b0b3b8; -fx-font-size: 14;");
		btnSettings.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				primaryStage.close();
				SettingsWindow stWindow = new SettingsWindow(user);
				Stage stWindowStage = new Stage();
				try {
					stWindow.start(stWindowStage);
				} catch (Exception ex) {
					System.out.println("Login Error: " + ex.getMessage());
					ex.printStackTrace();
				}
			}
		});

		btnProfileWindow = new Button();
		try {
			// Load image from Image folder
			Image profileImage = new Image(getClass().getResourceAsStream("/profileIcon.png"));
			ImageView profileView = new ImageView(profileImage);
			profileView.setFitHeight(50);
			profileView.setFitWidth(50);
			btnProfileWindow.setGraphic(profileView);
		} catch (Exception ex) {
			System.out.println("Error loading settings icon: " + ex.getMessage());
		}
		btnProfileWindow.setStyle("-fx-background-color: transparent; -fx-text-fill: #b0b3b8; -fx-font-size: 14;");
		btnProfileWindow.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				primaryStage.close();
				ProfileResultWindow prWindow = new ProfileResultWindow(user);
				Stage prWindowStage = new Stage();
				try {
					prWindow.start(prWindowStage);
				} catch (Exception ex) {
					System.out.println("Error: " + ex.getMessage());
					ex.printStackTrace();
				}
			}
		});

		btnDCRWindow = new Button();
		try {
			// load image from Images folder
			Image dcrImage = new Image(getClass().getResourceAsStream("/dcr.png"));
			ImageView dcrView = new ImageView(dcrImage);
			dcrView.setFitHeight(50);
			dcrView.setFitWidth(50);
			btnDCRWindow.setGraphic(dcrView);
		} catch (Exception ex) {
			System.out.println("Error loading settings icon: " + ex.getMessage());
		}
		
		btnDCRWindow.setStyle("-fx-background-color: transparent; -fx-text-fill: #b0b3b8; -fx-font-size: 14;");
		btnDCRWindow.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				primaryStage.close();
				if (user != null && result != null) {
					DailyCaloricRequirementWindow dcrWindow = new DailyCaloricRequirementWindow(user, result); 
					Stage dcrWindowStage = new Stage();
					try {
						dcrWindow.start(dcrWindowStage); // Starts DCRwindow on new stage with data passed through 
					} catch (Exception ex) {
						System.out.println("Error: " + ex.getMessage());
						ex.printStackTrace();
					}
				} else {
					lblMessage.setText("Please calculate results first");
				}
			}
		});

		// layout (columns, row)
		lblTitle.relocate(117, 20);
		pane.getChildren().add(lblTitle);

		lblProfile.relocate(28, 55);
		pane.getChildren().add(lblProfile);

		lblHeight.relocate(28, 100);
		pane.getChildren().add(lblHeight);
		txtHeight.relocate(270, 95);
		pane.getChildren().add(txtHeight);
		lblHeightUnit.relocate(220, 100);
		pane.getChildren().add(lblHeightUnit);

		lblWeight.relocate(28, 145);
		pane.getChildren().add(lblWeight);
		txtWeight.relocate(270, 140);
		pane.getChildren().add(txtWeight);
		lblWeightUnit.relocate(220, 145);
		pane.getChildren().add(lblWeightUnit);

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

		btnDCRWindow.relocate(210, 600);
		pane.getChildren().add(btnDCRWindow);

		btnSettings.relocate(300, 20);
		pane.getChildren().add(btnSettings);

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}