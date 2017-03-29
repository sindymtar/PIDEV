/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controller;
import com.esprit.dao.PersonneDao;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import com.esprit.entity.Personne;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author wiemhjiri
 */
public class AfficherPersonneController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Personne> personsTable;
    @FXML
    private TableColumn<Personne, String> NomColonne;
    @FXML
    private TableColumn<Personne, String> PrenomColonne;
   @FXML
    private TableColumn<Personne, Integer>  PrixColonne;
    @FXML
    private TableColumn<Personne, Integer>  JourprixColonne;
     @FXML
    private TableColumn<Personne, Integer>  NumberchambreColonne;

    @FXML
    private Label idLabel;
    @FXML
    private Label nomLabel;
    @FXML
    private Label prenomLabel;
 
    @FXML
    private Label prixLabel;
    
    private ListData listdata = new ListData();

    @FXML
    private Button btn_pie;
    @FXML
    private Button btn_s;
    
    
    
    
  



    @FXML
    void handleDeletePerson() {
        Personne p = personsTable.getSelectionModel().getSelectedItem();
        PersonneDao pdao = PersonneDao.getInstance();
       System.out.println("clicked");
 
        pdao.delete(p);
        this.refreshtable();
    }
     public void refreshtable(){
        PersonneDao pdao = PersonneDao.getInstance();
        ObservableList<Personne> list=FXCollections.observableArrayList(pdao.displayAll()); 
//            tableApprenant.setItems(list);
             personsTable.setItems(list);
    }


    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        personsTable.setItems(listdata.getPersons());
        NomColonne.setCellValueFactory(cell -> cell.
                getValue().getNomProperty());
        PrenomColonne.setCellValueFactory(cell -> cell.
                getValue().getPrenomProperty());
       
        
        PrixColonne.setCellValueFactory(new PropertyValueFactory<>("Prix"));
        PrixColonne.cellFactoryProperty();
        
        JourprixColonne.setCellValueFactory(new PropertyValueFactory<>("Jourprix"));
        JourprixColonne.cellFactoryProperty();
        
        NumberchambreColonne.setCellValueFactory(new PropertyValueFactory<>("Numberchambre"));
        NumberchambreColonne.cellFactoryProperty();
        
        
        personsTable.setOnMouseClicked(event->{
            
             
            
            
        idLabel.setText(String.valueOf(listdata.getPersons()
                .get(personsTable.getSelectionModel().getSelectedIndex())
                .getId()));
        nomLabel.setText(listdata.getPersons()
                .get(personsTable.getSelectionModel().getSelectedIndex())
                .getNom());
        prenomLabel.setText(listdata.getPersons()
                .get(personsTable.getSelectionModel().getSelectedIndex())
                .getPrenom());
        
        prixLabel.setText(String.valueOf(listdata.getPersons()
                .get(personsTable.getSelectionModel().getSelectedIndex())
                .getPrix()));
        
    
    });
        
        
        
  
        
        
        
        
        
        //Redirection vers l'interface PieChart
        btn_pie.setOnAction(event->{
            try {
                System.out.println("testttttttttttttt");
                Parent pagePieChart=FXMLLoader.load(getClass().getResource("/com/esprit/view/PieChartView.fxml"));
                Scene scene=new Scene(pagePieChart);
                Stage stage=(Stage) ((Node) event.getSource())
                        .getScene()
                        .getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AfficherPersonneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

}
