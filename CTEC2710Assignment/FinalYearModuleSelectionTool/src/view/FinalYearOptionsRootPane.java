package view;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;


public class FinalYearOptionsRootPane extends BorderPane {

	private CreateStudentProfilePane cspp;
	private FinalYearOptionsMenuBar mstmb;
	private SelectModulePane selectMod;
	private ReserveModulePane reserveMod;
	private OverviewSelectionPane osp;
	private TabPane tp;
	
	public FinalYearOptionsRootPane() {
		//create tab pane and disable tabs from being closed
		tp = new TabPane();
		tp.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		//create panes
		cspp = new CreateStudentProfilePane();
		selectMod = new SelectModulePane();
	    reserveMod = new ReserveModulePane();
	    osp = new OverviewSelectionPane();
		
		
		//create tabs with panes added
		Tab t1 = new Tab("Create Profile", cspp);
		Tab t2 = new Tab("Select Modules",selectMod);
		Tab t3 = new Tab("Reserve Modules", reserveMod);
		Tab t4 = new Tab("Overview Selection", osp);
		
		
		//add tabs to tab pane
		tp.getTabs().addAll(t1, t2, t3, t4);
		
		//create menu bar
		mstmb = new FinalYearOptionsMenuBar();
		
		//add menu bar and tab pane to this root pane
		this.setTop(mstmb);
		this.setCenter(tp);
		
	}

	//methods allowing sub-containers to be accessed by the controller.
	public CreateStudentProfilePane getCreateStudentProfilePane() {
		return cspp;
	}
	
	public FinalYearOptionsMenuBar getModuleSelectionToolMenuBar() {
		return mstmb;
	}
	
	public ReserveModulePane getReserveModulePane() {
		return this.reserveMod;
	}
	
	public SelectModulePane getSelectModulePane() {
		return this.selectMod;
	}
	public OverviewSelectionPane getOverviewSelectionPane() {
        return this.osp;
	}

	
	
	//method to allow the controller to change tabs
	public void changeTab(int index) {
		tp.getSelectionModel().select(index);
	}
}
