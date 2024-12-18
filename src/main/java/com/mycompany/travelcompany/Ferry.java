/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.travelcompany;

/**
 *
 * @author Utente
 */
import java.util.concurrent.Semaphore;

public class Ferry {
    private final Semaphore ferrySemaphore;

    public Ferry(Semaphore ferrySemaphore) {
        this.ferrySemaphore = ferrySemaphore;
    }

    public void board(String groupName) {
        try {
         
            ferrySemaphore.acquire();
            System.out.println("Imbarco sul traghetto dei " + groupName);
            System.out.println("Partenza dal porto dei " + groupName);
            Thread.sleep(2000); // Simula il viaggio

            System.out.println("Ritorno al porto del traghetto");
            ferrySemaphore.release();

           
            TravelLog.addEntry(groupName + " - Viaggio completato");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
