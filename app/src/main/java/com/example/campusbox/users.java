package com.example.campusbox;

public class users {

    String first, last, email;

    public users(){}

    public users(String first, String last, String email) {
        this.first = first;
        this.last = last;
        this.email = email;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
