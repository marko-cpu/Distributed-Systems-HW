/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fink.hw1.ds;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author marko
 */
class Posiljka implements Cloneable {
    private static int count = 0;
    private int id = ++count;
    private String adresa;

   
    public Posiljka(String adresa) {
        this.adresa = adresa;
    }
    
    @Override
    protected Posiljka clone() throws CloneNotSupportedException {
        Posiljka p = (Posiljka)super.clone();
        p.id = ++id;
        return p;
    }

    
    public String getAdresa() {
        return adresa;
    }

   
    @Override
    public String toString() {
        return "p_" + id + "[" + adresa + "]";
    }
}
    

