package com.github.ununmul.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class PasswordEntry {

    private String website;
    private String password;
    private String login;

    public PasswordEntry(String website, String password, String login) {
        this.website = website;
        this.password = password;
        this.login = login;
    }

    public String getWebsite() {
        return website;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public String toCSVString () {
        return website + ";" + password + ";" + login;
    }

    public String[] toArray () {
        return new String[] {website, password, login};
    }

}
