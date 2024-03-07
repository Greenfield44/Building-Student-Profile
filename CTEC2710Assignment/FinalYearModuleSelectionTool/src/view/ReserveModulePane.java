package view;
import javax.management.modelmbean.ModelMBean;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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

public class ReserveModulePane extends VBox{
	
	private Label txtSb1;
	private ListView<model.Module> txtA1;
	private ObservableList<model.Module> txtB1 ;
	
	private Label txtSb2;
	private ListView<model.Module> txtA2;
	private ObservableList<model.Module> txtB2;
	
	private Label txtBtn;
	private Button addBtn;
	private Button rmvBtn;
	private Button cfmBtn;

	
	// Constructor 
	public ReserveModulePane() {
		//create Labels
		
		txtSb1 = new Label("Unselected Block 3/4 modules:");
		txtB1 = FXCollections.observableArrayList();
		txtA1 = new ListView<model.Module>(txtB1);
//		txtA1.setMinWidth(200);
//		txtA1.setMinHeight(210);
		
		txtSb2 = new Label("Reserved Block 3/4 modules:");
		txtB2 = FXCollections.observableArrayList();
		txtA2 = new ListView<model.Module>(txtB2);
//		txtA2.setMinWidth(200);
//		txtA2.setMinHeight(210);
		
		HBox btnAddRmvCfm = new HBox();
		btnAddRmvCfm.setPadding(new Insets(20, 0, 20, 0));
		txtBtn = new Label("Reserve one optional module");
		HBox.setMargin(txtBtn, new Insets(0, 15, 0, 0));
		addBtn= new Button("Add");
		addBtn.setPadding(new Insets(3, 20, 3, 20));
		HBox.setMargin(addBtn, new Insets(0, 15, 0, 0));
		rmvBtn = new Button("Remove");
		HBox.setMargin(rmvBtn, new Insets(0, 15, 0, 0));
		rmvBtn.setPadding(new Insets(3, 20, 3, 20));
		cfmBtn = new Button("Confirm");
		HBox.setMargin(cfmBtn, new Insets(0, 15, 0, 0));
		cfmBtn.setPadding(new Insets(3, 20, 3, 20));
		btnAddRmvCfm.getChildren().addAll(txtBtn, addBtn, rmvBtn, cfmBtn);
		

		//HBox and VBox
		VBox receptacle = new VBox();
		receptacle.getChildren().addAll(txtSb1, txtA1);
		receptacle.setPadding(new Insets(10, 20, 10, 20));
		
		VBox receptacle1 = new VBox();
		receptacle1.getChildren().addAll(txtSb2, txtA2);
		receptacle1.setPadding(new Insets(10, 20, 10, 20));
		
		HBox box1 = new HBox();
		box1.getChildren().addAll(receptacle, receptacle1);
		box1.setPadding(new Insets(10, 20, 10, 20));
		box1.setAlignment(Pos.CENTER);
		
		HBox box2 = new HBox();
		box2.getChildren().addAll(btnAddRmvCfm);
		box2.setAlignment(Pos.BASELINE_CENTER);
		
//		VBox box3 = new VBox();
//		box3.getChildren().addAll(box1, box2);
		
		this.getChildren().addAll(box1, box2);
	}
	
	// Methods
	
	public ObservableList<model.Module> getTxtB1(){
		return this.txtB1;
	}
		
	public ObservableList<model.Module> getTxtB2(){
		return this.txtB2;
	}
	public void addAdd1Handler (EventHandler<ActionEvent> handler) {
		addBtn.setOnAction(handler);
	}
	public void addRemove1Handler (EventHandler<ActionEvent> handler) {
		rmvBtn.setOnAction(handler);
}
	public void addConfirm1Handler (EventHandler<ActionEvent> handler) {
		cfmBtn.setOnAction(handler);
	}
	public model.Module getSelectedItem(){
		return this.txtA1.getSelectionModel().getSelectedItem();
		}
	public model.Module getSelectedItem1(){
		return this.txtA2.getSelectionModel().getSelectedItem();
		}
	public ListView<model.Module> getlist(){
		return txtA1;
	}
	public ListView<model.Module> getlist1(){
		return txtA2;
	}
	}





