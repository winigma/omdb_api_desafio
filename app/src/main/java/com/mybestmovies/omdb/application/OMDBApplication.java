package com.mybestmovies.omdb.application;

import android.app.Application;

import com.mybestmovies.omdb.model.BO.MovieDAO;

/**
 * Created by Wisley on 12/03/2016.
 */
public class OMDBApplication extends Application {

    private static MovieDAO dbManager;

    @Override
    public void onCreate() {
        super.onCreate();

        dbManager = new MovieDAO(this, "my movies", null, 1);

        dbManager.insertMovieTrial();


    }

    public static MovieDAO getDbManager() {
        return dbManager;
    }
}
