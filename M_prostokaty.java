import java.util.ArrayList;

public class M_prostokaty extends Thread {
    double h;
    double a;
    double b;
    Double n;
    double wynik;
    ArrayList<Double> punkty;

    public M_prostokaty(double a, double b, double n){
        this.a = a;
        this.b = b;
        this.n = n;
        wynik = 0;
        punkty = new ArrayList<>();
    }

    private double funkcja(double x)
    {
        return  (Math.sin(x));
    }

    private void liczPunkty(){
        h=(b-a)/n;

        for(double i=1; i<=n; i++){
            punkty.add(a+(i/n)*(b-a));
        }
    }

    private void liczCalke(){
        for(int i=1; i<=n-1; i++){
            wynik += funkcja(punkty.get(i-1));
        }
        wynik*=h;
    }

    public void run(){
        liczPunkty();
        liczCalke();
    }

    public double getWynik() {
        return wynik;
    }
}
