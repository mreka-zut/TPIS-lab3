/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

/**
 *
 * @author micha
 */
public class Person implements EmailRecipient{
    private String emailAddress;
    private String firstName;
    private String lastName;
    public Person(String firstName, String lastName,String emailAddress)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress=emailAddress;
    }
    public String getFirstName() 
    {
        return firstName;
    }
    public String getLastName() 
    {
        return lastName;
    }
    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }
    @Override public String toString() 
    {
        return firstName + " " + lastName;
    }
    @Override
    public String getEmailAddress() {
        return this.emailAddress;
    }
}
