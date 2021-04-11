package eu.senla.task13;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoUserImpl implements Dao{


    @Override
    public User create(User user) {
        try {
            Connection connection = DriverManager.getConnection(DBConnection.URL,DBConnection.LOGIN,DBConnection.PASSWORD);
            String createUser = "INSERT INTO users.user (login, password) VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(createUser);
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2,user.getUserPassword());
            preparedStatement.executeUpdate();
            connection.close();
            System.out.printf("User %s is added to database\n", user.getUserName());
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public User read(String name, String password) {
        try {
            Connection connection = DriverManager.getConnection(DBConnection.URL,DBConnection.LOGIN,DBConnection.PASSWORD);
            String updateUser = "SELECT * FROM users.user WHERE login=? AND password=?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateUser);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);

            ResultSet resultSet= preparedStatement.executeQuery();
            String userName;
            String userPassword;
            while (resultSet.next()){
                userName = resultSet.getString("login");
                userPassword = resultSet.getString("password");
                System.out.printf("User %s with password: %s\n", userName, userPassword);
            }
            connection.close();
            return new User(name,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public User update(String name, User newUser) {
        try {
            Connection connection = DriverManager.getConnection(DBConnection.URL,DBConnection.LOGIN,DBConnection.PASSWORD);
            String updateUser = "UPDATE users.user SET login=?, password=? WHERE login=?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateUser);
            preparedStatement.setString(1,newUser.getUserName());
            preparedStatement.setString(2,newUser.getUserPassword());
            preparedStatement.setString(3,name);
            preparedStatement.executeUpdate();
            connection.close();
            System.out.printf("User %s is is changed to %s\n", name,newUser.getUserName());
            return newUser;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean delete(String name, String password) {
        try {
            Connection connection = DriverManager.getConnection(DBConnection.URL,DBConnection.LOGIN,DBConnection.PASSWORD);
            String deleteUser = "DELETE FROM users.user WHERE login=? AND password=?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteUser);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);
            preparedStatement.executeUpdate();
            connection.close();
            System.out.printf("User %s is deleted from database\n", name);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public List<User> readAll() {
        List <User> userList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(DBConnection.URL,DBConnection.LOGIN,DBConnection.PASSWORD);
            String readAll = "SELECT * FROM users.user";
            PreparedStatement preparedStatement = connection.prepareStatement(readAll);
            ResultSet resultSet= preparedStatement.executeQuery();
            String name;
            String password;
            while (resultSet.next()){
                name = resultSet.getString("login");
                password = resultSet.getString("password");
                userList.add(new User(name,password));
            }
            connection.close();
            System.out.println("Users from database are imported\n");
            return userList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
}
