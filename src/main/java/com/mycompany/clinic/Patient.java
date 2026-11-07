/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinic;

/**
 *
 * @author dagoa
 */
public abstract class Patient {
    private String id;
    private String name;
    private int age;
    private int roomNumber;

    public Patient(String id, String name, int age, int roomNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.roomNumber = roomNumber;
    }
    
    public abstract double calculateBill();
    
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    // Getter pour la facture totale (réutilise ta méthode calculateBill existante)
public double getTotalBill() {
    return calculateBill();
    }
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "Patient ID: " + id + " | Name: " + name + " | Age: " + age + " | Room Number: " + roomNumber ;
    }
    
    
}
