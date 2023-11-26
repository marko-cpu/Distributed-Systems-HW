/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fink.hw1.ds;


/**
 *
 * @author marko
 */
public abstract class AktivnaOsoba extends Thread {
    
    protected String ime;
    protected long minTime;
    protected long maxTime;
    protected long time;
    protected PostanskoSanduce sanduce;

   
    public AktivnaOsoba(String ime, long minTime, long maxTime, PostanskoSanduce sanduce) {
        if (minTime < 0 || maxTime < 0 || minTime > maxTime) {
            throw new IllegalArgumentException("Neispravno zadati parametri vremena izvršavanja.");
        }

        this.ime = ime;
        this.minTime = minTime;
        this.maxTime = maxTime;
        this.sanduce = sanduce;
        this.time = (long) (minTime + Math.random()*(maxTime - minTime));
        

    }
    protected long getTime() {
    return time;
}
    
    public abstract void zapocni() throws InterruptedException;

  
    @Override
    public void run() {
      
       
        while (!Thread.interrupted()) {
            try {
                
                zapocni();   
               
                sleep(this.time);
                          

            } catch (InterruptedException e) {
               
              
            }
        }
    }
    
   
    
    @Override
    public String toString() {
        return "Ime : " + ime + "\n" + " - Sanduce: " + sanduce.getAdresa();
    }
}