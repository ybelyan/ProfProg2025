package base;

public class Employee extends User {
    private String jobTitle;
    private double salary;

    public Employee(String lastName, String firstName, String jobTitle, double salary) {
        super(lastName, firstName);
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public String getJobTitle() {
        return getName() + " is working as " + jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public double calculateBonus() {
        return 0.0;
    }
}
