package com.hymane.materialhome.api.view;

public interface IBookDetailView {
    void showMessage(String msg);

    void showProgress();

    void hideProgress();

    void updateView(Object result);
}
