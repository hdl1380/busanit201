package com.example.todosampleapp.base;

public class BasePresenterImpl<T extends BaseView> implements BasePresenter<T> {
    T view;

    @Override
    public void setView(T view) { this.view = view; }

    @Override
    public void removeView() { view = null; }
}
