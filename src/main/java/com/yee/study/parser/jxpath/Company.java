package com.yee.study.parser.jxpath;

import java.util.List;

/**
 * Author: RogerYee
 * Create: 10/25/16
 */
public class Company
{
    private String name;

    private List<Department> departments;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Department> getDepartments()
    {
        return departments;
    }

    public void setDepartments(List<Department> departments)
    {
        this.departments = departments;
    }
}
