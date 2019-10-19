package com.example.todosampleapp.login.view;

import android.os.Bundle;

import com.example.todosampleapp.R;
import com.example.todosampleapp.login.LoginContract;
import com.example.todosampleapp.login.model.User;
import com.example.todosampleapp.login.presenter.LoginPresenter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Single;

public class LoginActivity extends AppCompatActivity
        implements LoginContract.View {

    @BindView(R.id.email)
    EditText etEmail;
    @BindView(R.id.pwd)
    EditText etPwd;

    @BindView(R.id.login)
    Button btnLogin;

    static final String _TAG = "LoginActivity";

    LoginContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenter = new LoginPresenter();
        presenter.setView(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = getUser();
                presenter.loginProc(user);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private User getUser() {
        User user = new User();
        String email = etEmail.getText().toString();
        String pwd = etPwd.getText().toString();
        user.setEmail(email);
        user.setPwd(pwd);

        return user;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void loginDone(Single<User> user) {
        String tEmail = getUser().getEmail();
        String tPwd = getUser().getPwd();

        Toast.makeText(LoginActivity.this, "(1380)로그인 성공", Toast.LENGTH_SHORT).show();
        Toast.makeText(LoginActivity.this, tEmail+" / "+ tPwd, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailed() {
        Toast.makeText(LoginActivity.this, "(1380)로그인 실패", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
