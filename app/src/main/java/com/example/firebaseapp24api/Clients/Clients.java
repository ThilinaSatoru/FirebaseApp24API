package com.example.firebaseapp24api.Clients;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Clients {
    private String Name;
    private String Email;
    private String Mobile;

    public Clients(){}

    public Clients(String name, String email, String mobile) {
        Name = name;
        Email = email;
        Mobile = mobile;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }
}
