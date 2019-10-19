package com.example.todosampleapp.login.model;

import io.reactivex.Single;
import io.reactivex.SingleObserver;

public class User extends Single<User> {
    private String email;
    private String pwd;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    protected void subscribeActual(SingleObserver<? super User> observer) {

    }
}
