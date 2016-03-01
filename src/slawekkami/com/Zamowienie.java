package slawekkami.com;

import java.util.Arrays;

/**
 * Created by Sławomir on 2016-02-27.
 */
public class Zamowienie {
    private int maksRozmiar;
    private Pozycja[] pozycje;
    private int ileDodanych;


    public Zamowienie() {
        maksRozmiar = 10;
        pozycje = new Pozycja[maksRozmiar];
    }

    public Zamowienie(int maksRozmiar) {
        this.maksRozmiar = maksRozmiar;
        pozycje = new Pozycja[this.maksRozmiar];
        ileDodanych =0;
    }

    public void dodajPozycje(Pozycja p){
        if (ileDodanych<=maksRozmiar){
            pozycje[ileDodanych] = p;
            ileDodanych++;
        } else{System.out.println(" Nie można dodać wiecej pozycji");}

    }

    public double obliczWartosc(){
        double suma=0;
        for(int i=0; i<ileDodanych; i++){
            suma= suma + pozycje[i].obliczWartosc();
        }
        return suma;

    }
    @Override
    public String toString() {
        String wyswietl="%nZamowienie:";

        for(int i=0; i<ileDodanych; i++) {
            wyswietl = wyswietl+ "%n" + pozycje[i].toString();
        }
        wyswietl = wyswietl+ "%nRazem: " + String.format("%8.2f", obliczWartosc()) +"zł";
        return String.format( wyswietl);
        }
}