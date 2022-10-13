package chatserver;

import Model.Model;
import Model.ModelManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChatServer extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Chat Server");
        stage.setOnCloseRequest(event->System.exit(0));
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }

	public void connect() {
		// TODO Auto-generated method stub
		
	}

	public String convert(String source) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
