package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Departamento;
import model.services.DepartamentoServices;

public class DepartamentoListController implements Initializable {
	private DepartamentoServices service;
	
	@FXML
	private TableView<Departamento> tabelViewDepart;
	
	@FXML
	private TableColumn<Departamento, Integer> tableColumnID;
	 @FXML
	 private TableColumn<Departamento, String> tableColumnName;
	 @FXML
	 private Button btNew;
	 
	 
	 private ObservableList<Departamento> obsList;
	 @FXML
	 public void onBtNewAction() {
		 System.out.println("clicou no bt new");
	 }
	 
	 public void setDepartamentoServices(DepartamentoServices service) {
		 this.service = service;
	 }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initializeNodes();
		
	}

	private void initializeNodes() {
		tableColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		Stage stage = (Stage) Main.getScene().getWindow();
		tabelViewDepart.prefHeightProperty().bind(stage.heightProperty());
	}
	
	public void updateTableView() {
		if(service == null)
			throw new IllegalStateException("Service was null");
		List<Departamento> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tabelViewDepart.setItems(obsList);
		
	}
}
