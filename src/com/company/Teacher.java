/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author micha
 */
public class Teacher extends Person{
    
    private String courseName;
    public Teacher(String firstName, String lastName, String emailAddress, String courseName) {
        super(firstName, lastName, emailAddress);
        this.courseName = courseName;

    }

    public String getCourseName()
    {
        return courseName;
    }
    public void setCourseName(String courseName) 
    {
        this.courseName = courseName;
    }
    
}
