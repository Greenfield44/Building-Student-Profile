package controller;

import java.util.Collection;

import javax.management.modelmbean.ModelMBeanInfoSupport;
import javax.swing.text.View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Block;
import model.Course;
import model.Module;
import model.StudentProfile;
import view.FinalYearOptionsRootPane;
import view.OverviewSelectionPane;
import view.ReserveModulePane;
import view.SelectModulePane;
import view.CreateStudentProfilePane;
import view.FinalYearOptionsMenuBar;

public class FinalYearOptionsController {

	//fields to be used throughout class
	private FinalYearOptionsRootPane view;
	private StudentProfile model;
	private model.Module models;
	private ReserveModulePane rmp;
	private CreateStudentProfilePane cspp;
	private FinalYearOptionsMenuBar mstmb;
	private model.Block modulles;
	private SelectModulePane smp;
	private OverviewSelectionPane osp;
	private Alert alert;
//	private StudentModule sm;

	public FinalYearOptionsController(FinalYearOptionsRootPane view, StudentProfile model) {
		//initialise view and model fields
		this.view = view;
		this.model = model;
		
		//initialise view subcontainer fields
		cspp = view.getCreateStudentProfilePane();
		mstmb = view.getModuleSelectionToolMenuBar();
		rmp = view.getReserveModulePane();
		smp = view.getSelectModulePane();
		osp = view.getOverviewSelectionPane();
	
		
		//add courses to combobox in create student profile pane using the buildModulesAndCourses helper method below
		cspp.addCourseDataToComboBox(buildModulesAndCourses());

		//attach event handlers to view using private helper method
		this.attachEventHandlers();
	}

	
	//helper method - used to attach event handlers
	private void attachEventHandlers() {
		//attach an event handler to the create student profile pane
		cspp.addCreateStudentProfileHandler(new CreateStudentProfileHandler());
		smp.addAddHandler(new AddHandler());
		smp.addRemoveHandler(new RemoveHandler());
		smp.addResetHandler(new ResetHandler());
		smp.addSubmitHandler(new SubmitHandler());
        rmp.addAdd1Handler(new Add1Handler());
        rmp.addRemove1Handler(new Remove1Handler());
        rmp.addConfirm1Handler(new Confirm1Handler());
        
		
		
		//attach an event handler to the menu bar that closes the application
		mstmb.addExitHandler(e -> System.exit(0));
		mstmb.addAboutHandler(e-> this.alertDialogue(AlertType.INFORMATION, "About", null, "This project demonstrates how to use Java for Object-Oriented Programming, how to construct the Model-View-Controller (MVC) architecture, and how to utilise JavaFX for the user interface."));
		
	}
	
	//event handler (currently empty), which can be used for creating a profile
	private class CreateStudentProfileHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			var views = view;
			var cspp = views.getCreateStudentProfilePane();
			var SelectedCourse = cspp.getSelectedCourse();
			var smp = views.getSelectModulePane();
			var modules = SelectedCourse.getAllModulesOnCourse();
			var txtB1 = smp.getListView();
			var txtB2 = smp.getListView1();
			var txtB3 = smp.getListView2();
			var txtB4 = smp.getListView3();
			var stdpN = cspp.getStudentPnumber();
			var stdName = cspp.getStudentName();
			var stdEmail = cspp.getStudentEmail();
			var stdDate = cspp.getStudentDate();
			txtB1.clear();
			txtB2.clear();
			txtB3.clear();
			txtB4.clear();
		
			modules.forEach((module)->{
				if(module.getRunPlan().equals(modulles.BLOCK_1)) 
				{
					txtB1.add(module);}
			});
			
			modules.forEach((module)->{
				if(module.getRunPlan().equals(modulles.BLOCK_2)) 
				{
					txtB2.add(module);}
			
			});
			
			modules.forEach((module)->{
				if(module.getRunPlan().equals(modulles.BLOCK_3_4)&& module.isMandatory()==false)
				{
					txtB3.add(module);
				}
			});
			modules.forEach((module)->{
				if(module.getRunPlan().equals(modulles.BLOCK_3_4)&& module.isMandatory()== true)
				{
					txtB4.add(module);
				}
			});		
			var studentPnumber = cspp.getStudentPnumber();
			var studentEmail = cspp.getStudentEmail();
			var studentDate = cspp.getStudentEmail();
			var studentFirstName = cspp.getStudentName();
			if(studentPnumber !="" && studentDate !="" && studentFirstName.getFirstName() !="" && studentFirstName.getFirstName() !="" && studentEmail !="" &&  SelectedCourse !=null) {
				
				 smp.refresh();
					view.changeTab(1);
}else {
			showErrorDialog("ERROR", "fill all text boxes!");
}	
		}
}
	private class RemoveHandler implements EventHandler<ActionEvent>{
		public void handle (ActionEvent e) {
			var views = view;
			var smp = view.getSelectModulePane();
			var listview2 = smp.getListView2();
			var listview3 = smp.getListView3();
			var selectedItems = smp.getSelectedItems3();
			var txtB4elements = smp.getListView3();
			var txtB3elements = smp.getListView2();
			if (selectedItems.isMandatory() == false) {
				
				txtB4elements.remove(selectedItems);
				txtB3elements.add(selectedItems);
				smp.refresh();
			}else {
				var alert = new Alert(Alert.AlertType.ERROR, "This module is Mandatory.");
		         alert.showAndWait();
		}
	}
	}
    //event handler (currently empty), which can be used for reseting a profile
	private class ResetHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			var views = view;
			var cspp = views.getCreateStudentProfilePane();
			var SelectedCourse = cspp.getSelectedCourse();
			var smp = views.getSelectModulePane();
			var modules = SelectedCourse.getAllModulesOnCourse();
			var txtB1 = smp.getListView();
			var txtB2 = smp.getListView1();
			var txtB3 = smp.getListView2();
			var txtB4 = smp.getListView3();
			txtB1.clear();
			txtB2.clear();
			txtB3.clear();
			txtB4.clear();
			
			modules.forEach((module)->{
				if(module.getRunPlan().equals(modulles.BLOCK_1)) 
				{
					txtB1.add(module);}
			});
			
			modules.forEach((module)->{
				if(module.getRunPlan().equals(modulles.BLOCK_2)) 
				{
					txtB2.add(module);}
			
			});
			
			modules.forEach((module)->{
				if(module.getRunPlan().equals(modulles.BLOCK_3_4)&& module.isMandatory()==false)
				{
					txtB3.add(module);
				}
			});
			modules.forEach((module)->{
				if(module.getRunPlan().equals(modulles.BLOCK_3_4)&& module.isMandatory()== true)
				{
					txtB4.add(module);
				}
			});		
			smp.refresh();
	}
	}
	//event handler (currently empty), which can be used to submit a profile
	private class SubmitHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			var views = view;
			Course c = cspp.getSelectedCourse();
			var module = c.getAllModulesOnCourse();
			var rmp = view.getReserveModulePane();
			var list = smp.getListView2();
			var listview = rmp.getTxtB1();
			var listview1 = rmp.getTxtB2();
			listview.clear();
			listview1.clear();
			
			list.forEach((element)->{
				if(listview1.size()!=1) {
					listview.add(element);
				}
			});
//			
			
		if(smp.creditscore() == 120) {
//			module.forEach((element)-> {
//			if (element.getRunPlan().equals(modulles.BLOCK_3_4)&& element.isMandatory()==false)
//			{
//				listview.add(element);
//			}
//			});
			view.changeTab(2);
			}else {
	         var alert = new Alert(Alert.AlertType.ERROR, "Credits must be 120.");
	         alert.showAndWait();
			}
		}
	}
	
	//event handler (currently empty), which can be used for adding profile
    private class AddHandler implements EventHandler<ActionEvent>{
    	public void handle (ActionEvent e) {
			var views = view;
			var smp = view.getSelectModulePane();
			var listview2 = smp.getListView2();
			var listview3 = smp.getListView3();
			var selectedItem = smp.getSelectedItems2();
			var txtB4 = smp.getListView3();
			var txtB3 = smp.getListView2();
			
			if (selectedItem != null) {
				
				listview2.remove(selectedItem);
				listview3.add(selectedItem);
			smp.refresh();
			} else {
				 var alert = new Alert(Alert.AlertType.ERROR, "Please Select a module.");
		         alert.showAndWait();
			}
    	}
    }
	//event handler which can be used to add unselected modules to ReserveModulePane
      private class Add1Handler implements EventHandler<ActionEvent>{
    	public void handle (ActionEvent e) {
			var views = view;
			var rmp = views.getReserveModulePane();
			var listView1 = rmp.getTxtB1();
			var listView2 = rmp.getTxtB2();
			var selectedItem = rmp.getSelectedItem();
		
					if (listView2.size()!=1) {
						listView2.add(selectedItem);
						listView1.remove(selectedItem);
						
					} else {
						var alert = new Alert(Alert.AlertType.ERROR, "Cannot add more than one");
						alert.showAndWait();
					}
    }	   
}
	//event handler which can be used to remove unselected modules to ReserveModulePane
	private class Remove1Handler implements EventHandler<ActionEvent>{
		public void handle (ActionEvent e) {
			var views = view;
			var rmp = view.getReserveModulePane();
			var listView1 = rmp.getTxtB1();
			var listView2 = rmp.getTxtB2();
			var selectedItem = rmp.getSelectedItem1();
			
    if (listView2.size()!= 3) {
    	listView2.remove(selectedItem);
		listView1.add(selectedItem);
	}else {
			var alert = new Alert (Alert.AlertType.ERROR, "please select item to be removed");
			alert.showAndWait();
			
		}
	}
	}
   //event handler which can be used to confirm unselected modules to ReserveModulePane
private class Confirm1Handler implements EventHandler<ActionEvent>{
	private String string1,string2,string3;
		public void handle(ActionEvent e) {
		var View = view;
		var model = models;
		var cspp = view.getCreateStudentProfilePane();
		var osp = view.getOverviewSelectionPane();
		var rmp =view.getReserveModulePane();
		var smp = view.getSelectModulePane();
		var txt0V1 = osp.getText1();
		var txt0V2 = osp.getText2();
		var txt0V3 = osp.getText3();
		var txtName = cspp.getStudentName ();
		var txtpnumber = cspp.getStudentPnumber();
		var txtEmail = cspp.getStudentEmail();
		var inputDate = cspp.getStudentDate();
		var course = cspp.getSelectedCourse();
		var TxtB2 = rmp.getTxtB2();
		
			
				var ListView = smp.getListView();
				
				var ListView1 = smp.getListView1();
		
				var ListView3 = smp.getListView3();
		
		  string1 = "Selected modules:\n=========\n";
		  string2 = "Reserved modules:\n=========\n";

			if(TxtB2.size()==1) {
				string3 = "Name: "+txtName.getFamilyName().toString()+txtName.getFirstName()+"\nPNo: "+txtpnumber+"\nEmail:"+txtEmail+"\nDate:"+inputDate.toString()+"\nCourse:"+course+"";
				
				string2 += TxtB2.get(0).toString();
				string1 += ListView.get(0) +"\n"+ListView1.get(0)+ "\n" + ListView3.get(0) + "\n" + ListView3.get(1); ; 
				view.changeTab(3); 
				}
			
			else {
				var alert = new Alert (Alert.AlertType.ERROR, "please select item to be reserved");
				alert.showAndWait();
			}
				
			txt0V1.setText(string3);
			txt0V2.setText(string1);
			txt0V3.setText(string2);
	    
		}
}

 private void alertDialogue(AlertType type, String Error, String header, String content) {
	Alert alert = new Alert(type);
	alert.setTitle(Error);
	alert.setHeaderText(header);
	alert.setContentText(content);
	alert.showAndWait();
}

	
	private Course[] buildModulesAndCourses() {
		Module ctec3701 = new Module("CTEC3701", "Software Development: Methods & Standards", 30, true, Block.BLOCK_1);

		Module ctec3702 = new Module("CTEC3702", "Big Data and Machine Learning", 30, true, Block.BLOCK_2);
		Module ctec3703 = new Module("CTEC3703", "Mobile App Development and Big Data", 30, true, Block.BLOCK_2);

		Module ctec3451 = new Module("CTEC3451", "Development Project", 30, true, Block.BLOCK_3_4);

		Module ctec3704 = new Module("CTEC3704", "Functional Programming", 30, false, Block.BLOCK_3_4);
		Module ctec3705 = new Module("CTEC3705", "Advanced Web Development", 30, false, Block.BLOCK_3_4);

		Module imat3711 = new Module("IMAT3711", "Privacy and Data Protection", 30, false, Block.BLOCK_3_4);
		Module imat3722 = new Module("IMAT3722", "Fuzzy Logic and Inference Systems", 30, false, Block.BLOCK_3_4);

		Module ctec3706 = new Module("CTEC3706", "Embedded Systems and IoT", 30, false, Block.BLOCK_3_4);


		Course compSci = new Course("Computer Science");
		compSci.addModule(ctec3701);
		compSci.addModule(ctec3702);
		compSci.addModule(ctec3451);
		compSci.addModule(ctec3704);
		compSci.addModule(ctec3705);
		compSci.addModule(imat3711);
		compSci.addModule(imat3722);

		Course softEng = new Course("Software Engineering");
		softEng.addModule(ctec3701);
		softEng.addModule(ctec3703);
		softEng.addModule(ctec3451);
		softEng.addModule(ctec3704);
		softEng.addModule(ctec3705);
		softEng.addModule(ctec3706);

		Course[] courses = new Course[2];
		courses[0] = compSci;
		courses[1] = softEng;

		return courses;
	}
	private void showErrorDialog(String title, String content) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(content);
		alert.showAndWait();
	}
	}





