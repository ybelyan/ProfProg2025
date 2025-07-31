package work;

import base.Employee;

public class Tester extends Employee {
    public Tester(String lastName, String firstName, String jobTitle, double salary) {
        super(lastName, firstName, jobTitle, salary);
    }

    public double calculateBonus() {
        return getSalary() * 0.4;
    }

    public void testCode() {
        System.out.println("Tester " + getName() + " is testing code");
    }
}
