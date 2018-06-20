package org.zgdf.ea.model;

public class Users {

    private int userID;
    private String userName;
    private String password;
    private String userRole;
    private int active;
    private String fullName;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

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

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Users{" + "userID=" + userID + ", userName=" + userName + ", password=" + password + ", userRole=" + userRole + ", active=" + active + ", fullName=" + fullName + '}';
    }

}
