/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.List;
import java.util.Observable;
import java.util.Observer;
import metier.Action;
import metier.Modele;

/**
 *
 * @author Thomas-PC
 */
public class ListSkieursObserver implements Observer {
    private List lstSkieurs;
    
    public ListSkieursObserver(List lstSkieurs) {
        this.lstSkieurs = lstSkieurs;
    }

    public void update(Observable o, Object arg) {
        switch(((Action) arg).getAction()){
            case 2:
                if (((Action) arg).getPos() == -1) {
                    lstSkieurs.removeAll();
                    ((Modele)o).chargerSkieurs();
                    for (int i = 0; i < ((Modele)o).getSizeLstSkieurs(); i++) {
                        lstSkieurs.add(((Modele)o).getSkieur(i).toString());
                    }
                }
            break;
        }
    }
}
