package slawekkami.com;

/**
 * Created by Sławomir on 2016-02-27.
 */

import java.io.Serializable;

public class Pozycja implements Serializable {
    private String nazwaTowaru;
    private int ileSztuk;
    private double cena;

    public Pozycja(String nazwaTowaru, int ilosc, double cena) {
        this.nazwaTowaru = nazwaTowaru;
        this.ileSztuk = ilosc;
        this.cena = cena;
    }

    public double obliczWartosc() {
        return ileSztuk * cena;
    }

    public void setIleSztuk(int ileSztuk) {
        this.ileSztuk = ileSztuk;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public void setNazwaTowaru(String nazwaTowaru) {
        this.nazwaTowaru = nazwaTowaru;
    }

    public String getNazwaTowaru() {
        return nazwaTowaru;
    }

    public int getIleSztuk() {
        return ileSztuk;
    }

    public double getCena() {
        return cena;
    }

    public double obliczWartoscZRabatem() {
        return ((ileSztuk * cena) / 100) * (100 - obliczRabat());
    }

    public double obliczWartoscRabatu() {
        return ((ileSztuk * cena) / 100) * obliczRabat();
    }

    public int obliczRabat() {
        if (ileSztuk >= 5 && ileSztuk < 10) {
            return 5;
        }
        if (ileSztuk >= 10 && ileSztuk < 20) {
            return 10;
        }
        if (ileSztuk >= 20) {
            return 15;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%-40s %10.2f zł %4d szt. %10.2f zł %4d proc %5.2f zł %10.2f zł",
                nazwaTowaru, cena, ileSztuk, obliczWartosc(), obliczRabat(), obliczWartoscRabatu(), obliczWartoscZRabatem());
    }


    }


