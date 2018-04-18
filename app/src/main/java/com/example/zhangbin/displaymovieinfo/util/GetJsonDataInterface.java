package com.example.zhangbin.displaymovieinfo.util;

import com.example.zhangbin.displaymovieinfo.DataModel.JsonObject;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by zhangbin on 3/3/2018.
 */

public interface GetJsonDataInterface {

    @GET("movie/top250")
    Flowable<JsonObject> getJsonData();
}
