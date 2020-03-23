package com.company;

import java.util.ArrayList;
import java.util.List;

public class University implements EmailRecipient{
    private String name;
    private String emailAddress;
    private List<Faculty> faculties = new ArrayList<>();
    public List<Faculty> getFaculties() {
        return faculties;
    }
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public University(String name, String emailAddress) {
        this.emailAddress = emailAddress;
        this.name = name;
    }

    @Override
    public String getEmailAddress() {
        return emailAddress;
    }
}
