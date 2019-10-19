package com.example.todosampleapp.login.model;

import com.example.todosampleapp.login.LoginContract;
import com.example.todosampleapp.login.model.LoginRepository;

import io.reactivex.Single;

public class LoginRepositoryImpl implements LoginRepository {
    LoginContract.Presenter presenter;

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
        // local 데이터베이스 저장소 정의예정
    }

    @Override
    public Single<User> LoginProc(User user) {

        // login 처리결과
        return user;
    }
}
