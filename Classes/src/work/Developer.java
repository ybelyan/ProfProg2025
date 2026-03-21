package work;

import base.Employee;

public class Developer extends Employee {
    public Developer(String lastName, String firstName, String jobTitle, double salary) {
        super(lastName, firstName, jobTitle, salary);
    }

    public double calculateBonus() {
        return getSalary() * 0.5;
    }

    public void devCode(){
        System.out.println("Developer " + getName() + " is busy");
    }
}
