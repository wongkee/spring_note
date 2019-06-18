package spring_in_action.beans.xmlconfig;

public class User {
    private String username;
    private String passworld;
    User(){
        System.out.println("Hello World");
    }
    public User(String username, String passworld) {
        this.username = username;
        this.passworld = passworld;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassworld() {
        return passworld;
    }

    public void setPassworld(String passworld) {
        this.passworld = passworld;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", passworld='" + passworld + '\'' +
                '}';
    }
}