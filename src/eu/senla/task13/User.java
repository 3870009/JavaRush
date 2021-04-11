package eu.senla.task13;

public class User {
    private String userName;
    private String userPassword;

    @Override
    public String toString() {
        return " Login: " + userName  +
                " , Password : " + userPassword + "\n";
    }

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
