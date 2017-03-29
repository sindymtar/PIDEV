/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.dao;


import com.esprit.entity.Personne;
import com.esprit.utils.ConnexionSingleton;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author wiemhjiri
 */
public class PersonneDao implements Idao<Personne>{
    
    private static PersonneDao instance;
    private Statement st;
    private ResultSet rs;
    
    private PersonneDao() {
        ConnexionSingleton cs=ConnexionSingleton.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static PersonneDao getInstance(){
        if(instance==null) 
            instance=new PersonneDao();
        return instance;
    }

    @Override
    public void insert(Personne o) {
       
        String req="insert into 'maison' values ('"+o.getNom()+"','"+o.getPrenom()+"','"+o.getPrix()+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   

    @Override
    public void delete(Personne o) {
        String req="delete from maison where id="+o.getId();
        Personne p=displayById(o.getId());
        
          if(p!=null)
              try {
           
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }else System.out.println("n'existe pas");
    }

    @Override
    public ObservableList<Personne> displayAll() {
        String req="select * from maison";
        ObservableList<Personne> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Personne p=new Personne();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString(3));
                p.setPrix(rs.getInt(4));
                p.setJourprix(rs.getInt(5));
                p.setNumberchambre(rs.getInt(6));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Personne> displayAllList() {
        String req="select * from maison";
        List<Personne> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Personne p=new Personne();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString(3));
                p.setPrix(rs.getInt(4));
                p.setJourprix(rs.getInt(5));
                p.setNumberchambre(rs.getInt(6));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    @Override
    public Personne displayById(int id) {
           String req="select * from maison where id ="+id;
           Personne p=new Personne();
        try {
            rs=st.executeQuery(req);
           // while(rs.next()){
            rs.next();
                p.setId(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("adresse"));
                p.setPrix(rs.getInt("prix"));
                p.setJourprix(rs.getInt("jourprix"));
                p.setNumberchambre(rs.getInt("numberchambre"));
            //}  
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p;
    }

    @Override
    public boolean update(Personne p) {
        String qry = "UPDATE maison SET nom = '"+p.getNom()+"', adresse = '"+p.getPrenom()+"', prix = '"+p.getPrix()+"' WHERE id = "+p.getId();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    
    
}
