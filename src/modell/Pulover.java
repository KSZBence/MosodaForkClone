package modell;

public class Pulover extends Ruha{
    private double szinIntenzitas;

    public Pulover(String tulNev) {
        super(tulNev);
        szinIntenzitas = 100;
    }

    public double getSzin() {
        return szinIntenzitas;
    }

    public void setSzin(double szinIntenzitas) {
        this.szinIntenzitas = szinIntenzitas;
    }

    @Override
    public String toString() {
        String os = super.toString();
        return os + "\n\tIng{" + "szinIntenzitas=" + szinIntenzitas + '}';
    }

    
}