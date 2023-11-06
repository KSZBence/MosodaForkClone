package modell;

public class Ing extends Ruha{
    private double szinIntenzitas;

    public Ing(String tulNev) {
        super(tulNev);
        szinIntenzitas = 100;
    }

    public double getSzin() {
        return szinIntenzitas;
    }

    public void setSzin(double szinIntenzitas) {
        this.szinIntenzitas = szinIntenzitas;
    }
    
    public void kimeloMosas(){
        this.szinIntenzitas = this.szinIntenzitas*0.985;
        this.setTiszta();
    }
    
    public void mosas(){
        this.szinIntenzitas = this.szinIntenzitas*0.97;
        this.setTiszta();
    }
    
    

    @Override
    public String toString() {
        String os = super.toString();
        return os + "\n\tIng{" + "szinIntenzitas=" + szinIntenzitas + '}';
    }

    
}
