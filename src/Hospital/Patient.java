/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital;

/**
 *
 * @author Abi
 */
import java.io.Serializable;
public class Patient implements Serializable {
 private String name;
    private int age;
    private String date;
    private String month;
    private String year;
    private String doctorName;
    private String patientCase;
    private int duration;
    private String status;

    public Patient(String name, int age, String date, String month, String year, String doctorName, String patientCase, int duration) {
        this.name = name;
        this.age = age;
        this.date = date;
        this.month = month;
        this.year = year;
        this.doctorName = doctorName;
        this.patientCase = patientCase;
        this.duration = duration;
        this.status = "Admitted";
    }

    // Getters and setters omitted for brevity

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", date='" + date + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", patientCase='" + patientCase + '\'' +
                ", duration=" + duration +
                ", status='" + status + '\'' +
                '}';
    }   

    }
