/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.travelcompany;

/**
 *
 * @author Utente
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TravelLog {
    private static final List<String> logEntries = new ArrayList<>();

    public static synchronized void addEntry(String entry) {
        logEntries.add(entry);
    }


    public static void writeLog() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("travel_log.txt"))) {
            writer.write("Data odierna: " + LocalDate.now() + "\n");
            writer.write("Viaggi effettuati:\n");
            for (String entry : logEntries) {
                writer.write(entry + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
