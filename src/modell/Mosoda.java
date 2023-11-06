package modell;

public class Mosoda {
    private Ruha[] ruhak;
    private int ruhaDb;
    
    //private boolean uzemel;
    private enum UzemelesiAllapot {UZEMEL, NEM_UZEMEL, LEEGETT};
    private UzemelesiAllapot allapot;

    public Mosoda() {
        this(5);
    }

    public Mosoda(int db) {
        ruhaDb = 0;
        ruhak = new Ruha[db];
        //uzemel = true;
        allapot = UzemelesiAllapot.UZEMEL;
    }
    
    /* setUzemel(boolean uzemel) */
    public void leeg(){
        //uzemel = false;
        allapot = UzemelesiAllapot.LEEGETT;
    }
    
    /* a "hagyományos" getUzemel, így enum típust ad vissza 
     * nem szerencsés, mert az enum nem elérhető típus
     * private az osztályban
     * ezt jelzi is az IDE: exporting non-public type through public API
    */
    public UzemelesiAllapot getUzemel(){
        //return uzemel;
        return allapot;
    }
    
    /* a könnyebb használatért: */
    public boolean isUzemel(){
        return allapot == UzemelesiAllapot.UZEMEL;
    }
    
    public void bevesz(Ruha ruha){
        //if (uzemel) {
        if (allapot == UzemelesiAllapot.UZEMEL) {
            if (ruhaDb < ruhak.length) {
                ruhak[ruhaDb++] = ruha;
            } else {
                System.out.println("A mosoda megtelt!");
            }
        } else {
            nemUzemel();
        }
    }
    
    public void mos(boolean kimelo){
        //if (uzemel) {
        if (allapot == UzemelesiAllapot.UZEMEL) {
            for (Ruha ruha : ruhak) {
                if (ruha != null) {
                    if (ruha instanceof Ing && kimelo) {
                        Ing ing = (Ing) ruha;
                        ing.kimeloMosas();
                    }
                    
                }
            }
        } else {
            nemUzemel();
        }
    }
    
    public Ruha kiad(String tulNeve){
        //Ruha r = null;
        Ruha r = new NemletezoRuha();
        //if (uzemel) {
        if (allapot == UzemelesiAllapot.UZEMEL) {
            int i = 0;
            while (ruhak[i] == null || i < ruhaDb && !(ruhak[i].getTulNev().equals(tulNeve))) {
                i++;
            }
            if (i < ruhaDb) {
                String tipus = ruhak[i] instanceof Ruha ? "ruhája" : "inge";
                System.out.println("Kiadva %s %s!".formatted(tulNeve, tipus));
                r = ruhak[i];
                ruhak[i] = null;//ez is lehetne NemletezoRuha
            } else {
                System.out.println("Nincs ilyen ruha a mosodában!");
            }
            
        } else {
            nemUzemel();
        }
        
        return r;
    }

    public String[] getRuhak() {
        //if (uzemel) {
        if (allapot == UzemelesiAllapot.UZEMEL) {
            String[] ruhak = new String[this.ruhak.length];
            for (int i = 0; i < ruhaDb; i++) {
                Ruha r = this.ruhak[i];
                if (r != null) {
                    ruhak[i] = r.toString();
//                ruhak[i] = r.getTulNev();
//                
//                //ruhak[i] += r instanceof Ing ? " ingje " : " ruhája ";
//                String szinIntenzitas = "";
//                if(r instanceof Ing){
//                    ruhak[i] += " ingje ";
//                    szinIntenzitas = " színe " + ((Ing) r).getSzin() + "%";
//                }else{
//                    ruhak[i] += " ruhája ";
//                }
//                ruhak[i] += r.isTiszta() ? "tiszta" : "koszos";
//                ruhak[i] += szinIntenzitas;
                }
            }
            return ruhak;
        } else {
            nemUzemel();
            //return null;
            return new String[]{new NemletezoRuha().toString()};
        }
    }

    private void nemUzemel() {
        if (allapot == UzemelesiAllapot.NEM_UZEMEL) {
            System.out.println("A mosoda nem üzemel!");
        } else if(allapot == UzemelesiAllapot.LEEGETT){
            System.out.println("A mosoda leégett!");
        }
    }
    
    
}
