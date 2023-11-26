/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fink.hw2.ds;

/**
 *
 * @author marko
 */
public class Izvestac extends Thread {
    
    private static int statId = 0;
    private int id = ++statId;
    private Skladiste skladiste;
    private int interval;

    public Izvestac(Skladiste skladiste, int interval) {
        this.skladiste = skladiste;
        this.interval = interval;
    }

    public void run() {
        System.out.println("Izvestac " + id + " prikazuje sadrzaj skladišta svakih " + interval + " sekundi.");
        try {
            while (!interrupted()) {
                Thread.sleep(interval * 1000);
                int brojStavljenih = skladiste.getBrojStavljenih();
                int brojUzetih = skladiste.getBrojUzetih();
                System.out.println("Sadrzaj skladišta: " +  skladiste.getStanje() +
                        ", Ukupno stavljeno: " + brojStavljenih +
                        ", Ukupno uzeto: " + brojUzetih);
            }
        } catch (InterruptedException ex) {
            System.out.println("Izvestac " + id + " je zavrsio sa radom");
        }
    }
    
    
    
}
