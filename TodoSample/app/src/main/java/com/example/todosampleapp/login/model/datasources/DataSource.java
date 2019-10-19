package com.example.todosampleapp.login.model.datasources;

import com.example.todosampleapp.login.model.User;

import io.reactivex.Single;

public interface DataSource {
    Single<User> loginProc(User user);

}
