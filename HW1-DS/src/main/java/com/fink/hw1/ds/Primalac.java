/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fink.hw1.ds;

/**
 *
 * @author marko
 */
public class Primalac extends AktivnaOsoba {
     

    
    public Primalac(String ime, long minTime, long maxTime, PostanskoSanduce sanduce) {
         super(ime, minTime, maxTime, sanduce);
       
    }
    
   


    @Override
    public void zapocni() throws InterruptedException {
     
            while (!Thread.interrupted()) {
                 if(!sanduce.posiljke.isEmpty()){
                sanduce.izvadiPrvuPosiljku();
                
                Thread.sleep(getTime());
                 
            }
        } 

}
}
    
    
