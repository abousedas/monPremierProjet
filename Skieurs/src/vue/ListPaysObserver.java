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
public class ListPaysObserver implements Observer{
    private List lstPays;
    
    public ListPaysObserver(List lstPays) {
        this.lstPays = lstPays;
    }

    public void update(Observable o, Object arg) {
        switch (((Action) arg).getAction()) {
            case 1:
                for (int i = 0; i < ((Modele)o).getSizeLstPays(); i++) {
                    lstPays.add(((Modele)o).getPays(i).getCode());
                }
            break;
        }
    }
}
