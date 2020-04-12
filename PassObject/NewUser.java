package ru.gb.java_3.hw_3.PassObject;

import java.io.Serializable;

public class NewUser implements Serializable {
    private String name;
    private String password;

    public NewUser(String name, String password){
        this.name = name;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
