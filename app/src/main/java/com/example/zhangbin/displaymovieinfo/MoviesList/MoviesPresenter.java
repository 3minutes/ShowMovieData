package com.example.zhangbin.displaymovieinfo.MoviesList;

import android.content.Intent;
import android.graphics.Movie;
import android.util.Log;

import com.example.zhangbin.displaymovieinfo.DataModel.MovieBean;
import com.example.zhangbin.displaymovieinfo.util.GetJsonDataInterface;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by zhangbin on 3/3/2018.
 */

public class MoviesPresenter implements MovieListContract.Presenter {

    private static MovieListContract.View mMoviesView;

    private static MovieListContract.Presenter mMoviesPresenter;

    private CompositeDisposable mCompositeDisposable;

    public MoviesPresenter(MovieListContract.View moviesView){
        mMoviesView = checkNotNull(moviesView,"moviesView can not be null");
        mCompositeDisposable = new CompositeDisposable();
        moviesView.setPresenter(this);
    }


    @Override
    public void subscribe() {
        getMoviesData();
    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.clear();
    }

    @Override
    public void openMovieDetail(MovieBean movieBean) {
        checkNotNull(movieBean,"moviebean can not be null");
        mMoviesView.showMovieDetailUi(movieBean);
    }

    @Override
    public void getMoviesData() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                            .addNetworkInterceptor(new StethoInterceptor()).build();
        Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("https://api.douban.com/v2/")   //set request http url;
                            .client(client)
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

        GetJsonDataInterface requestData = retrofit.create(GetJsonDataInterface.class);
        requestData.getJsonData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(jsonData -> {
                    mMoviesView.showMovies(jsonData.getSubjects());
                }, e ->{
                    e.printStackTrace();
                });

    }

}
