package com.example.zhangbin.displaymovieinfo.MoviesList;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhangbin.displaymovieinfo.DataModel.MovieBean;
import com.example.zhangbin.displaymovieinfo.OneMoiveDetail.MovieDetailActivity;
import com.example.zhangbin.displaymovieinfo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by zhangbin on 3/3/2018.
 */

public class MoviesFragment extends Fragment implements MovieListContract.View {

    private MovieListContract.Presenter mPresenter;

    private MovieAdapter mMovieAdapter;

    private RecyclerView recyclerView;

    public MoviesFragment(){

    }

    public static MoviesFragment newInstence(){
        return new MoviesFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstenceState){
//        Log.d("debuglog","create");
        super.onCreate(savedInstenceState);
        mMovieAdapter = new MovieAdapter(this.getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstenceState){
//        Log.d("debuglog","create view");
        View root = inflater.inflate(R.layout.movies_frame,parent,false);
        recyclerView = (RecyclerView) root.findViewById(R.id.movies_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(mMovieAdapter);
        return root;
    }

    @Override
    public void onResume(){
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void onPause(){
        super.onPause();
        mPresenter.unsubscribe();
    }

    @Override
    public void setPresenter(@NonNull MovieListContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void showMovies(List<MovieBean> movieBeans) {
        mMovieAdapter.setList(movieBeans);
//        Log.d("setlist",movieBeans.size()+" ");
    }

    @Override
    public void showMovieDetailUi(MovieBean movieBean){
        Intent intent = new Intent(getContext(),MovieDetailActivity.class);
        intent.putExtra("moviebean",movieBean);
        startActivity(intent);
    }

    public static class MovieAdapter extends RecyclerView.Adapter<MovieHolder>{

        private List<MovieBean> mMovies = new ArrayList<>();
        private Activity activity;
        private LayoutInflater layoutInflater;

        public MovieAdapter(Activity mAct){
            this.activity = mAct;
            this.layoutInflater = LayoutInflater.from(mAct);
        }

        public MovieAdapter(Activity mAct, List<MovieBean> movieBeanList){
            this.activity = mAct;
            this.layoutInflater = LayoutInflater.from(mAct);
            this.mMovies = movieBeanList;
        }

        @Override
        public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final View view = layoutInflater.inflate(R.layout.one_movie, parent, false);
            final MovieHolder movieHolder = new MovieHolder(view);
            view.setOnClickListener(v ->{
                Intent intent=new Intent(this.activity,MovieDetailActivity.class);
                intent.putExtra("movieDetail",mMovies.get(movieHolder.getAdapterPosition()));
                this.activity.startActivity(intent);
            });
            return movieHolder;
        }

        @Override
        public void onBindViewHolder(MovieHolder holder, int position) {
            MovieBean movieBean = mMovies.get(position);
            holder.mMovieTitle.setText(movieBean.getTitle());
            holder.mOriginalTitle.setText(movieBean.getOriginal_title());
            String imageUrl = movieBean.getImages().get("medium");
            Picasso.with(this.activity).load(imageUrl).into(holder.mMovieImage);
        }

        @Override
        public int getItemCount() {
            return mMovies.size();
        }

        public void setList(List<MovieBean> movies){
            this.mMovies.clear();
            this.mMovies.addAll(movies);
            notifyDataSetChanged();
//            Log.d("addList",movies.size()+" ");
        }
    }

    public static class MovieHolder extends RecyclerView.ViewHolder{
        public ImageView mMovieImage;
        public TextView mOriginalTitle;
        public TextView mMovieTitle;

        public MovieHolder(View itemView){
            super((itemView));
            mMovieImage = (ImageView) itemView.findViewById(R.id.movieImage);
            mOriginalTitle = (TextView) itemView.findViewById(R.id.originalTitle);
            mMovieTitle = (TextView) itemView.findViewById(R.id.movieTitle);
//            Log.d("show","complete");
        }
    }


}
