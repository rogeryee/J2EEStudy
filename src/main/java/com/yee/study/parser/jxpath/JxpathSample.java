package com.yee.study.parser.jxpath;

import org.apache.commons.jxpath.JXPathContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Author: RogerYee
 * Create: 10/25/16
 */
public class JXPathSample
{
    public static void main(String[] args)
    {
        Company company = setup();

        JXPathContext context = JXPathContext.newContext(company);  // 初始化JXPathContext
        context.setLenient(true); // 设置成Lenient模式, 如果访问不存在的属性则返回null, 而不是抛出异常.

        // 1. 获取根节点, 也就是当前节点
        Company root = (Company)context.getValue(".");
        System.out.println(root == company);

        // 2. 访问属性
        String name = (String)context.getValue("name"); // Andpay
        String nameEn = (String)context.getValue("nameEn"); // null

        System.out.println(name);
        System.out.println(nameEn);

        // 3. 使用谓词
        Department dev = (Department) context.getValue("departments[name='Dev']");
        System.out.println(dev.getName());

        Employee employee = (Employee) context.getValue("departments/employees[firstName='Roger' and age=20]");
        System.out.println(employee.getFirstName() + " " + employee.getLastName());

        // 4. 使用变量
        context.getVariables().declareVariable("name", "Roger");
        Employee roger = (Employee)context.getValue("/departments/employees[firstName=$name]");
        System.out.println(roger.getFirstName() + " " + roger.getLastName());

        // 5. 访问Map
        String contact = (String)context.getValue("departments/employees[firstName='Roger']/contacts[@name='0001']");
        System.out.println(contact);

        // 6. 迭代单个集合
        for (Iterator<?> iter = context.iterate( "/departments" ); iter.hasNext();  )
        {
            Department dept = (Department) iter.next();
            System.out.println(dept.getName());
        }

        // 7. 迭代多个集合
        for (Iterator<?> iter = context.iterate( "/departments/employees" ); iter.hasNext();  )
        {
            Employee emp = (Employee) iter.next();
            System.out.println(emp.getFirstName() + " " + emp.getLastName());
        }
    }

    /**
     *
     * @return
     */
    public static Company setup()
    {
        Employee employee = new Employee();
        employee.setFirstName("Roger");
        employee.setLastName("Yi");
        employee.setAge(20);
        employee.setContacts(new HashMap<String, String>());
        employee.getContacts().put("0001", "Phoebe");
        employee.getContacts().put("0002", "Angel");
        employee.getContacts().put("0003", "SBS");

        Employee employee1 = new Employee();
        employee1.setFirstName("Phoebe");
        employee1.setLastName("Cao");
        employee1.setAge(18);
        employee1.setContacts(new HashMap<String, String>());
        employee1.getContacts().put("0004", "Roger");
        employee1.getContacts().put("0005", "James");

        Employee employee2 = new Employee();
        employee2.setFirstName("Johnny");
        employee2.setLastName("Ye");
        employee2.setAge(30);
        employee2.setContacts(new HashMap<String, String>());
        employee2.getContacts().put("0006", "John");

        Department development = new Department();
        development.setName("Dev");
        development.setEmployees(new HashSet<Employee>());
        development.getEmployees().add(employee);
        development.getEmployees().add(employee1);

        Department sale = new Department();
        sale.setName("Sales");
        sale.setEmployees(new HashSet<Employee>());
        sale.getEmployees().add(employee2);

        Company company = new Company();
        company.setName("Andpay");
        company.setDepartments(new ArrayList<Department>());
        company.getDepartments().add(development);
        company.getDepartments().add(sale);

        return company;
    }
}
