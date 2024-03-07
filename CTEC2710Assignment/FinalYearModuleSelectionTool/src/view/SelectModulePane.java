package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Course;
import model.Module;
import model.Name;


public class SelectModulePane extends VBox {
	

private Label txtSb1;
private ListView<model.Module> txtA1;
private ObservableList<model.Module> txtB1;

private Label txtSb2;
private ListView<model.Module> txtA2;
private ObservableList<model.Module> txtB2;

private Label txtSb3;
private ListView<model.Module> txtA3;
private ObservableList<model.Module> txtB3;

private Label txtSb4;
private ListView<model.Module> txtA4;
private ObservableList<model.Module> txtB4;

private Label txtSb5;

private Label txtBtn;
private Button addBtn;
private Button rmvBtn;
private Button resetBtn;
private Button submitBtn;
private int creditscore;
private TextField txt;
private Label crrentcredit;
public SelectModulePane() {
	
	//create Labels
	
	txtSb1 = new Label("Selected Block 1 modules:");
	txtB1 = FXCollections.observableArrayList();
	txtA1 = new ListView<model.Module>(txtB1);
//	txtA1.setMinWidth(400);
//	txtA1.setMinHeight(150);
	txtA1.setPrefSize(300, 150);
	txtA1.setMinSize(200,150);
	
	txtSb2 = new Label("Selected Block 2 modules:");
	txtB2 = FXCollections.observableArrayList();
	txtA2 = new ListView<model.Module>(txtB2);
//	txtA2.setMinWidth(400);
//	txtA2.setMinHeight(150);
	txtA2.setPrefSize(300, 150);
	txtA2.setMinSize(200,150);
	HBox.setMargin(txtSb2,  new Insets(20, 0, 0, 0));
	HBox box12 = new HBox();
	box12.getChildren().addAll(txtSb1, txtA1, txtSb2, txtA2);
	
	txtSb3 = new Label("Unselected Block 3/4 modules:");
	txtB3 = FXCollections.observableArrayList();
	txtA3 = new ListView<model.Module>(txtB3);
	txtA3.getSelectionModel().select(1);
//	txtA3.setMinWidth(400);
//	txtA3.setMinHeight(100);
	txtA3.setPrefSize(200, 100);
//	txtA3.setMinWidth(200);
	
	HBox btnAddRmv = new HBox();
	btnAddRmv.setPadding(new Insets(20, 0, 20, 0));
	txtBtn = new Label("Block 3/4");
	HBox.setMargin(txtBtn, new Insets(0, 20, 0, 0));
	addBtn = new Button("Add");
	HBox.setMargin(addBtn, new Insets(0, 15, 0, 0));
	addBtn.setPadding(new Insets(3, 20, 3, 20));
	rmvBtn = new Button("Remove");
	rmvBtn.setPadding(new Insets(3, 20, 3, 20));
	btnAddRmv.getChildren().addAll(txtBtn, addBtn, rmvBtn);
	btnAddRmv.setAlignment(Pos.BOTTOM_CENTER);
	HBox btnResetSubmit = new HBox();
	btnResetSubmit.setPadding(new Insets(20, 0, 20, 0));
	resetBtn = new Button("Reset");
	resetBtn.setPadding(new Insets(3, 20, 3, 20));
	submitBtn = new Button("Submit");
	submitBtn.setPadding(new Insets(3, 20, 3, 20));
	
	txtSb4 = new Label("Selected Block 3/4 modules:");
	txtB4 = FXCollections.observableArrayList();
	txtA4 = new ListView<model.Module>(txtB4);
	txtA4.setPrefSize(400, 150);
	txtA4.setMinWidth(250);
	
	
	
	//creditscore
	creditscore = 0;
	txt = new TextField("" +creditscore);
	txt.setPrefSize(50, 10);
	txtSb5 = new Label("Current credits:");
	
	//HBox and VBox
	VBox receptacle = new VBox();
	receptacle.getChildren().addAll(txtSb1, txtA1, txtSb2, txtA2);
	receptacle.autosize();
	
	VBox receptacle1 = new VBox();
	receptacle1.getChildren().addAll(txtSb3, txtA3, btnAddRmv, txtSb4, txtA4);
	receptacle1.autosize();
		
	VBox drum = new VBox();
	drum.getChildren().add(txtSb5);
	drum.autosize();
	
	VBox drum2 = new VBox();
	drum2.getChildren().addAll(txt);
	drum2.autosize();
	
	VBox container = new VBox();
	container.getChildren().addAll(resetBtn);
	container.setPadding(new Insets(10, 20, 10, 20));
	container.autosize();
	
	VBox container2 = new VBox();
	container2.getChildren().addAll(submitBtn);
	container2.setPadding(new Insets(10, 10, 10, 10));
	container2.autosize();
	
	HBox box4 = new HBox(10);
	box4.getChildren().addAll(receptacle, receptacle1);
	box4.setAlignment(Pos.CENTER);
	
	HBox box6 = new HBox();
	box6.getChildren().addAll(drum, drum2);
	box6.setAlignment(Pos.BOTTOM_CENTER);
	box6.autosize();
	
	HBox box7 = new HBox();
	box7.getChildren().addAll(container, container2);
	box7.setAlignment(Pos.BOTTOM_CENTER);
	box7.autosize();
	
	this.setAlignment(Pos.CENTER);
	this.autosize();
	this.getChildren().addAll(box4, box6, box7);
	this.setPadding(new Insets(10, 10, 10, 10));
}
   

//method
public ObservableList<model.Module> getListView(){
	return this.txtB1;
}
public ObservableList<model.Module> getListView1(){
	return this.txtB2;	
}
public ObservableList<model.Module> getListView2(){
	return this.txtB3;
}
public ObservableList<model.Module> getListView3(){
	return this.txtB4;
}
	//method for event handler

public void addAddHandler(EventHandler<ActionEvent> handler) {
	addBtn.setOnAction(handler);
}

public void addResetHandler(EventHandler<ActionEvent> handler) {
	resetBtn.setOnAction(handler);
}

public void addRemoveHandler(EventHandler<ActionEvent> handler) {
	rmvBtn.setOnAction(handler);
}

public void addSubmitHandler(EventHandler<ActionEvent> handler) {
	submitBtn.setOnAction(handler);
}
public Module getSelectedItems() {
	return this.txtA1.getSelectionModel().getSelectedItem();
	}

public Module getSelectedItems1() {
	return this.txtA2.getSelectionModel().getSelectedItem();
	}

public Module getSelectedItems2() {
	return this.txtA3.getSelectionModel().getSelectedItem();
	}

public Module getSelectedItems3() {
	return this.txtA4.getSelectionModel().getSelectedItem();
	}

public ListView<model.Module> getlist() {
	return txtA3;
}

public ListView<model.Module> getlist1() {
	return txtA4;
}
public int creditscore() {
	return creditscore;
}
public void refresh() {
	creditscore = 0;
	txtB1.forEach((e)->{
		creditscore += e.getModuleCredits();
	});
	txtB2.forEach((e)->{
		creditscore += e.getModuleCredits();
	});
	txtB4.forEach((e)->{
		creditscore += e.getModuleCredits();
	});
	this.txt.setText(""+creditscore);
}
//private void showErrorDialog(String title, String content) {
//	Alert alert = new Alert(Alert.AlertType.ERROR);
//	alert.setTitle("Error");
//	alert.setHeaderText(null);
//	alert.setContentText(content);
//	alert.showAndWait();

}




	
	


