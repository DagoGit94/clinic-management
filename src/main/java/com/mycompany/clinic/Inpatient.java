/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinic;

/**
 *
 * @author dagoa
 */
public class Inpatient extends Patient {
    private int daysAdmitted;
    private double dailyRate;

    public Inpatient(String id, String name, int age, int roomNumber,int daysAdmitted, double dailyRate) {
      super(id, name, age, roomNumber);  
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
    }
    @Override
    public double calculateBill(){
       return daysAdmitted * dailyRate; 
    }
    
    public int getDaysAdmitted(){
        return daysAdmitted;
    }
    
    public double getDailyRate(){
        return dailyRate;
    }
    
    @Override
    public String toString(){
        return super.toString()+ "| Day Admitted: "+ daysAdmitted + "| Daily Rate:" +dailyRate +"| Bill calculated:  $"+calculateBill();
    }
    
}
