package slawekkami.com;

/**
 * Created by Sławomir on 2016-02-27.
 */
public class Pozycja {
    private String nazwaTowaru;
    private int ilosc;
    private double cena;

    public Pozycja(String nazwaTowaru, int ilosc, double cena) {
        this.nazwaTowaru = nazwaTowaru;
        this.ilosc = ilosc;
        this.cena = cena;
    }
    public double obliczWartosc(){
        return ilosc*cena;
    }

    @Override
    public String toString() {
        return String.format("%-40s %10.2f zł %4d szt. %10.2f zł", nazwaTowaru,cena, ilosc,obliczWartosc() );
    }
}

