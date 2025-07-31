package work;

import base.Employee;

public class Manager extends Employee {
    private int numberOfSubordinates;

    public Manager(String lastName, String firstName, String jobTitle, double salary, int numberOfSubordinates) {
        super(lastName, firstName, jobTitle, salary);
        this.numberOfSubordinates = numberOfSubordinates;
    }

    public double calculateBonus() {
        return getSalary() * 0.2;
    }

    public void manageProject(){
        System.out.println("Manager " + getName() + " is managing a project of " + numberOfSubordinates);
    }
}
