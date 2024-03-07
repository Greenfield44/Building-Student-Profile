package view;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class OverviewSelectionPane extends VBox {

	private TextArea txf1;
	
	private TextArea txf2;
	
	private TextArea txf3;
	
	private Button saveoverviewBtn;
	
	public OverviewSelectionPane() {
		//create TextField
		txf1 = new TextArea("Profile will appear here");
		txf1.setPrefSize(970, 80);
		txf2 = new TextArea("Selected modules willappear here");
//		txf2.setMinWidth(50);
//		txf2.setMinHeight(150);
		
		txf3 = new TextArea("Reserved modules will appear here");
//		txf3.setMinWidth(50);
//		txf3.setMinHeight(150);
		
		HBox btnsaveoverview = new HBox();
		saveoverviewBtn = new Button("Save Overview");
		HBox.setMargin(saveoverviewBtn, new Insets(3, 3, 3, 3));
		saveoverviewBtn.setPadding(new Insets(3, 3, 3, 3));
		btnsaveoverview.getChildren().addAll(saveoverviewBtn);
		btnsaveoverview.setAlignment(Pos.BOTTOM_CENTER);
		
		//HBox and VBox
		VBox receptacle1 = new VBox();
		receptacle1.getChildren().addAll(txf1);
		
		
		VBox receptacle2 = new VBox();
		receptacle2.getChildren().addAll(txf2);
		receptacle2.setAlignment(Pos.CENTER);
		
		VBox receptacle3 = new VBox();
		receptacle3.getChildren().addAll(txf3);
		receptacle3.setAlignment(Pos.CENTER);
		
		HBox box1 = new HBox();
		box1.getChildren().addAll(receptacle1);
		box1.setPadding(new Insets(10, 20, 10, 20));
		box1.setAlignment(Pos.CENTER);
		
		HBox box2 = new HBox();
		box2.getChildren().addAll(receptacle2, receptacle3);
		box2.setPadding(new Insets(10, 20, 10, 20));
		box2.setAlignment(Pos.CENTER);
		box2.setSpacing(10);
		
		this.getChildren().addAll(box1, box2, btnsaveoverview);
	}

//methods
public TextArea getText1(){
	return this. txf1;
}
public TextArea getText2() {
	return this.txf2;
}
public TextArea getText3() {
	return this.txf3;
}
}
