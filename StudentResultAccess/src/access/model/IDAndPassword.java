package access.model;

public class IDAndPassword {
    public static String GL_ID;  //global this client id
    String ID;
    String password;
    String newPassword;
    boolean loginSuccess;

    public void setLoginSuccess(boolean loginSuccess) {
        this.loginSuccess = loginSuccess;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }


    public String getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }

    public boolean getLoginSuccess() {
        return loginSuccess;
    }

}
