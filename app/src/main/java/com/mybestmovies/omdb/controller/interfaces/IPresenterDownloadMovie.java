package com.mybestmovies.omdb.controller.interfaces;

import com.mybestmovies.omdb.model.BO.Movie;

/**
 * Created by Wisley on 12/03/2016.
 */
public interface IPresenterDownloadMovie {
    void notifyStart();


    void notifyFinish(Movie movie);

    void notifyError();
}
