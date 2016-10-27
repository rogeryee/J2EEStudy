package com.yee.study.parser.jxpath;

import java.util.Map;

/**
 * Author: RogerYee
 * Create: 10/25/16
 */
public class Employee
{
    private String firstName;

    private String lastName;

    private int age;

    private Map<String, String> contacts;

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public Map<String, String> getContacts()
    {
        return contacts;
    }

    public void setContacts(Map<String, String> contacts)
    {
        this.contacts = contacts;
    }
}
