package slawekkami.com;

/**
 * Created by Sławomir on 2016-02-27.
 */

import java.io.*;

public class Zamowienie implements Serializable {
    private int maksRozmiar;
    private Pozycja[] pozycje;
    private int ileDodanych = 0;


    public Zamowienie() {
        maksRozmiar = 10;
        pozycje = new Pozycja[maksRozmiar];
    }

    public Zamowienie(int maksRozmiar) {
        this.maksRozmiar = maksRozmiar;
        pozycje = new Pozycja[this.maksRozmiar];
        ileDodanych = 0;
    }

    public void dodajPozycje(Pozycja p) {
        boolean wstaw = false;
        if (ileDodanych > 0) {
            for (int i = 0; i < ileDodanych; i++) {
                if (pozycje[i].getNazwaTowaru() == p.getNazwaTowaru()) {
                    pozycje[i].setCena(p.getCena() + pozycje[i].getCena());
                    pozycje[i].setIleSztuk(p.getIleSztuk() + pozycje[i].getIleSztuk());
                } else {
                    wstaw = true;
                }
            }
        } else {
            pozycje[ileDodanych] = p;
            ileDodanych++;
        }
        if (wstaw == true) {
            if (ileDodanych <= maksRozmiar) {
                pozycje[ileDodanych] = p;
                ileDodanych++;
            }
        }
    }

    public double obliczWartosc() {
        double suma = 0;
        for (int i = 0; i < ileDodanych; i++) {
            suma = suma + pozycje[i].obliczWartosc();
        }
        return suma;
    }

    public double obliczWartoscRabatu() {
        double suma = 0;
        for (int i = 0; i < ileDodanych; i++) {
            suma = suma + pozycje[i].obliczWartoscRabatu();
        }
        return suma;

    }

    public double obliczWartoscZRabatem() {
        double suma = 0;
        for (int i = 0; i < ileDodanych; i++) {
            suma = suma + pozycje[i].obliczWartoscZRabatem();
        }
        return suma;

    }

    public void usunPozycje(int index) {
        for (int i = index - 1; i <= ileDodanych; i++) {
            if (i == ileDodanych) {
                pozycje[i] = null;
                ileDodanych--;
            } else
                pozycje[i] = pozycje[i + 1];
        }
    }

    public void edytujPozycje(int index, String nazwaTowaru, double cena, int ileSztuk) {
        System.out.println("Zmieniono pozycję");
        System.out.println(pozycje[index - 1]);
        pozycje[index - 1].setNazwaTowaru(nazwaTowaru);
        pozycje[index - 1].setCena(cena);
        pozycje[index - 1].setIleSztuk(ileSztuk);
        System.out.println("Na pozycję");
        System.out.println(pozycje[index - 1]);
    }

    @Override
    public String toString() {
        String wyswietl = "%nZamowienie:";

        for (int i = 0; i < ileDodanych; i++) {
            wyswietl = wyswietl + "%n" + pozycje[i].toString();
        }
        wyswietl = wyswietl + "%n%nRazem: " + String.format("%68.2f zł %15.2f zł %10.2f zł",
                obliczWartosc(), obliczWartoscRabatu(), obliczWartoscZRabatem());
        return String.format(wyswietl);
    }
    public static void zapiszZamowienie(Zamowienie z, String nazwaPliku)throws IOException, ClassNotFoundException{
        ObjectOutputStream plikZamowienia = new ObjectOutputStream(new FileOutputStream(nazwaPliku));
        plikZamowienia.writeObject(z);
    }

    public  Zamowienie wczytajZamowienie(String nazwaPliku) throws IOException, ClassNotFoundException{
        //Zamowienie z = new Zamowienie();
        ObjectInputStream plikZamowienia = new ObjectInputStream(new FileInputStream(nazwaPliku));
        //Zamowienie z =new Zamowienie(maksRozmiar);
        return (Zamowienie)plikZamowienia.readObject();
        //return z;

    }
}