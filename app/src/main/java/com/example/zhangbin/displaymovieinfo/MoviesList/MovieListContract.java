package com.example.zhangbin.displaymovieinfo.MoviesList;

import android.widget.BaseAdapter;

import com.example.zhangbin.displaymovieinfo.DataModel.MovieBean;
import com.example.zhangbin.displaymovieinfo.util.BasePresenter;
import com.example.zhangbin.displaymovieinfo.util.BaseView;

import java.util.List;

/**
 * Created by zhangbin on 3/3/2018.
 */

public interface MovieListContract {

    interface View extends BaseView<Presenter>{

        void showMovies(List<MovieBean> movieBeans);
        void showMovieDetailUi(MovieBean movieBean);
    }

    interface Presenter extends BasePresenter {

        void openMovieDetail(MovieBean movieBean);

        void getMoviesData();
    }
}
