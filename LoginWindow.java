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

public class LoginWindow extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Scene scene = new Scene(pane);
        
        pane.setStyle("-fx-background-color: #212121;");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Window");
        primaryStage.setWidth(300);
        primaryStage.setHeight(300);
        primaryStage.setAlwaysOnTop(false);
        primaryStage.setResizable(false);

        // declare
        Label lblTitle, lblEmail, lblPassword, lblMessage;
        TextField txtEmail;
        PasswordField txtPassword;
        Button btnLogin, btnNew;
        
        // initialize and sets
        lblTitle = new Label("Login Window");
        lblTitle.setFont(new Font("Arial", 18)); // set font
        lblTitle.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold;");
        
        lblEmail = new Label("Email");
        lblEmail.setFont(new Font("Arial", 14)); // set font
        lblEmail.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold; ");
        
        lblPassword = new Label("Password");
        lblPassword.setFont(new Font("Arial", 14)); // set font
        lblPassword.setStyle("-fx-text-fill: #b0b3b8; -fx-font-weight: bold; ");
        
        lblMessage = new Label("Message");
        lblMessage.setFont(new Font("Arial", 12)); // set font
        lblMessage.setStyle("-fx-text-fill: #b0b3b8; ");
        
        txtEmail = new TextField(); // text box for user to input data 
        txtEmail.setPrefWidth(180); // set width of the text box
        txtEmail.setStyle("-fx-background-color: #424242; -fx-text-fill: #b0b3b8; -fx-font-weight: bold; -fx-background-radius: 11;");
        
        txtPassword = new PasswordField(); // using passwordfield cause it hides the password while inserting (security reasons)
        txtPassword.setPrefWidth(180); // set width of the text box
        txtPassword.setStyle("-fx-background-color: #424242; -fx-text-fill: #b0b3b8; -fx-background-radius: 11;");

        btnLogin = new Button("Login"); // initializing button and prompt for identifying the button
        btnLogin.setStyle("-fx-background-color: #424242; -fx-text-fill: #ffd300; -fx-font-weight: bold; -fx-background-radius: 11;");
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent actionEvent) {
                String email = txtEmail.getText().trim(); // trim() -> trims the excess space 
                String password = txtPassword.getText().trim();
                User user = new UserCRUD().authenticator(email, password);
                
                if (email.isEmpty() || password.isEmpty()) {  // checking whether the user input is empty or not 
                    lblMessage.setText("Please fill all the credentials!");
                    return; // if empty this ensures that code below won't be executed
                }
                
                if (user != null && user.getEmail() != null && user.getPassword() != null && 
                    user.getEmail().equalsIgnoreCase(email) && user.getPassword().equalsIgnoreCase(password)) {
                    // if condition true 
                    primaryStage.close(); // closing loginwindow (under maintenance)
                    
                    // opens main window profileresultwindow
                    ProfileResultWindow prWindow = new ProfileResultWindow();
                    Stage prWindowStage = new Stage(); // creating a new stage
                    try {
                        prWindow.start(prWindowStage); // starting profileresultwindow
                    } 
                    catch(Exception ex) { 
                        System.out.println("Login Error: " + ex.getMessage()); // error message prompt 
                        ex.printStackTrace();
                    }
                } else { 
                    lblMessage.setText("Invalid email or password!"); 
                }
            }
        });
        
        btnNew = new Button("New User? Click Me!");
        btnNew.setStyle("-fx-background-color: #424242; -fx-text-fill: #bd83fc; -fx-font-weight: bold; -fx-background-radius: 11;");
        btnNew.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent arg0) {
                primaryStage.close(); // closes loginwindow
                
                // opens signinwindow
                SignInWindow signIn = new SignInWindow();
                Stage signInStage = new Stage();  // creating a new stage
                try {
                    signIn.start(signInStage);  // starting signinwindow with a new stage
                } 
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        // column, row
        lblTitle.relocate(90,20);
        pane.getChildren().add(lblTitle); // adding lbltitle to pane's children which is scene which adds this to primarystage for display 
        
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