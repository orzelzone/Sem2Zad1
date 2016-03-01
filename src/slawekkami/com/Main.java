package slawekkami.com;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Pozycja poz1 = new Pozycja("t1",2,3);
        Pozycja poz2 = new Pozycja("t2",3,3);
        System.out.println(poz1);
        System.out.println(poz2);
        Zamowienie z =new Zamowienie(5);
        z.dodajPozycje(poz1);
        z.dodajPozycje(poz2);
        System.out.println(z);

    }
}
