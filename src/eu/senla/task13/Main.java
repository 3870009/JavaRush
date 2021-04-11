package eu.senla.task13;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Ivanov","qwerty"));
        userList.add(new User("Petrov","asdfg"));
        userList.add(new User("Sidorov","123qwe"));
        userList.add(new User("Andreev","zxcv123"));
        userList.add(new User("Vasiliev","qazwsx"));

        DBConnection.connectDB();
        DaoUserImpl dao = new DaoUserImpl();
        for(User users:userList){
            dao.create(users);  //Create
        }
        dao.delete("Ivanov","qwerty"); // Delete
        dao.update("Sidorov", new User("Nikiforov","mmm")); //Update
        List <User> userListFromDatabase = dao.readAll(); //ReadAll
        System.out.println(userListFromDatabase);
        dao.read("Petrov", "asdfg"); //Read
    }
}
