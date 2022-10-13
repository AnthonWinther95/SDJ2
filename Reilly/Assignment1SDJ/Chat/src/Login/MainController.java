package Login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController {
@FXML
private Label status;

@FXML 
private TextField Username;

@FXML
private TextField Password;

public void LoginUser (ActionEvent event) throws Exception {
	if (Username.getText().equals("user") && Password.getText().equals("pass")) {
		status.setText("Login Success");
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene scene = new Scene (root,400,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	else {
		status.setText("Login Failed");
	}
}

}
