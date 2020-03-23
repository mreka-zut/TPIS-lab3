/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author micha
 */
public class Student extends Person{
    private String groupID;
    private List<Double> grades = new ArrayList<>();
    public Student(String firstName, String lastName, String emailAddress, String groupID) {
        super(firstName, lastName, emailAddress);
        this.groupID = groupID;
    }
    public String getGroupID() {
        return groupID;
    }
    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }
    public List<Double> getGrades() {
        return grades;
    }
    public void addGrade(double grade){
        this.grades.add(grade);
    }
    public Double getGradesAverage(){
        if(grades.isEmpty()==true)
        {
            System.out.print("Lista ocen jest pusta!");
            return null;
        }
        else
        {
            double gradesAverage = 0;
            for(double grade: grades)
            {
                gradesAverage=gradesAverage+grade;
            }
            gradesAverage=gradesAverage/grades.size();
            return gradesAverage;
        }
    }
}
