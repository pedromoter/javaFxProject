package application;

import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javafx.animation.RotateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainMenu {
	@FXML
	private Button button;
	
	@FXML
	private ImageView image1;
	
	@FXML
	private ImageView image2;


	
	@FXML
	private Button button1;
	@FXML
	private Button button11;
	
	@FXML
	private Button button111;
	
	@FXML
	private Button janitor;
	@FXML
	private Button teacher;
	@FXML
	private Button student;
	
	@FXML
	private ListView<Person> list;
	
	private binaryRepresentation data;

public void initialize() {
	
	Image img1 = new Image("application/me.JPG");
	Image img2 = new Image("application/valencia.jpeg");

	image1.setImage(img2);
	
	image2.setImage(img1);


    RotateTransition rotateTransition = new RotateTransition(); 
     rotateTransition.setDuration(Duration.millis(1000)); 
    
    RotateTransition rt = new RotateTransition(Duration.millis(1000));
    rt.setNode(image1);
    rt.setByAngle(360);
    rt.setCycleCount(-1); 
    rt.play();
    
    button.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        	try {
        	FXMLLoader fxml = new FXMLLoader(getClass().getResource("CreateNewPerson.fxml"));
        	Parent root = fxml.load();
        	CreateNewPersonController ctlr = fxml.<CreateNewPersonController>getController();
        ctlr.setData(data);
        
 
    		Scene scene = new Scene(root,400,400);
    		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		Stage primaryStage = new Stage();
    		primaryStage.setScene(scene);
    		primaryStage.show();
    		
    	       ctlr.setWindowDelegate(new WindowDelegate() {
    				@Override
    				public void close() {
    					primaryStage.close();
    					update();
    				}
    	        });
    		
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        	
        }
    });
	
    button1.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        	try {
        	FXMLLoader fxml = new FXMLLoader(getClass().getResource("CreateNewStudent.fxml"));
        	Parent root = fxml.load();
        	CreateNewStudentController ctlr = fxml.<CreateNewStudentController>getController();
        ctlr.setData(data);
    		Scene scene = new Scene(root,400,400);
    		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		Stage primaryStage = new Stage();
    		primaryStage.setScene(scene);
    		primaryStage.show();
    		   ctlr.setWindowDelegate(new WindowDelegate() {
   				@Override
   				public void close() {
   					primaryStage.close();
   					update();
   				}
   	        });
   		
    		
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        	
        }
    });
    
    button11.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        	try {
        	FXMLLoader fxml = new FXMLLoader(getClass().getResource("CreateNewTeacher.fxml"));
        	Parent root = fxml.load();
        	CreateNewTeacherController ctlr = fxml.<CreateNewTeacherController>getController();
        ctlr.setData(data);
    		Scene scene = new Scene(root,400,400);
    		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		Stage primaryStage = new Stage();
    		primaryStage.setScene(scene);
    		primaryStage.show();
    		
    		   ctlr.setWindowDelegate(new WindowDelegate() {
   				@Override
   				public void close() {
   					primaryStage.close();
   					update();
   				}
   	        });
   		
    		
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        	
        }
    });
    
    button111.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        	try {
        	FXMLLoader fxml = new FXMLLoader(getClass().getResource("CreateNewJanitor.fxml"));
        	Parent root = fxml.load();
        	CreateNewJanitorController ctlr = fxml.<CreateNewJanitorController>getController();
        ctlr.setData(data);
    		Scene scene = new Scene(root,400,400);
    		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		Stage primaryStage = new Stage();
    		primaryStage.setScene(scene);
    		primaryStage.show();
    		
    		   ctlr.setWindowDelegate(new WindowDelegate() {
   				@Override
   				public void close() {
   					primaryStage.close();
   					update();
   				}
   	        });
   		
    		   
    		
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        	
        }
    });
    
    
    janitor.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        	try {
        		JanitorToTXT();
        	}catch(Exception e) {
        		e.printStackTrace();
        		Alert alert = new Alert(AlertType.ERROR);
     	        alert.setTitle("Error");
     	        alert.setContentText(e.getMessage());
     	        alert.showAndWait();      
        	}
        	
        }
    });
    
    student.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        	try {
        		StudentToTXT();
        	}catch(Exception e) {
        		e.printStackTrace();
        		Alert alert = new Alert(AlertType.ERROR);
     	        alert.setTitle("Error");
     	        alert.setContentText(e.getMessage());
     	        alert.showAndWait();      
        	}
        	
        }
    });
    
    teacher.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        	try {
        		TeacherToTXT();
        	}catch(Exception e) {
        		e.printStackTrace();
        		Alert alert = new Alert(AlertType.ERROR);
     	        alert.setTitle("Error");
     	        alert.setContentText(e.getMessage());
     	        alert.showAndWait();      
        	}
        	
        }
    });
}

public void update() {
	System.out.println("Update");

		ObservableList<Person> d = FXCollections.observableArrayList(); 
		ArrayList<Person> all  = this.data.getAll();
		d.addAll(all);
		list.setItems(d);
		
		  list.getSelectionModel().selectedItemProperty().addListener(
			        (ChangeListener<? super Person>) (ObservableValue<? extends Person> ov, Person old_val, 
			            Person p) -> {
			                
			            	 Alert alert = new Alert(AlertType.INFORMATION);
			     	        alert.setTitle(p.toString());
			     	        alert.setContentText(p.longDescription());
			     	        alert.showAndWait();      
			    });
}

public void setData(binaryRepresentation data) {
	this.data = data;
	System.out.println("Set data"+data);
    update();
}


public void TeacherToTXT() throws FileNotFoundException {
	try (PrintWriter out = new PrintWriter("teachers.txt")) {
	    for(Teacher t : this.data.Teachers) {
	    	out.println(t.longDescription());
	    }
	}
}

public void StudentToTXT() throws FileNotFoundException {
	try (PrintWriter out = new PrintWriter("students.txt")) {
	    for(Student t : this.data.Student) {
	    	out.println(t.longDescription());
	    }
	}
}

public void JanitorToTXT() throws FileNotFoundException {
	try (PrintWriter out = new PrintWriter("janitor.txt")) {
	    for(Janitor t : this.data.Janitor) {
	    	out.println(t.longDescription());
	    }
	}
}



}
