import java.util.ArrayList;

public class M_kwadratury extends Thread{

    static ArrayList<Double> wagi = new ArrayList<>();
    static ArrayList<Double> wezly = new ArrayList<>();
    double a;
    double b;
    int n;
    double wynik;

    public M_kwadratury(double a, double b, int n){
        this.a = a;
        this.b = b;
        this.n = n;
        wynik = 0;
    }

    public static void dodaj(int n)
    {
        switch(n){
            case 2:
                wagi.add(1.0);
                wagi.add(1.0);
                wezly.add(-0.5773502691896257);
                wezly.add(0.5773502691896257);
            case 6:
                wagi.add(0.3607615730481386);
                wagi.add(0.3607615730481386);
                wagi.add(0.4679139345726910);
                wagi.add(0.4679139345726910);
                wagi.add(0.1713244923791704);
                wagi.add(0.1713244923791704);
                wezly.add(0.6612093864662645);
                wezly.add(-0.6612093864662645);
                wezly.add(-0.2386191860831969);
                wezly.add(0.2386191860831969);
                wezly.add(-0.9324695142031521);
                wezly.add(0.9324695142031521);
            case 10:
                wagi.add(0.2955242247147529);
                wagi.add(0.2955242247147529);
                wagi.add(0.2692667193099963);
                wagi.add(0.2692667193099963);
                wagi.add(0.2190863625159820);
                wagi.add(0.2190863625159820);
                wagi.add(0.1494513491505806);
                wagi.add(0.1494513491505806);
                wagi.add(0.0666713443086881);
                wagi.add(0.0666713443086881);
                wezly.add(-0.1488743389816312);
                wezly.add(0.1488743389816312);
                wezly.add(-0.4333953941292472);
                wezly.add(0.4333953941292472);
                wezly.add(-0.6794095682990244);
                wezly.add(0.6794095682990244);
                wezly.add(-0.8650633666889845);
                wezly.add(0.8650633666889845);
                wezly.add(-0.9739065285171717);
                wezly.add(0.9739065285171717);
        }
    }

    private double liczWezel(double a, double b, int i)
    {
        return ((b-a)/2)*wezly.get(i) + (b+a)/2;
    }

    private double funkcja(double x)
    {
        return Math.sin(x);
    }

    private void licz(){
        double wezel= 0.0;
            for(int i=0; i<n; i++)
            {
                wezel=liczWezel(a,b,i);
                wynik+=wagi.get(i)*funkcja(wezel);
            }
            wynik*=(b-a)/2;
    }

    public double getWynik() {
        return wynik;
    }

    public void run(){
        licz();
    }
}
