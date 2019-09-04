package application;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class CreateNewJanitorController implements BinarySaverDelegate {
	private binaryRepresentation data;
	
	private WindowDelegate windowDelegate;

	public void setWindowDelegate(WindowDelegate del) {
		this.windowDelegate = del;
	}
	
	
	@FXML
	private AnchorPane pane;
	
	@FXML
	private TextField fname;
	
	@FXML
	private TextField mi;
	
	@FXML
	private TextField last;
	
	@FXML
	private TextField number;
	
	@FXML
	private TextField street;
	
	@FXML
	private TextField stype;
	
	@FXML
	private TextField city;
	
	@FXML
	private TextField zip;
	
	@FXML
	private ChoiceBox state;
	
	@FXML
	private TextField month;
	
	@FXML
	private TextField day;
	
	@FXML
	private TextField year;
	
	@FXML
	private TextField pay;
	
	@FXML
	private CheckBox smoker;
	
	@FXML
	private Button save;
	
	@FXML
	private Button cancel;
	
	
	@FXML
	private RadioButton rbM;
	@FXML
	private RadioButton rbF;
	@FXML
	private RadioButton rbU;
	@FXML
	private RadioButton rbO;
	
	private ToggleGroup sex = new ToggleGroup();
	
	public void initialize() {
	    rbM.setToggleGroup(sex);
	    rbF.setToggleGroup(sex);
	    rbU.setToggleGroup(sex);
	    rbO.setToggleGroup(sex);
	    rbF.setSelected(true);
		
	    States states = new States();
	    
	    
	    	    ObservableList<String> list = FXCollections.observableArrayList(states.getFullNameList());
	    
	   state.setItems(list);
	    state.setValue(list.get(0));
	    
	    save.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	        	save();
	        	};
	        });
	    
	    cancel.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	        	windowDelegate.close();
	        	};
	        });
	}
	
	public void save() {
		States states = new States();
		//create new person
		if(mi.getText().isEmpty()) {
			mi.setText(" ");
		}
		
		
		try {
		RadioButton sexrd = (RadioButton)(sex.getSelectedToggle());
		Janitor person = new Janitor(
				new Name(fname.getText() , mi.getText().charAt(0) ,last.getText()),
				new Adress(Integer.parseInt(number.getText()), street.getText(), stype.getText(), city.getText(), states.getShort((String)state.getValue()), Integer.parseInt(zip.getText())),
				new DOB(Integer.parseInt(month.getText()),Integer.parseInt(day.getText()),Integer.parseInt(year.getText())),
				smoker.isSelected(),
				sexrd.getText().charAt(0),
				Double.parseDouble(pay.getText())
				);
		System.out.println(person);
		

		person.Validate();
		
		this.data.Janitor.add(person);
		Platform.runLater(new binarySaver(this, data));
		
		}catch(Exception e) {
			pane.setDisable(false);
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Error!");
	        alert.setContentText(e.getMessage());
	        alert.showAndWait();
		}

	}
	
	public void setData(binaryRepresentation data) {
		this.data = data;
		System.out.println(data);
	}

	@Override
	public void BinarySaverDidStart(String d) {
		pane.setDisable(true);
		
		
	}

	@Override
	public void BinarySaverDidComplete() {
		pane.setDisable(false);

		   Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Saved");
	        alert.setContentText("The new person has been added sucessfully!");
	        alert.showAndWait();
	        windowDelegate.close();

	}

	@Override
	public void BinarySaverDidError(Exception e) {
		//pane.setDisable(false);
		   Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Error!");
	        alert.setContentText(e.getMessage());
	        alert.showAndWait();
	        windowDelegate.close();
	}

	
}
	


