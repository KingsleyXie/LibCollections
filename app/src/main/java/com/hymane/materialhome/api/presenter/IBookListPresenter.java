package com.hymane.materialhome.api.presenter;

public interface IBookListPresenter {
    void loadBooks(String q, String tag, int start, int count, String fields);

    void cancelLoading();
}
