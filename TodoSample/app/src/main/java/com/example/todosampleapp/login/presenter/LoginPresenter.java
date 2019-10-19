package com.example.todosampleapp.login.presenter;

import com.example.todosampleapp.base.BasePresenterImpl;
import com.example.todosampleapp.login.LoginContract;
import com.example.todosampleapp.login.model.LoginRepository;
import com.example.todosampleapp.login.model.LoginRepositoryImpl;
import com.example.todosampleapp.login.model.User;

import io.reactivex.Single;

public class LoginPresenter
        extends BasePresenterImpl<LoginContract.View>
        implements LoginContract.Presenter {

    LoginContract.View view;

    LoginRepository repository = new LoginRepositoryImpl();

    @Override
    public void setView(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        view = null;
    }


    @Override
    public void loginProc(User user) {
        // user 값 확인후 그대로 리턴하여 view에서 출력
//        if (user == null)
//            view.loginFailed();
//        else
//            view.loginDone(user);

        // 이후 Repository 에서 데이터베이스 확인 후 결과 리턴으로 수정
        Single<User> rtnUser = repository.LoginProc(user);
        if (rtnUser == null)
            view.loginFailed();
        else
            view.loginDone(rtnUser);
    }

    @Override
    public void loginDone(User user) {
        view.loginDone(user);
    }


}
