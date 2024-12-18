/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.travelcompany;

/**
 *
 * @author Utente
 */
import java.util.concurrent.Semaphore;

public class TravelCompany {
    
    private static final Semaphore ferrySemaphore = new Semaphore(1);

    public static void main(String[] args) {
     
        Ferry ferry = new Ferry(ferrySemaphore);

       
        TouristGroup frenchGroup = new TouristGroup("Francesi", 25, ferry);
        TouristGroup germanGroup = new TouristGroup("Tedeschi", 25, ferry);
        TouristGroup spanishGroup = new TouristGroup("Spagnoli", 25, ferry);

        
        Thread frenchThread = new Thread(frenchGroup);
        Thread germanThread = new Thread(germanGroup);
        Thread spanishThread = new Thread(spanishGroup);

        frenchThread.start();
        germanThread.start();
        spanishThread.start();

        
        try {
            frenchThread.join();
            germanThread.join();
            spanishThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       
        TravelLog.writeLog();
        System.out.println("Tutti i viaggi sono completati. Log salvato su file.");
    }
}
