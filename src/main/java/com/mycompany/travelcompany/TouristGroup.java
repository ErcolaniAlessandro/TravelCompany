/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.travelcompany;

/**
 *
 * @author Utente
 */
public class TouristGroup implements Runnable {
    private final String groupName;
    private final int groupSize;
    private final Ferry ferry;

    public TouristGroup(String groupName, int groupSize, Ferry ferry) {
        this.groupName = groupName;
        this.groupSize = groupSize;
        this.ferry = ferry;
    }

    @Override
    public void run() {
        try {
           
            System.out.println("Partenza dagli alloggi dei " + groupName);
            Thread.sleep(1000); 

            System.out.println("Arrivo al porto dei " + groupName);
            Thread.sleep(500);

            System.out.println("Pagamento del biglietto dei " + groupName);
            Thread.sleep(500);

            
            ferry.board(groupName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

