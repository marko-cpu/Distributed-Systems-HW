/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.fink.hw2.ds;

/**
 *
 * @author marko
 */
public class HW2DS {

    public static void main(String[] args) {
        Skladiste skladište = new Skladiste(5);

        for (int i = 0; i < 10; i++) {
            Proizvodjac proizvodjac = new Proizvodjac(skladište, 1000, 3000);
            proizvodjac.start();
        }

        for (int i = 0; i < 10; i++) {
            Potrosac potrosac = new Potrosac(skladište, 1000, 3000);
            potrosac.start();
        }

        Izvestac izvestac = new Izvestac(skladište, 10);
        izvestac.start();
    }
}

