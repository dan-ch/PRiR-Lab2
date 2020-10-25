import java.util.Locale;
import java.util.Scanner;

public class Program {
    private int ilosc;
    private double wynik;
    private double poczatek;
    private double koniec;
    private static final Scanner scan = new Scanner(System.in);

    public Program(){
        scan.useLocale(Locale.US);
        System.out.println("Podaj poczatek przedzialu");
        poczatek = scan.nextDouble();
        koniec = Double.MAX_VALUE;
        System.out.println("Podaj koniec przedzialu (wiekszy niz " + poczatek + ")");
        koniec = scan.nextDouble();
        wynik = 0;
        System.out.println("Podaj ilosc watkow");
        ilosc = scan.nextInt();
    }

    public void wybierzMetode(){
        System.out.println("1 - prostokaty, 2 - trapezy, 3 - Simpson, 4 - Kwadratury Gaussa");
        int wybor = scan.nextInt();
        int dokladnosc = 0;
        if(wybor == 4)
        {
            while(dokladnosc != 2 && dokladnosc != 6 && dokladnosc != 10){
                System.out.println("Podaj dokladności obliczen dla watku 2 lun 6 lub 10");
                dokladnosc = scan.nextInt();
            }
        }
        else{
            while(dokladnosc < 2 || dokladnosc > 100){
                System.out.println("Podaj dokladności obliczen dla watku od 2 do 100");
                dokladnosc = scan.nextInt();
            }
        }

        double skok = (koniec - poczatek)/ilosc;
        switch (wybor){
            case 1:
                Prostokaty(dokladnosc, skok);
                break;
            case 2:
                Trapezy(dokladnosc, skok);
                break;
            case 3:
                Simpson(dokladnosc, skok);
                break;
            case 4:
                Kwadratury(dokladnosc, skok);
                break;
            default:
                System.out.println("Zly wybor");
        }
    }

    public void czekaj(Thread[] watki) {
        for (int i = 0; i < ilosc; i++) {
            try {
                watki[i].join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }
    }


    private void Prostokaty(int dokladosc, double skok){
        M_prostokaty[] watki = new M_prostokaty[ilosc];

        for(int i = 0; i < ilosc; i++){
            watki[i] = new M_prostokaty(poczatek + i * skok, poczatek + (i+1) * skok, dokladosc);
            watki[i].start();
        }
        czekaj(watki);

        for(int i = 0; i < ilosc; i++){
            wynik += watki[i].getWynik();
        }

        System.out.println("Obliczony wynik to: " + wynik);
    }

    private void Trapezy(int dokladosc, double skok){
        M_trapezy[] watki = new M_trapezy[ilosc];

        for(int i = 0; i < ilosc; i++){
            watki[i] = new M_trapezy(poczatek + i * skok, poczatek + (i+1) * skok, dokladosc);
            watki[i].start();
        }
        czekaj(watki);

        for(int i = 0; i < ilosc; i++){
            wynik += watki[i].getWynik();
        }

        System.out.println("Obliczony wynik to: " + wynik);
    }

    private void Simpson(int dokladosc, double skok){
       M_simpson[] watki = new M_simpson[ilosc];

        for(int i = 0; i < ilosc; i++){
            watki[i] = new M_simpson(poczatek + i * skok, poczatek + (i+1) * skok, dokladosc);
            watki[i].start();
        }
        czekaj(watki);

        for(int i = 0; i < ilosc; i++){
            wynik += watki[i].getWynik();
        }

        System.out.println("Obliczony wynik to: " + wynik);
    }

    private void Kwadratury(int dokladnosc, double skok){
        M_kwadratury.dodaj(dokladnosc);
        M_kwadratury[] watki = new M_kwadratury[ilosc];

        for(int i = 0; i < ilosc; i++){
            watki[i] = new M_kwadratury(poczatek + i * skok, poczatek + (i+1) * skok, dokladnosc);
            watki[i].start();
        }
        czekaj(watki);

        for(int i = 0; i < ilosc; i++){
            wynik += watki[i].getWynik();
        }

        System.out.println("Obliczony wynik to: " + wynik);
    }

}



