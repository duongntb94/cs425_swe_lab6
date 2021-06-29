package edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author duong at 6/29/21
 * @project SWE_Lab6
 */
public class Student {
    private String studentId;
    private String name;
    private LocalDate dateOfAdmission;

    public Student() {
        studentId = "";
        name = "";
        dateOfAdmission = LocalDate.now();
    }

    public Student(String studentId, String name, int admissionYear, int admissionMonth, int admissionDay) {
        this.studentId = studentId;
        this.name = name;
        this.dateOfAdmission = LocalDate.of(admissionYear, admissionMonth, admissionDay);
    }

    public Student(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(LocalDate dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }
}
