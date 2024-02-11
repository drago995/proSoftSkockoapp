/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package commonskocko;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ljubomir
 */
public class CommonSkocko implements Serializable {

    Date date;
    int prvi;
    int drugi;
    int treci;
    int cetvrti;
    int pogodjeniNaMestu;
    int pogodjeniNisuNaMestu;
    int[] niz;
    boolean poslednja = false;
   

    public void setPoslednja(boolean poslednja) {
        this.poslednja = poslednja;
    }

    public boolean isPoslednja() {
        return poslednja;
    }
    boolean tacanNiza = false;

    public CommonSkocko(int prvi, int drugi, int treci, int cetvrti) {
        this.prvi = prvi;
        this.drugi = drugi;
        this.treci = treci;
        this.cetvrti = cetvrti;
        niz = new int[4];
        niz[0] = prvi;
        niz[1] = drugi;
        niz[2] = treci;
        niz[3] = cetvrti;

    }

    public int getPogodjeniNaMestu(CommonSkocko cm) {
        for (int i = 0; i < 4; i++) {
            if (niz[i] == cm.niz[i]) {
                pogodjeniNaMestu++;
            }
        }

        return pogodjeniNaMestu;

    }

    public int getPogodjeniNisuNaMestu(CommonSkocko cm) {
    pogodjeniNisuNaMestu = 0; // Initialize the counter
    
    boolean[] counted = new boolean[4];
    
    for (int i = 0; i < 4; i++) {
        if ((niz[i] == cm.prvi && i != 0) ||
            (niz[i] == cm.drugi && i != 1) ||
            (niz[i] == cm.treci && i != 2) ||
            (niz[i] == cm.cetvrti && i != 3)) {
            if (!counted[niz[i]]) {
                pogodjeniNisuNaMestu++;
                counted[niz[i]] = true;
            }
        }
    }

    return pogodjeniNisuNaMestu;
}

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPrvi(int prvi) {
        this.prvi = prvi;
    }

    public void setDrugi(int drugi) {
        this.drugi = drugi;
    }

    public void setTreci(int treci) {
        this.treci = treci;
    }

    public void setCetvrti(int cetvrti) {
        this.cetvrti = cetvrti;
    }

    public String getKombinacija() {
        return prvi + "-" + drugi + "-" + treci + "-" + cetvrti;
    }

    public void setPogodjeniNaMestu(int pogodjeniNaMestu) {
        this.pogodjeniNaMestu = pogodjeniNaMestu;
    }

    public void setPogodjeniNisuNaMestu(int pogodjeniNisuNaMestu) {
        this.pogodjeniNisuNaMestu = pogodjeniNisuNaMestu;
    }

    public void setNiz(int[] niz) {
        this.niz = niz;
    }
    
    
    public boolean pobedioJe(){
        
        return (pogodjeniNaMestu == 4) ? true : false;
    
    }
    
    public void setTacanNiz(boolean istina){
        this.tacanNiza = true;
    }

    public int getPogodjeniNaMestu() {
        return pogodjeniNaMestu;
    }

    public int getPogodjeniNisuNaMestu() {
        return pogodjeniNisuNaMestu;
    }
    
    

}
