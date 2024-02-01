package it.uniba.dib.casostudiologopedia.Paziente;

import it.uniba.dib.casostudiologopedia.DatiGioco3;
import it.uniba.dib.casostudiologopedia.DatiIntent;

public class DatiBambino {
    private static String email;
    public static void setEmail(String a){
        email=a;
        DatiIntent.setvaluecounter(0);
        DatiIntent.setcountet1value(1);
        DatiGioco3.setvaluecounter(0);
    }
    public static String getEmail(){return email;}
}
