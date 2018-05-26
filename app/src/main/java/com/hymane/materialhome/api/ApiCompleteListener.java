package com.hymane.materialhome.api;

import com.hymane.materialhome.bean.http.douban.BaseResponse;

public interface ApiCompleteListener {
    void onComplected(Object result);

    void onFailed(BaseResponse msg);
}