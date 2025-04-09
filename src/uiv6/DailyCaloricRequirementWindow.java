package uiv6;

//importing libraries
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DailyCaloricRequirementWindow extends Application {
	private User user; // Store User object
	private MacroResult macroResult; // Store the calculation results

	// default constructor
	public DailyCaloricRequirementWindow() {
		this.user = null;
		this.macroResult = null;
	}

	// parameterized constructor
	public DailyCaloricRequirementWindow(User user, MacroResult result) {
		this.user = user;
		this.macroResult = result;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane pane = new Pane();
		Scene scene = new Scene(pane);

		pane.setStyle("-fx-background-color: #212121;");
		primaryStage.setScene(scene);
		primaryStage.setTitle("Daily Caloric Requirement Window");
		primaryStage.setWidth(350);
		primaryStage.setHeight(700);
		primaryStage.setAlwaysOnTop(false);
		primaryStage.setResizable(false);

		// Declare
		Label lblTitle, lblDCR, lblMacroDistribution, lblCarbs, lblProtein, lblFat, lblDietType, lblCarbsResult,
				lblProteinResult, lblFatResult, lblCaloriesResult;
		ComboBox<String> cbDietType;
		Button btnProfileWindow, btnDCRWindow, btnSettings;

		// Initialize and set
		lblTitle = new Label("Macro Calculator");
		lblTitle.setFont(new Font("Arial", 14)); // setting font for title
		lblTitle.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;"); // grey and bold text

		lblDCR = new Label("Daily Caloric Requirement");
		lblDCR.setFont(new Font("Arial", 20));
		lblDCR.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");

		lblCaloriesResult = new Label(macroResult != null ? String.format("%.0f cal", macroResult.getCalories()) : "");
		lblCaloriesResult.setFont(new Font("Arial", 18));
		lblCaloriesResult.setStyle("-fx-text-fill: #ffffff; -fx-font-weight: bold;");

		lblMacroDistribution = new Label("Macro Distribution");
		lblMacroDistribution.setFont(new Font("Arial", 20));
		lblMacroDistribution.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");

		lblCarbs = new Label("Carbs");
		lblCarbs.setFont(new Font("Arial", 14));
		lblCarbs.setStyle("-fx-text-fill: #ffd300; -fx-font-weight: bold;");

		lblCarbsResult = new Label(macroResult != null ? String.format("%.0f g", macroResult.getCarbs()) : "");
		lblCarbsResult.setFont(new Font("Arial", 14));
		lblCarbsResult.setStyle("-fx-text-fill: #ffd300; -fx-font-weight: bold;");

		lblProtein = new Label("Protein");
		lblProtein.setFont(new Font("Arial", 14));
		lblProtein.setStyle("-fx-text-fill: #bd83fc; -fx-font-weight: bold;");

		lblProteinResult = new Label(macroResult != null ? String.format("%.0f g", macroResult.getProtein()) : "");
		lblProteinResult.setFont(new Font("Arial", 14));
		lblProteinResult.setStyle("-fx-text-fill: #bd83fc; -fx-font-weight: bold;");

		lblFat = new Label("Fat");
		lblFat.setFont(new Font("Arial", 14));
		lblFat.setStyle("-fx-text-fill: #ff4444; -fx-font-weight: bold;");

		lblFatResult = new Label(macroResult != null ? String.format("%.0f g", macroResult.getFat()) : "");
		lblFatResult.setFont(new Font("Arial", 14));
		lblFatResult.setStyle("-fx-text-fill: #ff4444; -fx-font-weight: bold;");

		lblDietType = new Label("Diet Type");
		lblDietType.setFont(new Font("Arial", 14));
		lblDietType.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");

		cbDietType = new ComboBox<>();
		cbDietType.getItems().addAll("Standard", "Low Fat", "Keto");
		cbDietType.setPrefWidth(100);
		cbDietType.setStyle(
				"-fx-background-color: #212121; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-background-radius: 11;");

		cbDietType.setButtonCell(new ListCell<String>() {
			@Override
			protected void updateItem(String item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item);
				setStyle(
						"-fx-background-color: #424242; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-background-radius: 11;");
			}
		});

		// Set initial diet type
		if (cbDietType.getValue() == null) {
			cbDietType.setValue("Standard"); // Default to Standard
		}

		// Initialize chart
		CaloricChart caloricChart = new CaloricChart(macroResult != null ? macroResult.getCarbs() : 200,
				macroResult != null ? macroResult.getProtein() : 150, macroResult != null ? macroResult.getFat() : 50);
		CaloricChartView chartView = new CaloricChartView(caloricChart);
		PieChart pieChart = chartView.getPieChart();

		// Update chart with initial values if macroResult exists
		if (macroResult != null) {
			chartView.updateChart(macroResult.getCarbs(), macroResult.getProtein(), macroResult.getFat());
		} else {
			chartView.updateChart(300, 100, 70); // Default values
		}


		btnSettings = new Button();
		try {
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

		btnProfileWindow = new Button();
		try { 
			// Load image from Image folder in the project 
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
				primaryStage.close(); // closing itself

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
				primaryStage.close(); // closing itself

				DailyCaloricRequirementWindow dcrWindow = new DailyCaloricRequirementWindow(user, macroResult);
				Stage dcrWindowStage = new Stage();
				try {
					dcrWindow.start(dcrWindowStage);
				} catch (Exception ex) {
					System.out.println("Error: " + ex.getMessage());
					ex.printStackTrace();
				}
			}
		});

		
		cbDietType.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (user != null && macroResult != null) {
					String dietType = cbDietType.getValue();
					MacroCalculator calculator = new MacroCalculator();
					MacroResult newResult = calculator.calculate(user, "Mifflin-St Jeor", dietType,
							user.getFitnessGoal());

					macroResult = newResult;

					// Update labels
					lblCaloriesResult.setText(String.format("%.0f cal", newResult.getCalories()));
					lblCarbsResult.setText(String.format("%.0f g", newResult.getCarbs()));
					lblProteinResult.setText(String.format("%.0f g", newResult.getProtein()));
					lblFatResult.setText(String.format("%.0f g", newResult.getFat()));

					// Update pie chart
					chartView.updateChart(newResult.getCarbs(), newResult.getProtein(), newResult.getFat());
				}
			}
		});

		// layout (columns, rows)
		lblTitle.relocate(117, 20);
		pane.getChildren().add(lblTitle);
		
		lblDCR.relocate(48, 68);
		pane.getChildren().add(lblDCR);
		
		lblCaloriesResult.relocate(145, 120);
		pane.getChildren().add(lblCaloriesResult);
		
		lblMacroDistribution.relocate(90, 200);
		pane.getChildren().add(lblMacroDistribution);
		
		lblCarbs.relocate(48, 245);
		pane.getChildren().add(lblCarbs);
		
		lblCarbsResult.relocate(48, 270);
		pane.getChildren().add(lblCarbsResult);
		
		lblProtein.relocate(158, 245);
		pane.getChildren().add(lblProtein);
		
		lblProteinResult.relocate(158, 270);
		pane.getChildren().add(lblProteinResult);
		
		lblFat.relocate(280, 245);
		pane.getChildren().add(lblFat);
		
		lblFatResult.relocate(280, 270);
		pane.getChildren().add(lblFatResult);
		
		lblDietType.relocate(28, 525);
		pane.getChildren().add(lblDietType);
		
		cbDietType.relocate(100, 520);
		pane.getChildren().add(cbDietType);
		
		btnProfileWindow.relocate(70, 600);
		pane.getChildren().add(btnProfileWindow);
		
		btnDCRWindow.relocate(210, 600);
		pane.getChildren().add(btnDCRWindow);
		
		btnSettings.relocate(300, 20);
		pane.getChildren().add(btnSettings);

		pieChart.relocate(75, 320);
		pane.getChildren().add(pieChart);

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}