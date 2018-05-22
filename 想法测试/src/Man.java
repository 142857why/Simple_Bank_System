import java.io.Serializable;

public class Man implements Serializable {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Man(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

}
