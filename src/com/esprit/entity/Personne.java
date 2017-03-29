/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entity;

import java.util.Objects;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author wiemhjiri
 */
public class Personne {
    
    private SimpleIntegerProperty id;
    private SimpleStringProperty nom;
    private SimpleStringProperty prenom;
    private SimpleIntegerProperty prix;
    private SimpleIntegerProperty jourprix;
    private SimpleIntegerProperty numberchambre;
    private SimpleStringProperty path;
    

    public Personne() {
    }

    
    public Personne(int id, String nom, String prenom, Integer prix ,Integer jourprix, Integer numberchambre,String path) {
        this.id = new SimpleIntegerProperty(id);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.prix = new SimpleIntegerProperty(prix);
        this.jourprix = new SimpleIntegerProperty(jourprix);
        this.numberchambre = new SimpleIntegerProperty(numberchambre);
        this.path = new SimpleStringProperty(path);
    }

    public Personne(String nom, String prenom,Integer prix, Integer jourprix,Integer numberchambre,String path) {
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.prix = new SimpleIntegerProperty(prix);
        this.jourprix = new SimpleIntegerProperty(jourprix);
        this.numberchambre = new SimpleIntegerProperty(numberchambre);
        this.path = new SimpleStringProperty(path);
    }
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public String getNom() {
        return nom.get();
    }

    public void setNom(String nom) {
        this.nom = new SimpleStringProperty(nom);
    }
    
    
     public String getPath() {
        return path.get();
    }

    public void setPath(String path) {
        this.path = new SimpleStringProperty(path);
    }
    
    

      public String getPrenom() {
        return prenom.get();
    }
    public void setPrenom(String prenom) {
        this.prenom = new SimpleStringProperty(prenom);
    }
    
  
    
    
    
    public Integer getPrix() {
        return prix.get();
    }

    public void setPrix(Integer prix) {
        this.prix = new SimpleIntegerProperty(prix);
    }
    
     public Integer getJourprix() {
        return jourprix.get();
    }

    public void setJourprix(Integer jourprix) {
        this.jourprix = new SimpleIntegerProperty(jourprix);
    }
    
    
       public Integer getNumberchambre() {
        return numberchambre.get();
    }

    public void setNumberchambre(Integer numberchambre) {
        this.numberchambre = new SimpleIntegerProperty(numberchambre);
    }
    
    
    
     public SimpleIntegerProperty getPrixProperty(){
        return prix;
    }
     
     public SimpleIntegerProperty getJourprixProperty(){
        return jourprix;
    }
    public SimpleIntegerProperty getNumberchambreProperty(){
        return numberchambre;
    }
    
    
    
    public SimpleStringProperty getNomProperty(){
        return nom;
    }
    public SimpleStringProperty getPrenomProperty(){
        return prenom;
    }
    
   public SimpleStringProperty getPathProperty(){
        return path;
    }

    @Override
    public String toString() {
        return "Personne{" + "id=" + id.get() + ", nom=" + nom.get() + ", prenom=" + prenom.get() +", prix=" + prix.get() +", jourprix=" + jourprix.get() +", numberchambre=" + numberchambre.get() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Personne other = (Personne) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
