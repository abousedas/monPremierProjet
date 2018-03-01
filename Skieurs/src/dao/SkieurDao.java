package dao;

import java.util.ArrayList;
import java.util.StringTokenizer;
import outils.FileStr;
import domaine.Skieur;
import domaine.Pays;

public class SkieurDao {
    
    private static final String FICHIER_SKIEURS = "Skieurs.txt";

    public static ArrayList getListeSkieurs(Pays pays) {
        String[] tabSkieurs = FileStr.read(FICHIER_SKIEURS);
        ArrayList aLst = new ArrayList();
        for (int i=0; i<tabSkieurs.length; i++) {
            StringTokenizer strT = new StringTokenizer(tabSkieurs[i], ";");
            Pays p = new Pays(strT.nextToken());
            if (p.equals(pays)) { aLst.add(new Skieur(Integer.parseInt(strT.nextToken()), strT.nextToken(), strT.nextToken(), pays)); }
        }
        return aLst;
    }   
}