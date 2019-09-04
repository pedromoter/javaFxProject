package application;
	
import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;


public class Main extends Application implements BinaryLoaderDelegate, BinarySaverDelegate {
	public Stage primaryStage;
	
	private binaryRepresentation data;
	
	private databaseConnector db;
	
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
	
		
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Load Local Information");
		alert.setHeaderText("I have found information available to load, would you like to do so?");
		alert.setContentText("Are you ok with this? If you say no we will just start over.");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			Platform.runLater((new binaryLoader(data, this)));
			
		} else {
		 
			this.data =  new binaryRepresentation(null, null, null, null);
			this.data.start();
			Platform.runLater(new binarySaver(this,data));
			initScreen();
		}
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void BinaryLoaderDelegateDidStart(String data) {
		System.out.println("Started");
		try {
			this.db = new databaseConnector();
			this.db.log("This is a log");
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void initScreen() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
			Parent root = loader.load();
			MainMenu ctlr = loader.<MainMenu>getController();
			ctlr.setData(data);
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void BinaryLoaderDelegateDidComplete(String result, binaryRepresentation data) {
		this.data = data;
		System.out.println("From delegeat " + this.data.toString());
		initScreen();
	}
	

	@Override
	public void BinaryLoaderDelegateDidError(Exception e) {
	        Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Error");
	        alert.setContentText(e.getMessage());
	        alert.showAndWait();
	}

	@Override
	public void BinarySaverDidStart(String d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void BinarySaverDidComplete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void BinarySaverDidError(Exception e) {
		// TODO Auto-generated method stub
		
	}


}
