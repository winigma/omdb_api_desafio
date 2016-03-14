package com.mybestmovies.omdb.mybestmovies;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mybestmovies.omdb.application.OMDBApplication;
import com.mybestmovies.omdb.controller.ControllerRegisterMovie;
import com.mybestmovies.omdb.controller.DAOFacadeImpl;
import com.mybestmovies.omdb.model.BO.Movie;
import com.mybestmovies.omdb.model.BO.SharedPreferencesUtils;
import com.mybestmovies.omdb.view.holder.HolderDetailActivity;
import com.mybestmovies.omdb.view.interfaces.IListenersViews;
import com.squareup.picasso.Picasso;

/**
 * Created by Wisley on 13/03/2016.
 */
public class MovieDetailActivity extends Activity implements IListenersViews {


    private HolderDetailActivity mHolder;
    private static String CODE_ID = "id";
    private Movie movie;
    private int idMovie;
    private ControllerRegisterMovie mControllerActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detail_movie);
        Intent intent = getIntent();
        idMovie = intent.getIntExtra(CODE_ID, 0); // here 0 is the default value

        mHolder = new HolderDetailActivity(this);

        initializeActions();

    }


    /**
     * this method load data in screen
     */
    private void initializeActions() {


        // get movie by id
        movie = DAOFacadeImpl.getFilm(OMDBApplication.getDbManager(), idMovie);

        mControllerActivity = new ControllerRegisterMovie(new DAOFacadeImpl());

        Picasso.with(getApplicationContext()).load(movie.getPoster()).error(R.drawable.no_movie).into(mHolder.getIv_Poster());

        mHolder.getTv_actors().setText(movie.getActors());

        mHolder.getTv_plot().setText(movie.getPlot());

        mHolder.getTv_released().setText(movie.getReleased());

        mHolder.getTv_title().setText(movie.getTitle());

        mHolder.getDelete().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mControllerActivity.delete(movie);
                SharedPreferencesUtils.writePreferences(getApplicationContext(), "delete_ok", true);

                finish();
            }
        });


    }


}
