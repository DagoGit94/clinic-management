/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author dagoa
 */
public class Management {
     private ArrayList<Patient> patientList;
    private HashMap<String, Patient> patientMap;
    
    public Management() {
        this.patientList = new ArrayList<>();
        this.patientMap = new HashMap<>();
    } 
    
    public void addPatient(Patient patient) {
        patientList.add(patient);
        patientMap.put(patient.getId(), patient);
    }
    
    public Patient findPatientById(String id) {
        return patientMap.get(id);
    }
    
    public void displayAllPatients() {
        if (patientList.isEmpty()) {
            System.out.println("Aucun patient dans la liste.");
        } else {
            System.out.println("=== LISTE DES PATIENTS ===");
            for (Patient p : patientList) {
                System.out.println(p);
            }
        }
    }
    
    public boolean dischargePatient(String id) {
        // Recherche et retrait de la HashMap
        Patient removedPatient = patientMap.remove(id);
        
        if (removedPatient != null) {
            // Retrait de la liste synchronisée
            patientList.remove(removedPatient);
            return true;
        }
        return false;
    }
    
    public double calculateTotalFRevenue() {
        double total = 0;
        for (Patient p : patientList) {
            total += p.calculateBill();
        }
        return total;
    }
    
    public void savePatientsToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Patient patient : patientList) {
                if (patient instanceof Inpatient) {
                    Inpatient ip = (Inpatient) patient;
                    writer.println("INPATIENT," + ip.getId() + "," + ip.getName() + "," + ip.getAge() + "," + ip.getRoomNumber() + "," + ip.getDaysAdmitted() + "," + ip.getDailyRate());
                } else if (patient instanceof Outpatient) {
                    Outpatient op = (Outpatient) patient;
                    writer.println("OUTPATIENT," + op.getId() + "," + op.getName() + "," + op.getAge() + "," + op.getRoomNumber() + "," + op.getDoctorName() + "," + op.getConsultationFee());
                }
            }
            System.out.println("Données sauvegardées avec succès dans " + fileName);
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }
    
    public void loadPatientsFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            patientList.clear();
            patientMap.clear();

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length == 7) {
                    try {
                        String type = parts[0].trim();
                        String id = parts[1].trim();
                        String name = parts[2].trim();
                        int age = Integer.parseInt(parts[3].trim());
                        int roomNumber = Integer.parseInt(parts[4].trim());

                        if (type.equals("INPATIENT")) {
                            int daysAdmitted = Integer.parseInt(parts[5].trim());
                            double dailyRate = Double.parseDouble(parts[6].trim());
                            addPatient(new Inpatient(id, name, age, roomNumber, daysAdmitted, dailyRate));
                        } else if (type.equals("OUTPATIENT")) {
                            String doctorName = parts[5].trim();
                            double consultationFee = Double.parseDouble(parts[6].trim());
                            addPatient(new Outpatient(id, name, age, roomNumber, doctorName, consultationFee));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ligne ignorée (erreur format numérique) : " + line);
                    }
                }
            }
            System.out.println("Données chargées avec succès depuis " + fileName);
        } catch (IOException e) {
            System.out.println("Aucun fichier de sauvegarde trouvé. Démarrage à vide.");
        }
        
    }
 
    
}
