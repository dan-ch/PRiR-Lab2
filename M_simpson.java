import java.util.ArrayList;

public class M_simpson extends Thread {
    double a;
    double b;
    Double n;
    double h;
    double wynik = 0;
    ArrayList<Double> Ti;
    ArrayList<Double> punkty;

    public M_simpson(double a, double b, double n){
        this.a = a;
        this.b = b;
        this.n = n;
        wynik = 0;
        Ti = new ArrayList<>();
        punkty = new ArrayList<>();
    }

    private double funkcja(double x)
    {
        return  ((Math.sqrt(1.4 *x + 0.2))/Math.cos(0.1*Math.pow(x,2) + 2.1));
    }

    private void liczPunkty(){
        punkty.add(a);
        for(double i=1; i<=n-1; i++){
            punkty.add(a+(i/n)*(b-a));
        }
        punkty.add(b);
        h=(punkty.get(2)-punkty.get(1))/2;
        for(int i=0; i<=n-1; i++){
            Ti.add((punkty.get(i+1)+punkty.get(i))/2);
        }
    }

    private void liczCalke() {
        wynik = funkcja(punkty.get(0));
        wynik += funkcja(punkty.get(punkty.size()-1));
        for(int i=0; i<=n-1; i++){
            wynik+=4*funkcja(Ti.get(i));
        }

        for(int i=1; i<=n-1; i++){
            wynik+=2*funkcja(punkty.get(i));
        }
        wynik *= h / 3;
    }

    public void run(){
        liczPunkty();
        liczCalke();
    }

    public double getWynik() {
        return wynik;
    }
}

