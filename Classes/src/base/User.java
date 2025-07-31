package base;

public class User {
    protected String lastName, firstName;

    public User(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getName() {
        return lastName + " " + firstName;
    }

    public void setLastName(String lastName) {
        if (!"".equals(lastName)) {
            this.lastName = lastName;
        }
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
