<<<<<<< HEAD
package uiv3;
=======
package uiv6;
>>>>>>> first commit

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DailyCaloricRequirementWindow extends Application {
<<<<<<< HEAD
    private User user;          // Store User object
    private MacroResult macroResult; // Store the calculation results
=======
    private User user;          // store user object
    private MacroResult macroResult; // stores the calculation results
>>>>>>> first commit

    public DailyCaloricRequirementWindow() {
        this.user = null;
        this.macroResult = null;
    }

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
        Label lblTitle, lblDCR, lblMacroDistribution, lblCarbs, lblProtein, 
              lblFat, lblDietType, lblCarbsResult, lblProteinResult, 
              lblFatResult, lblCaloriesResult;
        ComboBox<String> cbDietType;
        Button btnProfileWindow, btnDCRWindow, btnSettings;
        
        // Initialize and set
        lblTitle = new Label("Macro Calculator");
        lblTitle.setFont(new Font("Arial", 14));
        lblTitle.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");
        
        lblDCR = new Label("Daily Caloric Requirement");
        lblDCR.setFont(new Font("Arial", 20));
        lblDCR.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");
        
        lblCaloriesResult = new Label(macroResult != null ? String.format("%.0f cal", macroResult.getCalories()): "");
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
        cbDietType.setStyle("-fx-background-color: #212121; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-background-radius: 11;");
        
<<<<<<< HEAD
=======

        
>>>>>>> first commit
        cbDietType.setButtonCell(new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item);
                setStyle("-fx-background-color: #424242; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-background-radius: 11;");
            }
        });
        
<<<<<<< HEAD
        // Update macro distribution when diet type changes
        cbDietType.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (user != null && macroResult != null) {
                    String dietType;
                    switch (cbDietType.getValue()) {
                        case "Standard":
                            dietType = "Standard";
                            break;
                        case "Low Fat":
                            dietType = "Low Fat";
                            break;
                        case "Keto":
                            dietType = "Keto";
                            break;
                        default:
                            dietType = "Standard";
                            break;
                    }
                    
                    // Recalculate macros with new diet type using actual User data
                    MacroCalculator calculator = new MacroCalculator();
                    MacroResult newResult = calculator.calculate(user, "Mifflin-St Jeor", dietType, "Maintenance"); // Adjust goal if needed
                    
                    lblCaloriesResult.setText(String.format("%.0f cal", newResult.getCalories()));
                    lblCarbsResult.setText(String.format("%.0f g", newResult.getCarbs()));
                    lblProteinResult.setText(String.format("%.0f g", newResult.getProtein()));
                    lblFatResult.setText(String.format("%.0f g", newResult.getFat()));
                }
            }
        });
=======
>>>>>>> first commit
        
        btnSettings = new Button("Settings");
        btnSettings.setStyle("-fx-background-color: transparent; -fx-text-fill: #b0b3b8; -fx-font-size: 14;");
        btnSettings.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
<<<<<<< HEAD
=======
            	// closes itself
            	primaryStage.close();
            	
>>>>>>> first commit
                SettingsWindow stWindow = new SettingsWindow();
                Stage stWindowStage = new Stage();
                try {
                    stWindow.start(stWindowStage);
                } catch (Exception ex) {
                    System.out.println("Error: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });
        
        btnProfileWindow = new Button("Profile");
        btnProfileWindow.setStyle("-fx-background-color: transparent; -fx-text-fill: #b0b3b8; -fx-font-size: 14;");
        btnProfileWindow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
<<<<<<< HEAD
                ProfileResultWindow prWindow = new ProfileResultWindow();
                Stage prWindowStage = new Stage();
                try {
                    prWindow.start(prWindowStage);
=======
            	
            	primaryStage.close(); // closing itself (DailycaloricRequirementWindow
            	
            	// open ProfileResultWindow  // currently doesn't pass any value (under maintenance)
                ProfileResultWindow prWindow = new ProfileResultWindow();
                Stage prWindowStage = new Stage();
                try {
                    prWindow.start(prWindowStage); 
>>>>>>> first commit
                } catch (Exception ex) {
                    System.out.println("Error: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });
        
<<<<<<< HEAD
        btnDCRWindow = new Button("Daily Caloric Requirement");
        btnDCRWindow.setStyle("-fx-background-color: transparent; -fx-text-fill: #b0b3b8; -fx-font-size: 14;");
        btnDCRWindow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
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
        
        CaloricChart caloricChart = new CaloricChart(200, 150, 50);
        CaloricChartView chartView = new CaloricChartView(caloricChart);
        PieChart pieChart = chartView.getPieChart();

        chartView.updateChart(300, 100, 70);
        
        
        // When diet type changes (in cbDietType's onAction)
        cbDietType.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String dietType = cbDietType.getValue();
                MacroCalculator calculator = new MacroCalculator();
                MacroResult newResult = calculator.calculate(user, "Mifflin-St Jeor", dietType, "Maintenance");
=======
        
        btnDCRWindow = new Button("Daily Caloric Requirement");
        btnDCRWindow.setStyle("-fx-background-color: transparent; -fx-text-fill: #b0b3b8; -fx-font-size: 14;");
        // no action window 
        
        
        
        CaloricChart caloricChart = new CaloricChart(200, 150, 50); // initial values carbs, protein, fat
        CaloricChartView chartView = new CaloricChartView(caloricChart);
        PieChart pieChart = chartView.getPieChart();
        
        // when diet type changes 
        cbDietType.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            
            public void handle(ActionEvent event) {
                String dietType = cbDietType.getValue(); 
                MacroCalculator calculator = new MacroCalculator(); 
                MacroResult newResult = calculator.calculate(user, "Mifflin-St Jeor", dietType, user.getFitnessGoal());
>>>>>>> first commit
                macroResult = newResult;

                // Update labels
                lblCaloriesResult.setText(String.format("%.0f cal", newResult.getCalories()));
                lblCarbsResult.setText(String.format("%.0f g", newResult.getCarbs()));
                lblProteinResult.setText(String.format("%.0f g", newResult.getProtein()));
                lblFatResult.setText(String.format("%.0f g", newResult.getFat()));

                // Update pie chart
                chartView.updateChart(newResult.getCarbs(), newResult.getProtein(), newResult.getFat());
            }
        });
        
        
<<<<<<< HEAD
        // Column, row
        lblTitle.relocate(117, 20);
        pane.getChildren().add(lblTitle);
=======
        
        // Column, row
        lblTitle.relocate(117, 20);
        pane.getChildren().add(lblTitle);
        
>>>>>>> first commit
        lblDCR.relocate(48, 68);
        pane.getChildren().add(lblDCR);

        lblCaloriesResult.relocate(145, 120);
        pane.getChildren().add(lblCaloriesResult);
        
        lblMacroDistribution.relocate(90, 200);
        pane.getChildren().add(lblMacroDistribution);
<<<<<<< HEAD
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
        btnDCRWindow.relocate(140, 600);
        pane.getChildren().add(btnDCRWindow);
        btnSettings.relocate(300, 20);
        pane.getChildren().add(btnSettings);
        
        pieChart.relocate(75,320);// Position below labels
        pane.getChildren().add(pieChart); // Add pie chart to pane
=======
        
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
        
        btnDCRWindow.relocate(140, 600);
        pane.getChildren().add(btnDCRWindow);
        
        btnSettings.relocate(300, 20);
        pane.getChildren().add(btnSettings);
        
        pieChart.relocate(75,320);
        pane.getChildren().add(pieChart); 
>>>>>>> first commit
        
        primaryStage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}