import java.util.ArrayList;

public class M_trapezy extends Thread {
    double h;
    double a;
    double b;
    Double n;
    double wynik;
    ArrayList<Double> punkty;

    public M_trapezy(double a, double b, double n){
        this.a = a;
        this.b = b;
        this.n = n;
        wynik = 0;
        punkty = new ArrayList<>();
    }

    private double funkcja(double x)
    {
        return  (Math.pow(x,2)+2*x-5)/(3*x+5);
    }

    private void liczPunkty(){
        h=(b-a)/n;

        for(double i=1; i<=n-1; i++){
            punkty.add(a+(i/n)*(b-a));
        }
    }

    private void liczCalke(){
        wynik = funkcja(a)/2;
        wynik += funkcja(b)/2;
        for(int i=1; i<=n-1; i++){
            wynik += funkcja(punkty.get(i-1));
        }
        wynik*=h;
    }

    public double getWynik() {
        return wynik;
    }

    public void run(){
        liczPunkty();
        liczCalke();
    }
}
