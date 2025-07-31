package main;

import roles.Employee;
import roles.Friend;
import roles.Human;
import roles.Parent;

import java.util.Random;

public class HumanRoles {

    private static final Random random = new Random();
    private static final String NAME = "Ivan Ivanov";

    public static void main(String[] args) {
        /*roles.Human human = new roles.Employee("Ivan Ivanov");
        human.doing();

        human = new roles.Friend("Ivan Ivanov");
        human.doing();*/

        Human[] roles = new Human[6];
        for(int i = 0; i < roles.length; i++) {
            roles[i] = randomRole();
        }

        for (Human role: roles) {
            role.doing();
        }
    }

    private static Human randomRole() {
        switch(random.nextInt(3)){
            case 0:
                return new Employee(NAME);
            case 1:
                return new Friend(NAME);
            case 2:
                return new Parent(NAME);
            default:
                System.out.println("Некорректное значение роли");
                return new Parent();
        }
    }
}
