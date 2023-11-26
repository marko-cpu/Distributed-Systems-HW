/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fink.hw2.ds;

/**
 *
 * @author marko
 */
public class Skladiste {
    private static int statId = 0;
    private int id=++statId;
    private int [] niz;
    private int ulaz;
    private int izlaz;
    private int stanje;
    private final int kapacitet;
    private int brojStavljenih = 0;
    private int brojUzetih = 0;
    
    public int getStanje() {
        return stanje;
    }
     public int getBrojStavljenih() {
        return brojStavljenih;
    }

    public int getBrojUzetih() {
        return brojUzetih;
    }

    public int getId() {
        return id;
    }
    public Skladiste( int kapacitet ) {
        this.kapacitet = kapacitet;
        niz = new int[kapacitet];
        }
   public synchronized void Stavi(int element) throws InterruptedException {
        while (stanje == kapacitet) wait();
        niz[ulaz++] = element;
        stanje++;
        brojStavljenih++;
        if (ulaz == kapacitet) ulaz = 0;
        notifyAll();
       
    }

    public synchronized int Uzmi() throws InterruptedException {
        while (stanje == 0) wait();
        int element = niz[izlaz];
        niz[izlaz++] = 0;
        stanje--;
        brojUzetih++;
        if (izlaz == kapacitet) izlaz = 0;
        notifyAll();
    
        return element;
    }
}
