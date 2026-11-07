/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinic;

/**
 *
 * @author dagoa
 */
public class Outpatient extends Patient {
    private String doctorName;
    private double consultationFee;

    public Outpatient(String id, String name, int age, int roomNumber ,String doctorName, double consultationFee) {
       super(id, name, age, roomNumber);  
        this.doctorName = doctorName;
        this.consultationFee = consultationFee;
    }
    @Override
    public double calculateBill(){
       return consultationFee; 
    }
 
    public String getDoctorName() {
        return doctorName;
    }

    public double getConsultationFee() {
        return consultationFee;
    }
    @Override
    public String toString(){
        return super.toString()+ "| Doctor Name: "+ doctorName + "| Consulation fee: $" +calculateBill();
    }

    
}
