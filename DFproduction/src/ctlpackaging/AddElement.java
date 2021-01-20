/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctlpackaging;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Akwellan
 */


public class AddElement {
    Connecter conn=new Connecter();
    Statement stm;
    ResultSet Rs;
    public AddElement(){
        
        
        
    }
    
    
    
    public void setElementCombo(String Lieu_archivage, String Type_de_Materiel, String Constructeur, String Materiel, String Annee) {
        try {
            //INSERT INTO `prod_critere` (`id`, `Lieu_archivage`, `Type_de_Materiel`, `Constructeur`, `Materiel`, `Annee`) VALUES (NULL, NULL, NULL, NULL, NULL, NULL)
            String requete="INSERT INTO `prod_critere` (`id`, `Lieu_archivage`, `Type_de_Materiel`, `Constructeur`, `Materiel`, `Annee`) VALUES ("+Lieu_archivage+", "+Type_de_Materiel+", "+Constructeur+", "+Materiel+", "+Annee+", "+Lieu_archivage+")";
            stm.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(AddElement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void setElementAtelierSousEnsemble(String Ateliers, String GFH_Ligne, String Machines, String Sous_ensemble) {
        
        //------------------------------------------prod_atelier_gfh_ligne-----------------------------------------
        if(!"".equals(Ateliers) && !"".equals(GFH_Ligne)){
        try {
            //INSERT INTO `prod_critere` (`id`, `Lieu_archivage`, `Type_de_Materiel`, `Constructeur`, `Materiel`, `Annee`) VALUES (NULL, NULL, NULL, NULL, NULL, NULL)
            String requete="INSERT INTO `prod_atelier_gfh_ligne` (`id`, `Ateliers`, `GFH_Ligne`) VALUES (NULL, '"+Ateliers+"', '"+GFH_Ligne+"'))";
            stm.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(AddElement.class.getName()).log(Level.SEVERE, null, ex);
        }}
        //------------------------------------------prod_atelier_gfh_ligne-----------------------------------------
        
        
        //------------------------------------------prod_gfh_ligne_machines----------------------------------------- 
        if(!"".equals(GFH_Ligne) && !"".equals(Machines)){
        try {
            String requete="INSERT INTO `prod_gfh_ligne_machines` (`id`, `GFH_Ligne`, `Machines`) VALUES (NULL, '"+GFH_Ligne+"', '"+Machines+"'))";
            stm.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(AddElement.class.getName()).log(Level.SEVERE, null, ex);
        }}
        //------------------------------------------prod_gfh_ligne_machines----------------------------------------- 
        
        
        //------------------------------------------prod_machines_sous_ensemble----------------------------------------- 
        if(!"".equals(Machines) && !"".equals(Sous_ensemble)){
        try {
            String requete="INSERT INTO `prod_machines_sous_ensemble` (`id`, `Machines`, `Sous_ensemble`) VALUES (NULL, '"+Machines+"', '"+Sous_ensemble+"'))";
            stm.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(AddElement.class.getName()).log(Level.SEVERE, null, ex);
        }}
        //------------------------------------------prod_machines_sous_ensemble----------------------------------------- 
        
    }
    
    public void setElementTypeDocument(String Document, String Type_de_Document_N1, String Type_de_Document_N2, String Type_de_Document_N3) {
        try {
            //INSERT INTO `prod_critere` (`id`, `Lieu_archivage`, `Type_de_Materiel`, `Constructeur`, `Materiel`, `Annee`) VALUES (NULL, NULL, NULL, NULL, NULL, NULL)
            String requete="INSERT INTO `prod_type_document` (`Document`, `Type_de_Document_N1`, `Type_de_Document_N2`, `Type_de_Document_N3`) VALUES ("+Document+", "+Type_de_Document_N1+", "+Type_de_Document_N2+", "+Type_de_Document_N3+")";
            stm.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(AddElement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
            
    }
}

