/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.fink.hw1.ds;

/**
 *
 * @author marko
 */
public class HW1DS {

    public static void main(String[] args) throws InterruptedException {
       
        PostanskoSanduce postanskosanduce = new PostanskoSanduce("Adresa-postara", 5);
        postanskosanduce.dodajPosiljku(new Posiljka("Adresa1"));
        postanskosanduce.dodajPosiljku(new Posiljka("Adresa2"));
        postanskosanduce.dodajPosiljku(new Posiljka("Adresa3"));
        postanskosanduce.dodajPosiljku(new Posiljka("Adresa4"));

      

       Postar postar = new Postar("Postar-Marko", 1000, 5000, postanskosanduce);
       postar.dodajSanduce(postanskosanduce);
     

       
       PostanskoSanduce sanducePrimaoca = new PostanskoSanduce("Adresa1",5);
       postar.dodajSanduce(sanducePrimaoca);
            
       Primalac primalac = new Primalac("Primalac1",2000,4000, sanducePrimaoca);    
            
       
            
            
       System.out.println(postar+"\n");
       System.out.println(primalac+"\n");
            
       Thread.sleep(2000);
            
        postar.interrupt();
        primalac.interrupt();
            
        System.out.println("Kraj programa.");
    }
}
