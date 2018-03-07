/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import dao.PaysDao;
import dao.SkieurDao;
import domaine.Pays;
import domaine.Skieur;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Thomas-PC
 */
public class Modele extends Observable {
    private ArrayList lstSkieurs;
    private ArrayList lstPays;
    private int idCourrantPays = -1;
    private int idCourrantSkieur = -1;
    private static final int TROUVE_LERREUR_TOCCARD = -1;
    
    public void chargerPays(){
        lstPays = PaysDao.getListePays();
        setChanged(); notifyObservers(new Action(1));
    }
    
    public void chargerSkieurs(){
        lstSkieurs = SkieurDao.getListeSkieurs((Pays) lstPays.get(idCourrantPays));
    }
    
    public int getSizeLstPays(){ return lstPays.size(); }
    public Pays getPays(int i){ return (Pays) lstPays.get(i); }
    
    public int getSizeLstSkieurs(){ return lstSkieurs.size(); }
    public Skieur getSkieur(int i){ return (Skieur) lstSkieurs.get(i); }
    
    public void setPosPays(int idCourrant){ 
        idCourrantPays = idCourrant; 
        idCourrantSkieur = TROUVE_LERREUR_TOCCARD; 
        setChanged(); notifyObservers(new Action(2));
    }
    
    public void setPosSkieur(int idCourrant){
        idCourrantSkieur = idCourrant;
        setChanged(); notifyObservers(new Action(2, idCourrantSkieur));
    }
    
    public int getIdCourrantPays(){ return idCourrantPays; }
}
