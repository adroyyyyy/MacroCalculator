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

public class UnitsFormatsWindow extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane pane = new Pane();
		Scene scene = new Scene(pane);

		pane.setStyle("-fx-background-color: #212121;");
		primaryStage.setScene(scene);
		primaryStage.setTitle("Units and Formats Window");
		primaryStage.setWidth(350);
		primaryStage.setHeight(700);
		primaryStage.setAlwaysOnTop(false);
		primaryStage.setResizable(false);

		// Declare
		Label lblTitle, lblUnitsFormats, lblHeight, lblWeight, lblCm, lblFtin, lblKg, lblLbs;

		ToggleGroup tgHeight, tgWeight;

		RadioButton rbCm, rbFtin, rbKg, rbLbs;

		Button btnBack;

		// Initialize and set
		lblTitle = new Label("Macro Calculator");
		lblTitle.setFont(new Font("Arial", 14)); // Set font
		lblTitle.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");

		lblUnitsFormats = new Label("Units and Formats");
		lblUnitsFormats.setFont(new Font("Arial", 20)); // Set font
		lblUnitsFormats.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");

		lblHeight = new Label("Height");
		lblHeight.setFont(new Font("Arial", 16)); // Set font
		lblHeight.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold; ");

		lblWeight = new Label("Weight");
		lblWeight.setFont(new Font("Arial", 16)); // Set font
		lblWeight.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold; ");

		lblCm = new Label("cm");
		lblCm.setFont(new Font("Arial", 14)); // Set font
		lblCm.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold; ");

		lblFtin = new Label("ft inches");
		lblFtin.setFont(new Font("Arial", 14)); // Set font
		lblFtin.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold; ");

		lblKg = new Label("kg");
		lblKg.setFont(new Font("Arial", 14)); // Set font
		lblKg.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold; ");

		lblLbs = new Label("lbs");
		lblLbs.setFont(new Font("Arial", 14)); // Set font
		lblLbs.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold; ");

		tgHeight = new ToggleGroup();
		tgWeight = new ToggleGroup();

		rbCm = new RadioButton("");
		rbCm.setToggleGroup(tgHeight);
		rbCm.setSelected(true);
		rbCm.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-mark-color: #424242;");

		rbFtin = new RadioButton("");
		rbFtin.setToggleGroup(tgHeight);
		rbFtin.setStyle(rbCm.getStyle());

		rbKg = new RadioButton("");
		rbKg.setToggleGroup(tgWeight);
		rbKg.setSelected(true);
		rbKg.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-mark-color: #424242;");

		rbLbs = new RadioButton("");
		rbLbs.setToggleGroup(tgWeight);
		rbLbs.setStyle(rbKg.getStyle());

		btnBack = new Button("<");
		btnBack.setFont(new Font("Arial", 14));
		btnBack.setStyle(
				"-fx-background-color: #424242; -fx-text-fill: #b0b3b8; -fx-font-weight: bold; -fx-background-radius: 11;");
		btnBack.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {

				// Closes itself

				// Opens previous window (settings window)
				SettingsWindow stWindow = new SettingsWindow();
				Stage stWindowStage = new Stage();

				try {
					stWindow.start(stWindowStage);
				} catch (Exception ex) {

					System.out.println("Login Error: " + ex.getMessage());

				}
			}
		});

		// Column, row
		lblTitle.relocate(117, 20);
		pane.getChildren().add(lblTitle);

		lblUnitsFormats.relocate(95, 85);
		pane.getChildren().add(lblUnitsFormats);

		lblHeight.relocate(45, 145);
		pane.getChildren().add(lblHeight);

		lblCm.relocate(55, 190);
		pane.getChildren().add(lblCm);

		rbCm.relocate(285, 189);
		pane.getChildren().add(rbCm);

		lblFtin.relocate(55, 235);
		pane.getChildren().add(lblFtin);

		rbFtin.relocate(285, 234);
		pane.getChildren().add(rbFtin);

		lblWeight.relocate(45, 300);
		pane.getChildren().add(lblWeight);

		lblKg.relocate(55, 360);
		pane.getChildren().add(lblKg);

		rbKg.relocate(285, 359);
		pane.getChildren().add(rbKg);

		lblLbs.relocate(55, 405);
		pane.getChildren().add(lblLbs);

		rbLbs.relocate(285, 404);
		pane.getChildren().add(rbLbs);

		btnBack.relocate(30, 28);
		pane.getChildren().add(btnBack);

		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
