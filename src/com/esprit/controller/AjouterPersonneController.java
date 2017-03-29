/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controller;

import com.esprit.dao.PersonneDao;
import com.esprit.entity.Personne;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author wiemhjiri
 */
public class AjouterPersonneController implements Initializable {

   
static File path =new File("");
    @FXML
    private Button btn;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;

    @FXML
    private TextField prix;
    
    @FXML
    private ImageView imageView;
    
    
    
    @FXML
   public void choisirPhoto(ActionEvent event) {
        
 FileChooser fc = new FileChooser();
        File sf = fc.showOpenDialog(null);
        System.out.println("bbbbb");
        if (sf != null) {
            System.out.println("aaaaa");
            fc.setTitle("Ajouter");
            fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Images", "*.jpg", "*.png", "*.jpeg"));
            if (sf != null) {
                AjouterPersonneController.path = sf.getAbsoluteFile();
                Image i = new Image(sf.toURI().toString());
                imageView.setImage(i);
                System.out.println("aaaaa");
            }
        }
    }
     
    @FXML
    void add(ActionEvent event) throws IOException{
     
       Personne p = new Personne();
            PersonneDao pdao = PersonneDao.getInstance();
            pdao.insert(p);       
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Personne insérée avec succés!");
        alert.show();
        nom.setText("");
        prenom.setText("");
        prix.setText("");
    
        p.setPath(AjouterPersonneController.path.getAbsolutePath());
           pdao.insert(p);
            }
   
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image img = null;
        img = new Image(path.toURI().toString());
        imageView.setImage(img);
            
            
        
        
        
    }

}
