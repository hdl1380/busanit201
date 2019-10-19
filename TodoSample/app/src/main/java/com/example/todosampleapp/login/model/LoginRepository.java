package com.example.todosampleapp.login.model;

import com.example.todosampleapp.login.LoginContract;

import io.reactivex.Single;

public interface LoginRepository {
    void setPresenter(LoginContract.Presenter presenter);
    Single<User> LoginProc(User user);

}
