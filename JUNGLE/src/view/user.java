package view;

import java.util.Objects;

public class user {
    private String user_name;
    private String password;

    private int winNumber;

    public user(String user_name, String password,int winNumber) {
        this.user_name = user_name;
        this.password = password;
        this.winNumber=winNumber;
    }
    public user() {
    }

    public  String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public  String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public  int getWinNumber() {
        return winNumber;
    }

    public void setWinNumber(int winNumber) {
        this.winNumber = winNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        user user = (user) o;
        return Objects.equals(user_name, user.user_name) && Objects.equals(password, user.password);
    }


}
