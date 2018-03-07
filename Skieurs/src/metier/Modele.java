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
    private int posPays = -1;
    private int posSkieur = -1;
  
    public void chargerPays(){
        lstPays = PaysDao.getListePays();
        setChanged(); notifyObservers(new Action(1));
    }
    
    public void chargerSkieurs(){
        lstSkieurs = SkieurDao.getListeSkieurs((Pays) lstPays.get(posPays));
    }
    
    public int getSizeLstPays(){ return lstPays.size(); }
    public Pays getPays(int i){ return (Pays) lstPays.get(i); }
    
    public int getSizeLstSkieurs(){ return lstSkieurs.size(); }
    public Skieur getSkieur(int i){ return (Skieur) lstSkieurs.get(i); }
    
    public void setPosPays(int idCourrant){ 
        posPays = pos; 
        posSkieur = -1;
        setChanged(); notifyObservers(new Action(2));
    }
    
    public void setPosSkieur(int idCourrant){
        posSkieur = pos;
        setChanged(); notifyObservers(new Action(2, posSkieur));
    }
    
    public int getIdCourrantPays(){ return posPays; }
}
