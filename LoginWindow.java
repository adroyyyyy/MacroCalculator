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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

<<<<<<< HEAD
//fasdfasdfasdf
=======
>>>>>>> first commit


public class LoginWindow extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane pane = new Pane();
		Scene scene = new Scene(pane);
        
<<<<<<< HEAD
        pane.setStyle("-fx-background-color: #212121;");
		primaryStage.setScene(scene);
		primaryStage.setTitle("Login Window");
		primaryStage.setWidth(300);
		primaryStage.setHeight(300);
		primaryStage.setAlwaysOnTop(false);
		primaryStage.setResizable(false);
=======
        pane.setStyle("-fx-background-color: #212121;"); //  setting up color of pane
		primaryStage.setScene(scene);
		primaryStage.setTitle("Login Window");
		primaryStage.setWidth(300); // setting width of the Login window
		primaryStage.setHeight(300); // setting height of the Login window 
		primaryStage.setAlwaysOnTop(false); // other application can be on top of it 
		primaryStage.setResizable(false);	// won't be able to resize it 
>>>>>>> first commit
		
		
		// Declare
		Label lblTitle, lblEmail, lblPassword, lblMessage;
<<<<<<< HEAD
		TextField txtEmail;
=======
		TextField txtEmail; 
>>>>>>> first commit
		PasswordField txtPassword;
		Button btnLogin, btnNew;
		
		 
		// Initialize and sets
<<<<<<< HEAD
		lblTitle = new Label("Login Window");
		lblTitle.setFont(new Font("Arial", 18)); // Set font
		lblTitle.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");
		
		lblEmail = new Label("Email");
		lblEmail.setFont(new Font("Arial", 14)); // Set font
		lblEmail.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold; ");
		
		lblPassword = new Label("Password");
		lblPassword.setFont(new Font("Arial", 14)); // Set font
		lblPassword.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold; ");
		lblMessage = new Label("Message");
		lblMessage.setFont(new Font("Arial", 12)); // Set font
		lblMessage.setStyle("-fx-text-fill: #b0b3b8; ");
		
		txtEmail = new TextField();
		txtEmail.setPrefWidth(180); // Set width
		txtEmail.setStyle("-fx-background-color: #424242; -fx-text-fill: #b0b3b8; -fx-font-weight: bold; -fx-background-radius: 11;");
		txtPassword = new PasswordField();
		txtPassword.setPrefWidth(180); // Set width
		txtPassword.setStyle("-fx-background-color: #424242; -fx-text-fill: #b0b3b8; -fx-background-radius: 11;");

		
		btnLogin = new Button("Login");
		btnLogin.setStyle("-fx-background-color: #424242; -fx-text-fill: #ffd300; -fx-font-weight: bold; -fx-background-radius: 11;");
		btnLogin.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent actionEvent) {
				String email = txtEmail.getText().trim(); 
=======
		lblTitle = new Label("Login Window"); // initializing and prompt for identifying 
		lblTitle.setFont(new Font("Arial", 18)); // Set font
		lblTitle.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;"); // color of the text // making font bold
		
		lblEmail = new Label("Email");
		lblEmail.setFont(new Font("Arial", 14)); // Set font
		lblEmail.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold; "); 
		
		lblPassword = new Label("Password");
		lblPassword.setFont(new Font("Arial", 14)); 
		lblPassword.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold; ");
		lblMessage = new Label("Message");
		lblMessage.setFont(new Font("Arial", 12)); 
		lblMessage.setStyle("-fx-text-fill: #b0b3b8; ");
		
		txtEmail = new TextField(); // text box for user to input data 
		txtEmail.setPrefWidth(180); // Set width of the text box
		txtEmail.setStyle("-fx-background-color: #424242; -fx-text-fill: #b0b3b8; -fx-font-weight: bold; -fx-background-radius: 11;"); // -fx-background-radius: 11 -> making the edges curved 
		
		txtPassword = new PasswordField(); // using PasswordField cause it hides the password while inserting (security reasons)
		txtPassword.setPrefWidth(180); // Set width of the text box
		txtPassword.setStyle("-fx-background-color: #424242; -fx-text-fill: #b0b3b8; -fx-background-radius: 11;");

		
		btnLogin = new Button("Login"); // initializing button and prompt for identifying the button
		btnLogin.setStyle("-fx-background-color: #424242; -fx-text-fill: #ffd300; -fx-font-weight: bold; -fx-background-radius: 11;"); 
		btnLogin.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent actionEvent) {
				String email = txtEmail.getText().trim(); // trim() -> trims the excess space 
>>>>>>> first commit
				String password = txtPassword.getText().trim();
				User user = new UserCRUD().authenticator(email, password);
				
				if (email.isEmpty() || password.isEmpty()) {  // Checking whether the user input is empty or not 
					lblMessage.setText("Please fill all the credentials!");
					return; // if empty this ensures that code below won't be executed
				}
				
<<<<<<< HEAD
				if (user != null && user.getEmail() != null && user.getPassword() != null && user.getEmail().equalsIgnoreCase(email) && user.getPassword().equalsIgnoreCase(password)) {
					
						primaryStage.close(); // Closing LoginWindow (under maintenance)
					
						// Opens main window: ProfileResultWindow
						ProfileResultWindow prWindow = new ProfileResultWindow();
						Stage prWindowStage = new Stage();
						try {
							prWindow.start(prWindowStage);
						} 
						catch(Exception ex) { 
							System.out.println("Login Error: " + ex.getMessage());
							ex.printStackTrace();
=======
				// condition for checking if there is data in the database 
				// not null specified so user has to enter identifiable credentials
				if (user != null && user.getEmail() != null && user.getPassword() != null && user.getEmail().equalsIgnoreCase(email) && user.getPassword().equalsIgnoreCase(password)) {
					// if condition true 
					
						primaryStage.close(); // Closing LoginWindow (under maintenance)
					
						// Opens main window ProfileResultWindow
						ProfileResultWindow prWindow = new ProfileResultWindow();
						Stage prWindowStage = new Stage(); // creating a new stage
						try {
							prWindow.start(prWindowStage); // starting ProfileResultWindow
						} 
						catch(Exception ex) { 
							System.out.println("Login Error: " + ex.getMessage()); // Error message prompt 
							ex.printStackTrace(); // gets detailed error 
>>>>>>> first commit
							
						}
					
					
				} else { 
					
<<<<<<< HEAD
					lblMessage.setText("Invalid email or password!");
=======
					lblMessage.setText("Invalid email or password!"); 
>>>>>>> first commit
				}
			}
		});
		
		
		btnNew = new Button("New User? Click Me!");
		btnNew.setStyle("-fx-background-color: #424242; -fx-text-fill: #bd83fc; -fx-font-weight: bold; -fx-background-radius: 11;");
		btnNew.setOnAction(new EventHandler<ActionEvent> () {
			@Override
			public void handle(ActionEvent arg0) {
				
				primaryStage.close(); // Closes LoginWindow
				
				
				// Opens SignInWindow
		        SignInWindow signIn = new SignInWindow();
<<<<<<< HEAD
		        Stage signInStage = new Stage();  // Creating a new Stage
		        try {
		            signIn.start(signInStage);  // Starting SignInWindow with a new Stage
		        } 
		        catch (Exception e) {
		            e.printStackTrace();
=======
		        Stage signInStage = new Stage();  // creating a new stage
		        try {
		            signIn.start(signInStage);  // starting SignInWindow with a new Stage
		        } 
		        catch (Exception ex) {
		            ex.printStackTrace();
>>>>>>> first commit
		            
		        }
				
	
			}
		});
		
		
		// Column, row
		lblTitle.relocate(90,20);
<<<<<<< HEAD
		pane.getChildren().add(lblTitle);
=======
		// adding lblTitle to pane's children which is scene which adds this to primaryStage for display 
		pane.getChildren().add(lblTitle); 
>>>>>>> first commit
		
		lblEmail.relocate(28, 80);
		pane.getChildren().add(lblEmail);
		
		txtEmail.relocate(100, 75);
		pane.getChildren().add(txtEmail);
		
		lblPassword.relocate(28, 125);
		pane.getChildren().add(lblPassword);
		
		txtPassword.relocate(100, 120);
		pane.getChildren().add(txtPassword);
		
		btnNew.relocate(45, 200);
		pane.getChildren().add(btnNew);
		
		btnLogin.relocate(215, 200);
		pane.getChildren().add(btnLogin);
		
		lblMessage.relocate(28, 240);
		pane.getChildren().add(lblMessage);
		
		
		
		primaryStage.show();
		

	}

	public static void main(String[] args) {
		launch(args);
	}


}
