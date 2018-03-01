/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.TextField;
import java.util.Observable;
import java.util.Observer;
import metier.Action;
import metier.Modele;

/**
 *
 * @author Thomas-PC
 */
public class TfSkieurObserver implements Observer {
    private TextField tfNo, tfNom, tfPays, tfPrenom;
    
    public TfSkieurObserver(TextField tfNo, TextField tfNom, TextField tfPays, TextField tfPrenom){
        this.tfNo = tfNo;
        this.tfNom = tfNom;
        this.tfPays = tfPays;
        this.tfPrenom = tfPrenom;
    }

    public void update(Observable o, Object arg) {
        switch(((Action)arg).getAction()){
            case 2:
                tfNo.setText("");
                tfNom.setText("");
                tfPays.setText("");
                tfPrenom.setText("");
                int id = ((Action)arg).getPos();
                if (id != -1) {
                    tfNo.setText(Integer.toString(((Modele)o).getSkieur(id).getNo()));
                    tfNom.setText(((Modele)o).getSkieur(id).getNom());
                    tfPays.setText(((Modele)o).getSkieur(id).getPays().toString());
                    tfPrenom.setText(((Modele)o).getSkieur(id).getPrenom());
                }
            break;
        }
    }
    
    
}
