/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clinic;

import java.util.Scanner;

/**
 *
 * @author dagoa
 */
public class Clinic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Management manager = new Management();
        
        manager.loadPatientsFromFile("patients.txt");
        boolean running = true;
        
        while(running){
            System.out.println("\n=== WELCOME TO THE GENERAL HOSPITAL ===");
            System.out.println("1. Admission patient hospitalisé");
            System.out.println("2. Enregistrement patient externe");
            System.out.println("3. Recherche patient par l'ID");
            System.out.println("4. Afficher tous les patients");
            System.out.println("5. Libérer un patient");
            System.out.println("6. Afficher le revenu total de l'hôpital");
            System.out.println("7. Sauvegarder et quitter");
            System.out.print("Votre choix : ");
            
            try {
                int choix = scanner.nextInt(); 
                scanner.nextLine(); // Nettoyage du tampon
                
                switch (choix) {
                    case 1:
                        System.out.println("Entrez l'ID du patient :");
                        String id = scanner.nextLine();
                        
                        System.out.println("Entrez le nom du patient :");
                        String name = scanner.nextLine();
                        
                        System.out.println("Entrez l'âge du patient :");
                        int age = scanner.nextInt(); 
                        scanner.nextLine();
                        
                        System.out.println("Indiquez le numéro de chambre :");
                        int numRoom = Integer.parseInt(scanner.nextLine());
                        
                        System.out.println("Indiquez le nombre de jours d'hospitalisation :");
                        int daysAdmitted = scanner.nextInt(); 
                        scanner.nextLine();
                        
                        System.out.println("Indiquez le tarif journalier :");
                        double dailyRate = scanner.nextDouble(); 
                        scanner.nextLine();
                        
                        Inpatient inpt = new Inpatient(id, name, age, numRoom, daysAdmitted, dailyRate); 
                        manager.addPatient(inpt);
                        System.out.println("Nouveau patient interne ajouté avec succès !");
                        break;
                        
                    case 2:
                        System.out.println("Entrez l'ID du patient :");
                        String opId = scanner.nextLine();
                        
                        System.out.println("Entrez le nom du patient :");
                        String opName = scanner.nextLine();
                        
                        System.out.println("Entrez l'âge du patient :");
                        int opAge = scanner.nextInt(); 
                        scanner.nextLine();
                        
                        System.out.println("Indiquez le numéro de chambre :");
                        int opNumRoom = Integer.parseInt(scanner.nextLine());
                        
                        System.out.println("Entrez le nom du médecin :");
                        String doctorName = scanner.nextLine();
                        
                        System.out.println("Indiquez les frais de consultation :");
                        double consultationFee = scanner.nextDouble(); 
                        scanner.nextLine();
                        
                        Outpatient oupt = new Outpatient(opId, opName, opAge, opNumRoom, doctorName, consultationFee); 
                        manager.addPatient(oupt);
                        System.out.println("Nouveau patient externe ajouté avec succès !");
                        break; 
                        
                    case 3:
                        System.out.println("Entrez l'ID du patient à rechercher :");
                        String searchId = scanner.nextLine();
                        
                        Patient foundPatient = manager.findPatientById(searchId);
                        if (foundPatient != null) {
                            System.out.println("Patient trouvé : " + foundPatient);
                        } else {
                            System.out.println("Aucun patient trouvé avec l'ID : " + searchId);
                        }
                        break;
                        
                    case 4:
                        manager.displayAllPatients();
                        break;
                        
                    case 5:
                        System.out.println("Entrez l'ID du patient à libérer :");
                        String dischargeId = scanner.nextLine();
                        
                        if (manager.dischargePatient(dischargeId)) {
                            System.out.println("Patient libéré avec succès.");
                        } else {
                            System.out.println("Aucun patient trouvé avec l'ID : " + dischargeId);
                        }
                        break;
                        
                    case 6:
                        System.out.println("Revenu total de l'hôpital : $" + manager.calculateTotalFRevenue());
                        break;
                        
                    case 7:
                        manager.savePatientsToFile("patients.txt");
                        running = false;
                        System.out.println("Données sauvegardées. Fermeture du système. Au revoir !");
                        break;
                        
                    default:
                        System.out.println("Numéro invalide ! Veuillez réessayer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erreur de saisie ! Assurez-vous d'entrer le bon type de données.");
                scanner.nextLine(); // Vider le scanner en cas d'erreur
            }
        }
        
        scanner.close();
    }
}
