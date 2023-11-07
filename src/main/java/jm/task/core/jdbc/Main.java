package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import static java.lang.System.out;
import static jm.task.core.jdbc.util.Util.closeConnection;


public class Main {
    private final static UserService userService = new UserServiceImpl ();

    public static void main (String[] args) {

        userService.createUsersTable ();

        userService.saveUser ("Илья", "Степанов", (byte) 37);
        userService.saveUser ("Вова", "Сидоров", (byte) 74);
        userService.saveUser ("Иван", "Иванов", (byte) 59);
        userService.saveUser ("Саша", "Петров", (byte) 33);

        userService.getAllUsers ().forEach (out::println);

        userService.cleanUsersTable ();

        userService.dropUsersTable ();

        closeConnection();

    }
}
