/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fink.hw1.ds;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author marko
 */
public class PostanskoSanduce {
    
  private String adresa;
  protected List<Posiljka> posiljke;
  private int kapacitet;

 

  
    public PostanskoSanduce(String adresa, int kapacitet) {
        this.adresa = adresa;
        this.kapacitet = kapacitet;
        this.posiljke = new ArrayList<>();
      
        
    }

      public String getAdresa() {
        return adresa;
    }
  

    public synchronized void dodajPosiljku(Posiljka posiljka) throws InterruptedException {
        while (posiljke.size() >= kapacitet) {
            wait();
        }
        posiljke.add(posiljka);
        System.out.println("Posiljka je dodata " + posiljka +" u sanduce " + adresa);
        notifyAll();
    }
    
      public synchronized void izvadiPrvuPosiljku() throws InterruptedException
    {
        while (posiljke.isEmpty()) {
            wait();
        }
        Posiljka prvaPosiljka = posiljke.remove(0);
        System.out.println("Primalac je preuzeo posiljku " + prvaPosiljka);
        notifyAll();
    
    }

  
    public synchronized ArrayList<Posiljka> izvadiPosiljku(String adresa) throws InterruptedException {
        
        while (posiljke.isEmpty()) {
            wait();
        }

        ArrayList<Posiljka> trazenaPosiljka = new ArrayList<>();
        Iterator<Posiljka> iterator = posiljke.iterator();
        while (iterator.hasNext()) {
            Posiljka posiljka = iterator.next();
            if (posiljka.getAdresa().equals(adresa)) {
                iterator.remove();
                System.out.println("Postar vadi posiljku " + posiljka);
                trazenaPosiljka.add(posiljka);
                
                notifyAll();
            }
                
        }
        return trazenaPosiljka;
    }
    


    @Override
    public String toString() {
        StringBuilder opis = new StringBuilder();
        for (Posiljka posiljka : posiljke) {
            opis.append(posiljka.toString()).append("\n");
        }
        return opis.toString();
    }
    
}
