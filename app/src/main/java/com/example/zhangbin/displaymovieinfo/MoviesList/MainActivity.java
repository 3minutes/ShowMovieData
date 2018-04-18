package com.example.zhangbin.displaymovieinfo.MoviesList;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.zhangbin.displaymovieinfo.R;
import com.example.zhangbin.displaymovieinfo.util.ActivityUtil;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MoviesPresenter mMoviesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MoviesFragment moviesFragment = (MoviesFragment) getSupportFragmentManager()
                                        .findFragmentById(R.id.moviesFrame);
        if(moviesFragment == null){
            moviesFragment = new MoviesFragment();
            ActivityUtil.addFragmentToActivity(getSupportFragmentManager(),
                    moviesFragment, R.id.moviesFrame);
        }

        mMoviesPresenter = new MoviesPresenter(moviesFragment);

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

}
