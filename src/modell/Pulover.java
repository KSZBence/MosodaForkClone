package modell;

public class Pulover extends Ruha{    
    
    private enum meretAllapot{BEBI, GYEREK, TINI, FELNOTT};
    private meretAllapot meret;
    
    public Pulover(String tulNev, meretAllapot meret) {
        super(tulNev);
        this.meret = meret;
    }
    
    public void kimeloMosas(){
        this.setTiszta();
    }
    
    public void mosas(){
        while (meret.ordinal()>0) {            
            meret = meretAllapot.values()[meret.ordinal()-1];
        }
        this.setTiszta();
    }

    @Override
    public String toString() {
        String os = super.toString();
        return os + "\n\tPulover{" + "meret=" + meret + '}';
    }

    
}