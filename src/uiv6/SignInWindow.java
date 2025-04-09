package uiv6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SignInWindow extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane pane = new Pane();
		Scene scene = new Scene(pane);

		pane.setStyle("-fx-background-color: #212121;");
		primaryStage.setScene(scene);
		primaryStage.setTitle("SignIn Window");
		primaryStage.setWidth(300);
		primaryStage.setHeight(300);
		primaryStage.setAlwaysOnTop(false);
		primaryStage.setResizable(false);

		// Declare
		Label lblTitle, lblName, lblEmail, lblPassword, lblMessage;
		TextField txtName, txtEmail;
		PasswordField txtPassword;
		Button btnSignIn;

		// Initialize and set
		lblTitle = new Label("SignIn Window"); // Single initialization
		lblTitle.setFont(new Font("Arial", 18)); // Set font
		lblTitle.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");

		lblName = new Label("Name");
		lblName.setFont(new Font("Arial", 14)); // Set font
		lblName.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold; ");

		lblEmail = new Label("Email");
		lblEmail.setFont(new Font("Arial", 14)); // Set font
		lblEmail.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold; ");

		lblPassword = new Label("Password");
		lblPassword.setFont(new Font("Arial", 14)); // Set font
		lblPassword.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold; ");

		lblMessage = new Label("Message");
		lblMessage.setFont(new Font("Arial", 12)); // Set font
		lblMessage.setStyle("-fx-text-fill: #b0b3b8; ");

		txtName = new TextField();
		txtName.setPrefWidth(180); // Set width
		txtName.setStyle(
				"-fx-background-color: #424242; -fx-text-fill: #b0b3b8; -fx-font-weight: bold; -fx-background-radius: 11;"); // Single
																																// style
																																// setting

		txtEmail = new TextField();
		txtEmail.setPrefWidth(180); // Set width
		txtEmail.setStyle(
				"-fx-background-color: #424242; -fx-text-fill: #b0b3b8; -fx-font-weight: bold; -fx-background-radius: 11;");

		txtPassword = new PasswordField();
		txtPassword.setPrefWidth(180); // Set width
		txtPassword.setStyle("-fx-background-color: #424242; -fx-text-fill: #b0b3b8; -fx-background-radius: 11;");

		btnSignIn = new Button("SignIn");
		btnSignIn.setStyle(
				"-fx-background-color: #424242; -fx-text-fill: #ffd300; -fx-font-weight: bold; -fx-background-radius: 11;");
		btnSignIn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				String name = txtName.getText().trim();
				String email = txtEmail.getText().trim();
				String password = txtPassword.getText().trim();

				if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
					lblMessage.setText("Please fill all the credentials!");
					return; // if true meaning user hasn't inserted any data in any field, it does not let
							// the code below run
				}

				UserCRUD userCRUD = new UserCRUD();
				User user = userCRUD.newUser(name, email, password);

				if (user != null) { // if the user inserted data is new (not in the database already)
					lblMessage.setText("Sign In Successful!");

					primaryStage.close(); // closes itself (SignInWindow)

					ProfileResultWindow prWindow = new ProfileResultWindow(user);
					Stage prWindowStage = new Stage();
					try {
						prWindow.start(prWindowStage); // Opening ProfileResultWindow in new stage
					} catch (Exception ex) {
						lblMessage.setText("Error opening profile window: " + ex.getMessage()); // error prompt in the app
						System.out.println("Error opening profile window: " + ex.getMessage()); // error prompt in console
						ex.printStackTrace(); // gets error details
					}
				} else {
					lblMessage.setText("Sign-in failed: Email may already be in use or there was a database error.");
				}
			}
		});

		//  layout (Column, row)
		lblTitle.relocate(90, 20);
		pane.getChildren().add(lblTitle);

		lblName.relocate(28, 80);
		pane.getChildren().add(lblName);

		txtName.relocate(100, 75);
		pane.getChildren().add(txtName);

		lblEmail.relocate(28, 125);
		pane.getChildren().add(lblEmail);

		txtEmail.relocate(100, 120);
		pane.getChildren().add(txtEmail);

		lblPassword.relocate(28, 170);
		pane.getChildren().add(lblPassword);

		txtPassword.relocate(100, 165);
		pane.getChildren().add(txtPassword);

		lblMessage.relocate(28, 240);
		pane.getChildren().add(lblMessage);

		btnSignIn.relocate(215, 220);
		pane.getChildren().add(btnSignIn);

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}