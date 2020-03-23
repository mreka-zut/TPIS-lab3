package com.company;

import java.util.ArrayList;
import java.util.List;

public class Faculty implements EmailRecipient{
    private String name;
    private String emailAddress;
    private List<Teacher> teachers = new ArrayList<>();
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Faculty(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
    }

    @Override
    public String getEmailAddress() {
        return emailAddress;
    }
}

