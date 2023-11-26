/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fink.hw1.ds;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marko
 */
public class Postar extends AktivnaOsoba {
   
 
   private List<PostanskoSanduce> sanducici;

    // Konstruktor
    public Postar(String ime, long minTime, long maxTime, PostanskoSanduce sanduce) {
       super(ime, minTime, maxTime, sanduce);
        sanducici = new ArrayList<>();
    }
    
    
    public synchronized void dodajSanduce(PostanskoSanduce sanduce) {
        sanducici.add(sanduce);
    }

   

    @Override
    public void zapocni() throws InterruptedException {
        
        String adresaDostave = sanduce.posiljke.get(0).getAdresa();
        int br_posiljki = sanduce.posiljke.size();
         
    
            while(!Thread.interrupted() && !sanduce.posiljke.isEmpty()){
               for(PostanskoSanduce sanduce : sanducici){
            
                    if (sanduce.getAdresa().equals(adresaDostave)) {
               
                        for(int i = 0; i < br_posiljki; i++){
                        
                            ArrayList<Posiljka> posiljka = sanduce.izvadiPosiljku(adresaDostave);
                            int count = posiljka.size();
                            for(int j=0; j<count; j++){
                                if(posiljka.get(j) != null) sanduce.dodajPosiljku(posiljka.get(j));
                            }
                            Thread.sleep(getTime()); 
                            
                        }
                        break;
                    }
                }
            }
        }
        
           
    }  

    

