package slawekkami.com;

import java.io.IOException;

public class Main {

    public static void main(String[] args)  throws IOException, ClassNotFoundException{
        // write your code here
        Pozycja poz1 = new Pozycja("t1", 1, 3);
        Pozycja poz2 = new Pozycja("t2", 2, 3);
        Pozycja poz3 = new Pozycja("t3", 3, 3);
        Pozycja poz4 = new Pozycja("t4", 4, 3);
        Pozycja poz5 = new Pozycja("t5", 5, 3);
        System.out.println(poz1);
        System.out.println(poz2);
        Zamowienie z = new Zamowienie(10);
        z.dodajPozycje(poz1);
        z.dodajPozycje(poz2);
        z.dodajPozycje(poz3);
        z.dodajPozycje(poz4);
        z.dodajPozycje(poz5);
        System.out.println(z);
        z.dodajPozycje(poz2);
        System.out.println(z);
        z.usunPozycje(1);
        System.out.println(z);
        z.edytujPozycje(2, "zmienionaNazwa", 4.50, 17);
        System.out.println(z);
        z.zapiszZamowienie(z,"zam.dat");
        Zamowienie z2 = new Zamowienie(10);
        z2.wczytajZamowienie("zam.dat");
        System.out.println("to jest zamowiennie z2");
        System.out.println(z2);


    }
}
