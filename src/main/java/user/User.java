package user;

public class User {
    public User(String userName, String realName, String password, String emailAddress) {
        this.userName = userName;
        this.realName = realName;
        this.password = password;
        this.emailAddress = emailAddress;
    }

    public String getUserName() {return userName;}
    public String getRealName() {
        return realName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmailAddress() {return emailAddress; }

    protected String userName;
    protected String realName;
    protected String password;
    protected String emailAddress;



    @Override
    public String toString() {
        return userName + " " + realName + " " + password;
    }
}
