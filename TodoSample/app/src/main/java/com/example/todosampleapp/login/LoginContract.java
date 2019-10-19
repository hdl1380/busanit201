package com.example.todosampleapp.login;

import com.example.todosampleapp.base.BasePresenter;
import com.example.todosampleapp.base.BaseView;
import com.example.todosampleapp.login.model.User;

import io.reactivex.Single;

public class LoginContract {
    public interface View extends BaseView {
        void loginDone(Single<User> user);
        void loginFailed();
    }

    public interface Presenter extends BasePresenter<View> {
        void loginProc(User user);
        void loginDone(User user);
    }
}
