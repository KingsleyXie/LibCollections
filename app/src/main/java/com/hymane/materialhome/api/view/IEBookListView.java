package com.hymane.materialhome.api.view;

public interface IEBookListView {
    void showMessage(String msg);

    void showProgress();

    void hideProgress();

    void refreshData(Object result);
}
