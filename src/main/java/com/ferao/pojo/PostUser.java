package com.ferao.pojo;

public class PostUser {

    private String username;
    private String password;
    private String money;

    @Override
    public String toString() {
        return "PostUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money='" + money + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
