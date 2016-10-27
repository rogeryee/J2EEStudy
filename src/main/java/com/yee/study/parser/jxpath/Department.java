package com.yee.study.parser.jxpath;

import java.util.Set;

/**
 * Author: RogerYee
 * Create: 10/25/16
 */
public class Department
{
    private String name;

    private Set<Employee> employees;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Set<Employee> getEmployees()
    {
        return employees;
    }

    public void setEmployees(Set<Employee> employees)
    {
        this.employees = employees;
    }
}
