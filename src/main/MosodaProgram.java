package main;

import modell.Ing;
import modell.Mosoda;
import modell.Ruha;

public class MosodaProgram {

    private Mosoda mosoda;

    public static void main(String[] args) {
        new MosodaProgram();
    }
    
    public MosodaProgram() {
        mosoda = new Mosoda(4);
        mosoda.bevesz(new Ruha("Péter"));
        mosoda.bevesz(new Ruha("Pál"));
        mosoda.bevesz(new Ing("Petra"));
        mosoda.bevesz(new Ing("Piroska"));

        mosoda.leeg();
        
        System.out.println("--- mosoda ruhái mosás ELŐTT:");
        mosodaRuhai();
        
        System.out.println("--- mosoda ruhái 1. mosás UTÁN:");
        mosoda.mos();
        mosodaRuhai();
        
        System.out.println("--- mosoda ruhái 2. mosás UTÁN:");
        mosoda.mos();
        mosodaRuhai();
        
        System.out.println("--- a kivett ruhák:");
        Ruha ruhaPal = mosoda.kiad("Pál");
        System.out.println("ruhaPal = " + ruhaPal);
        Ruha ingPetra = mosoda.kiad("Petra");
        System.out.println("ingPetra = " + ingPetra);
        
        System.out.println("--- a mosodában maradt ruhák:");
        mosodaRuhai();
        
        
        
        System.out.println("--- a mosoda leégett!");
        mosoda.leeg();
        System.out.println("--- a leégés utáni beadás, kivevés:");
        mosoda.bevesz(new Ruha("nem vehető be"));
        mosoda.kiad("???");
    }
    
    private void mosodaRuhai() {
        for (String ruha : mosoda.getRuhak()) {
            if(ruha != null){
                System.out.println(ruha);
            }
        }
    }

}
